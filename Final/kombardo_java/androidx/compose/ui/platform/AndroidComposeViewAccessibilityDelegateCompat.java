package androidx.compose.ui.platform;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.constants.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 ¯\u00022\u00020\u0001:\u0010°\u0002±\u0002¯\u0002²\u0002³\u0002´\u0002µ\u0002¶\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u0011\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JK\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\u001a\u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0014\b\u0002\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0 0\u001fH\u0002¢\u0006\u0004\b\"\u0010#JC\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\u001c2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0 0\u001fH\u0002¢\u0006\u0004\b(\u0010)J+\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\u001a\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020'H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b/\u00100J'\u00103\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u001cH\u0002¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u0004\u0018\u0001072\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b8\u00109J\u0019\u0010:\u001a\u0004\u0018\u0001072\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b:\u00109J\u001f\u0010;\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u00106J\u0017\u0010<\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b<\u00100J\u001f\u0010=\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b=\u00106J\u0019\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u0004\u0018\u00010A*\u00020>H\u0002¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\bD\u00106J\u0017\u0010E\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010FJ=\u0010L\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010JH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010R\u001a\u00020N2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0003¢\u0006\u0004\bR\u0010SJ?\u0010Y\u001a\u00020N2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u000b2\b\u0010U\u001a\u0004\u0018\u00010\u000b2\b\u0010V\u001a\u0004\u0018\u00010\u000b2\b\u0010X\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b[\u0010FJ)\u0010_\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\b_\u0010`J1\u0010b\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00132\u0006\u0010a\u001a\u0002072\b\u0010^\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bb\u0010cJ#\u0010h\u001a\u0004\u0018\u00010g2\b\u0010d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010f\u001a\u00020eH\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\bj\u0010kJ/\u0010n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010l*\u00020W2\b\u0010X\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010m\u001a\u00020\u000bH\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010r\u001a\u00020'2\u0006\u0010q\u001a\u00020pH\u0002¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020'2\u0006\u0010q\u001a\u00020pH\u0002¢\u0006\u0004\bt\u0010sJ\u001f\u0010w\u001a\u00020'2\u0006\u0010q\u001a\u00020p2\u0006\u0010v\u001a\u00020uH\u0002¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020'H\u0002¢\u0006\u0004\by\u0010.J\u000f\u0010z\u001a\u00020'H\u0002¢\u0006\u0004\bz\u0010.J\u001d\u0010|\u001a\u00020'2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b|\u0010}J)\u0010\u0081\u0001\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u000b2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0JH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020'2\u0007\u0010\u0083\u0001\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J.\u0010\u0088\u0001\u001a\u00020'2\u0007\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\t\u0010\u0087\u0001\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J%\u0010\u008d\u0001\u001a\u00020'2\u0007\u0010\u008a\u0001\u001a\u00020\u001c2\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u008f\u0001\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000bH\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J5\u0010\u0094\u0001\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001c2\u0007\u0010\u0091\u0001\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001a\u0010\u0096\u0001\u001a\u00020'2\u0007\u0010\u0086\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0005\b\u0096\u0001\u0010kJ5\u0010\u009a\u0001\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001c2\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001a\u0010\u009c\u0001\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001a\u0010\u009e\u0001\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009d\u0001J\u0019\u0010\u009f\u0001\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u009f\u0001\u00100J(\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0091\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u001d\u0010£\u0001\u001a\u0004\u0018\u0001072\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0005\b£\u0001\u00109J\u0019\u0010¥\u0001\u001a\u0004\u0018\u00010>*\u00030¤\u0001H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J,\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001b\u0010¬\u0001\u001a\u00020\t2\u0007\u0010O\u001a\u00030©\u0001H\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J&\u0010²\u0001\u001a\u00020\u000b2\b\u0010®\u0001\u001a\u00030\u00ad\u00012\b\u0010¯\u0001\u001a\u00030\u00ad\u0001H\u0001¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001d\u0010¶\u0001\u001a\u00030µ\u00012\b\u0010´\u0001\u001a\u00030³\u0001H\u0016¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0011\u0010¹\u0001\u001a\u00020'H\u0000¢\u0006\u0005\b¸\u0001\u0010.J\u0013\u0010¼\u0001\u001a\u00020'H\u0080@¢\u0006\u0006\bº\u0001\u0010»\u0001J\u0019\u0010¾\u0001\u001a\u00020'2\u0006\u0010q\u001a\u00020pH\u0000¢\u0006\u0005\b½\u0001\u0010sR\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001R/\u0010Â\u0001\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u001e\n\u0006\bÂ\u0001\u0010Ã\u0001\u0012\u0005\bÇ\u0001\u0010.\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0005\bÆ\u0001\u0010kR=\u0010É\u0001\u001a\u000f\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\t0È\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u001f\n\u0006\bÉ\u0001\u0010Ê\u0001\u0012\u0005\bÏ\u0001\u0010.\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R2\u0010Ô\u0001\u001a\u00020\t2\u0007\u0010Ó\u0001\u001a\u00020\t8\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R*\u0010Û\u0001\u001a\u00030Ú\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0018\u0010å\u0001\u001a\u00030ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001RD\u0010é\u0001\u001a-\u0012\u000f\u0012\r è\u0001*\u0005\u0018\u00010ç\u00010ç\u0001 è\u0001*\u0015\u0012\u000f\u0012\r è\u0001*\u0005\u0018\u00010ç\u00010ç\u0001\u0018\u00010J0 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u0018\u0010ì\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001e\u0010ï\u0001\u001a\u00070î\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u0019\u0010ñ\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010Ã\u0001R\u001b\u0010ò\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0019\u0010ô\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010Õ\u0001R\u001e\u0010ö\u0001\u001a\t\u0012\u0005\u0012\u00030õ\u00010\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001e\u0010ø\u0001\u001a\t\u0012\u0005\u0012\u00030õ\u00010\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0001\u0010÷\u0001R'\u0010ú\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020W0ù\u00010ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R'\u0010ý\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020W0ü\u00010ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010û\u0001R\u0019\u0010þ\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Ã\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u001e\u0010\u0082\u0002\u001a\t\u0012\u0004\u0012\u00020p0\u0081\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001e\u0010\u0085\u0002\u001a\t\u0012\u0004\u0012\u00020'0\u0084\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0019\u0010\u0087\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010Õ\u0001R\u001c\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068B@\u0002X\u0082\u000e¢\u0006\u000f\n\u0005\b\b\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0019\u0010\u008e\u0002\u001a\u00020u8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R*\u0010\u0091\u0002\u001a\u00030\u0090\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u0092\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R*\u0010\u0097\u0002\u001a\u00030\u0090\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0097\u0002\u0010\u0092\u0002\u001a\u0006\b\u0098\u0002\u0010\u0094\u0002\"\u0006\b\u0099\u0002\u0010\u0096\u0002R\u001f\u0010\u009a\u0002\u001a\u0002078\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001f\u0010\u009e\u0002\u001a\u0002078\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009e\u0002\u0010\u009b\u0002\u001a\u0006\b\u009f\u0002\u0010\u009d\u0002R\u0018\u0010¡\u0002\u001a\u00030 \u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R \u0010£\u0002\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010÷\u0001R\u001a\u0010¤\u0002\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u0019\u0010¦\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010Õ\u0001R\u0018\u0010¨\u0002\u001a\u00030§\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001d\u0010ª\u0002\u001a\b\u0012\u0004\u0012\u00020\u007f0 8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0002\u0010ê\u0001R$\u0010«\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020'0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0002\u0010Ê\u0001R\u0017\u0010¬\u0002\u001a\u00020\t8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¬\u0002\u0010×\u0001R\u0017\u0010®\u0002\u001a\u00020\t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010×\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006·\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroidx/compose/ui/platform/AndroidComposeView;", "view", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "currentSemanticsNodes", BuildConfig.FLAVOR, "vertical", BuildConfig.FLAVOR, "direction", "Landroidx/compose/ui/geometry/Offset;", "position", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll", "virtualViewId", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "createNodeInfo", "(I)Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "node", "Landroid/graphics/Rect;", "boundsInScreen", "(Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;)Landroid/graphics/Rect;", "layoutIsRtl", "Ljava/util/ArrayList;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/collections/ArrayList;", "parentListToSort", "Landroidx/collection/MutableIntObjectMap;", BuildConfig.FLAVOR, "containerChildrenMapping", "sortByGeometryGroupings", "(ZLjava/util/ArrayList;Landroidx/collection/MutableIntObjectMap;)Ljava/util/List;", "currNode", "geometryList", "containerMapToChildren", BuildConfig.FLAVOR, "geometryDepthFirstSearch", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/ArrayList;Landroidx/collection/MutableIntObjectMap;)V", "listToSort", "subtreeSortedByGeometryGrouping", "(ZLjava/util/List;)Ljava/util/List;", "setTraversalValues", "()V", "isScreenReaderFocusable", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "info", "semanticsNode", "populateAccessibilityNodeInfoProperties", "(ILandroidx/core/view/accessibility/AccessibilityNodeInfoCompat;Landroidx/compose/ui/semantics/SemanticsNode;)V", "setContentInvalid", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V", BuildConfig.FLAVOR, "getInfoStateDescriptionOrNull", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/String;", "createStateDescriptionForTextField", "setStateDescription", "getInfoIsCheckable", "setIsCheckable", "Landroidx/compose/ui/text/AnnotatedString;", "getInfoText", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/text/AnnotatedString;", "Landroid/text/SpannableString;", "toSpannableString", "(Landroidx/compose/ui/text/AnnotatedString;)Landroid/text/SpannableString;", "setText", "isAccessibilityFocused", "(I)Z", "requestAccessibilityFocus", "eventType", "contentChangeType", BuildConfig.FLAVOR, "contentDescription", "sendEventForVirtualView", "(IILjava/lang/Integer;Ljava/util/List;)Z", "Landroid/view/accessibility/AccessibilityEvent;", "event", "sendEvent", "(Landroid/view/accessibility/AccessibilityEvent;)Z", "createEvent", "(II)Landroid/view/accessibility/AccessibilityEvent;", "fromIndex", "toIndex", "itemCount", BuildConfig.FLAVOR, "text", "createTextSelectionChangedEvent", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "clearAccessibilityFocus", "action", "Landroid/os/Bundle;", "arguments", "performActionHelper", "(IILandroid/os/Bundle;)Z", "extraDataKey", "addExtraDataToAccessibilityNodeInfoHelper", "(ILandroidx/core/view/accessibility/AccessibilityNodeInfoCompat;Ljava/lang/String;Landroid/os/Bundle;)V", "textNode", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroid/graphics/RectF;", "toScreenCoords", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/geometry/Rect;)Landroid/graphics/RectF;", "updateHoveredVirtualView", "(I)V", "T", "size", "trimToSize", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "notifySubtreeAccessibilityStateChangedIfNeeded", "(Landroidx/compose/ui/node/LayoutNode;)V", "sendTypeViewScrolledAccessibilityEvent", "Landroidx/collection/MutableIntSet;", "subtreeChangedSemanticsNodesIds", "sendSubtreeChangeAccessibilityEvents", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/collection/MutableIntSet;)V", "checkForSemanticsChanges", "updateSemanticsNodesCopyAndPanes", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents", "(Landroidx/collection/IntObjectMap;)V", Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/ui/platform/ScrollObservationScope;", "oldScrollObservationScopes", "registerScrollingId", "(ILjava/util/List;)Z", "scrollObservationScope", "scheduleScrollEventIfNeeded", "(Landroidx/compose/ui/platform/ScrollObservationScope;)V", "semanticsNodeId", Constants.IntentExtra.PushTitle, "sendPaneChangeEvents", "(IILjava/lang/String;)V", "newNode", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "oldNode", "sendAccessibilitySemanticsStructureChangeEvents", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/platform/SemanticsNodeCopy;)V", "semanticsNodeIdToAccessibilityVirtualNodeId", "(I)I", "granularity", "forward", "extendSelection", "traverseAtGranularity", "(Landroidx/compose/ui/semantics/SemanticsNode;IZZ)Z", "sendPendingTextTraversedAtGranularityEvent", "start", "end", "traversalMode", "setAccessibilitySelection", "(Landroidx/compose/ui/semantics/SemanticsNode;IIZ)Z", "getAccessibilitySelectionStart", "(Landroidx/compose/ui/semantics/SemanticsNode;)I", "getAccessibilitySelectionEnd", "isAccessibilitySelectionExtendable", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIteratorForGranularity", "(Landroidx/compose/ui/semantics/SemanticsNode;I)Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIterableTextForAccessibility", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getTextForTextField", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Landroidx/compose/ui/text/AnnotatedString;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "(Landroid/view/MotionEvent;)Z", "dispatchHoverEvent", BuildConfig.FLAVOR, "x", "y", "hitTestSemanticsAt$ui_release", "(FF)I", "hitTestSemanticsAt", "Landroid/view/View;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "getAccessibilityNodeProvider", "(Landroid/view/View;)Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "onSemanticsChange$ui_release", "onSemanticsChange", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesEventLoop", "onLayoutChange$ui_release", "onLayoutChange", "Landroidx/compose/ui/platform/AndroidComposeView;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "hoveredVirtualViewId", "I", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "getHoveredVirtualViewId$ui_release$annotations", "Lkotlin/Function1;", "onSendAccessibilityEvent", "Lkotlin/jvm/functions/Function1;", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "getOnSendAccessibilityEvent$ui_release$annotations", "Landroid/view/accessibility/AccessibilityManager;", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "value", "accessibilityForceEnabledForTesting", "Z", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", BuildConfig.FLAVOR, "SendRecurringAccessibilityEventsIntervalMillis", "J", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "enabledServices", "Ljava/util/List;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "focusedVirtualViewId", "currentlyFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "sendingFocusAffectingEvent", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "pendingVerticalScrollEvents", "Landroidx/collection/SparseArrayCompat;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/MutableObjectIntMap;", "labelToActionId", "accessibilityCursorPosition", "previousTraversedNode", "Ljava/lang/Integer;", "Landroidx/collection/ArraySet;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Lkotlinx/coroutines/channels/Channel;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "currentSemanticsNodesInvalidated", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "Landroidx/collection/IntObjectMap;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "Landroidx/collection/MutableIntIntMap;", "idToBeforeMap", "Landroidx/collection/MutableIntIntMap;", "getIdToBeforeMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToBeforeMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToAfterMap", "getIdToAfterMap$ui_release", "setIdToAfterMap$ui_release", "ExtraDataTestTraversalBeforeVal", "Ljava/lang/String;", "getExtraDataTestTraversalBeforeVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalAfterVal", "getExtraDataTestTraversalAfterVal$ui_release", "Landroidx/compose/ui/text/platform/URLSpanCache;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "previousSemanticsNodes", "previousSemanticsRoot", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "checkingForSemanticsChanges", "Ljava/lang/Runnable;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "scrollObservationScopes", "scheduleScrollEventIfNeededLambda", "isTouchExplorationEnabled", "isEnabled$ui_release", "isEnabled", "Companion", "Api24Impl", "Api29Impl", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "TopBottomBoundsComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.this.getView().getParent().requestSendAccessibilityEvent(AndroidComposeViewAccessibilityDelegateCompat.this.getView(), accessibilityEvent));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", BuildConfig.FLAVOR, "()V", "addSetProgressAction", BuildConfig.FLAVOR, "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            AccessibilityAction accessibilityAction;
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (!enabled || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", BuildConfig.FLAVOR, "()V", "addPageActions", BuildConfig.FLAVOR, "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                SemanticsConfiguration unmergedConfig = semanticsNode.getUnmergedConfig();
                SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsActions.getPageUp());
                if (accessibilityAction != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageDown());
                if (accessibilityAction2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageLeft());
                if (accessibilityAction3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageLeft, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageRight());
                if (accessibilityAction4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageRight, accessibilityAction4.getLabel()));
                }
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", BuildConfig.FLAVOR, "virtualViewId", BuildConfig.FLAVOR, "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "extraDataKey", BuildConfig.FLAVOR, "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", BuildConfig.FLAVOR, "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            AccessibilityNodeInfoCompat createNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent && virtualViewId == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = createNodeInfo;
            }
            return createNodeInfo;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", BuildConfig.FLAVOR, "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a5, SemanticsNode b5) {
            Rect boundsInWindow = a5.getBoundsInWindow();
            Rect boundsInWindow2 = b5.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow.getLeft(), boundsInWindow2.getLeft());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            return compare3 != 0 ? compare3 : Float.compare(boundsInWindow.getRight(), boundsInWindow2.getRight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", BuildConfig.FLAVOR, "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", BuildConfig.FLAVOR, "granularity", "fromIndex", "toIndex", "traverseTime", BuildConfig.FLAVOR, "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i5, int i6, int i7, int i8, long j5) {
            this.node = semanticsNode;
            this.action = i5;
            this.granularity = i6;
            this.fromIndex = i7;
            this.toIndex = i8;
            this.traverseTime = j5;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", BuildConfig.FLAVOR, "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a5, SemanticsNode b5) {
            Rect boundsInWindow = a5.getBoundsInWindow();
            Rect boundsInWindow2 = b5.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow2.getRight(), boundsInWindow.getRight());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            return compare3 != 0 ? compare3 : Float.compare(boundsInWindow2.getLeft(), boundsInWindow.getLeft());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", BuildConfig.FLAVOR, "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TopBottomBoundsComparator implements Comparator<Pair<? extends Rect, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<? extends Rect, ? extends List<SemanticsNode>> pair, Pair<? extends Rect, ? extends List<SemanticsNode>> pair2) {
            return compare2((Pair<Rect, ? extends List<SemanticsNode>>) pair, (Pair<Rect, ? extends List<SemanticsNode>>) pair2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<Rect, ? extends List<SemanticsNode>> a5, Pair<Rect, ? extends List<SemanticsNode>> b5) {
            int compare = Float.compare(a5.getFirst().getTop(), b5.getFirst().getTop());
            return compare != 0 ? compare : Float.compare(a5.getFirst().getBottom(), b5.getFirst().getBottom());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.h
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z5) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat.this, z5);
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.i
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z5) {
                AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat.this, z5);
            }
        };
        this.enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                accessibilityManager2.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.j
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$49(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope scrollObservationScope) {
                AndroidComposeViewAccessibilityDelegateCompat.this.scheduleScrollEventIfNeeded(scrollObservationScope);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        SemanticsNode semanticsNode;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
            if (orDefault != -1) {
                info.getExtras().putInt(extraDataKey, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || arguments == null || !Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            SemanticsConfiguration unmergedConfig = semanticsNode.getUnmergedConfig();
            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
            if (!unmergedConfig.contains(semanticsProperties.getTestTag()) || arguments == null || !Intrinsics.areEqual(extraDataKey, "androidx.compose.ui.semantics.testTag")) {
                if (Intrinsics.areEqual(extraDataKey, "androidx.compose.ui.semantics.id")) {
                    info.getExtras().putInt(extraDataKey, semanticsNode.getId());
                    return;
                }
                return;
            } else {
                String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getTestTag());
                if (str != null) {
                    info.getExtras().putCharSequence(extraDataKey, str);
                    return;
                }
                return;
            }
        }
        int i5 = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i6 = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i6 > 0 && i5 >= 0) {
            if (i5 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig());
                if (textLayoutResult == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = i5 + i7;
                    if (i8 >= textLayoutResult.getLayoutInput().getText().length()) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i8)));
                    }
                }
                info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.graphics.Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        android.graphics.Rect adjustedBounds = node.getAdjustedBounds();
        long mo1913localToScreenMKHz9U = this.view.mo1913localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.left, adjustedBounds.top));
        long mo1913localToScreenMKHz9U2 = this.view.mo1913localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.right, adjustedBounds.bottom));
        return new android.graphics.Rect((int) Math.floor(Offset.m1337getXimpl(mo1913localToScreenMKHz9U)), (int) Math.floor(Offset.m1338getYimpl(mo1913localToScreenMKHz9U)), (int) Math.ceil(Offset.m1337getXimpl(mo1913localToScreenMKHz9U2)), (int) Math.ceil(Offset.m1338getYimpl(mo1913localToScreenMKHz9U2)));
    }

    /* renamed from: canScroll-moWRBKg, reason: not valid java name */
    private final boolean m2111canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey<ScrollAxisRange> horizontalScrollAxisRange;
        boolean z5;
        ScrollAxisRange scrollAxisRange;
        if (Offset.m1334equalsimpl0(position, Offset.INSTANCE.m1348getUnspecifiedF1C5BW0()) || !Offset.m1340isValidimpl(position)) {
            return false;
        }
        if (vertical) {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else {
            if (vertical) {
                throw new NoWhenBranchMatchedException();
            }
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr = currentSemanticsNodes.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            boolean z6 = false;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j5 & 255) < 128) {
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) objArr[(i5 << 3) + i7];
                            if (RectHelper_androidKt.toComposeRect(semanticsNodeWithAdjustedBounds.getAdjustedBounds()).m1354containsk4lQ0M(position) && (scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig(), horizontalScrollAxisRange)) != null) {
                                int i8 = scrollAxisRange.getReverseScrolling() ? -direction : direction;
                                if (direction == 0 && scrollAxisRange.getReverseScrolling()) {
                                    i8 = -1;
                                }
                                if (i8 < 0) {
                                    if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
                                    }
                                    z6 = true;
                                } else {
                                    if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue()) {
                                    }
                                    z6 = true;
                                }
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return z6;
                    }
                }
                if (i5 == length) {
                    z5 = z6;
                    break;
                }
                i5++;
            }
        } else {
            z5 = false;
        }
        return z5;
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui_release()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
        return true;
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(eventType);
        obtain.setEnabled(true);
        obtain.setClassName("android.view.View");
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, virtualViewId);
        if (isEnabled$ui_release() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
            obtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        }
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (virtualViewId == -1) {
            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
            obtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode parent = semanticsNode.getParent();
            Integer valueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
            if (valueOf == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                throw new KotlinNothingValueException();
            }
            int intValue = valueOf.intValue();
            obtain.setParent(this.view, intValue != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? intValue : -1);
        }
        obtain.setSource(this.view, virtualViewId);
        obtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
        populateAccessibilityNodeInfoProperties(virtualViewId, obtain, semanticsNode);
        return obtain;
    }

    private final String createStateDescriptionForTextField(SemanticsNode node) {
        Collection collection;
        CharSequence charSequence;
        SemanticsConfiguration config = node.copyWithMergingEnabled$ui_release().getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        Collection collection2 = (Collection) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getContentDescription());
        if ((collection2 == null || collection2.isEmpty()) && (((collection = (Collection) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getText())) == null || collection.isEmpty()) && ((charSequence = (CharSequence) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getEditableText())) == null || charSequence.length() == 0))) {
            return this.view.getContext().getResources().getString(R$string.state_empty);
        }
        return null;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent createEvent = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            createEvent.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            createEvent.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            createEvent.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            createEvent.getText().add(text);
        }
        return createEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z5) {
        androidComposeViewAccessibilityDelegateCompat.enabledServices = z5 ? androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1) : CollectionsKt.emptyList();
    }

    private final void geometryDepthFirstSearch(SemanticsNode currNode, ArrayList<SemanticsNode> geometryList, MutableIntObjectMap<List<SemanticsNode>> containerMapToChildren) {
        boolean isRtl;
        isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(currNode);
        boolean booleanValue = ((Boolean) currNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue();
        if ((booleanValue || isScreenReaderFocusable(currNode)) && getCurrentSemanticsNodes().containsKey(currNode.getId())) {
            geometryList.add(currNode);
        }
        if (booleanValue) {
            containerMapToChildren.set(currNode.getId(), subtreeSortedByGeometryGrouping(isRtl, CollectionsKt.toMutableList((Collection) currNode.getChildren())));
            return;
        }
        List<SemanticsNode> children = currNode.getChildren();
        int size = children.size();
        for (int i5 = 0; i5 < size; i5++) {
            geometryDepthFirstSearch(children.get(i5), geometryList, containerMapToChildren);
        }
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig.contains(semanticsProperties.getContentDescription()) || !node.getUnmergedConfig().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.m2280getEndimpl(((TextRange) node.getUnmergedConfig().get(semanticsProperties.getTextSelectionRange())).getPackedValue());
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig.contains(semanticsProperties.getContentDescription()) || !node.getUnmergedConfig().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.m2285getStartimpl(((TextRange) node.getUnmergedConfig().get(semanticsProperties.getTextSelectionRange())).getPackedValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            if (isEnabled$ui_release()) {
                setTraversalValues();
            }
        }
        return this.currentSemanticsNodes;
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getRole());
        boolean z5 = toggleableState != null;
        if (((Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getSelected())) != null) {
            return role != null ? Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2176getTabo7Vup1c()) : false ? z5 : true;
        }
        return z5;
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        Object orNull = SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getStateDescription());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getRole());
        if (toggleableState != null) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i5 == 1) {
                if ((role == null ? false : Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2175getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R$string.state_on);
                }
            } else if (i5 == 2) {
                if ((role == null ? false : Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2175getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R$string.state_off);
                }
            } else if (i5 == 3 && orNull == null) {
                orNull = this.view.getContext().getResources().getString(R$string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2176getTabo7Vup1c())) && orNull == null) {
                orNull = booleanValue ? this.view.getContext().getResources().getString(R$string.selected) : this.view.getContext().getResources().getString(R$string.not_selected);
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    float current = ((range.getEndInclusive().floatValue() - range.getStart().floatValue()) > 0.0f ? 1 : ((range.getEndInclusive().floatValue() - range.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    if (current < 0.0f) {
                        current = 0.0f;
                    }
                    if (current > 1.0f) {
                        current = 1.0f;
                    }
                    if (!(current == 0.0f)) {
                        r5 = (current == 1.0f ? 1 : 0) != 0 ? 100 : RangesKt.coerceIn(Math.round(current * 100), 1, 99);
                    }
                    orNull = this.view.getContext().getResources().getString(R$string.template_percent, Integer.valueOf(r5));
                }
            } else if (orNull == null) {
                orNull = this.view.getContext().getResources().getString(R$string.in_progress);
            }
        }
        if (node.getUnmergedConfig().contains(semanticsProperties.getEditableText())) {
            orNull = createStateDescriptionForTextField(node);
        }
        return (String) orNull;
    }

    private final AnnotatedString getInfoText(SemanticsNode node) {
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        return textForTextField == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : textForTextField;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig.contains(semanticsProperties.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(semanticsProperties.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(semanticsProperties.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AccessibilityIterators$TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        String iterableTextForAccessibility;
        TextLayoutResult textLayoutResult;
        if (node == null || (iterableTextForAccessibility = getIterableTextForAccessibility(node)) == null || iterableTextForAccessibility.length() == 0) {
            return null;
        }
        if (granularity == 1) {
            AccessibilityIterators$CharacterTextSegmentIterator companion = AccessibilityIterators$CharacterTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            companion.initialize(iterableTextForAccessibility);
            return companion;
        }
        if (granularity == 2) {
            AccessibilityIterators$WordTextSegmentIterator companion2 = AccessibilityIterators$WordTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            companion2.initialize(iterableTextForAccessibility);
            return companion2;
        }
        if (granularity != 4) {
            if (granularity == 8) {
                AccessibilityIterators$ParagraphTextSegmentIterator companion3 = AccessibilityIterators$ParagraphTextSegmentIterator.INSTANCE.getInstance();
                companion3.initialize(iterableTextForAccessibility);
                return companion3;
            }
            if (granularity != 16) {
                return null;
            }
        }
        if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig())) == null) {
            return null;
        }
        if (granularity == 4) {
            AccessibilityIterators$LineTextSegmentIterator companion4 = AccessibilityIterators$LineTextSegmentIterator.INSTANCE.getInstance();
            companion4.initialize(iterableTextForAccessibility, textLayoutResult);
            return companion4;
        }
        AccessibilityIterators$PageTextSegmentIterator companion5 = AccessibilityIterators$PageTextSegmentIterator.INSTANCE.getInstance();
        companion5.initialize(iterableTextForAccessibility, textLayoutResult, node);
        return companion5;
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return !unmergedConfig.contains(semanticsProperties.getContentDescription()) && node.getUnmergedConfig().contains(semanticsProperties.getEditableText());
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        boolean z5 = ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null && !getInfoIsCheckable(node)) ? false : true;
        if (SemanticsUtils_androidKt.isVisible(node)) {
            if (node.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                return true;
            }
            if (node.isUnmergedLeafNode$ui_release() && z5) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo3767trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c9  */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x01a7 -> B:87:0x01a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        SemanticsNode semanticsNode;
        Function0 function0;
        boolean enabled;
        Function0 function02;
        Function0 function03;
        Function0 function04;
        float f5;
        int i5;
        Function0 function05;
        boolean isRtl;
        Function0 function06;
        Function0 function07;
        Function0 function08;
        Function0 function09;
        Function0 function010;
        Function0 function011;
        Function1 function1;
        AccessibilityAction accessibilityAction;
        boolean isRtl2;
        Function2 function2;
        SemanticsConfiguration unmergedConfig;
        SemanticsConfiguration unmergedConfig2;
        AccessibilityAction accessibilityAction2;
        Function1 function12;
        Function0 function012;
        Function0 function013;
        Function0 function014;
        Function0 function015;
        Function0 function016;
        CharSequence charSequence;
        List list;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return false;
        }
        if (action == 64) {
            return requestAccessibilityFocus(virtualViewId);
        }
        if (action == 128) {
            return clearAccessibilityFocus(virtualViewId);
        }
        if (action == 256 || action == 512) {
            if (arguments != null) {
                return traverseAtGranularity(semanticsNode, arguments.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"), action == 256, arguments.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"));
            }
            return false;
        }
        if (action == 16384) {
            AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
            if (accessibilityAction3 == null || (function0 = (Function0) accessibilityAction3.getAction()) == null) {
                return false;
            }
            return ((Boolean) function0.invoke()).booleanValue();
        }
        if (action == 131072) {
            boolean accessibilitySelection = setAccessibilitySelection(semanticsNode, arguments != null ? arguments.getInt("ACTION_ARGUMENT_SELECTION_START_INT", -1) : -1, arguments != null ? arguments.getInt("ACTION_ARGUMENT_SELECTION_END_INT", -1) : -1, false);
            if (accessibilitySelection) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 0, null, null, 12, null);
            }
            return accessibilitySelection;
        }
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (!enabled) {
            return false;
        }
        if (action == 1) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getRequestFocus());
            if (accessibilityAction4 == null || (function02 = (Function0) accessibilityAction4.getAction()) == null) {
                return false;
            }
            return ((Boolean) function02.invoke()).booleanValue();
        }
        if (action == 2) {
            if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), Boolean.TRUE)) {
                return false;
            }
            this.view.getFocusOwner().mo1290clearFocusI7lrPNg(false, true, true, FocusDirection.INSTANCE.m1281getExitdhqQ8s());
            return true;
        }
        Boolean bool = null;
        bool = null;
        switch (action) {
            case 16:
                AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                if (accessibilityAction5 != null && (function03 = (Function0) accessibilityAction5.getAction()) != null) {
                    bool = (Boolean) function03.invoke();
                }
                Boolean bool2 = bool;
                sendEventForVirtualView$default(this, virtualViewId, 1, null, null, 12, null);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return false;
            case 32:
                AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                if (accessibilityAction6 == null || (function04 = (Function0) accessibilityAction6.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function04.invoke()).booleanValue();
            case 4096:
            case 8192:
                break;
            case 32768:
                AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                if (accessibilityAction7 == null || (function07 = (Function0) accessibilityAction7.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function07.invoke()).booleanValue();
            case 65536:
                AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                if (accessibilityAction8 == null || (function08 = (Function0) accessibilityAction8.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function08.invoke()).booleanValue();
            case 262144:
                AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                if (accessibilityAction9 == null || (function09 = (Function0) accessibilityAction9.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function09.invoke()).booleanValue();
            case 524288:
                AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                if (accessibilityAction10 == null || (function010 = (Function0) accessibilityAction10.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function010.invoke()).booleanValue();
            case 1048576:
                AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                if (accessibilityAction11 == null || (function011 = (Function0) accessibilityAction11.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function011.invoke()).booleanValue();
            case 2097152:
                String string = arguments != null ? arguments.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE") : null;
                AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                if (accessibilityAction12 == null || (function1 = (Function1) accessibilityAction12.getAction()) == null) {
                    return false;
                }
                if (string == null) {
                    string = BuildConfig.FLAVOR;
                }
                return ((Boolean) function1.invoke(new AnnotatedString(string, null, null, 6, null))).booleanValue();
            case R.id.accessibilityActionShowOnScreen:
                SemanticsNode parent = semanticsNode.getParent();
                if (parent != null && (unmergedConfig2 = parent.getUnmergedConfig()) != null) {
                    accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig2, SemanticsActions.INSTANCE.getScrollBy());
                    while (parent != null && accessibilityAction == null) {
                        parent = parent.getParent();
                        if (parent != null && (unmergedConfig = parent.getUnmergedConfig()) != null) {
                            accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getScrollBy());
                        }
                    }
                    if (parent != null) {
                        return false;
                    }
                    Rect boundsInParent = LayoutCoordinatesKt.boundsInParent(parent.getLayoutInfo().getCoordinates());
                    LayoutCoordinates parentLayoutCoordinates = parent.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                    Rect m1359translatek4lQ0M = boundsInParent.m1359translatek4lQ0M(parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.INSTANCE.m1349getZeroF1C5BW0());
                    Rect m1362Recttz77jQw = RectKt.m1362Recttz77jQw(semanticsNode.m2178getPositionInRootF1C5BW0(), IntSizeKt.m2668toSizeozmzZPI(semanticsNode.m2179getSizeYbymL2g()));
                    SemanticsConfiguration unmergedConfig3 = parent.getUnmergedConfig();
                    SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                    ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(unmergedConfig3, semanticsProperties.getHorizontalScrollAxisRange());
                    ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig(), semanticsProperties.getVerticalScrollAxisRange());
                    float performActionHelper$scrollDelta = performActionHelper$scrollDelta(m1362Recttz77jQw.getLeft() - m1359translatek4lQ0M.getLeft(), m1362Recttz77jQw.getRight() - m1359translatek4lQ0M.getRight());
                    if (scrollAxisRange != null && scrollAxisRange.getReverseScrolling()) {
                        performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                    }
                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    if (isRtl2) {
                        performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                    }
                    float performActionHelper$scrollDelta2 = performActionHelper$scrollDelta(m1362Recttz77jQw.getTop() - m1359translatek4lQ0M.getTop(), m1362Recttz77jQw.getBottom() - m1359translatek4lQ0M.getBottom());
                    if (scrollAxisRange2 != null && scrollAxisRange2.getReverseScrolling()) {
                        performActionHelper$scrollDelta2 = -performActionHelper$scrollDelta2;
                    }
                    if (accessibilityAction == null || (function2 = (Function2) accessibilityAction.getAction()) == null) {
                        return false;
                    }
                    return ((Boolean) function2.invoke(Float.valueOf(performActionHelper$scrollDelta), Float.valueOf(performActionHelper$scrollDelta2))).booleanValue();
                }
                accessibilityAction = null;
                while (parent != null) {
                    parent = parent.getParent();
                    if (parent != null) {
                        accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getScrollBy());
                    }
                    accessibilityAction = null;
                    while (parent != null) {
                    }
                }
                if (parent != null) {
                }
                break;
            case R.id.accessibilityActionSetProgress:
                if (arguments == null || !arguments.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") || (accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null || (function12 = (Function1) accessibilityAction2.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function12.invoke(Float.valueOf(arguments.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")))).booleanValue();
            case R.id.accessibilityActionImeEnter:
                AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
                if (accessibilityAction13 == null || (function012 = (Function0) accessibilityAction13.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function012.invoke()).booleanValue();
            default:
                switch (action) {
                    case R.id.accessibilityActionScrollUp:
                    case R.id.accessibilityActionScrollLeft:
                    case R.id.accessibilityActionScrollDown:
                    case R.id.accessibilityActionScrollRight:
                        break;
                    default:
                        switch (action) {
                            case R.id.accessibilityActionPageUp:
                                AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                                if (accessibilityAction14 == null || (function013 = (Function0) accessibilityAction14.getAction()) == null) {
                                    return false;
                                }
                                return ((Boolean) function013.invoke()).booleanValue();
                            case R.id.accessibilityActionPageDown:
                                AccessibilityAction accessibilityAction15 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                                if (accessibilityAction15 == null || (function014 = (Function0) accessibilityAction15.getAction()) == null) {
                                    return false;
                                }
                                return ((Boolean) function014.invoke()).booleanValue();
                            case R.id.accessibilityActionPageLeft:
                                AccessibilityAction accessibilityAction16 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                                if (accessibilityAction16 == null || (function015 = (Function0) accessibilityAction16.getAction()) == null) {
                                    return false;
                                }
                                return ((Boolean) function015.invoke()).booleanValue();
                            case R.id.accessibilityActionPageRight:
                                AccessibilityAction accessibilityAction17 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                                if (accessibilityAction17 == null || (function016 = (Function0) accessibilityAction17.getAction()) == null) {
                                    return false;
                                }
                                return ((Boolean) function016.invoke()).booleanValue();
                            default:
                                SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(virtualViewId);
                                if (sparseArrayCompat == null || (charSequence = sparseArrayCompat.get(action)) == null || (list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions())) == null) {
                                    return false;
                                }
                                int size = list.size();
                                for (int i6 = 0; i6 < size; i6++) {
                                    CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i6);
                                    if (Intrinsics.areEqual(customAccessibilityAction.getLabel(), charSequence)) {
                                        return customAccessibilityAction.getAction().invoke().booleanValue();
                                    }
                                }
                                return false;
                        }
                }
        }
        ?? r12 = action == 4096;
        ?? r22 = action == 8192;
        ?? r42 = action == 16908345;
        ?? r6 = action == 16908347;
        ?? r9 = action == 16908344;
        ?? r02 = action == 16908346;
        ?? r10 = r42 == true || r6 == true || r12 == true || r22 == true;
        ?? r03 = r9 == true || r02 == true || r12 == true || r22 == true;
        if (r12 != false || r22 != false) {
            ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
            AccessibilityAction accessibilityAction18 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress());
            if (progressBarRangeInfo != null && accessibilityAction18 != null) {
                float coerceAtLeast = RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue());
                float coerceAtMost = RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue());
                if (progressBarRangeInfo.getSteps() > 0) {
                    f5 = coerceAtLeast - coerceAtMost;
                    i5 = progressBarRangeInfo.getSteps() + 1;
                } else {
                    f5 = coerceAtLeast - coerceAtMost;
                    i5 = 20;
                }
                float f6 = f5 / i5;
                if (r22 != false) {
                    f6 = -f6;
                }
                Function1 function13 = (Function1) accessibilityAction18.getAction();
                if (function13 != null) {
                    return ((Boolean) function13.invoke(Float.valueOf(progressBarRangeInfo.getCurrent() + f6))).booleanValue();
                }
                return false;
            }
        }
        long m1357getSizeNHjbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode.getLayoutInfo().getCoordinates()).m1357getSizeNHjbRc();
        Float scrollViewportLength = SemanticsUtils_androidKt.getScrollViewportLength(semanticsNode.getUnmergedConfig());
        SemanticsConfiguration unmergedConfig4 = semanticsNode.getUnmergedConfig();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        AccessibilityAction accessibilityAction19 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig4, semanticsActions.getScrollBy());
        if (accessibilityAction19 == null) {
            return false;
        }
        SemanticsConfiguration unmergedConfig5 = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
        ScrollAxisRange scrollAxisRange3 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(unmergedConfig5, semanticsProperties2.getHorizontalScrollAxisRange());
        if (scrollAxisRange3 != null && r10 != false) {
            float floatValue = scrollViewportLength != null ? scrollViewportLength.floatValue() : Size.m1377getWidthimpl(m1357getSizeNHjbRc);
            if (r42 != false || r22 != false) {
                floatValue = -floatValue;
            }
            if (scrollAxisRange3.getReverseScrolling()) {
                floatValue = -floatValue;
            }
            isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
            if (isRtl && (r42 != false || r6 != false)) {
                floatValue = -floatValue;
            }
            if (performActionHelper$canScroll(scrollAxisRange3, floatValue)) {
                if (semanticsNode.getUnmergedConfig().contains(semanticsActions.getPageLeft()) || semanticsNode.getUnmergedConfig().contains(semanticsActions.getPageRight())) {
                    AccessibilityAction accessibilityAction20 = floatValue > 0.0f ? (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageRight()) : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageLeft());
                    if (accessibilityAction20 != null && (function06 = (Function0) accessibilityAction20.getAction()) != null) {
                        return ((Boolean) function06.invoke()).booleanValue();
                    }
                } else {
                    Function2 function22 = (Function2) accessibilityAction19.getAction();
                    if (function22 != null) {
                        return ((Boolean) function22.invoke(Float.valueOf(floatValue), Float.valueOf(0.0f))).booleanValue();
                    }
                }
                return false;
            }
        }
        ScrollAxisRange scrollAxisRange4 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getVerticalScrollAxisRange());
        if (scrollAxisRange4 == null || !r03 == true) {
            return false;
        }
        float floatValue2 = scrollViewportLength != null ? scrollViewportLength.floatValue() : Size.m1375getHeightimpl(m1357getSizeNHjbRc);
        if (r9 != false || r22 != false) {
            floatValue2 = -floatValue2;
        }
        if (scrollAxisRange4.getReverseScrolling()) {
            floatValue2 = -floatValue2;
        }
        if (!performActionHelper$canScroll(scrollAxisRange4, floatValue2)) {
            return false;
        }
        if (semanticsNode.getUnmergedConfig().contains(semanticsActions.getPageUp()) || semanticsNode.getUnmergedConfig().contains(semanticsActions.getPageDown())) {
            AccessibilityAction accessibilityAction21 = floatValue2 > 0.0f ? (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageDown()) : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPageUp());
            if (accessibilityAction21 != null && (function05 = (Function0) accessibilityAction21.getAction()) != null) {
                return ((Boolean) function05.invoke()).booleanValue();
            }
        } else {
            Function2 function23 = (Function2) accessibilityAction19.getAction();
            if (function23 != null) {
                return ((Boolean) function23.invoke(Float.valueOf(0.0f), Float.valueOf(floatValue2))).booleanValue();
            }
        }
        return false;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f5) {
        return (f5 < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f5 > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f5, float f6) {
        if (Math.signum(f5) == Math.signum(f6)) {
            return Math.abs(f5) < Math.abs(f6) ? f5 : f6;
        }
        return 0.0f;
    }

    private final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        boolean enabled;
        boolean enabled2;
        boolean enabled3;
        View semanticsIdToView;
        boolean enabled4;
        boolean enabled5;
        boolean isRtl;
        boolean isRtl2;
        boolean enabled6;
        boolean excludeLineAndPageGranularities;
        boolean enabled7;
        boolean z5;
        boolean enabled8;
        boolean z6;
        info.setClassName("android.view.View");
        SemanticsConfiguration unmergedConfig = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig.contains(semanticsProperties.getEditableText())) {
            info.setClassName("android.widget.EditText");
        }
        if (semanticsNode.getUnmergedConfig().contains(semanticsProperties.getText())) {
            info.setClassName("android.widget.TextView");
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getRole());
        if (role != null) {
            role.getValue();
            if (semanticsNode.getIsFake() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                Role.Companion companion = Role.INSTANCE;
                if (Role.m2166equalsimpl0(role.getValue(), companion.m2176getTabo7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R$string.tab));
                } else if (Role.m2166equalsimpl0(role.getValue(), companion.m2175getSwitcho7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R$string.switch_role));
                } else {
                    String m2151toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m2151toLegacyClassNameV4PA4sw(role.getValue());
                    if (!Role.m2166equalsimpl0(role.getValue(), companion.m2173getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                        info.setClassName(m2151toLegacyClassNameV4PA4sw);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        info.setPackageName(this.view.getContext().getPackageName());
        info.setImportantForAccessibility(SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode));
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i5 = 0; i5 < size; i5++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i5);
            if (getCurrentSemanticsNodes().contains(semanticsNode2.getId())) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.getLayoutNode());
                if (semanticsNode2.getId() != -1) {
                    if (androidViewHolder != null) {
                        info.addChild(androidViewHolder);
                    } else {
                        info.addChild(this.view, semanticsNode2.getId());
                    }
                }
            }
        }
        if (virtualViewId == this.focusedVirtualViewId) {
            info.setAccessibilityFocused(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            info.setAccessibilityFocused(false);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        setStateDescription(semanticsNode, info);
        setIsCheckable(semanticsNode, info);
        SemanticsConfiguration unmergedConfig2 = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(unmergedConfig2, semanticsProperties2.getToggleableState());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                info.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                info.setChecked(false);
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2176getTabo7Vup1c())) {
                info.setSelected(booleanValue);
            } else {
                info.setChecked(booleanValue);
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getContentDescription());
            info.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull(list) : null);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getTestTag());
        if (str != null) {
            SemanticsNode semanticsNode3 = semanticsNode;
            while (true) {
                if (semanticsNode3 == null) {
                    z6 = false;
                    break;
                }
                SemanticsConfiguration unmergedConfig3 = semanticsNode3.getUnmergedConfig();
                SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.INSTANCE;
                if (unmergedConfig3.contains(semanticsPropertiesAndroid.getTestTagsAsResourceId())) {
                    z6 = ((Boolean) semanticsNode3.getUnmergedConfig().get(semanticsPropertiesAndroid.getTestTagsAsResourceId())).booleanValue();
                    break;
                }
                semanticsNode3 = semanticsNode3.getParent();
            }
            if (z6) {
                info.setViewIdResourceName(str);
            }
        }
        SemanticsConfiguration unmergedConfig4 = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties3 = SemanticsProperties.INSTANCE;
        if (((Unit) SemanticsConfigurationKt.getOrNull(unmergedConfig4, semanticsProperties3.getHeading())) != null) {
            info.setHeading(true);
            Unit unit4 = Unit.INSTANCE;
        }
        info.setPassword(semanticsNode.getUnmergedConfig().contains(semanticsProperties3.getPassword()));
        info.setEditable(semanticsNode.getUnmergedConfig().contains(semanticsProperties3.getIsEditable()));
        Integer num = (Integer) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getMaxTextLength());
        info.setMaxTextLength(num != null ? num.intValue() : -1);
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        info.setEnabled(enabled);
        info.setFocusable(semanticsNode.getUnmergedConfig().contains(semanticsProperties3.getFocused()));
        if (info.isFocusable()) {
            info.setFocused(((Boolean) semanticsNode.getUnmergedConfig().get(semanticsProperties3.getFocused())).booleanValue());
            if (info.isFocused()) {
                info.addAction(2);
            } else {
                info.addAction(1);
            }
        }
        info.setVisibleToUser(SemanticsUtils_androidKt.isVisible(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getLiveRegion());
        if (liveRegionMode != null) {
            int value = liveRegionMode.getValue();
            LiveRegionMode.Companion companion2 = LiveRegionMode.INSTANCE;
            info.setLiveRegion((LiveRegionMode.m2157equalsimpl0(value, companion2.m2162getPolite0phEisY()) || !LiveRegionMode.m2157equalsimpl0(value, companion2.m2161getAssertive0phEisY())) ? 1 : 2);
            Unit unit5 = Unit.INSTANCE;
        }
        info.setClickable(false);
        SemanticsConfiguration unmergedConfig5 = semanticsNode.getUnmergedConfig();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig5, semanticsActions.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getSelected()), Boolean.TRUE);
            Role.Companion companion3 = Role.INSTANCE;
            if (!(role == null ? false : Role.m2166equalsimpl0(role.getValue(), companion3.m2176getTabo7Vup1c()))) {
                if (!(role == null ? false : Role.m2166equalsimpl0(role.getValue(), companion3.m2174getRadioButtono7Vup1c()))) {
                    z5 = false;
                    info.setClickable(z5 || (z5 && !areEqual));
                    enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled8 && info.isClickable()) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
                    }
                    Unit unit6 = Unit.INSTANCE;
                }
            }
            z5 = true;
            info.setClickable(z5 || (z5 && !areEqual));
            enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled8) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit62 = Unit.INSTANCE;
        }
        info.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getOnLongClick());
        if (accessibilityAction2 != null) {
            info.setLongClickable(true);
            enabled7 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled7) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit7 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getCopyText());
        if (accessibilityAction3 != null) {
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit8 = Unit.INSTANCE;
        }
        enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled2) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getSetText());
            if (accessibilityAction4 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit9 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getOnImeAction());
            if (accessibilityAction5 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionImeEnter, accessibilityAction5.getLabel()));
                Unit unit10 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getCutText());
            if (accessibilityAction6 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction6.getLabel()));
                Unit unit11 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getPasteText());
            if (accessibilityAction7 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction7.getLabel()));
                }
                Unit unit12 = Unit.INSTANCE;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getSetSelection());
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction8 != null ? accessibilityAction8.getLabel() : null));
            info.addAction(256);
            info.addAction(512);
            info.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getContentDescription());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig().contains(semanticsActions.getGetTextLayoutResult())) {
                excludeLineAndPageGranularities = AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode);
                if (!excludeLineAndPageGranularities) {
                    info.setMovementGranularities(info.getMovementGranularities() | 20);
                }
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        ArrayList arrayList = new ArrayList();
        arrayList.add("androidx.compose.ui.semantics.id");
        CharSequence text = info.getText();
        if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig().contains(semanticsActions.getGetTextLayoutResult())) {
            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
        }
        if (semanticsNode.getUnmergedConfig().contains(semanticsProperties3.getTestTag())) {
            arrayList.add("androidx.compose.ui.semantics.testTag");
        }
        info.setAvailableExtraData(arrayList);
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig().contains(semanticsActions.getSetProgress())) {
                info.setClassName("android.widget.SeekBar");
            } else {
                info.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig().contains(semanticsActions.getSetProgress())) {
                enabled6 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled6) {
                    if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode, info);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode, info);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getScrollBy());
        if (scrollAxisRange != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled5) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    info.addAction(!isRtl2 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                    info.addAction(!isRtl ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getVerticalScrollAxisRange());
        if (scrollAxisRange2 != null && accessibilityAction9 != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            enabled4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled4) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (i6 >= 29) {
            Api29Impl.addPageActions(info, semanticsNode);
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties3.getPaneTitle()));
        enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled3) {
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getExpand());
            if (accessibilityAction10 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction10.getLabel()));
                Unit unit13 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getCollapse());
            if (accessibilityAction11 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction11.getLabel()));
                Unit unit14 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsActions.getDismiss());
            if (accessibilityAction12 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction12.getLabel()));
                Unit unit15 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig().contains(semanticsActions.getCustomActions())) {
                List list3 = (List) semanticsNode.getUnmergedConfig().get(semanticsActions.getCustomActions());
                int size2 = list3.size();
                IntList intList = AccessibilityActionsResourceIds;
                if (size2 >= intList.get_size()) {
                    throw new IllegalStateException("Can't have more than " + intList.get_size() + " custom actions for one widget");
                }
                SparseArrayCompat<CharSequence> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
                MutableObjectIntMap<CharSequence> mutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                if (this.labelToActionId.containsKey(virtualViewId)) {
                    MutableObjectIntMap<CharSequence> mutableObjectIntMap = this.labelToActionId.get(virtualViewId);
                    MutableIntList mutableIntList = new MutableIntList(0, 1, null);
                    int[] iArr = intList.content;
                    int i7 = intList._size;
                    for (int i8 = 0; i8 < i7; i8++) {
                        mutableIntList.add(iArr[i8]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = list3.size();
                    for (int i9 = 0; i9 < size3; i9++) {
                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list3.get(i9);
                        Intrinsics.checkNotNull(mutableObjectIntMap);
                        if (mutableObjectIntMap.contains(customAccessibilityAction.getLabel())) {
                            int i10 = mutableObjectIntMap.get(customAccessibilityAction.getLabel());
                            sparseArrayCompat.put(i10, customAccessibilityAction.getLabel());
                            mutableObjectIntMapOf.set(customAccessibilityAction.getLabel(), i10);
                            mutableIntList.remove(i10);
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i10, customAccessibilityAction.getLabel()));
                        } else {
                            arrayList2.add(customAccessibilityAction);
                        }
                    }
                    int size4 = arrayList2.size();
                    for (int i11 = 0; i11 < size4; i11++) {
                        CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i11);
                        int i12 = mutableIntList.get(i11);
                        sparseArrayCompat.put(i12, customAccessibilityAction2.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction2.getLabel(), i12);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i12, customAccessibilityAction2.getLabel()));
                    }
                } else {
                    int size5 = list3.size();
                    for (int i13 = 0; i13 < size5; i13++) {
                        CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list3.get(i13);
                        int i14 = AccessibilityActionsResourceIds.get(i13);
                        sparseArrayCompat.put(i14, customAccessibilityAction3.getLabel());
                        mutableObjectIntMapOf.set(customAccessibilityAction3.getLabel(), i14);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i14, customAccessibilityAction3.getLabel()));
                    }
                }
                this.actionIdToLabel.put(virtualViewId, sparseArrayCompat);
                this.labelToActionId.put(virtualViewId, mutableObjectIntMapOf);
            }
        }
        info.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode));
        int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
        if (orDefault != -1) {
            View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault);
            if (semanticsIdToView2 != null) {
                info.setTraversalBefore(semanticsIdToView2);
            } else {
                info.setTraversalBefore(this.view, orDefault);
            }
            addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, this.ExtraDataTestTraversalBeforeVal, null);
        }
        int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
        if (orDefault2 == -1 || (semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault2)) == null) {
            return;
        }
        info.setTraversalAfter(semanticsIdToView);
        addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, this.ExtraDataTestTraversalAfterVal, null);
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        boolean z5;
        ScrollObservationScope findById = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (findById != null) {
            z5 = false;
        } else {
            findById = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
            z5 = true;
        }
        this.scrollObservationScopes.add(findById);
        return z5;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i5 = this.focusedVirtualViewId;
        if (i5 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i5, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
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
                    int semanticsNodeIdToAccessibilityVirtualNodeId;
                    IntObjectMap currentSemanticsNodes;
                    IntObjectMap currentSemanticsNodes2;
                    SemanticsNode semanticsNode;
                    LayoutNode layoutNode;
                    MutableIntObjectMap mutableIntObjectMap;
                    MutableIntObjectMap mutableIntObjectMap2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    android.graphics.Rect boundsInScreen;
                    ScrollAxisRange horizontalScrollAxisRange = ScrollObservationScope.this.getHorizontalScrollAxisRange();
                    ScrollAxisRange verticalScrollAxisRange = ScrollObservationScope.this.getVerticalScrollAxisRange();
                    Float oldXValue = ScrollObservationScope.this.getOldXValue();
                    Float oldYValue = ScrollObservationScope.this.getOldYValue();
                    float floatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
                    float floatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
                    if (floatValue != 0.0f || floatValue2 != 0.0f) {
                        semanticsNodeIdToAccessibilityVirtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(ScrollObservationScope.this.getSemanticsNodeId());
                        currentSemanticsNodes = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes.get(this.focusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI;
                                if (accessibilityNodeInfoCompat != null) {
                                    boundsInScreen = androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds);
                                    accessibilityNodeInfoCompat.setBoundsInScreen(boundsInScreen);
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        currentSemanticsNodes2 = this.getCurrentSemanticsNodes();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) currentSemanticsNodes2.get(semanticsNodeIdToAccessibilityVirtualNodeId);
                        if (semanticsNodeWithAdjustedBounds2 != null && (semanticsNode = semanticsNodeWithAdjustedBounds2.getSemanticsNode()) != null && (layoutNode = semanticsNode.getLayoutNode()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            if (horizontalScrollAxisRange != null) {
                                mutableIntObjectMap2 = androidComposeViewAccessibilityDelegateCompat2.pendingHorizontalScrollEvents;
                                mutableIntObjectMap2.set(semanticsNodeIdToAccessibilityVirtualNodeId, horizontalScrollAxisRange);
                            }
                            if (verticalScrollAxisRange != null) {
                                mutableIntObjectMap = androidComposeViewAccessibilityDelegateCompat2.pendingVerticalScrollEvents;
                                mutableIntObjectMap.set(semanticsNodeIdToAccessibilityVirtualNodeId, verticalScrollAxisRange);
                            }
                            androidComposeViewAccessibilityDelegateCompat2.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        }
                    }
                    if (horizontalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
                    }
                    if (verticalScrollAxisRange != null) {
                        ScrollObservationScope.this.setOldYValue(verticalScrollAxisRange.getValue().invoke());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$49(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i5 = 0; i5 < size; i5++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i5);
            if (getCurrentSemanticsNodes().contains(semanticsNode.getId())) {
                if (!oldNode.getChildren().contains(semanticsNode.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                mutableIntSetOf.add(semanticsNode.getId());
            }
        }
        MutableIntSet children = oldNode.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128 && !mutableIntSetOf.contains(iArr[(i6 << 3) + i8])) {
                            notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                            return;
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
        for (int i9 = 0; i9 < size2; i9++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i9);
            if (getCurrentSemanticsNodes().contains(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
        }
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent createEvent = createEvent(virtualViewId, eventType);
        if (contentChangeType != null) {
            createEvent.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            createEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        Trace.beginSection("sendEvent");
        try {
            return sendEvent(createEvent);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i5, int i6, Integer num, List list, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            num = null;
        }
        if ((i7 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i5, i6, num, list);
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        createEvent.setContentChangeTypes(contentChangeType);
        if (title != null) {
            createEvent.getText().add(title);
        }
        sendEvent(createEvent);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                createEvent.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                createEvent.setToIndex(pendingTextTraversedEvent.getToIndex());
                createEvent.setAction(pendingTextTraversedEvent.getAction());
                createEvent.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                createEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(createEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x0583, code lost:
    
        if (r0.containsAll(r2) != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0586, code lost:
    
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x05da, code lost:
    
        if (r0 == false) goto L162;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        int i5;
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        char c5;
        int i6;
        int i7;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        char c6;
        int i8;
        int i9;
        int i10;
        SemanticsNodeCopy semanticsNodeCopy;
        SemanticsNode semanticsNode;
        int i11;
        int i12;
        int i13;
        int i14;
        ArrayList arrayList3;
        int[] iArr3;
        long[] jArr3;
        char c7;
        int i15;
        boolean accessibilityEquals;
        String text;
        AccessibilityEvent createTextSelectionChangedEvent;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap = newSemanticsNodes;
        ArrayList arrayList4 = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        int[] iArr4 = intObjectMap.keys;
        long[] jArr4 = intObjectMap.metadata;
        char c8 = 2;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j5 = jArr4[i16];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i17 = 8;
                int i18 = 8 - ((~(i16 - length)) >>> 31);
                long j6 = j5;
                int i19 = 0;
                while (i19 < i18) {
                    if ((j6 & 255) >= 128 || (semanticsNodeCopy = this.previousSemanticsNodes.get((i10 = iArr4[(i16 << 3) + i19]))) == null) {
                        i6 = i19;
                        i7 = i16;
                        arrayList2 = arrayList4;
                        iArr2 = iArr4;
                        jArr2 = jArr4;
                        c6 = c8;
                        i8 = i18;
                        i9 = i17;
                    } else {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap.get(i10);
                        SemanticsNode semanticsNode2 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (semanticsNode2 == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsNode2.getUnmergedConfig().iterator();
                        boolean z5 = false;
                        while (it.hasNext()) {
                            Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> next = it.next();
                            SemanticsPropertyKey<?> key = next.getKey();
                            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                            if (((Intrinsics.areEqual(key, semanticsProperties.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(next.getKey(), semanticsProperties.getVerticalScrollAxisRange())) ? registerScrollingId(i10, arrayList4) : false) || !Intrinsics.areEqual(next.getValue(), SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), next.getKey()))) {
                                SemanticsPropertyKey<?> key2 = next.getKey();
                                if (Intrinsics.areEqual(key2, semanticsProperties.getPaneTitle())) {
                                    Object value = next.getValue();
                                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                                    String str = (String) value;
                                    if (semanticsNodeCopy.getUnmergedConfig().contains(semanticsProperties.getPaneTitle())) {
                                        sendPaneChangeEvents(i10, i17, str);
                                    }
                                } else {
                                    if (Intrinsics.areEqual(key2, semanticsProperties.getStateDescription()) ? true : Intrinsics.areEqual(key2, semanticsProperties.getToggleableState())) {
                                        semanticsNode = semanticsNode2;
                                        int i20 = i10;
                                        i11 = i19;
                                        i12 = i18;
                                        i14 = i16;
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i10), 2048, 64, null, 8, null);
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i20), 2048, 0, null, 8, null);
                                        i13 = i20;
                                    } else {
                                        semanticsNode = semanticsNode2;
                                        int i21 = i10;
                                        i11 = i19;
                                        i12 = i18;
                                        if (Intrinsics.areEqual(key2, semanticsProperties.getProgressBarRangeInfo())) {
                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i21), 2048, 64, null, 8, null);
                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i21), 2048, 0, null, 8, null);
                                            arrayList3 = arrayList4;
                                            iArr3 = iArr4;
                                            jArr3 = jArr4;
                                            i13 = i21;
                                            c7 = 2;
                                            i15 = 8;
                                            i14 = i16;
                                        } else {
                                            if (Intrinsics.areEqual(key2, semanticsProperties.getSelected())) {
                                                Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getRole());
                                                if (!(role == null ? false : Role.m2166equalsimpl0(role.getValue(), Role.INSTANCE.m2176getTabo7Vup1c()))) {
                                                    i13 = i21;
                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i21), 2048, 64, null, 8, null);
                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i13), 2048, 0, null, 8, null);
                                                    i14 = i16;
                                                } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getSelected()), Boolean.TRUE)) {
                                                    AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i21), 4);
                                                    SemanticsNode copyWithMergingEnabled$ui_release = semanticsNode.copyWithMergingEnabled$ui_release();
                                                    List list = (List) SemanticsConfigurationKt.getOrNull(copyWithMergingEnabled$ui_release.getConfig(), semanticsProperties.getContentDescription());
                                                    String fastJoinToString$default = list != null ? ListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null) : null;
                                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(copyWithMergingEnabled$ui_release.getConfig(), semanticsProperties.getText());
                                                    String fastJoinToString$default2 = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, ",", null, null, 0, null, null, 62, null) : null;
                                                    if (fastJoinToString$default != null) {
                                                        createEvent.setContentDescription(fastJoinToString$default);
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    if (fastJoinToString$default2 != null) {
                                                        createEvent.getText().add(fastJoinToString$default2);
                                                    }
                                                    sendEvent(createEvent);
                                                    i13 = i21;
                                                    i14 = i16;
                                                } else {
                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i21), 2048, 0, null, 8, null);
                                                    i14 = i16;
                                                    arrayList3 = arrayList4;
                                                    iArr3 = iArr4;
                                                    jArr3 = jArr4;
                                                    i13 = i21;
                                                    c7 = 2;
                                                }
                                            } else {
                                                i13 = i21;
                                                i14 = i16;
                                                if (Intrinsics.areEqual(key2, semanticsProperties.getContentDescription())) {
                                                    int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(i13);
                                                    Object value2 = next.getValue();
                                                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                                    sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                                                } else {
                                                    boolean areEqual = Intrinsics.areEqual(key2, semanticsProperties.getEditableText());
                                                    String str2 = BuildConfig.FLAVOR;
                                                    if (!areEqual) {
                                                        arrayList3 = arrayList4;
                                                        iArr3 = iArr4;
                                                        jArr3 = jArr4;
                                                        c7 = 2;
                                                        if (Intrinsics.areEqual(key2, semanticsProperties.getTextSelectionRange())) {
                                                            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig());
                                                            if (textForTextField != null && (text = textForTextField.getText()) != null) {
                                                                str2 = text;
                                                            }
                                                            long packedValue = ((TextRange) semanticsNode.getUnmergedConfig().get(semanticsProperties.getTextSelectionRange())).getPackedValue();
                                                            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i13), Integer.valueOf(TextRange.m2285getStartimpl(packedValue)), Integer.valueOf(TextRange.m2280getEndimpl(packedValue)), Integer.valueOf(str2.length()), trimToSize(str2, 100000)));
                                                            sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
                                                        } else if (Intrinsics.areEqual(key2, semanticsProperties.getHorizontalScrollAxisRange()) ? true : Intrinsics.areEqual(key2, semanticsProperties.getVerticalScrollAxisRange())) {
                                                            notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode());
                                                            ScrollObservationScope findById = SemanticsUtils_androidKt.findById(this.scrollObservationScopes, i13);
                                                            Intrinsics.checkNotNull(findById);
                                                            findById.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getHorizontalScrollAxisRange()));
                                                            findById.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getVerticalScrollAxisRange()));
                                                            scheduleScrollEventIfNeeded(findById);
                                                        } else if (Intrinsics.areEqual(key2, semanticsProperties.getFocused())) {
                                                            Object value3 = next.getValue();
                                                            Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                                                            if (((Boolean) value3).booleanValue()) {
                                                                i15 = 8;
                                                                sendEvent(createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 8));
                                                            } else {
                                                                i15 = 8;
                                                            }
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 2048, 0, null, 8, null);
                                                        } else {
                                                            i15 = 8;
                                                            SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
                                                            if (Intrinsics.areEqual(key2, semanticsActions.getCustomActions())) {
                                                                List list3 = (List) semanticsNode.getUnmergedConfig().get(semanticsActions.getCustomActions());
                                                                List list4 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsActions.getCustomActions());
                                                                if (list4 != null) {
                                                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                                    int size = list3.size();
                                                                    for (int i22 = 0; i22 < size; i22++) {
                                                                        linkedHashSet.add(((CustomAccessibilityAction) list3.get(i22)).getLabel());
                                                                    }
                                                                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                                                    int size2 = list4.size();
                                                                    for (int i23 = 0; i23 < size2; i23++) {
                                                                        linkedHashSet2.add(((CustomAccessibilityAction) list4.get(i23)).getLabel());
                                                                    }
                                                                    if (linkedHashSet.containsAll(linkedHashSet2)) {
                                                                    }
                                                                    z5 = true;
                                                                } else if (!list3.isEmpty()) {
                                                                    i10 = i13;
                                                                    i17 = 8;
                                                                    i18 = i12;
                                                                    i16 = i14;
                                                                    i19 = i11;
                                                                    semanticsNode2 = semanticsNode;
                                                                    iArr4 = iArr3;
                                                                    jArr4 = jArr3;
                                                                    z5 = true;
                                                                    c8 = c7;
                                                                    arrayList4 = arrayList3;
                                                                }
                                                            } else {
                                                                if (next.getValue() instanceof AccessibilityAction) {
                                                                    Object value4 = next.getValue();
                                                                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                                                    accessibilityEquals = AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), next.getKey()));
                                                                }
                                                                z5 = true;
                                                            }
                                                        }
                                                    } else if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                        AnnotatedString textForTextField2 = getTextForTextField(semanticsNodeCopy.getUnmergedConfig());
                                                        if (textForTextField2 == null) {
                                                            textForTextField2 = BuildConfig.FLAVOR;
                                                        }
                                                        AnnotatedString textForTextField3 = getTextForTextField(semanticsNode.getUnmergedConfig());
                                                        if (textForTextField3 != null) {
                                                            str2 = textForTextField3;
                                                        }
                                                        CharSequence trimToSize = trimToSize(str2, 100000);
                                                        int length2 = textForTextField2.length();
                                                        int length3 = str2.length();
                                                        int coerceAtMost = RangesKt.coerceAtMost(length2, length3);
                                                        int i24 = 0;
                                                        while (true) {
                                                            if (i24 >= coerceAtMost) {
                                                                arrayList3 = arrayList4;
                                                                break;
                                                            }
                                                            arrayList3 = arrayList4;
                                                            if (textForTextField2.charAt(i24) != str2.charAt(i24)) {
                                                                break;
                                                            }
                                                            i24++;
                                                            arrayList4 = arrayList3;
                                                        }
                                                        iArr3 = iArr4;
                                                        int i25 = 0;
                                                        while (i25 < coerceAtMost - i24 && textForTextField2.charAt((length2 - 1) - i25) == str2.charAt((length3 - 1) - i25)) {
                                                            i25++;
                                                        }
                                                        int i26 = (length2 - i25) - i24;
                                                        int i27 = (length3 - i25) - i24;
                                                        SemanticsConfiguration unmergedConfig = semanticsNodeCopy.getUnmergedConfig();
                                                        SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
                                                        boolean contains = unmergedConfig.contains(semanticsProperties2.getPassword());
                                                        boolean contains2 = semanticsNode.getUnmergedConfig().contains(semanticsProperties2.getPassword());
                                                        jArr3 = jArr4;
                                                        boolean contains3 = semanticsNodeCopy.getUnmergedConfig().contains(semanticsProperties2.getEditableText());
                                                        boolean z6 = contains3 && !contains && contains2;
                                                        boolean z7 = contains3 && contains && !contains2;
                                                        if (z6 || z7) {
                                                            createTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i13), 0, 0, Integer.valueOf(length3), trimToSize);
                                                        } else {
                                                            createTextSelectionChangedEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i13), 16);
                                                            createTextSelectionChangedEvent.setFromIndex(i24);
                                                            createTextSelectionChangedEvent.setRemovedCount(i26);
                                                            createTextSelectionChangedEvent.setAddedCount(i27);
                                                            createTextSelectionChangedEvent.setBeforeText(textForTextField2);
                                                            createTextSelectionChangedEvent.getText().add(trimToSize);
                                                        }
                                                        createTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                        sendEvent(createTextSelectionChangedEvent);
                                                        if (z6 || z7) {
                                                            long packedValue2 = ((TextRange) semanticsNode.getUnmergedConfig().get(semanticsProperties2.getTextSelectionRange())).getPackedValue();
                                                            createTextSelectionChangedEvent.setFromIndex(TextRange.m2285getStartimpl(packedValue2));
                                                            createTextSelectionChangedEvent.setToIndex(TextRange.m2280getEndimpl(packedValue2));
                                                            sendEvent(createTextSelectionChangedEvent);
                                                        }
                                                        c7 = 2;
                                                    } else {
                                                        arrayList3 = arrayList4;
                                                        iArr3 = iArr4;
                                                        jArr3 = jArr4;
                                                        c7 = 2;
                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i13), 2048, 2, null, 8, null);
                                                    }
                                                }
                                            }
                                            i15 = 8;
                                        }
                                        i10 = i13;
                                        i17 = i15;
                                        i18 = i12;
                                        i16 = i14;
                                        i19 = i11;
                                        semanticsNode2 = semanticsNode;
                                        iArr4 = iArr3;
                                        jArr4 = jArr3;
                                        c8 = c7;
                                        arrayList4 = arrayList3;
                                    }
                                    arrayList3 = arrayList4;
                                    iArr3 = iArr4;
                                    jArr3 = jArr4;
                                    c7 = 2;
                                    i15 = 8;
                                    i10 = i13;
                                    i17 = i15;
                                    i18 = i12;
                                    i16 = i14;
                                    i19 = i11;
                                    semanticsNode2 = semanticsNode;
                                    iArr4 = iArr3;
                                    jArr4 = jArr3;
                                    c8 = c7;
                                    arrayList4 = arrayList3;
                                }
                            }
                            semanticsNode = semanticsNode2;
                            i13 = i10;
                            i11 = i19;
                            i12 = i18;
                            i14 = i16;
                            arrayList3 = arrayList4;
                            iArr3 = iArr4;
                            jArr3 = jArr4;
                            c7 = 2;
                            i15 = i17;
                            i10 = i13;
                            i17 = i15;
                            i18 = i12;
                            i16 = i14;
                            i19 = i11;
                            semanticsNode2 = semanticsNode;
                            iArr4 = iArr3;
                            jArr4 = jArr3;
                            c8 = c7;
                            arrayList4 = arrayList3;
                        }
                        SemanticsNode semanticsNode3 = semanticsNode2;
                        int i28 = i10;
                        i6 = i19;
                        i7 = i16;
                        arrayList2 = arrayList4;
                        iArr2 = iArr4;
                        jArr2 = jArr4;
                        c6 = c8;
                        i8 = i18;
                        i9 = i17;
                        if (!z5) {
                            z5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(semanticsNode3, semanticsNodeCopy.getUnmergedConfig());
                        }
                        if (z5) {
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 0, null, 8, null);
                        }
                    }
                    j6 >>= i9;
                    i19 = i6 + 1;
                    intObjectMap = newSemanticsNodes;
                    i17 = i9;
                    i18 = i8;
                    i16 = i7;
                    iArr4 = iArr2;
                    jArr4 = jArr2;
                    c8 = c6;
                    arrayList4 = arrayList2;
                }
                i5 = i16;
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                c5 = c8;
                if (i18 != i17) {
                    return;
                }
            } else {
                i5 = i16;
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                c5 = c8;
            }
            if (i5 == length) {
                return;
            }
            i16 = i5 + 1;
            intObjectMap = newSemanticsNodes;
            c8 = c5;
            arrayList4 = arrayList;
            iArr4 = iArr;
            jArr4 = jArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r8, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        LayoutNode findClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8)));
                    }
                });
            }
            if (layoutNode == null || (collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release()) == null) {
                return;
            }
            if (!collapsedSemantics$ui_release.getIsMergingSemanticsOfDescendants() && findClosestParentNode != null) {
                layoutNode = findClosestParentNode;
            }
            int semanticsId = layoutNode.getSemanticsId();
            if (subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, null, 8, null);
            }
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent createEvent = createEvent(semanticsId, 4096);
            if (scrollAxisRange != null) {
                createEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                createEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
            }
            if (scrollAxisRange2 != null) {
                createEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                createEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
            }
            sendEvent(createEvent);
        }
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String iterableTextForAccessibility;
        boolean enabled;
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (unmergedConfig.contains(semanticsActions.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node);
            if (enabled) {
                Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(semanticsActions.getSetSelection())).getAction();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
                }
                return false;
            }
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start < 0 || start != end || end > iterableTextForAccessibility.length()) {
            start = -1;
        }
        this.accessibilityCursorPosition = start;
        boolean z5 = iterableTextForAccessibility.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), z5 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z5 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z5 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, iterableTextForAccessibility));
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig.contains(semanticsProperties.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), semanticsProperties.getError()));
        }
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription(getInfoStateDescriptionOrNull(node));
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString infoText = getInfoText(node);
        info.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final void setTraversalValues() {
        boolean isRtl;
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(semanticsNode);
        isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
        List<SemanticsNode> subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(isRtl, CollectionsKt.mutableListOf(semanticsNode));
        int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        int i5 = 1;
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int id = subtreeSortedByGeometryGrouping.get(i5 - 1).getId();
            int id2 = subtreeSortedByGeometryGrouping.get(i5).getId();
            this.idToBeforeMap.set(id, id2);
            this.idToAfterMap.set(id2, id);
            if (i5 == lastIndex) {
                return;
            } else {
                i5++;
            }
        }
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, ArrayList<SemanticsNode> parentListToSort, MutableIntObjectMap<List<SemanticsNode>> containerChildrenMapping) {
        ArrayList arrayList = new ArrayList();
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        int i5 = 0;
        if (lastIndex >= 0) {
            int i6 = 0;
            while (true) {
                SemanticsNode semanticsNode = parentListToSort.get(i6);
                if (i6 == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(arrayList, semanticsNode)) {
                    arrayList.add(new Pair(semanticsNode.getBoundsInWindow(), CollectionsKt.mutableListOf(semanticsNode)));
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        CollectionsKt.sortWith(arrayList, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            Pair pair = (Pair) arrayList.get(i7);
            List list = (List) pair.getSecond();
            final Comparator comparator = layoutIsRtl ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE;
            final Comparator<LayoutNode> zComparator$ui_release = LayoutNode.INSTANCE.getZComparator$ui_release();
            final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    int compare = comparator.compare(t5, t6);
                    return compare != 0 ? compare : zComparator$ui_release.compare(((SemanticsNode) t5).getLayoutNode(), ((SemanticsNode) t6).getLayoutNode());
                }
            };
            CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    int compare = comparator2.compare(t5, t6);
                    return compare != 0 ? compare : ComparisonsKt.compareValues(Integer.valueOf(((SemanticsNode) t5).getId()), Integer.valueOf(((SemanticsNode) t6).getId()));
                }
            });
            arrayList2.addAll((Collection) pair.getSecond());
        }
        final AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 androidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode semanticsNode2, SemanticsNode semanticsNode3) {
                SemanticsConfiguration unmergedConfig = semanticsNode2.getUnmergedConfig();
                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                return Integer.valueOf(Float.compare(((Number) unmergedConfig.getOrElse(semanticsProperties.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode3.getUnmergedConfig().getOrElse(semanticsProperties.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
        CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: androidx.compose.ui.platform.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int sortByGeometryGroupings$lambda$7;
                sortByGeometryGroupings$lambda$7 = AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings$lambda$7(Function2.this, obj, obj2);
                return sortByGeometryGroupings$lambda$7;
            }
        });
        while (i5 <= CollectionsKt.getLastIndex(arrayList2)) {
            List<SemanticsNode> list2 = containerChildrenMapping.get(((SemanticsNode) arrayList2.get(i5)).getId());
            if (list2 != null) {
                if (isScreenReaderFocusable((SemanticsNode) arrayList2.get(i5))) {
                    i5++;
                } else {
                    arrayList2.remove(i5);
                }
                arrayList2.addAll(i5, list2);
                i5 += list2.size();
            } else {
                i5++;
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortByGeometryGroupings$lambda$7(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<Rect, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float top = semanticsNode.getBoundsInWindow().getTop();
        float bottom = semanticsNode.getBoundsInWindow().getBottom();
        boolean z5 = top >= bottom;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                Rect first = arrayList.get(i5).getFirst();
                boolean z6 = first.getTop() >= first.getBottom();
                if (!z5 && !z6 && Math.max(top, first.getTop()) < Math.min(bottom, first.getBottom())) {
                    arrayList.set(i5, new Pair<>(first.intersect(0.0f, top, Float.POSITIVE_INFINITY, bottom), arrayList.get(i5).getSecond()));
                    arrayList.get(i5).getSecond().add(semanticsNode);
                    return true;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return false;
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList<SemanticsNode> arrayList = new ArrayList<>();
        int size = listToSort.size();
        for (int i5 = 0; i5 < size; i5++) {
            geometryDepthFirstSearch(listToSort.get(i5), arrayList, mutableIntObjectMapOf);
        }
        return sortByGeometryGroupings(layoutIsRtl, arrayList, mutableIntObjectMapOf);
    }

    private final RectF toScreenCoords(SemanticsNode textNode, Rect bounds) {
        if (textNode == null) {
            return null;
        }
        Rect m1359translatek4lQ0M = bounds.m1359translatek4lQ0M(textNode.m2178getPositionInRootF1C5BW0());
        Rect boundsInRoot = textNode.getBoundsInRoot();
        Rect intersect = m1359translatek4lQ0M.overlaps(boundsInRoot) ? m1359translatek4lQ0M.intersect(boundsInRoot) : null;
        if (intersect == null) {
            return null;
        }
        long mo1913localToScreenMKHz9U = this.view.mo1913localToScreenMKHz9U(OffsetKt.Offset(intersect.getLeft(), intersect.getTop()));
        long mo1913localToScreenMKHz9U2 = this.view.mo1913localToScreenMKHz9U(OffsetKt.Offset(intersect.getRight(), intersect.getBottom()));
        return new RectF(Offset.m1337getXimpl(mo1913localToScreenMKHz9U), Offset.m1338getYimpl(mo1913localToScreenMKHz9U), Offset.m1337getXimpl(mo1913localToScreenMKHz9U2), Offset.m1338getYimpl(mo1913localToScreenMKHz9U2));
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z5) {
        androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        int i5;
        int i6;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        boolean z5 = false;
        if (iterableTextForAccessibility != null && iterableTextForAccessibility.length() != 0) {
            AccessibilityIterators$TextSegmentIterator iteratorForGranularity = getIteratorForGranularity(node, granularity);
            if (iteratorForGranularity == null) {
                return false;
            }
            int accessibilitySelectionEnd = getAccessibilitySelectionEnd(node);
            if (accessibilitySelectionEnd == -1) {
                accessibilitySelectionEnd = forward ? 0 : iterableTextForAccessibility.length();
            }
            int[] following = forward ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
            if (following == null) {
                return false;
            }
            int i7 = following[0];
            z5 = true;
            int i8 = following[1];
            if (extendSelection && isAccessibilitySelectionExtendable(node)) {
                i5 = getAccessibilitySelectionStart(node);
                if (i5 == -1) {
                    i5 = forward ? i7 : i8;
                }
                i6 = forward ? i8 : i7;
            } else {
                i5 = forward ? i8 : i7;
                i6 = i5;
            }
            this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, forward ? 256 : 512, granularity, i7, i8, SystemClock.uptimeMillis());
            setAccessibilitySelection(node, i5, i6, true);
        }
        return z5;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be greater than 0");
        }
        if (text == null || text.length() == 0 || text.length() <= size) {
            return text;
        }
        int i5 = size - 1;
        if (Character.isHighSurrogate(text.charAt(i5)) && Character.isLowSurrogate(text.charAt(size))) {
            size = i5;
        }
        T t5 = (T) text.subSequence(0, size);
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t5;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        int i5 = this.hoveredVirtualViewId;
        if (i5 == virtualViewId) {
            return;
        }
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i5, 256, null, null, 12, null);
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        SemanticsConfiguration unmergedConfig;
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
        MutableIntSet mutableIntSet2 = this.paneDisplayed;
        int[] iArr = mutableIntSet2.elements;
        long[] jArr = mutableIntSet2.metadata;
        int length = jArr.length - 2;
        long j5 = 128;
        long j6 = 255;
        char c5 = 7;
        long j7 = -9187201950435737472L;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j8 = jArr[i5];
                long[] jArr2 = jArr;
                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j8 & j6) < j5) {
                            int i8 = iArr[(i5 << 3) + i7];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i8);
                            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode == null || !semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                mutableIntSet.add(i8);
                                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i8);
                                sendPaneChangeEvents(i8, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                        }
                        j8 >>= 8;
                        i7++;
                        j5 = 128;
                        j6 = 255;
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
                j5 = 128;
                j6 = 255;
            }
        }
        this.paneDisplayed.removeAll(mutableIntSet);
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = getCurrentSemanticsNodes();
        int[] iArr2 = currentSemanticsNodes.keys;
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr3 = currentSemanticsNodes.metadata;
        int length2 = jArr3.length - 2;
        if (length2 >= 0) {
            int i9 = 0;
            while (true) {
                long j9 = jArr3[i9];
                if ((((~j9) << c5) & j9 & j7) != j7) {
                    int i10 = 8 - ((~(i9 - length2)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((j9 & 255) < 128) {
                            int i12 = (i9 << 3) + i11;
                            int i13 = iArr2[i12];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) objArr[i12];
                            SemanticsConfiguration unmergedConfig2 = semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig();
                            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                            if (unmergedConfig2.contains(semanticsProperties.getPaneTitle()) && this.paneDisplayed.add(i13)) {
                                sendPaneChangeEvents(i13, 16, (String) semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig().get(semanticsProperties.getPaneTitle()));
                            }
                            this.previousSemanticsNodes.set(i13, new SemanticsNodeCopy(semanticsNodeWithAdjustedBounds2.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        j9 >>= 8;
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
                j7 = -9187201950435737472L;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0035, B:14:0x0065, B:19:0x0077, B:21:0x007f, B:23:0x0088, B:25:0x0091, B:27:0x00a2, B:29:0x00a9, B:30:0x00b2, B:39:0x0051), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0086 -> B:13:0x00d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cf -> B:13:0x00d2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> continuation) {
        AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1;
        int i5;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
        MutableIntSet mutableIntSet;
        ChannelIterator<Unit> it;
        MutableIntSet mutableIntSet2;
        Object hasNext;
        try {
            if (continuation instanceof AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) {
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = (AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) continuation;
                int i6 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            mutableIntSet = new MutableIntSet(0, 1, null);
                            it = this.boundsUpdateChannel.iterator();
                            androidComposeViewAccessibilityDelegateCompat = this;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = androidComposeViewAccessibilityDelegateCompat;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = mutableIntSet;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2 = it;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                            hasNext = it.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            androidComposeViewAccessibilityDelegateCompat = this;
                            androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.clear();
                            throw th;
                        }
                    } else if (i5 == 1) {
                        it = (ChannelIterator) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2;
                        mutableIntSet2 = (MutableIntSet) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                        androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (ChannelIterator) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2;
                        mutableIntSet2 = (MutableIntSet) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                        androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableIntSet = mutableIntSet2;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = androidComposeViewAccessibilityDelegateCompat;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = mutableIntSet;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2 = it;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableIntSet2 = mutableIntSet;
                        obj = hasNext;
                        if (((Boolean) obj).booleanValue()) {
                            androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.clear();
                            return Unit.INSTANCE;
                        }
                        it.next();
                        if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui_release()) {
                            int size = androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.size();
                            for (int i7 = 0; i7 < size; i7++) {
                                LayoutNode valueAt = androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.valueAt(i7);
                                androidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents(valueAt, mutableIntSet2);
                                androidComposeViewAccessibilityDelegateCompat.sendTypeViewScrolledAccessibilityEvent(valueAt);
                            }
                            mutableIntSet2.clear();
                            if (!androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges) {
                                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = true;
                                androidComposeViewAccessibilityDelegateCompat.handler.post(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
                            }
                            androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.clear();
                            androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.clear();
                            androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.clear();
                            long j5 = androidComposeViewAccessibilityDelegateCompat.SendRecurringAccessibilityEventsIntervalMillis;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = androidComposeViewAccessibilityDelegateCompat;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = mutableIntSet2;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2 = it;
                            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 2;
                            if (DelayKt.delay(j5, androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        mutableIntSet = mutableIntSet2;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = androidComposeViewAccessibilityDelegateCompat;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = mutableIntSet;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$2 = it;
                        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
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
        androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = new AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(this, continuation);
        Object obj2 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m2112canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return m2111canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
        }
        return false;
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
            return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    /* renamed from: getExtraDataTestTraversalAfterVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* renamed from: getExtraDataTestTraversalBeforeVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* renamed from: getIdToAfterMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToAfterMap() {
        return this.idToAfterMap;
    }

    /* renamed from: getIdToBeforeMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToBeforeMap() {
        return this.idToBeforeMap;
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final int hitTestSemanticsAt$ui_release(float x5, float y5) {
        int i5;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        this.view.getRoot().m2004hitTestSemanticsM_7yMNQ$ui_release(OffsetKt.Offset(x5, y5), hitTestResult, (r13 & 4) != 0, (r13 & 8) != 0);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            i5 = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(hitTestResult.get(lastIndex));
            if (this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode) != null) {
                return Integer.MIN_VALUE;
            }
            if (requireLayoutNode.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
                i5 = semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode.getSemanticsId());
                if (SemanticsUtils_androidKt.isImportantForAccessibility(SemanticsNodeKt.SemanticsNode(requireLayoutNode, false))) {
                    break;
                }
            }
            lastIndex--;
        }
        return i5;
    }

    public final boolean isEnabled$ui_release() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && !this.enabledServices.isEmpty());
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j5) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j5;
    }
}
