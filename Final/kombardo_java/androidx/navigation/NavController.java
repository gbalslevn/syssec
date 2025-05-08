package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 \u0084\u00022\u00020\u0001:\u0006\u0084\u0002\u0085\u0002\u0086\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0016\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001b\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001b\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001b\u0010 J3\u0010\u001b\u001a\u00020\u0019\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010#J'\u0010\u001b\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010%J9\u0010(\u001a\u00020\u00192\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000e2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b(\u0010)J1\u0010-\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0019H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0019H\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b4\u00102J\u0019\u00107\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000105H\u0003¢\u0006\u0004\b7\u00108J\u0019\u0010;\u001a\u0004\u0018\u00010$2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u00020=*\b\u0012\u0004\u0012\u00020\u00060*H\u0002¢\u0006\u0004\b>\u0010?J!\u0010@\u001a\u00020$\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0004\b@\u0010AJ5\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\bF\u0010GJ5\u0010I\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bI\u0010JJ;\u0010K\u001a\u00020\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010C\u001a\u0004\u0018\u0001052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bK\u0010LJ%\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002¢\u0006\u0004\bN\u0010OJ9\u0010S\u001a\u00020\t2\u0006\u0010B\u001a\u00020\r2\b\u0010P\u001a\u0004\u0018\u0001052\u0006\u0010Q\u001a\u00020\u00062\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\tH\u0002¢\u0006\u0004\bU\u0010VJ\u0019\u0010Y\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bW\u0010XJ\u0017\u0010\\\u001a\u00020\t2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\t2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b^\u0010]J\u000f\u0010_\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u00102J!\u0010_\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u0010`J)\u0010_\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b_\u0010 J)\u0010_\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b_\u0010%J3\u0010_\u001a\u00020\u0019\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b_\u0010#J%\u0010e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\t0aH\u0000¢\u0006\u0004\bc\u0010dJ\u000f\u0010f\u001a\u00020\u0019H\u0017¢\u0006\u0004\bf\u00102J\u000f\u0010h\u001a\u00020\tH\u0000¢\u0006\u0004\bg\u0010VJ\u0015\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0000¢\u0006\u0004\bi\u0010jJ!\u0010m\u001a\u00020\t2\u0006\u0010l\u001a\u00020=2\b\u00106\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0004\bm\u0010nJ\u0019\u0010q\u001a\u00020\u00192\b\u0010p\u001a\u0004\u0018\u00010oH\u0017¢\u0006\u0004\bq\u0010rJ'\u0010t\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\bt\u0010uJ3\u0010w\u001a\u0004\u0018\u00010\r*\u00020\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010v\u001a\u00020\u00192\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\bw\u0010xJ\u0017\u0010D\u001a\u00020\t2\u0006\u0010:\u001a\u00020yH\u0017¢\u0006\u0004\bD\u0010zJ\u0017\u0010D\u001a\u00020\t2\u0006\u0010|\u001a\u00020{H\u0017¢\u0006\u0004\bD\u0010}J!\u0010D\u001a\u00020\t2\u0006\u0010|\u001a\u00020{2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\bD\u0010~J+\u0010D\u001a\u00020\t2\u0006\u0010|\u001a\u00020{2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\bD\u0010\u007fJ.\u0010D\u001a\u00020\t2\u0006\u0010\"\u001a\u00020$2\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\t0\u0014H\u0007¢\u0006\u0005\bD\u0010\u0082\u0001J0\u0010D\u001a\u00020\t2\u0006\u0010\"\u001a\u00020$2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0005\bD\u0010\u0083\u0001J:\u0010D\u001a\u00020\t\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00028\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0005\bD\u0010\u0084\u0001J\u0013\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0012\u0010\u001a\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0005\b\u001a\u0010\u0088\u0001J\u001c\u0010\u008a\u0001\u001a\u00020\t2\t\u0010\u0089\u0001\u001a\u0004\u0018\u000105H\u0017¢\u0006\u0005\b\u008a\u0001\u00108J\u001c\u0010\u008d\u0001\u001a\u00020\t2\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0017¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\u0091\u0001\u001a\u00020\t2\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0017¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001c\u0010\u0093\u0001\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0018\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020$¢\u0006\u0006\b\u0093\u0001\u0010\u0095\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u000f\n\u0005\b\u0003\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R#\u0010¥\u0001\u001a\f\u0012\u0005\u0012\u00030¤\u0001\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001d\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R$\u0010¬\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R,\u0010¯\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0®\u00018GX\u0087\u0004¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R$\u0010³\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010\u00ad\u0001R)\u0010´\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0®\u00018\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010°\u0001\u001a\u0006\bµ\u0001\u0010²\u0001R$\u0010·\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R%\u0010º\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030¹\u00010¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010¸\u0001R&\u0010»\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010$0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¸\u0001R*\u0010¼\u0001\u001a\u0015\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010¸\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001e\u0010Æ\u0001\u001a\t\u0012\u0004\u0012\u00020Z0Å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R*\u0010É\u0001\u001a\u00030È\u00018@@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ð\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ó\u0001\u001a\u00030Ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010¨\u0001R\u001a\u0010×\u0001\u001a\u00030Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R1\u0010Ú\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0012\t\u0012\u00070Ù\u0001R\u00020\u00000¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010¸\u0001R'\u0010Û\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R'\u0010Ý\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ü\u0001R$\u0010Þ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010¸\u0001R\u0019\u0010ß\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001e\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R!\u0010è\u0001\u001a\u00030\u009c\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001e\u0010ê\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060é\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R#\u0010í\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ì\u00018\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001R\u0017\u0010ó\u0001\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001R'\u0010l\u001a\u00020=2\u0006\u0010l\u001a\u00020=8W@WX\u0096\u000e¢\u0006\u000f\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0005\bm\u0010ö\u0001R,\u0010÷\u0001\u001a\u00030Ö\u00012\b\u0010÷\u0001\u001a\u00030Ö\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R\u0019\u0010þ\u0001\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\bü\u0001\u0010ý\u0001R\u0019\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0019\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0002\u0010\u0080\u0002¨\u0006\u0087\u0002"}, d2 = {"Landroidx/navigation/NavController;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavBackStackEntry;", "child", "parent", BuildConfig.FLAVOR, "linkChildToParent", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", BuildConfig.FLAVOR, "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Lkotlin/Function1;", "handler", "navigateInternal", "(Landroidx/navigation/Navigator;Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;Lkotlin/jvm/functions/Function1;)V", "popUpTo", BuildConfig.FLAVOR, "saveState", "popBackStackInternal", "(Landroidx/navigation/Navigator;Landroidx/navigation/NavBackStackEntry;ZLkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "destinationId", "inclusive", "(IZZ)Z", "T", "route", "(Ljava/lang/Object;ZZ)Z", BuildConfig.FLAVOR, "(Ljava/lang/String;ZZ)Z", "popOperations", "foundDestination", "executePopOperations", "(Ljava/util/List;Landroidx/navigation/NavDestination;ZZ)Z", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "popEntryFromBackStack", "(Landroidx/navigation/NavBackStackEntry;ZLkotlin/collections/ArrayDeque;)V", "clearBackStackInternal", "(I)Z", "tryRelaunchUpToExplicitStack", "()Z", "tryRelaunchUpToGeneratedStack", "dispatchOnDestinationChanged", "Landroid/os/Bundle;", "startDestinationArgs", "onGraphCreated", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "deepLink", "findInvalidDestinationDisplayNameInDeepLink", "([I)Ljava/lang/String;", "Landroidx/navigation/NavGraph;", "getTopGraph", "(Lkotlin/collections/ArrayDeque;)Landroidx/navigation/NavGraph;", "generateRouteFilled", "(Ljava/lang/Object;)Ljava/lang/String;", "node", "args", "navigate", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "launchSingleTopInternal", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Z", Constants.ID_ATTRIBUTE_KEY, "restoreStateInternal", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "executeRestoreState", "(Ljava/util/List;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "backStackState", "instantiateBackStack", "(Lkotlin/collections/ArrayDeque;)Ljava/util/List;", "finalArgs", "backStackEntry", "restoredEntries", "addEntryToBackStack", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavBackStackEntry;Ljava/util/List;)V", "updateOnBackPressedCallbackEnabled", "()V", "unlinkChildFromParent$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "unlinkChildFromParent", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "listener", "addOnDestinationChangedListener", "(Landroidx/navigation/NavController$OnDestinationChangedListener;)V", "removeOnDestinationChangedListener", "popBackStack", "(IZ)Z", "Lkotlin/Function0;", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;)V", "popBackStackFromNavigator", "navigateUp", "updateBackStackLifecycle$navigation_runtime_release", "updateBackStackLifecycle", "populateVisibleEntries$navigation_runtime_release", "()Ljava/util/List;", "populateVisibleEntries", "graph", "setGraph", "(Landroidx/navigation/NavGraph;Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "handleDeepLink", "(Landroid/content/Intent;)Z", "matchingDest", "findDestination", "(ILandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination;", "searchChildren", "findDestinationComprehensive", "(Landroidx/navigation/NavDestination;IZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination;", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "Landroidx/navigation/NavDeepLinkRequest;", "request", "(Landroidx/navigation/NavDeepLinkRequest;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavOptionsBuilder;", "builder", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "(Ljava/lang/Object;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkBuilder;", "createDeepLink", "()Landroidx/navigation/NavDeepLinkBuilder;", "()Landroid/os/Bundle;", "navState", "restoreState", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "getBackStackEntry", "(I)Landroidx/navigation/NavBackStackEntry;", "(Ljava/lang/String;)Landroidx/navigation/NavBackStackEntry;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroidx/navigation/NavInflater;", "inflater", "Landroidx/navigation/NavInflater;", "_graph", "Landroidx/navigation/NavGraph;", "navigatorStateToRestore", "Landroid/os/Bundle;", BuildConfig.FLAVOR, "Landroid/os/Parcelable;", "backStackToRestore", "[Landroid/os/Parcelable;", "deepLinkHandled", "Z", "backQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "_visibleEntries", "visibleEntries", "getVisibleEntries", BuildConfig.FLAVOR, "childToParentEntries", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentToChildCount", "backStackMap", "backStackStates", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "addToBackStackHandler", "Lkotlin/jvm/functions/Function1;", "popFromBackStackHandler", "entrySavedState", "dispatchReentrantCount", "I", BuildConfig.FLAVOR, "backStackEntriesToDispatch", "Ljava/util/List;", "navInflater$delegate", "Lkotlin/Lazy;", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "getDestinationCountOnBackStack", "()I", "destinationCountOnBackStack", "getGraph", "()Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "currentDestination", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getPreviousBackStackEntry", "previousBackStackEntry", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;

    /* renamed from: navInflater$delegate, reason: from kotlin metadata */
    private final Lazy navInflater;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;
    private static boolean deepLinkSaveState = true;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", BuildConfig.FLAVOR, com.adjust.sdk.Constants.PUSH, "(Landroidx/navigation/NavBackStackEntry;)V", "addInternal", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", BuildConfig.FLAVOR, "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.this$0.getContext(), destination, arguments, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, null, null, 96, null);
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            Intrinsics.checkNotNullParameter(entry, "entry");
            boolean areEqual = Intrinsics.areEqual(this.this$0.entrySavedState.get(entry), Boolean.TRUE);
            super.markTransitionComplete(entry);
            this.this$0.entrySavedState.remove(entry);
            if (this.this$0.backQueue.contains(entry)) {
                if (getIsNavigating()) {
                    return;
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.this$0.backQueue));
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
                return;
            }
            this.this$0.unlinkChildFromParent$navigation_runtime_release(entry);
            if (entry.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            ArrayDeque arrayDeque = this.this$0.backQueue;
            if (arrayDeque == null || !arrayDeque.isEmpty()) {
                Iterator<E> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).getId(), entry.getId())) {
                        break;
                    }
                }
            }
            if (!areEqual && (navControllerViewModel = this.this$0.viewModel) != null) {
                navControllerViewModel.clear(entry.getId());
            }
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(final NavBackStackEntry popUpTo, final boolean saveState) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
            this.this$0.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
            if (!Intrinsics.areEqual(navigator, this.navigator)) {
                Object obj = this.this$0.navigatorState.get(navigator);
                Intrinsics.checkNotNull(obj);
                ((NavControllerNavigatorState) obj).pop(popUpTo, saveState);
            } else {
                Function1 function1 = this.this$0.popFromBackStackHandler;
                if (function1 == null) {
                    this.this$0.popBackStackFromNavigator$navigation_runtime_release(popUpTo, new Function0<Unit>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
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
                            super/*androidx.navigation.NavigatorState*/.pop(popUpTo, saveState);
                        }
                    });
                } else {
                    function1.invoke(popUpTo);
                    super.pop(popUpTo, saveState);
                }
            }
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, saveState);
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            super.prepareForTransition(entry);
            if (!this.this$0.backQueue.contains(entry)) {
                throw new IllegalStateException("Cannot transition entry that is not in the back stack");
            }
            entry.setMaxLifecycle(Lifecycle.State.STARTED);
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
            if (!Intrinsics.areEqual(navigator, this.navigator)) {
                Object obj = this.this$0.navigatorState.get(navigator);
                if (obj != null) {
                    ((NavControllerNavigatorState) obj).push(backStackEntry);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
            }
            Function1 function1 = this.this$0.addToBackStackHandler;
            if (function1 != null) {
                function1.invoke(backStackEntry);
                addInternal(backStackEntry);
                return;
            }
            Log.i(NavController.TAG, "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", BuildConfig.FLAVOR, "onDestinationChanged", BuildConfig.FLAVOR, "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments);
    }

    public NavController(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            }
        }
        this.activity = (Activity) obj;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._currentBackStack = MutableStateFlow;
        this.currentBackStack = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: H.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.lifecycleObserver$lambda$2(NavController.this, lifecycleOwner, event);
            }
        };
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(false);
            }

            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                NavController.this.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater = LazyKt.lazy(new Function0<NavInflater>() { // from class: androidx.navigation.NavController$navInflater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavInflater invoke() {
                NavInflater navInflater;
                navInflater = NavController.this.inflater;
                return navInflater == null ? new NavInflater(NavController.this.getContext(), NavController.this._navigatorProvider) : navInflater;
            }
        });
        MutableSharedFlow<NavBackStackEntry> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._currentBackStackEntryFlow = MutableSharedFlow$default;
        this.currentBackStackEntryFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0251, code lost:
    
        r0 = r9.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0259, code lost:
    
        if (r0.hasNext() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x025b, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r30.navigatorState.get(r30._navigatorProvider.getNavigator(r1.getDestination().getNavigatorName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0275, code lost:
    
        if (r2 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0277, code lost:
    
        r2.addInternal(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02a0, code lost:
    
        throw new java.lang.IllegalStateException(("NavigatorBackStack for " + r31.getNavigatorName() + " should already be created").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02a1, code lost:
    
        r30.backQueue.addAll(r9);
        r30.backQueue.add(r8);
        r0 = kotlin.collections.CollectionsKt.plus((java.util.Collection<? extends androidx.navigation.NavBackStackEntry>) r9, r8).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02b9, code lost:
    
        if (r0.hasNext() == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02bb, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r1.getDestination().getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02c9, code lost:
    
        if (r2 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02cb, code lost:
    
        linkChildToParent(r1, getBackStackEntry(r2.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02d7, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01ee, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0105, code lost:
    
        r0 = ((androidx.navigation.NavBackStackEntry) r9.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00dc, code lost:
    
        r12 = r0;
        r13 = r2;
        r11 = r4;
        r9 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00a4, code lost:
    
        r19 = r12;
        r0 = r13;
        r8 = r14;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x007b, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00e1, code lost:
    
        r11 = r4;
        r9 = r5;
        r19 = r12;
        r12 = r13;
        r8 = r14;
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00f6, code lost:
    
        r9 = r5;
        r19 = r12;
        r12 = r13;
        r8 = r14;
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        r5 = new kotlin.collections.ArrayDeque();
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        if ((r31 instanceof androidx.navigation.NavGraph) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r4 = r0.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r4 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r0 = r13.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (r0.hasPrevious() == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r1 = r0.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1.getDestination(), r4) == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        r19 = r12;
        r0 = r13;
        r2 = r15;
        r8 = r14;
        r1 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.INSTANCE, r30.context, r4, r32, getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a9, code lost:
    
        r5.addFirst(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0010, code lost:
    
        if ((r12 instanceof androidx.navigation.FloatingWindow) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
    
        if (r30.backQueue.last().getDestination() != r4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        r12 = r0;
        r13 = r2;
        r11 = r4;
        r9 = r5;
        popEntryFromBackStack$default(r30, r30.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e8, code lost:
    
        if (r11 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ea, code lost:
    
        if (r11 != r31) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ed, code lost:
    
        r14 = r8;
        r5 = r9;
        r0 = r11;
        r15 = r13;
        r13 = r12;
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0100, code lost:
    
        if (r9.isEmpty() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0102, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010f, code lost:
    
        if (r0 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0119, code lost:
    
        if (findDestination(r0.getId(), r0) == r0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011b, code lost:
    
        r0 = r0.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011f, code lost:
    
        if (r0 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0121, code lost:
    
        if (r13 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0128, code lost:
    
        if (r32.isEmpty() != true) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012a, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        r1 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013a, code lost:
    
        if (r1.hasPrevious() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013c, code lost:
    
        r2 = r1.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.getDestination(), r0) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0150, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
    
        if (r2 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0154, code lost:
    
        r2 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.INSTANCE, r30.context, r0, r0.addInDefaultArgs(r15), getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0174, code lost:
    
        r9.addFirst(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014e, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012d, code lost:
    
        r15 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017c, code lost:
    
        if (r9.isEmpty() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if ((r30.backQueue.last().getDestination() instanceof androidx.navigation.FloatingWindow) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017f, code lost:
    
        r19 = ((androidx.navigation.NavBackStackEntry) r9.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0191, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a1, code lost:
    
        if ((r30.backQueue.last().getDestination() instanceof androidx.navigation.NavGraph) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a3, code lost:
    
        r0 = r30.backQueue.last().getDestination();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.navigation.NavGraph");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c2, code lost:
    
        if (((androidx.navigation.NavGraph) r0).getNodes().get(r19.getId()) != null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c4, code lost:
    
        popEntryFromBackStack$default(r30, r30.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d7, code lost:
    
        r0 = r30.backQueue.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01df, code lost:
    
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e1, code lost:
    
        r0 = (androidx.navigation.NavBackStackEntry) r9.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e7, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e9, code lost:
    
        r0 = r0.getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f6, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r30._graph) != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f8, code lost:
    
        r0 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0204, code lost:
    
        if (r0.hasPrevious() == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        if (popBackStackInternal$default(r30, r30.backQueue.last().getDestination().getId(), true, false, 4, null) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0206, code lost:
    
        r1 = r0.previous();
        r2 = r1.getDestination();
        r3 = r30._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x021a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x021c, code lost:
    
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x021e, code lost:
    
        r18 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0220, code lost:
    
        if (r18 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0222, code lost:
    
        r19 = androidx.navigation.NavBackStackEntry.INSTANCE;
        r0 = r30.context;
        r1 = r30._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2 = r30._graph;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r18 = androidx.navigation.NavBackStackEntry.Companion.create$default(r19, r0, r1, r2.addInDefaultArgs(r13), getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x024c, code lost:
    
        r9.addFirst(r18);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addEntryToBackStack(NavDestination node, Bundle finalArgs, NavBackStackEntry backStackEntry, List<NavBackStackEntry> restoredEntries) {
        Bundle bundle = finalArgs;
        NavBackStackEntry navBackStackEntry = backStackEntry;
        List<NavBackStackEntry> list = restoredEntries;
        NavDestination destination = backStackEntry.getDestination();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i5 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    private final boolean clearBackStackInternal(int destinationId) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(destinationId, null, NavOptionsBuilderKt.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: androidx.navigation.NavController$clearBackStackInternal$restored$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptions) {
                Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                navOptions.setRestoreState(true);
            }
        }), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal(destinationId, true, false);
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i5 = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i5;
        if (i5 == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList((Collection) this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        return lastOrNull != null;
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean inclusive, final boolean saveState) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (it.hasNext()) {
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            popBackStackInternal(navigator, this.backQueue.last(), saveState, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$executePopOperations$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    Ref$BooleanRef.this.element = true;
                    ref$BooleanRef.element = true;
                    this.popEntryFromBackStack(entry, saveState, arrayDeque);
                }
            });
            if (!ref$BooleanRef2.element) {
                break;
            }
        }
        if (saveState) {
            if (!inclusive) {
                for (NavDestination navDestination : SequencesKt.takeWhile(SequencesKt.generateSequence(foundDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$executePopOperations$2
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$executePopOperations$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Map map;
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        map = NavController.this.backStackMap;
                        return Boolean.valueOf(!map.containsKey(Integer.valueOf(destination.getId())));
                    }
                })) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer valueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState firstOrNull = arrayDeque.firstOrNull();
                    map.put(valueOf, firstOrNull != null ? firstOrNull.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState first = arrayDeque.first();
                Iterator it2 = SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination$default(this, first.getDestinationId(), null, 2, null), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$executePopOperations$5
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$executePopOperations$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Map map2;
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        map2 = NavController.this.backStackMap;
                        return Boolean.valueOf(!map2.containsKey(Integer.valueOf(destination.getId())));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    this.backStackMap.put(Integer.valueOf(((NavDestination) it2.next()).getId()), first.getId());
                }
                if (this.backStackMap.values().contains(first.getId())) {
                    this.backStackStates.put(first.getId(), arrayDeque);
                }
            }
        }
        updateOnBackPressedCallbackEnabled();
        return ref$BooleanRef.element;
    }

    private final boolean executeRestoreState(final List<NavBackStackEntry> entries, final Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : entries) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt.lastOrNull((List) arrayList);
            if (Intrinsics.areEqual((list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        for (List<NavBackStackEntry> list2 : arrayList) {
            Navigator<? extends NavDestination> navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first((List) list2)).getDestination().getNavigatorName());
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            navigateInternal(navigator, list2, navOptions, navigatorExtras, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$executeRestoreState$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry3) {
                    invoke2(navBackStackEntry3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    List<NavBackStackEntry> emptyList;
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    Ref$BooleanRef.this.element = true;
                    int indexOf = entries.indexOf(entry);
                    if (indexOf != -1) {
                        int i5 = indexOf + 1;
                        emptyList = entries.subList(ref$IntRef.element, i5);
                        ref$IntRef.element = i5;
                    } else {
                        emptyList = CollectionsKt.emptyList();
                    }
                    this.addEntryToBackStack(entry.getDestination(), args, entry, emptyList);
                }
            });
        }
        return ref$BooleanRef.element;
    }

    public static /* synthetic */ NavDestination findDestination$default(NavController navController, int i5, NavDestination navDestination, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestination");
        }
        if ((i6 & 2) != 0) {
            navDestination = null;
        }
        return navController.findDestination(i5, navDestination);
    }

    public static /* synthetic */ NavDestination findDestinationComprehensive$default(NavController navController, NavDestination navDestination, int i5, boolean z5, NavDestination navDestination2, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestinationComprehensive");
        }
        if ((i6 & 4) != 0) {
            navDestination2 = null;
        }
        return navController.findDestinationComprehensive(navDestination, i5, z5, navDestination2);
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] deepLink) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i5 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i5 >= length) {
                return null;
            }
            int i6 = deepLink[i5];
            if (i5 == 0) {
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.getId() == i6) {
                    navDestination = this._graph;
                }
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestination = navGraph2.findNode(i6);
            }
            if (navDestination == null) {
                return NavDestination.INSTANCE.getDisplayName(this.context, i6);
            }
            if (i5 != deepLink.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph2 = navGraph;
            }
            i5++;
        }
    }

    private final <T> String generateRouteFilled(T route) {
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()))), true, null, 4, null);
        if (findDestinationComprehensive$default == null) {
            throw new IllegalArgumentException(("Destination with route " + Reflection.getOrCreateKotlinClass(route.getClass()).getSimpleName() + " cannot be found in navigation graph " + this._graph).toString());
        }
        Map<String, NavArgument> arguments = findDestinationComprehensive$default.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        return RouteSerializerKt.generateRouteWithArgs(route, linkedHashMap);
    }

    private final int getDestinationCountOnBackStack() {
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        int i5 = 0;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<NavBackStackEntry> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (!(it.next().getDestination() instanceof NavGraph) && (i5 = i5 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i5;
    }

    private final NavGraph getTopGraph(ArrayDeque<NavBackStackEntry> arrayDeque) {
        NavDestination navDestination;
        NavBackStackEntry lastOrNull = arrayDeque.lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
        }
        if (navDestination instanceof NavGraph) {
            return (NavGraph) navDestination;
        }
        NavGraph parent = navDestination.getParent();
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> backStackState) {
        NavDestination graph;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (graph = lastOrNull.getDestination()) == null) {
            graph = getGraph();
        }
        if (backStackState != null) {
            for (NavBackStackEntryState navBackStackEntryState : backStackState) {
                NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, graph, navBackStackEntryState.getDestinationId(), true, null, 4, null);
                if (findDestinationComprehensive$default == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + graph).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(this.context, findDestinationComprehensive$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                graph = findDestinationComprehensive$default;
            }
        }
        return arrayList;
    }

    private final boolean launchSingleTopInternal(NavDestination node, Bundle args) {
        int i5;
        NavDestination destination;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i5 = -1;
                break;
            }
            if (listIterator.previous().getDestination() == node) {
                i5 = listIterator.nextIndex();
                break;
            }
        }
        if (i5 == -1) {
            return false;
        }
        if (node instanceof NavGraph) {
            List list = SequencesKt.toList(SequencesKt.map(NavGraph.INSTANCE.childHierarchy((NavGraph) node), new Function1<NavDestination, Integer>() { // from class: androidx.navigation.NavController$launchSingleTopInternal$childHierarchyId$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getId());
                }
            }));
            if (this.backQueue.size() - i5 != list.size()) {
                return false;
            }
            ArrayDeque<NavBackStackEntry> arrayDeque2 = this.backQueue;
            List<NavBackStackEntry> subList = arrayDeque2.subList(i5, arrayDeque2.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
            Iterator<T> it = subList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((NavBackStackEntry) it.next()).getDestination().getId()));
            }
            if (!Intrinsics.areEqual(arrayList, list)) {
                return false;
            }
        } else if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || node.getId() != destination.getId()) {
            return false;
        }
        ArrayDeque<NavBackStackEntry> arrayDeque3 = new ArrayDeque();
        while (CollectionsKt.getLastIndex(this.backQueue) >= i5) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.removeLast(this.backQueue);
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            arrayDeque3.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.getDestination().addInDefaultArgs(args)));
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque3) {
            NavGraph parent = navBackStackEntry2.getDestination().getParent();
            if (parent != null) {
                linkChildToParent(navBackStackEntry2, getBackStackEntry(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque3) {
            this._navigatorProvider.getNavigator(navBackStackEntry3.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.hostLifecycleState = event.getTargetState();
        if (this$0._graph != null) {
            Iterator it = CollectionsKt.toMutableList((Collection) this$0.backQueue).iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
            }
        }
    }

    private final void linkChildToParent(NavBackStackEntry child, NavBackStackEntry parent) {
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(parent);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i5 & 2) != 0) {
            navOptions = null;
        }
        if ((i5 & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    private final void onGraphCreated(Bundle startDestinationArgs) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle = this.navigatorStateToRestore;
        if (bundle != null && (stringArrayList = bundle.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String name = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Navigator navigator = navigatorProvider.getNavigator(name);
                Bundle bundle2 = bundle.getBundle(name);
                if (bundle2 != null) {
                    navigator.onRestoreState(bundle2);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination$default = findDestination$default(this, navBackStackEntryState.getDestinationId(), null, 2, null);
                if (findDestination$default == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
                NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(findDestination$default.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.add(instantiate);
                navControllerNavigatorState.addInternal(instantiate);
                NavGraph parent = instantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent(instantiate, getBackStackEntry(parent.getId()));
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> values = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : values) {
            if (!((Navigator) obj).getIsAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !this.backQueue.isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity = this.activity) != null) {
            Intrinsics.checkNotNull(activity);
            if (handleDeepLink(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this._graph;
        Intrinsics.checkNotNull(navGraph);
        navigate(navGraph, startDestinationArgs, null, null);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, Object obj, boolean z5, boolean z6, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        return navController.popBackStack((NavController) obj, z5, z6);
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z5, Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z5);
        this.popFromBackStackHandler = null;
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i5, boolean z5, boolean z6, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        return navController.popBackStackInternal(i5, z5, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry popUpTo, boolean saveState, ArrayDeque<NavBackStackEntryState> savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        NavBackStackEntry last = this.backQueue.last();
        if (!Intrinsics.areEqual(last, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + ')').toString());
        }
        CollectionsKt.removeLast(this.backQueue);
        NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(last.getDestination().getNavigatorName()));
        boolean z5 = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) && !this.parentToChildCount.containsKey(last)) {
            z5 = false;
        }
        Lifecycle.State state = last.getLifecycle().getState();
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.isAtLeast(state2)) {
            if (saveState) {
                last.setMaxLifecycle(state2);
                savedState.addFirst(new NavBackStackEntryState(last));
            }
            if (z5) {
                last.setMaxLifecycle(state2);
            } else {
                last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(last);
            }
        }
        if (saveState || z5 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(last.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z5, ArrayDeque arrayDeque, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navController.popEntryFromBackStack(navBackStackEntry, z5, arrayDeque);
    }

    private final boolean restoreStateInternal(int id, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(id))) {
            return false;
        }
        final String str = this.backStackMap.get(Integer.valueOf(id));
        CollectionsKt.removeAll(this.backStackMap.values(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                return Boolean.valueOf(Intrinsics.areEqual(str2, str));
            }
        });
        return executeRestoreState(instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str)), args, navOptions, navigatorExtras);
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int i5 = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        if (mutableList.size() < 2) {
            return false;
        }
        int intValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
        }
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), intValue, false, null, 4, null);
        if (findDestinationComprehensive$default instanceof NavGraph) {
            intValue = NavGraph.INSTANCE.findStartDestination((NavGraph) findDestinationComprehensive$default).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || intValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("android-support-nav:controller:deepLinkIntent", intent));
        Bundle bundle = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle != null) {
            bundleOf.putAll(bundle);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object obj : mutableList) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createDeepLink.addDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i5) : null);
            i5 = i6;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestId() != id) {
                Bundle bundle = new Bundle();
                Activity activity = this.activity;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            Intrinsics.checkNotNull(activity3);
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", activity3.getIntent());
                            NavGraph topGraph = getTopGraph(this.backQueue);
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(new NavDeepLinkRequest(intent), true, true, topGraph);
                            if ((matchDeepLinkComprehensive != null ? matchDeepLinkComprehensive.getMatchingArgs() : null) != null) {
                                bundle.putAll(matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), null, 2, null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity5 = this.activity;
                if (activity5 != null) {
                    activity5.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (getDestinationCountOnBackStack() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
        boolean z5 = this.enableOnBackPressedCallback;
        onBackPressedCallback.setEnabled(z5);
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry last = this.backQueue.last();
        listener.onDestinationChanged(this, last.getDestination(), last.getArguments());
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public final NavDestination findDestination(int destinationId, NavDestination matchingDest) {
        NavDestination navDestination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.getId() == destinationId) {
            if (matchingDest == null) {
                return this._graph;
            }
            if (Intrinsics.areEqual(this._graph, matchingDest) && matchingDest.getParent() == null) {
                return this._graph;
            }
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
        }
        return findDestinationComprehensive(navDestination, destinationId, false, matchingDest);
    }

    public final NavDestination findDestinationComprehensive(NavDestination navDestination, int i5, boolean z5, NavDestination navDestination2) {
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        if (navDestination.getId() == i5 && (navDestination2 == null || (Intrinsics.areEqual(navDestination, navDestination2) && Intrinsics.areEqual(navDestination.getParent(), navDestination2.getParent())))) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            NavGraph parent = navDestination.getParent();
            Intrinsics.checkNotNull(parent);
            navGraph = parent;
        }
        return navGraph.findNodeComprehensive(i5, navGraph, z5, navDestination2);
    }

    public NavBackStackEntry getBackStackEntry(int destinationId) {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == destinationId) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + destinationId + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public final Context getContext() {
        return this.context;
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.currentBackStack;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.backQueue.lastOrNull();
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        return this.lifecycleOwner == null ? Lifecycle.State.CREATED : this.hostLifecycleState;
    }

    /* renamed from: getNavigatorProvider, reason: from getter */
    public NavigatorProvider get_navigatorProvider() {
        return this._navigatorProvider;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object obj;
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleDeepLink(Intent intent) {
        int[] intArray;
        ArrayList parcelableArrayList;
        Bundle bundle;
        NavGraph topGraph;
        NavDestination.DeepLinkMatch matchDeepLinkComprehensive;
        Bundle addInDefaultArgs;
        NavDestination findNode;
        NavGraph navGraph;
        Bundle bundle2;
        int i5 = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
            } catch (Exception e5) {
                Log.e(TAG, "handleDeepLink() could not extract deepLink from " + intent, e5);
            }
            parcelableArrayList = extras == null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
            Bundle bundle3 = new Bundle();
            bundle = extras == null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
            if (bundle != null) {
                bundle3.putAll(bundle);
            }
            if ((intArray != null || intArray.length == 0) && (matchDeepLinkComprehensive = (topGraph = getTopGraph(this.backQueue)).matchDeepLinkComprehensive(new NavDeepLinkRequest(intent), true, true, topGraph)) != null) {
                NavDestination destination = matchDeepLinkComprehensive.getDestination();
                int[] buildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
                addInDefaultArgs = destination.addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
                if (addInDefaultArgs != null) {
                    bundle3.putAll(addInDefaultArgs);
                }
                intArray = buildDeepLinkIds$default;
                parcelableArrayList = null;
            }
            if (intArray != null || intArray.length == 0) {
                return false;
            }
            String findInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
            if (findInvalidDestinationDisplayNameInDeepLink != null) {
                Log.i(TAG, "Could not find destination " + findInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
                return false;
            }
            bundle3.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
            int length = intArray.length;
            Bundle[] bundleArr = new Bundle[length];
            for (int i6 = 0; i6 < length; i6++) {
                Bundle bundle4 = new Bundle();
                bundle4.putAll(bundle3);
                if (parcelableArrayList != null && (bundle2 = (Bundle) parcelableArrayList.get(i6)) != null) {
                    bundle4.putAll(bundle2);
                }
                bundleArr[i6] = bundle4;
            }
            int flags = intent.getFlags();
            int i7 = 268435456 & flags;
            if (i7 != 0 && (flags & 32768) == 0) {
                intent.addFlags(32768);
                TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(intent);
                Intrinsics.checkNotNullExpressionValue(addNextIntentWithParentStack, "create(context).addNextI…ntWithParentStack(intent)");
                addNextIntentWithParentStack.startActivities();
                Activity activity = this.activity;
                if (activity != null) {
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
                return true;
            }
            if (i7 != 0) {
                if (!this.backQueue.isEmpty()) {
                    NavGraph navGraph2 = this._graph;
                    Intrinsics.checkNotNull(navGraph2);
                    popBackStackInternal$default(this, navGraph2.getId(), true, false, 4, null);
                }
                while (i5 < intArray.length) {
                    int i8 = intArray[i5];
                    int i9 = i5 + 1;
                    Bundle bundle5 = bundleArr[i5];
                    final NavDestination findDestination$default = findDestination$default(this, i8, null, 2, null);
                    if (findDestination$default == null) {
                        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i8) + " cannot be found from the current destination " + getCurrentDestination());
                    }
                    navigate(findDestination$default, bundle5, NavOptionsBuilderKt.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                            invoke2(navOptionsBuilder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(NavOptionsBuilder navOptions) {
                            boolean z5;
                            Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                            navOptions.anim(new Function1<AnimBuilder, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimBuilder animBuilder) {
                                    invoke2(animBuilder);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimBuilder anim) {
                                    Intrinsics.checkNotNullParameter(anim, "$this$anim");
                                    anim.setEnter(0);
                                    anim.setExit(0);
                                }
                            });
                            NavDestination navDestination = NavDestination.this;
                            if (navDestination instanceof NavGraph) {
                                Sequence<NavDestination> hierarchy = NavDestination.INSTANCE.getHierarchy(navDestination);
                                NavController navController = this;
                                for (NavDestination navDestination2 : hierarchy) {
                                    NavDestination currentDestination = navController.getCurrentDestination();
                                    if (Intrinsics.areEqual(navDestination2, currentDestination != null ? currentDestination.getParent() : null)) {
                                        return;
                                    }
                                }
                                z5 = NavController.deepLinkSaveState;
                                if (z5) {
                                    navOptions.popUpTo(NavGraph.INSTANCE.findStartDestination(this.getGraph()).getId(), new Function1<PopUpToBuilder, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                            invoke2(popUpToBuilder);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(PopUpToBuilder popUpTo) {
                                            Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                            popUpTo.setSaveState(true);
                                        }
                                    });
                                }
                            }
                        }
                    }), null);
                    i5 = i9;
                }
                this.deepLinkHandled = true;
                return true;
            }
            NavGraph navGraph3 = this._graph;
            int length2 = intArray.length;
            for (int i10 = 0; i10 < length2; i10++) {
                int i11 = intArray[i10];
                Bundle bundle6 = bundleArr[i10];
                if (i10 == 0) {
                    findNode = this._graph;
                } else {
                    Intrinsics.checkNotNull(navGraph3);
                    findNode = navGraph3.findNode(i11);
                }
                if (findNode == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i11) + " cannot be found in graph " + navGraph3);
                }
                if (i10 == intArray.length - 1) {
                    NavOptions.Builder builder = new NavOptions.Builder();
                    NavGraph navGraph4 = this._graph;
                    Intrinsics.checkNotNull(navGraph4);
                    navigate(findNode, bundle6, NavOptions.Builder.setPopUpTo$default(builder, navGraph4.getId(), true, false, 4, (Object) null).setEnterAnim(0).setExitAnim(0).build(), null);
                } else if (findNode instanceof NavGraph) {
                    while (true) {
                        navGraph = (NavGraph) findNode;
                        Intrinsics.checkNotNull(navGraph);
                        if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                            break;
                        }
                        findNode = navGraph.findNode(navGraph.getStartDestId());
                    }
                    navGraph3 = navGraph;
                }
            }
            this.deepLinkHandled = true;
            return true;
        }
        intArray = null;
        if (extras == null) {
        }
        Bundle bundle32 = new Bundle();
        if (extras == null) {
        }
        if (bundle != null) {
        }
        if (intArray != null) {
        }
        NavDestination destination2 = matchDeepLinkComprehensive.getDestination();
        int[] buildDeepLinkIds$default2 = NavDestination.buildDeepLinkIds$default(destination2, null, 1, null);
        addInDefaultArgs = destination2.addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
        if (addInDefaultArgs != null) {
        }
        intArray = buildDeepLinkIds$default2;
        parcelableArrayList = null;
        if (intArray != null) {
        }
        return false;
    }

    public void navigate(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null));
    }

    public boolean navigateUp() {
        Intent intent;
        if (getDestinationCountOnBackStack() != 1) {
            return popBackStack();
        }
        Activity activity = this.activity;
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        return (extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null) != null ? tryRelaunchUpToExplicitStack() : tryRelaunchUpToGeneratedStack();
    }

    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        int indexOf = this.backQueue.indexOf(popUpTo);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i5 = indexOf + 1;
        if (i5 != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i5).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(navBackStackEntry2);
            }
        }
        CollectionsKt.addAll(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    public void restoreState(Bundle navState) {
        if (navState == null) {
            return;
        }
        navState.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = navState.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = navState.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] intArray = navState.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> stringArrayList = navState.getStringArrayList(KEY_BACK_STACK_IDS);
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                this.backStackMap.put(Integer.valueOf(intArray[i5]), stringArrayList.get(i6));
                i5++;
                i6++;
            }
        }
        ArrayList<String> stringArrayList2 = navState.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
        if (stringArrayList2 != null) {
            for (String id : stringArrayList2) {
                Parcelable[] parcelableArray = navState.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + id);
                if (parcelableArray != null) {
                    Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>(parcelableArray.length);
                    Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                    while (it.hasNext()) {
                        Parcelable parcelable = (Parcelable) it.next();
                        Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        arrayDeque.add((NavBackStackEntryState) parcelable);
                    }
                    map.put(id, arrayDeque);
                }
            }
        }
        this.deepLinkHandled = navState.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.size()];
            Iterator<NavBackStackEntry> it = this.backQueue.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                parcelableArr[i5] = new NavBackStackEntryState(it.next());
                i5++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i6 = 0;
            for (Map.Entry<Integer, String> entry2 : this.backStackMap.entrySet()) {
                int intValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i6] = intValue;
                arrayList2.add(value);
                i6++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry3 : this.backStackStates.entrySet()) {
                String key2 = entry3.getKey();
                ArrayDeque<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i7 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i7] = navBackStackEntryState;
                    i7 = i8;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + key2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.deepLinkHandled);
        }
        return bundle;
    }

    public void setGraph(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        setGraph(graph, null);
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (Intrinsics.areEqual(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.INSTANCE;
        if (Intrinsics.areEqual(navControllerViewModel, companion.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.viewModel = companion.getInstance(viewModelStore);
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(child);
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(remove);
        Integer valueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInteger atomicInteger;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.backQueue);
        if (mutableList.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) CollectionsKt.last(mutableList)).getDestination();
        ArrayList arrayList = new ArrayList();
        if (destination instanceof FloatingWindow) {
            Iterator it = CollectionsKt.reversed(mutableList).iterator();
            while (it.hasNext()) {
                NavDestination destination2 = ((NavBackStackEntry) it.next()).getDestination();
                arrayList.add(destination2);
                if (!(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination3 = navBackStackEntry.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (Intrinsics.areEqual((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        hashMap.put(navBackStackEntry, state);
                    }
                }
                NavDestination navDestination = (NavDestination) CollectionsKt.firstOrNull((List) arrayList);
                if (navDestination != null && navDestination.getId() == destination3.getId()) {
                    CollectionsKt.removeFirst(arrayList);
                }
                destination = destination.getParent();
            } else if (arrayList.isEmpty() || destination3.getId() != ((NavDestination) CollectionsKt.first((List) arrayList)).getId()) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                NavDestination navDestination2 = (NavDestination) CollectionsKt.removeFirst(arrayList);
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        hashMap.put(navBackStackEntry, state2);
                    }
                }
                NavGraph parent = navDestination2.getParent();
                if (parent != null && !arrayList.contains(parent)) {
                    arrayList.add(parent);
                }
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : mutableList) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.setMaxLifecycle(state3);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    public static /* synthetic */ void navigate$default(NavController navController, Object obj, NavOptions navOptions, Navigator.Extras extras, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i5 & 2) != 0) {
            navOptions = null;
        }
        if ((i5 & 4) != 0) {
            extras = null;
        }
        navController.navigate((NavController) obj, navOptions, extras);
    }

    public void navigate(NavDeepLinkRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate(request, (NavOptions) null);
    }

    public void setGraph(NavGraph graph, Bundle startDestinationArgs) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        if (!this.backQueue.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        }
        if (!Intrinsics.areEqual(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer id : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    clearBackStackInternal(id.intValue());
                }
                popBackStackInternal$default(this, navGraph.getId(), true, false, 4, null);
            }
            this._graph = graph;
            onGraphCreated(startDestinationArgs);
            return;
        }
        int size = graph.getNodes().size();
        for (int i5 = 0; i5 < size; i5++) {
            NavDestination valueAt = graph.getNodes().valueAt(i5);
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            int keyAt = navGraph2.getNodes().keyAt(i5);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(keyAt, valueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            List<NavDestination> asReversed = CollectionsKt.asReversed(SequencesKt.toList(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination())));
            NavDestination navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
            for (NavDestination navDestination2 : asReversed) {
                if (!Intrinsics.areEqual(navDestination2, this._graph) || !Intrinsics.areEqual(navDestination, graph)) {
                    if (navDestination instanceof NavGraph) {
                        navDestination = ((NavGraph) navDestination).findNode(navDestination2.getId());
                        Intrinsics.checkNotNull(navDestination);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestination);
        }
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(request, "request");
        navigate(request, navOptions, (Navigator.Extras) null);
    }

    public boolean popBackStack(int destinationId, boolean inclusive) {
        return popBackStack(destinationId, inclusive, false);
    }

    private final boolean popBackStackInternal(int destinationId, boolean inclusive, boolean saveState) {
        NavDestination navDestination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination.getNavigatorName());
            if (inclusive || navDestination.getId() != destinationId) {
                arrayList.add(navigator);
            }
            if (navDestination.getId() == destinationId) {
                break;
            }
        }
        if (navDestination == null) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.INSTANCE.getDisplayName(this.context, destinationId) + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, navDestination, inclusive, saveState);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(request, true, true, topGraph);
            if (matchDeepLinkComprehensive != null) {
                Bundle addInDefaultArgs = matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
                if (addInDefaultArgs == null) {
                    addInDefaultArgs = new Bundle();
                }
                NavDestination destination = matchDeepLinkComprehensive.getDestination();
                Intent intent = new Intent();
                intent.setDataAndType(request.getUri(), request.getMimeType());
                intent.setAction(request.getAction());
                addInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                navigate(destination, addInDefaultArgs, navOptions, navigatorExtras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    public boolean popBackStack(int destinationId, boolean inclusive, boolean saveState) {
        return popBackStackInternal(destinationId, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    public final boolean popBackStack(String route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal(route, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    public final <T> boolean popBackStack(T route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return popBackStackInternal((NavController) route, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    public final NavBackStackEntry getBackStackEntry(String route) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(route, "route");
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    private final <T> boolean popBackStackInternal(T route, boolean inclusive, boolean saveState) {
        return popBackStackInternal(generateRouteFilled(route), inclusive, saveState);
    }

    private final boolean popBackStackInternal(String route, boolean inclusive, boolean saveState) {
        NavBackStackEntry navBackStackEntry;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque<NavBackStackEntry> arrayDeque = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            boolean hasRoute = navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments());
            if (inclusive || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        NavDestination destination = navBackStackEntry3 != null ? navBackStackEntry3.getDestination() : null;
        if (destination == null) {
            Log.i(TAG, "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x012a A[LOOP:1: B:20:0x0124->B:22:0x012a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void navigate(final NavDestination node, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        boolean z5;
        boolean z6;
        Iterator<T> it;
        boolean popBackStackInternal;
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(true);
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        if (navOptions != null) {
            if (navOptions.getPopUpToRoute() != null) {
                String popUpToRoute = navOptions.getPopUpToRoute();
                Intrinsics.checkNotNull(popUpToRoute);
                popBackStackInternal = popBackStackInternal(popUpToRoute, navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteClass() != null) {
                KClass<?> popUpToRouteClass = navOptions.getPopUpToRouteClass();
                Intrinsics.checkNotNull(popUpToRouteClass);
                popBackStackInternal = popBackStackInternal(RouteSerializerKt.generateHashCode(SerializersKt.serializer(popUpToRouteClass)), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else if (navOptions.getPopUpToRouteObject() != null) {
                Object popUpToRouteObject = navOptions.getPopUpToRouteObject();
                Intrinsics.checkNotNull(popUpToRouteObject);
                popBackStackInternal = popBackStackInternal((NavController) popUpToRouteObject, navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else if (navOptions.getPopUpToId() != -1) {
                popBackStackInternal = popBackStackInternal(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            }
            z5 = popBackStackInternal;
            final Bundle addInDefaultArgs = node.addInDefaultArgs(args);
            if (navOptions == null && navOptions.getRestoreState() && this.backStackMap.containsKey(Integer.valueOf(node.getId()))) {
                ref$BooleanRef.element = restoreStateInternal(node.getId(), addInDefaultArgs, navOptions, navigatorExtras);
                z6 = false;
            } else {
                z6 = navOptions == null && navOptions.getSingleTop() && launchSingleTopInternal(node, args);
                if (!z6) {
                    navigateInternal(this._navigatorProvider.getNavigator(node.getNavigatorName()), CollectionsKt.listOf(NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, node, addInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), navOptions, navigatorExtras, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$navigate$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                            invoke2(navBackStackEntry);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(NavBackStackEntry it3) {
                            Intrinsics.checkNotNullParameter(it3, "it");
                            Ref$BooleanRef.this.element = true;
                            NavController.addEntryToBackStack$default(this, node, addInDefaultArgs, it3, null, 8, null);
                        }
                    });
                }
            }
            updateOnBackPressedCallbackEnabled();
            it = this.navigatorState.values().iterator();
            while (it.hasNext()) {
                ((NavControllerNavigatorState) it.next()).setNavigating(false);
            }
            if (z5 && !ref$BooleanRef.element && !z6) {
                updateBackStackLifecycle$navigation_runtime_release();
                return;
            } else {
                dispatchOnDestinationChanged();
            }
        }
        z5 = false;
        final Bundle addInDefaultArgs2 = node.addInDefaultArgs(args);
        if (navOptions == null) {
        }
        if (navOptions == null) {
        }
        if (!z6) {
        }
        updateOnBackPressedCallbackEnabled();
        it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
        }
        if (z5) {
        }
        dispatchOnDestinationChanged();
    }

    public final void navigate(String route, Function1<? super NavOptionsBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    public final void navigate(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchRouteComprehensive = topGraph.matchRouteComprehensive(route, true, true, topGraph);
            if (matchRouteComprehensive != null) {
                NavDestination destination = matchRouteComprehensive.getDestination();
                Bundle addInDefaultArgs = destination.addInDefaultArgs(matchRouteComprehensive.getMatchingArgs());
                if (addInDefaultArgs == null) {
                    addInDefaultArgs = new Bundle();
                }
                NavDestination destination2 = matchRouteComprehensive.getDestination();
                Intent intent = new Intent();
                Uri parse = Uri.parse(NavDestination.INSTANCE.createRoute(destination.getRoute()));
                Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
                intent.setDataAndType(parse, null);
                intent.setAction(null);
                addInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                navigate(destination2, addInDefaultArgs, navOptions, navigatorExtras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    public final <T> void navigate(T route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(route, "route");
        navigate(generateRouteFilled(route), navOptions, navigatorExtras);
    }
}
