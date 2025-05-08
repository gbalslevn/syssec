package kotlinx.coroutines.channels;

import androidx.concurrent.futures.a;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002Í\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010 \u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!JG\u0010\"\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0011H\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010%J\u001b\u0010(\u001a\u00020\u001e*\u00020\u001c2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)J1\u0010+\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u0017J\u001d\u0010.\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b.\u0010/J@\u00102\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u0010,J&\u00103\u001a\u00020\u00062\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u0010/J9\u00104\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b4\u00105J9\u00106\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b6\u00105J)\u00107\u001a\u00020\u001e*\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010:J-\u0010<\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0011H\u0002¢\u0006\u0004\b<\u0010=J-\u0010>\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0011H\u0002¢\u0006\u0004\b>\u0010=J\u0019\u0010@\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011H\u0002¢\u0006\u0004\b@\u0010AJ%\u0010E\u001a\u00020\u00062\n\u0010C\u001a\u0006\u0012\u0002\b\u00030B2\b\u0010D\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bE\u0010FJ\u001b\u0010G\u001a\u00020\u00062\n\u0010C\u001a\u0006\u0012\u0002\b\u00030BH\u0002¢\u0006\u0004\bG\u0010HJ%\u0010J\u001a\u0004\u0018\u00010\u001c2\b\u0010D\u001a\u0004\u0018\u00010\u001c2\b\u0010I\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u0010:J\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u0010:J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010:J\u000f\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010:J\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010:J\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010AJ\u0015\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bU\u0010VJ\u001d\u0010X\u001a\u00020\u00112\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bX\u0010YJ\u001d\u0010Z\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bZ\u0010[J%\u0010]\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\\\u001a\u00020\u0011H\u0002¢\u0006\u0004\b]\u0010^J\u0013\u0010_\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b_\u0010`J\u0013\u0010a\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\ba\u0010`J\u001b\u0010c\u001a\u00020\u0006*\u00020\u00152\u0006\u0010b\u001a\u00020\u001eH\u0002¢\u0006\u0004\bc\u0010dJ\u001f\u0010g\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u001eH\u0002¢\u0006\u0004\bg\u0010hJ-\u0010j\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\u0011H\u0002¢\u0006\u0004\bj\u0010=J-\u0010m\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bm\u0010nJ-\u0010o\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bo\u0010nJ5\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010p\u001a\u00020\u0011H\u0002¢\u0006\u0004\bq\u0010rJ%\u0010s\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u00112\f\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010v\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u0011H\u0002¢\u0006\u0004\bv\u0010AJ\u0017\u0010w\u001a\u00020\u00062\u0006\u0010u\u001a\u00020\u0011H\u0002¢\u0006\u0004\bw\u0010AJ\u001b\u0010x\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\bx\u0010\rJ&\u0010{\u001a\b\u0012\u0004\u0012\u00020\u0006002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\by\u0010zJ\u000f\u0010|\u001a\u00020\u0006H\u0014¢\u0006\u0004\b|\u0010:J\u000f\u0010}\u001a\u00020\u0006H\u0014¢\u0006\u0004\b}\u0010:J\u0013\u0010~\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ$\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010\u007fJ!\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020\u0011H\u0004¢\u0006\u0005\b\u0086\u0001\u0010AJ\u0019\u0010\u0088\u0001\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0011H\u0000¢\u0006\u0005\b\u0087\u0001\u0010AJ\u001a\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u0001H\u0096\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008c\u0001\u0010:J\u001e\u0010\u008f\u0001\u001a\u00020\u001e2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J#\u0010\u0093\u0001\u001a\u00020\u00062\u0011\u0010\u008e\u0001\u001a\f\u0018\u00010\u0091\u0001j\u0005\u0018\u0001`\u0092\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0096\u0001\u001a\u00020\u001e2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0010¢\u0006\u0006\b\u0095\u0001\u0010\u0090\u0001J'\u0010\u0097\u0001\u001a\u00020\u001e2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J*\u0010\u009a\u0001\u001a\u00020\u00062\u0016\u0010\u0099\u0001\u001a\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0012\u0010\u009e\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0013\u0010 \u0001\u001a\u00030\u009f\u0001H\u0016¢\u0006\u0006\b \u0001\u0010¡\u0001R\u0015\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0004\u0010¢\u0001R/\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0081\u0004¢\u0006\u0007\n\u0005\b\b\u0010£\u0001RU\u0010¦\u0001\u001a9\u0012\b\u0012\u0006\u0012\u0002\b\u00030B\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030\u008d\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010¤\u0001j\u0005\u0018\u0001`¥\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b¦\u0001\u0010§\u0001\u0012\u0005\b¨\u0001\u0010:R\u0017\u0010«\u0001\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0017\u0010¬\u0001\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u009d\u0001R\u0018\u0010¯\u0001\u001a\u00030\u008d\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001a\u0010°\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010%R\u001a\u0010±\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010%R\u0016\u0010\\\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010ª\u0001R\u0017\u0010´\u0001\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010ª\u0001R.\u0010¹\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000µ\u00018VX\u0096\u0004ø\u0001\u0000¢\u0006\u000f\u0012\u0005\b¸\u0001\u0010:\u001a\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010»\u0001\u001a\u0005\u0018\u00010\u008d\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010®\u0001R\u0018\u0010½\u0001\u001a\u00030\u008d\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010®\u0001R\u0017\u0010¾\u0001\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010\u009d\u0001R\u001e\u0010¿\u0001\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÀ\u0001\u0010:\u001a\u0006\b¿\u0001\u0010\u009d\u0001R\u001c\u0010f\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÁ\u0001\u0010:\u001a\u0005\bf\u0010\u009d\u0001R\u0015\u0010Ã\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Â\u00018\u0002X\u0082\u0004R\r\u0010Å\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004R\u0019\u0010Æ\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Â\u00018\u0002X\u0082\u0004R\u0015\u0010Ç\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0Â\u00018\u0002X\u0082\u0004R\r\u0010È\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004R\u0019\u0010É\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Â\u00018\u0002X\u0082\u0004R\r\u0010Ê\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004R\u0019\u0010Ë\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0Â\u00018\u0002X\u0082\u0004R\r\u0010Ì\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006Î\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", BuildConfig.FLAVOR, "capacity", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "element", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelSegment;", "segment", "index", BuildConfig.FLAVOR, "s", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Waiter;", "prepareSenderForSuspension", "(Lkotlinx/coroutines/Waiter;Lkotlinx/coroutines/channels/ChannelSegment;I)V", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", BuildConfig.FLAVOR, "waiter", BuildConfig.FLAVOR, "closed", "updateCellSend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "curSendersAndCloseStatus", "shouldSendSuspend", "(J)Z", "curSenders", "bufferOrRendezvousSend", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "r", "receiveOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "receiveCatchingOnNoWaiterSuspend", "onClosedReceiveCatchingOnNoWaiterSuspend", "updateCellReceive", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLjava/lang/Object;)Ljava/lang/Object;", "updateCellReceiveSlow", "tryResumeSender", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/ChannelSegment;I)Z", "expandBuffer", "()V", "b", "updateCellExpandBuffer", "(Lkotlinx/coroutines/channels/ChannelSegment;IJ)Z", "updateCellExpandBufferSlow", "nAttempts", "incCompletedExpandBufferAttempts", "(J)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "ignoredParam", "registerSelectForReceive", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "onClosedSelectOnReceive", "(Lkotlinx/coroutines/selects/SelectInstance;)V", "selectResult", "processResultSelectReceiveCatching", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "invokeCloseHandler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "sendersCur", "completeClose", "(J)Lkotlinx/coroutines/channels/ChannelSegment;", "completeCancel", "closeLinkedList", "()Lkotlinx/coroutines/channels/ChannelSegment;", "lastSegment", "markAllEmptyCellsAsClosed", "(Lkotlinx/coroutines/channels/ChannelSegment;)J", "removeUnprocessedElements", "(Lkotlinx/coroutines/channels/ChannelSegment;)V", "sendersCounter", "cancelSuspendedReceiveRequests", "(Lkotlinx/coroutines/channels/ChannelSegment;J)V", "resumeReceiverOnClosedChannel", "(Lkotlinx/coroutines/Waiter;)V", "resumeSenderOnCancelledChannel", "receiver", "resumeWaiterOnClosedChannel", "(Lkotlinx/coroutines/Waiter;Z)V", "sendersAndCloseStatusCur", "isClosedForReceive", "isClosed", "(JZ)Z", "globalIndex", "isCellNonEmpty", Constants.ID_ATTRIBUTE_KEY, "startFrom", "findSegmentSend", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "findSegmentReceive", "currentBufferEndCounter", "findSegmentBufferEnd", "(JLkotlinx/coroutines/channels/ChannelSegment;J)Lkotlinx/coroutines/channels/ChannelSegment;", "moveSegmentBufferEndToSpecifiedOrLast", "(JLkotlinx/coroutines/channels/ChannelSegment;)V", "value", "updateSendersCounterIfLower", "updateReceiversCounterIfLower", "send", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "globalCellIndex", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "waitExpandBufferCompletion$kotlinx_coroutines_core", "waitExpandBufferCompletion", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "onClosedIdempotent", BuildConfig.FLAVOR, "cause", "close", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl$kotlinx_coroutines_core", "cancelImpl", "closeOrCancelImpl", "(Ljava/lang/Throwable;Z)Z", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "hasElements$kotlinx_coroutines_core", "()Z", "hasElements", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "I", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/jvm/functions/Function3;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "getBufferEndCounter", "()J", "bufferEndCounter", "isRendezvousOrUnlimited", "getReceiveException", "()Ljava/lang/Throwable;", "receiveException", "isClosedForSend0", "isClosedForReceive0", "getSendersCounter$kotlinx_coroutines_core", "getReceiversCounter$kotlinx_coroutines_core", "receiversCounter", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveCatching", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveCatching$annotations", "onReceiveCatching", "getCloseCause", "closeCause", "getSendException", "sendException", "isConflatedDropOldest", "isClosedForSend", "isClosedForSend$annotations", "isClosedForReceive$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_closeCause", "Lkotlinx/atomicfu/AtomicLong;", "bufferEnd", "bufferEndSegment", "closeHandler", "completedExpandBuffersAndPauseFlag", "receiveSegment", "receivers", "sendSegment", "sendersAndCloseStatus", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private final int capacity;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
    private static final AtomicLongFieldUpdater receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
    private static final AtomicLongFieldUpdater bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
    private static final AtomicReferenceFieldUpdater sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
    private static final AtomicReferenceFieldUpdater receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
    private static final AtomicReferenceFieldUpdater _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
    private static final AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0006H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", BuildConfig.FLAVOR, "receiveResult", BuildConfig.FLAVOR, "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", BuildConfig.FLAVOR, "r", BuildConfig.FLAVOR, "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult;

        public BufferedChannelIterator() {
            Symbol symbol;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            this.receiveResult = symbol;
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i5, long j5, Continuation<? super Boolean> continuation) {
            Symbol symbol;
            Symbol symbol2;
            Boolean boxBoolean;
            Symbol symbol3;
            Symbol symbol4;
            Symbol symbol5;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i5, j5, this);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive == symbol) {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i5);
                } else {
                    symbol2 = BufferedChannelKt.FAILED;
                    Function1<Throwable, Unit> function1 = null;
                    if (updateCellReceive == symbol2) {
                        if (j5 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                                break;
                            }
                            long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                            int i6 = BufferedChannelKt.SEGMENT_SIZE;
                            long j6 = andIncrement / i6;
                            int i7 = (int) (andIncrement % i6);
                            if (channelSegment2.id != j6) {
                                ChannelSegment findSegmentReceive = bufferedChannel.findSegmentReceive(j6, channelSegment2);
                                if (findSegmentReceive != null) {
                                    channelSegment2 = findSegmentReceive;
                                }
                            }
                            Object updateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i7, andIncrement, this);
                            symbol3 = BufferedChannelKt.SUSPEND;
                            if (updateCellReceive2 == symbol3) {
                                bufferedChannel.prepareReceiverForSuspension(this, channelSegment2, i7);
                                break;
                            }
                            symbol4 = BufferedChannelKt.FAILED;
                            if (updateCellReceive2 != symbol4) {
                                symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                if (updateCellReceive2 == symbol5) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment2.cleanPrev();
                                this.receiveResult = updateCellReceive2;
                                this.continuation = null;
                                boxBoolean = Boxing.boxBoolean(true);
                                Function1<E, Unit> function12 = bufferedChannel.onUndeliveredElement;
                                if (function12 != null) {
                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive2, orCreateCancellableContinuation.getContext());
                                }
                            } else if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        this.continuation = null;
                        boxBoolean = Boxing.boxBoolean(true);
                        Function1<E, Unit> function13 = bufferedChannel.onUndeliveredElement;
                        if (function13 != null) {
                            function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                        }
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, function1);
                }
                Object result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            ChannelSegment<E> channelSegment;
            Symbol symbol;
            Symbol symbol2;
            Symbol symbol3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ChannelSegment<E> channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                int i5 = BufferedChannelKt.SEGMENT_SIZE;
                long j5 = andIncrement / i5;
                int i6 = (int) (andIncrement % i5);
                if (channelSegment2.id != j5) {
                    ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j5, channelSegment2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i6, andIncrement, null);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive == symbol) {
                    throw new IllegalStateException("unreachable");
                }
                symbol2 = BufferedChannelKt.FAILED;
                if (updateCellReceive != symbol2) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    if (updateCellReceive == symbol3) {
                        return hasNextOnNoWaiterSuspend(channelSegment, i6, andIncrement, continuation);
                    }
                    channelSegment.cleanPrev();
                    this.receiveResult = updateCellReceive;
                    return Boxing.boxBoolean(true);
                }
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            Symbol symbol;
            Symbol symbol2;
            E e5 = (E) this.receiveResult;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e5 == symbol) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            symbol2 = BufferedChannelKt.NO_RECEIVE_RESULT;
            this.receiveResult = symbol2;
            if (e5 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return e5;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
        }

        public final boolean tryResumeHasNext(E element) {
            boolean tryResume0;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function1 = BufferedChannel.this.onUndeliveredElement;
            tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cancellableContinuationImpl.getContext()) : null);
            return tryResume0;
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int i5, Function1<? super E, Unit> function1) {
        long initialBufferEnd;
        Symbol symbol;
        this.capacity = i5;
        this.onUndeliveredElement = function1;
        if (i5 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i5 + ", should be >=0").toString());
        }
        initialBufferEnd = BufferedChannelKt.initialBufferEnd(i5);
        this.bufferEnd = initialBufferEnd;
        this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
        ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment = channelSegment;
        this.receiveSegment = channelSegment;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = function1 != 0 ? new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
            final /* synthetic */ BufferedChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(final SelectInstance<?> selectInstance, Object obj, final Object obj2) {
                final BufferedChannel<E> bufferedChannel = this.this$0;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj2, selectInstance.getContext());
                        }
                    }
                };
            }
        } : null;
        symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        this._closeCause = symbol;
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        Symbol symbol;
        Object m3788constructorimpl$default = InlineList.m3788constructorimpl$default(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i5 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i5; i5--) {
                if ((lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i5 < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i5);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol) {
                            if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                                if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                    break;
                                }
                                if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m3788constructorimpl$default = InlineList.m3789plusFjFbRPM(m3788constructorimpl$default, state$kotlinx_coroutines_core);
                                    lastSegment.onCancelledRequest(i5, true);
                                    break;
                                }
                            } else {
                                if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m3788constructorimpl$default = InlineList.m3789plusFjFbRPM(m3788constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                    lastSegment.onCancelledRequest(i5, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        lastSegment.onSlotCleaned();
                        break;
                    }
                }
            }
            lastSegment = (ChannelSegment) lastSegment.getPrev();
        }
        if (m3788constructorimpl$default != null) {
            if (!(m3788constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) m3788constructorimpl$default);
                return;
            }
            Intrinsics.checkNotNull(m3788constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) m3788constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = bufferEndSegment$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$FU.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, sendersCur);
        return closeLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$FU.getAndIncrement(this);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / i5;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j5 && channelSegment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j5, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j5) {
                ChannelSegment<E> findSegmentBufferEnd = findSegmentBufferEnd(j5, channelSegment, andIncrement);
                if (findSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = findSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % i5), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
                Segment m3791getSegmentimpl = SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m3791getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m3791getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, segment, m3791getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m3791getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m3791getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
        long j5 = channelSegment.id;
        if (j5 <= id) {
            return channelSegment;
        }
        int i5 = BufferedChannelKt.SEGMENT_SIZE;
        if (bufferEnd$FU.compareAndSet(this, currentBufferEndCounter + 1, i5 * j5)) {
            incCompletedExpandBufferAttempts((channelSegment.id * i5) - currentBufferEndCounter);
            return null;
        }
        incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
                Segment m3791getSegmentimpl = SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m3791getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m3791getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, segment, m3791getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m3791getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m3791getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$FU;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.id >= channelSegment.id || !channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (a.a(atomicReferenceFieldUpdater2, this, segment2, channelSegment)) {
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                } else if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                    channelSegment.remove();
                }
            }
        }
        long j5 = channelSegment.id;
        if (j5 <= id) {
            return channelSegment;
        }
        int i5 = BufferedChannelKt.SEGMENT_SIZE;
        updateReceiversCounterIfLower(j5 * i5);
        if (channelSegment.id * i5 >= getSendersCounter$kotlinx_coroutines_core()) {
            return null;
        }
        channelSegment.cleanPrev();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
                Segment m3791getSegmentimpl = SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m3791getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m3791getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, segment, m3791getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m3791getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m3791getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
        long j5 = channelSegment.id;
        if (j5 <= id) {
            return channelSegment;
        }
        int i5 = BufferedChannelKt.SEGMENT_SIZE;
        updateSendersCounterIfLower(j5 * i5);
        if (channelSegment.id * i5 >= getReceiversCounter$kotlinx_coroutines_core()) {
            return null;
        }
        channelSegment.cleanPrev();
        return null;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException("Channel was closed") : closeCause;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if ((completedExpandBuffersAndPauseFlag$FU.addAndGet(this, nAttempts) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((completedExpandBuffersAndPauseFlag$FU.get(this) & 4611686018427387904L) != 0);
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i5 & 1) != 0) {
            j5 = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j5);
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        return true;
                    }
                    symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                    if (state$kotlinx_coroutines_core == symbol3 || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return false;
                    }
                    symbol4 = BufferedChannelKt.DONE_RCV;
                    if (state$kotlinx_coroutines_core == symbol4) {
                        return false;
                    }
                    symbol5 = BufferedChannelKt.POISONED;
                    if (state$kotlinx_coroutines_core == symbol5) {
                        return false;
                    }
                    symbol6 = BufferedChannelKt.RESUMING_BY_EB;
                    if (state$kotlinx_coroutines_core == symbol6) {
                        return true;
                    }
                    symbol7 = BufferedChannelKt.RESUMING_BY_RCV;
                    return state$kotlinx_coroutines_core != symbol7 && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
                }
            }
            symbol = BufferedChannelKt.POISONED;
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i5 = (int) (sendersAndCloseStatusCur >> 60);
        if (i5 == 0 || i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
            if (isClosedForReceive && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        } else {
            if (i5 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i5).toString());
            }
            completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
        }
        return true;
    }

    private final boolean isClosedForReceive0(long j5) {
        return isClosed(j5, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j5) {
        return isClosed(j5, false);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.ChannelSegment) r8.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> lastSegment) {
        Symbol symbol;
        do {
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i5--;
                if (-1 >= i5) {
                    break;
                }
                long j5 = (lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i5;
                if (j5 < getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i5);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol) {
                            if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                                return j5;
                            }
                        }
                    }
                    if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        lastSegment.onSlotCleaned();
                        break;
                    }
                }
            }
        } while (lastSegment != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long j5;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                return;
            } else {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j5, 1);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, constructSendersAndCloseStatus));
    }

    private final void markCancelled() {
        long j5;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j5, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, constructSendersAndCloseStatus));
    }

    private final void markClosed() {
        long j5;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            int i5 = (int) (j5 >> 60);
            if (i5 == 0) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j5 & 1152921504606846975L, 2);
            } else if (i5 != 1) {
                return;
            } else {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j5 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, constructSendersAndCloseStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2;
        while (startFrom.id < id && (channelSegment2 = (ChannelSegment) startFrom.getNext()) != null) {
            startFrom = channelSegment2;
        }
        while (true) {
            if (!startFrom.isRemoved() || (channelSegment = (ChannelSegment) startFrom.getNext()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= startFrom.id) {
                        return;
                    }
                    if (!startFrom.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, segment, startFrom)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                            return;
                        }
                        return;
                    } else if (startFrom.decPointers$kotlinx_coroutines_core()) {
                        startFrom.remove();
                    }
                }
            } else {
                startFrom = channelSegment;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m3567constructorimpl(ChannelResult.m3768boximpl(ChannelResult.INSTANCE.m3778closedJP2dKIU(getCloseCause()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(E e5, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e5, null, 2, null)) == null) {
            Throwable sendException = getSendException();
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        Throwable sendException = getSendException();
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i5) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i5) {
        waiter.invokeOnCancellation(channelSegment, i5 + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.m3768boximpl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.INSTANCE.m3778closedJP2dKIU(getCloseCause()) : ChannelResult.INSTANCE.m3780successJP2dKIU(selectResult));
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$FU.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(bufferedChannel);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / i5;
            int i6 = (int) (andIncrement % i5);
            if (channelSegment.id != j5) {
                ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j5, channelSegment);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            }
            Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i6, andIncrement, null);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive == symbol) {
                throw new IllegalStateException("unexpected");
            }
            symbol2 = BufferedChannelKt.FAILED;
            if (updateCellReceive != symbol2) {
                symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                if (updateCellReceive == symbol3) {
                    return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i6, andIncrement, continuation);
                }
                channelSegment.cleanPrev();
                return updateCellReceive;
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object m3763receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        int i5;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i6 = bufferedChannel$receiveCatching$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i6 - Integer.MIN_VALUE;
                BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$12 = bufferedChannel$receiveCatching$1;
                Object obj = bufferedChannel$receiveCatching$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bufferedChannel$receiveCatching$12.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((ChannelResult) obj).getHolder();
                }
                ResultKt.throwOnFailure(obj);
                ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$FU.get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = receivers$FU.getAndIncrement(bufferedChannel);
                    int i7 = BufferedChannelKt.SEGMENT_SIZE;
                    long j5 = andIncrement / i7;
                    int i8 = (int) (andIncrement % i7);
                    if (channelSegment.id != j5) {
                        ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j5, channelSegment);
                        if (findSegmentReceive == null) {
                            continue;
                        } else {
                            channelSegment = findSegmentReceive;
                        }
                    }
                    Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i8, andIncrement, null);
                    symbol = BufferedChannelKt.SUSPEND;
                    if (updateCellReceive == symbol) {
                        throw new IllegalStateException("unexpected");
                    }
                    symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol2) {
                        symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive != symbol3) {
                            channelSegment.cleanPrev();
                            return ChannelResult.INSTANCE.m3780successJP2dKIU(updateCellReceive);
                        }
                        bufferedChannel$receiveCatching$12.label = 1;
                        Object m3764receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel.m3764receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i8, andIncrement, bufferedChannel$receiveCatching$12);
                        return m3764receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended ? coroutine_suspended : m3764receiveCatchingOnNoWaiterSuspendGKJJFZk;
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                }
                return ChannelResult.INSTANCE.m3778closedJP2dKIU(bufferedChannel.getCloseCause());
            }
        }
        bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$122 = bufferedChannel$receiveCatching$1;
        Object obj2 = bufferedChannel$receiveCatching$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bufferedChannel$receiveCatching$122.label;
        if (i5 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3764receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> channelSegment, int i5, long j5, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        int i6;
        Symbol symbol;
        Symbol symbol2;
        ChannelResult m3768boximpl;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            int i7 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i7 - Integer.MIN_VALUE;
                Object obj = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i6 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
                if (i6 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = channelSegment;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = i5;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = j5;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
                    CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
                    try {
                        Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                        ReceiveCatching receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
                        Object updateCellReceive = updateCellReceive(channelSegment, i5, j5, receiveCatching);
                        symbol = BufferedChannelKt.SUSPEND;
                        if (updateCellReceive == symbol) {
                            prepareReceiverForSuspension(receiveCatching, channelSegment, i5);
                        } else {
                            symbol2 = BufferedChannelKt.FAILED;
                            Function1<Throwable, Unit> function1 = null;
                            if (updateCellReceive == symbol2) {
                                if (j5 < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
                                while (true) {
                                    if (isClosedForReceive()) {
                                        onClosedReceiveCatchingOnNoWaiterSuspend(orCreateCancellableContinuation);
                                        break;
                                    }
                                    long andIncrement = receivers$FU.getAndIncrement(this);
                                    int i8 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j6 = andIncrement / i8;
                                    int i9 = (int) (andIncrement % i8);
                                    if (channelSegment2.id != j6) {
                                        ChannelSegment findSegmentReceive = findSegmentReceive(j6, channelSegment2);
                                        if (findSegmentReceive != null) {
                                            channelSegment2 = findSegmentReceive;
                                        }
                                    }
                                    Object updateCellReceive2 = updateCellReceive(channelSegment2, i9, andIncrement, receiveCatching);
                                    symbol3 = BufferedChannelKt.SUSPEND;
                                    if (updateCellReceive2 == symbol3) {
                                        prepareReceiverForSuspension(receiveCatching, channelSegment2, i9);
                                        break;
                                    }
                                    symbol4 = BufferedChannelKt.FAILED;
                                    if (updateCellReceive2 != symbol4) {
                                        symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                        if (updateCellReceive2 == symbol5) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        channelSegment2.cleanPrev();
                                        m3768boximpl = ChannelResult.m3768boximpl(ChannelResult.INSTANCE.m3780successJP2dKIU(updateCellReceive2));
                                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                                        if (function12 != null) {
                                            function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive2, orCreateCancellableContinuation.getContext());
                                        }
                                    } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment2.cleanPrev();
                                    }
                                }
                            } else {
                                channelSegment.cleanPrev();
                                m3768boximpl = ChannelResult.m3768boximpl(ChannelResult.INSTANCE.m3780successJP2dKIU(updateCellReceive));
                                Function1<E, Unit> function13 = this.onUndeliveredElement;
                                if (function13 != null) {
                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                                }
                            }
                            orCreateCancellableContinuation.resume(m3768boximpl, function1);
                        }
                        obj = orCreateCancellableContinuation.getResult();
                        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((ChannelResult) obj).getHolder();
            }
        }
        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
        Object obj2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i6 != 0) {
        }
        return ((ChannelResult) obj2).getHolder();
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i5, long j5, Continuation<? super E> continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            Object updateCellReceive = updateCellReceive(channelSegment, i5, j5, orCreateCancellableContinuation);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive == symbol) {
                prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i5);
            } else {
                symbol2 = BufferedChannelKt.FAILED;
                Function1<Throwable, Unit> function1 = null;
                function1 = null;
                if (updateCellReceive == symbol2) {
                    if (j5 < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = receivers$FU.getAndIncrement(this);
                        int i6 = BufferedChannelKt.SEGMENT_SIZE;
                        long j6 = andIncrement / i6;
                        int i7 = (int) (andIncrement % i6);
                        if (channelSegment2.id != j6) {
                            ChannelSegment findSegmentReceive = findSegmentReceive(j6, channelSegment2);
                            if (findSegmentReceive != null) {
                                channelSegment2 = findSegmentReceive;
                            }
                        }
                        updateCellReceive = updateCellReceive(channelSegment2, i7, andIncrement, orCreateCancellableContinuation);
                        symbol3 = BufferedChannelKt.SUSPEND;
                        if (updateCellReceive == symbol3) {
                            CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                            if (cancellableContinuationImpl != null) {
                                prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment2, i7);
                            }
                        } else {
                            symbol4 = BufferedChannelKt.FAILED;
                            if (updateCellReceive != symbol4) {
                                symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                if (updateCellReceive == symbol5) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment2.cleanPrev();
                                Function1<E, Unit> function12 = this.onUndeliveredElement;
                                if (function12 != null) {
                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive, orCreateCancellableContinuation.getContext());
                                }
                            } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function13 = this.onUndeliveredElement;
                    if (function13 != null) {
                        function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                    }
                }
                orCreateCancellableContinuation.resume(updateCellReceive, function1);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / i5;
            int i6 = (int) (andIncrement % i5);
            if (channelSegment.id != j5) {
                ChannelSegment findSegmentReceive = findSegmentReceive(j5, channelSegment);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            }
            Object updateCellReceive = updateCellReceive(channelSegment, i6, andIncrement, select);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive == symbol) {
                Waiter waiter = select instanceof Waiter ? (Waiter) select : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i6);
                    return;
                }
                return;
            }
            symbol2 = BufferedChannelKt.FAILED;
            if (updateCellReceive != symbol2) {
                symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                if (updateCellReceive == symbol3) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                select.selectInRegistrationPhase(updateCellReceive);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        onClosedSelectOnReceive(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeUnprocessedElements(ChannelSegment<E> lastSegment) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementException = null;
        Object m3788constructorimpl$default = InlineList.m3788constructorimpl$default(null, 1, null);
        loop0: do {
            int i5 = BufferedChannelKt.SEGMENT_SIZE - 1;
            while (true) {
                if (-1 >= i5) {
                    break;
                }
                long j5 = (lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i5;
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i5);
                    symbol = BufferedChannelKt.DONE_RCV;
                    if (state$kotlinx_coroutines_core == symbol) {
                        break loop0;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        symbol2 = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core == symbol2 || state$kotlinx_coroutines_core == null) {
                            if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                lastSegment.onSlotCleaned();
                                break;
                            }
                        } else if (!(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            symbol3 = BufferedChannelKt.RESUMING_BY_EB;
                            if (state$kotlinx_coroutines_core == symbol3) {
                                break loop0;
                            }
                            symbol4 = BufferedChannelKt.RESUMING_BY_RCV;
                            if (state$kotlinx_coroutines_core == symbol4) {
                                break loop0;
                            }
                            symbol5 = BufferedChannelKt.RESUMING_BY_EB;
                            if (state$kotlinx_coroutines_core != symbol5) {
                                break;
                            }
                        } else {
                            if (j5 < getReceiversCounter$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            Waiter waiter = state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : (Waiter) state$kotlinx_coroutines_core;
                            if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                if (function1 != null) {
                                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i5), undeliveredElementException);
                                }
                                m3788constructorimpl$default = InlineList.m3789plusFjFbRPM(m3788constructorimpl$default, waiter);
                                lastSegment.cleanElement$kotlinx_coroutines_core(i5);
                                lastSegment.onSlotCleaned();
                            }
                        }
                    } else {
                        if (j5 < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (function1 != null) {
                                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i5), undeliveredElementException);
                            }
                            lastSegment.cleanElement$kotlinx_coroutines_core(i5);
                            lastSegment.onSlotCleaned();
                        }
                    }
                }
                i5--;
            }
        } while (lastSegment != null);
        if (m3788constructorimpl$default != null) {
            if (m3788constructorimpl$default instanceof ArrayList) {
                Intrinsics.checkNotNull(m3788constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) m3788constructorimpl$default;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    resumeSenderOnCancelledChannel((Waiter) arrayList.get(size));
                }
            } else {
                resumeSenderOnCancelledChannel((Waiter) m3788constructorimpl$default);
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z5) {
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(z5 ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) waiter).cont;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ChannelResult.m3768boximpl(ChannelResult.INSTANCE.m3778closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else {
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e5, Continuation<? super Unit> continuation) {
        ChannelSegment<E> channelSegment = (ChannelSegment) sendSegment$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel);
            long j5 = 1152921504606846975L & andIncrement;
            boolean isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j6 = j5 / i5;
            int i6 = (int) (j5 % i5);
            if (channelSegment.id != j6) {
                ChannelSegment<E> findSegmentSend = bufferedChannel.findSegmentSend(j6, channelSegment);
                if (findSegmentSend != null) {
                    channelSegment = findSegmentSend;
                } else if (isClosedForSend0) {
                    Object onClosedSend = bufferedChannel.onClosedSend(e5, continuation);
                    if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend;
                    }
                }
            }
            int updateCellSend = bufferedChannel.updateCellSend(channelSegment, i6, e5, j5, null, isClosedForSend0);
            if (updateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (updateCellSend == 1) {
                break;
            }
            if (updateCellSend != 2) {
                if (updateCellSend == 3) {
                    Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i6, e5, j5, continuation);
                    if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return sendOnNoWaiterSuspend;
                    }
                } else if (updateCellSend == 4) {
                    if (j5 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object onClosedSend2 = bufferedChannel.onClosedSend(e5, continuation);
                    if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend2;
                    }
                } else if (updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
            } else if (isClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object onClosedSend3 = bufferedChannel.onClosedSend(e5, continuation);
                if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return onClosedSend3;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i5, E e5, long j5, Continuation<? super Unit> continuation) {
        Object m3567constructorimpl;
        Object result;
        ChannelSegment channelSegment2;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            int updateCellSend = updateCellSend(channelSegment, i5, e5, j5, orCreateCancellableContinuation, false);
            if (updateCellSend == 0) {
                channelSegment.cleanPrev();
                Result.Companion companion = Result.INSTANCE;
                m3567constructorimpl = Result.m3567constructorimpl(Unit.INSTANCE);
            } else {
                if (updateCellSend != 1) {
                    if (updateCellSend != 2) {
                        if (updateCellSend != 4) {
                            if (updateCellSend != 5) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment.cleanPrev();
                            ChannelSegment channelSegment3 = (ChannelSegment) sendSegment$FU.get(this);
                            while (true) {
                                long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(this);
                                long j6 = andIncrement & 1152921504606846975L;
                                boolean isClosedForSend0 = isClosedForSend0(andIncrement);
                                int i6 = BufferedChannelKt.SEGMENT_SIZE;
                                long j7 = j6 / i6;
                                int i7 = (int) (j6 % i6);
                                if (channelSegment3.id != j7) {
                                    ChannelSegment findSegmentSend = findSegmentSend(j7, channelSegment3);
                                    if (findSegmentSend != null) {
                                        channelSegment2 = findSegmentSend;
                                    } else if (isClosedForSend0) {
                                        break;
                                    }
                                } else {
                                    channelSegment2 = channelSegment3;
                                }
                                ChannelSegment channelSegment4 = channelSegment2;
                                int updateCellSend2 = updateCellSend(channelSegment2, i7, e5, j6, orCreateCancellableContinuation, isClosedForSend0);
                                if (updateCellSend2 == 0) {
                                    channelSegment4.cleanPrev();
                                    Result.Companion companion2 = Result.INSTANCE;
                                    m3567constructorimpl = Result.m3567constructorimpl(Unit.INSTANCE);
                                    break;
                                }
                                if (updateCellSend2 == 1) {
                                    Result.Companion companion3 = Result.INSTANCE;
                                    m3567constructorimpl = Result.m3567constructorimpl(Unit.INSTANCE);
                                    break;
                                }
                                if (updateCellSend2 != 2) {
                                    if (updateCellSend2 == 3) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    if (updateCellSend2 != 4) {
                                        if (updateCellSend2 == 5) {
                                            channelSegment4.cleanPrev();
                                        }
                                        channelSegment3 = channelSegment4;
                                    } else if (j6 < getReceiversCounter$kotlinx_coroutines_core()) {
                                        channelSegment4.cleanPrev();
                                    }
                                } else if (isClosedForSend0) {
                                    channelSegment4.onSlotCleaned();
                                } else {
                                    CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                                    if (cancellableContinuationImpl != null) {
                                        prepareSenderForSuspension(cancellableContinuationImpl, channelSegment4, i7);
                                    }
                                }
                            }
                        } else if (j5 < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        onClosedSendOnNoWaiterSuspend(e5, orCreateCancellableContinuation);
                    } else {
                        prepareSenderForSuspension(orCreateCancellableContinuation, channelSegment, i5);
                    }
                    result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result != IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                Result.Companion companion4 = Result.INSTANCE;
                m3567constructorimpl = Result.m3567constructorimpl(Unit.INSTANCE);
            }
            orCreateCancellableContinuation.resumeWith(m3567constructorimpl);
            result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e5) {
        boolean tryResume0;
        boolean tryResume02;
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e5);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = receiveCatching.cont;
            ChannelResult m3768boximpl = ChannelResult.m3768boximpl(ChannelResult.INSTANCE.m3780successJP2dKIU(e5));
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            tryResume02 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, m3768boximpl, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, e5, receiveCatching.cont.getContext()) : null);
            return tryResume02;
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e5);
        }
        if (!(obj instanceof CancellableContinuation)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Function1<E, Unit> function12 = this.onUndeliveredElement;
        tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuation, e5, function12 != null ? OnUndeliveredElementKt.bindCancellationFun(function12, e5, cancellableContinuation.getContext()) : null);
        return tryResume0;
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i5) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        }
        if (!(obj instanceof SelectInstance)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
        if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i5);
        }
        return trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b5) {
        Symbol symbol;
        Symbol symbol2;
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if ((state$kotlinx_coroutines_core instanceof Waiter) && b5 >= receivers$FU.get(this)) {
            symbol = BufferedChannelKt.RESUMING_BY_EB;
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                    return true;
                }
                symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                segment.setState$kotlinx_coroutines_core(index, symbol2);
                segment.onCancelledRequest(index, false);
                return false;
            }
        }
        return updateCellExpandBufferSlow(segment, index, b5);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b5) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                if (state$kotlinx_coroutines_core != symbol3) {
                    if (state$kotlinx_coroutines_core != null) {
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                            symbol5 = BufferedChannelKt.POISONED;
                            if (state$kotlinx_coroutines_core == symbol5) {
                                break;
                            }
                            symbol6 = BufferedChannelKt.DONE_RCV;
                            if (state$kotlinx_coroutines_core == symbol6) {
                                break;
                            }
                            symbol7 = BufferedChannelKt.INTERRUPTED_RCV;
                            if (state$kotlinx_coroutines_core == symbol7 || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                                return true;
                            }
                            symbol8 = BufferedChannelKt.RESUMING_BY_RCV;
                            if (state$kotlinx_coroutines_core != symbol8) {
                                throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                            }
                        } else {
                            return true;
                        }
                    } else {
                        symbol4 = BufferedChannelKt.IN_BUFFER;
                        if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol4)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } else if (b5 >= receivers$FU.get(this)) {
                symbol = BufferedChannelKt.RESUMING_BY_EB;
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                    segment.setState$kotlinx_coroutines_core(index, symbol2);
                    segment.onCancelledRequest(index, false);
                    return false;
                }
            } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> segment, int index, long r5, Object waiter) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r5 >= (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    return symbol3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.SUSPEND;
                    return symbol2;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
            symbol = BufferedChannelKt.DONE_RCV;
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                expandBuffer();
                return segment.retrieveElement$kotlinx_coroutines_core(index);
            }
        }
        return updateCellReceiveSlow(segment, index, r5, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r5, Object waiter) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        Symbol symbol9;
        Symbol symbol10;
        Symbol symbol11;
        Symbol symbol12;
        Symbol symbol13;
        Symbol symbol14;
        Symbol symbol15;
        Symbol symbol16;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol5 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol5) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        symbol6 = BufferedChannelKt.DONE_RCV;
                        if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol6)) {
                            expandBuffer();
                            return segment.retrieveElement$kotlinx_coroutines_core(index);
                        }
                    } else {
                        symbol7 = BufferedChannelKt.INTERRUPTED_SEND;
                        if (state$kotlinx_coroutines_core == symbol7) {
                            symbol8 = BufferedChannelKt.FAILED;
                            return symbol8;
                        }
                        symbol9 = BufferedChannelKt.POISONED;
                        if (state$kotlinx_coroutines_core == symbol9) {
                            symbol10 = BufferedChannelKt.FAILED;
                            return symbol10;
                        }
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            expandBuffer();
                            symbol11 = BufferedChannelKt.FAILED;
                            return symbol11;
                        }
                        symbol12 = BufferedChannelKt.RESUMING_BY_EB;
                        if (state$kotlinx_coroutines_core != symbol12) {
                            symbol13 = BufferedChannelKt.RESUMING_BY_RCV;
                            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol13)) {
                                boolean z5 = state$kotlinx_coroutines_core instanceof WaiterEB;
                                if (z5) {
                                    state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                                }
                                if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                                    symbol16 = BufferedChannelKt.DONE_RCV;
                                    segment.setState$kotlinx_coroutines_core(index, symbol16);
                                    expandBuffer();
                                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                                }
                                symbol14 = BufferedChannelKt.INTERRUPTED_SEND;
                                segment.setState$kotlinx_coroutines_core(index, symbol14);
                                segment.onCancelledRequest(index, false);
                                if (z5) {
                                    expandBuffer();
                                }
                                symbol15 = BufferedChannelKt.FAILED;
                                return symbol15;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (r5 < (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                symbol = BufferedChannelKt.POISONED;
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.FAILED;
                    return symbol2;
                }
            } else {
                if (waiter == null) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    return symbol3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    symbol4 = BufferedChannelKt.SUSPEND;
                    return symbol4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s5, Object waiter, boolean closed) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s5, waiter, closed);
        }
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s5)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                symbol3 = BufferedChannelKt.DONE_RCV;
                segment.setState$kotlinx_coroutines_core(index, symbol3);
                onReceiveDequeued();
                return 0;
            }
            symbol = BufferedChannelKt.INTERRUPTED_RCV;
            Object andSetState$kotlinx_coroutines_core = segment.getAndSetState$kotlinx_coroutines_core(index, symbol);
            symbol2 = BufferedChannelKt.INTERRUPTED_RCV;
            if (andSetState$kotlinx_coroutines_core != symbol2) {
                segment.onCancelledRequest(index, true);
            }
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s5, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s5, Object waiter, boolean closed) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    symbol3 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core == symbol3) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    symbol4 = BufferedChannelKt.POISONED;
                    if (state$kotlinx_coroutines_core == symbol4) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        completeCloseOrCancel();
                        return 4;
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                        symbol7 = BufferedChannelKt.DONE_RCV;
                        segment.setState$kotlinx_coroutines_core(index, symbol7);
                        onReceiveDequeued();
                        return 0;
                    }
                    symbol5 = BufferedChannelKt.INTERRUPTED_RCV;
                    Object andSetState$kotlinx_coroutines_core = segment.getAndSetState$kotlinx_coroutines_core(index, symbol5);
                    symbol6 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (andSetState$kotlinx_coroutines_core != symbol6) {
                        segment.onCancelledRequest(index, true);
                    }
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (!bufferOrRendezvousSend(s5) || closed) {
                if (closed) {
                    symbol = BufferedChannelKt.INTERRUPTED_SEND;
                    if (segment.casState$kotlinx_coroutines_core(index, null, symbol)) {
                        segment.onCancelledRequest(index, false);
                        return 4;
                    }
                } else {
                    if (waiter == null) {
                        return 3;
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                        return 2;
                    }
                }
            } else if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                return 1;
            }
        }
    }

    private final void updateReceiversCounterIfLower(long value) {
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (j5 >= value) {
                return;
            }
        } while (!receivers$FU.compareAndSet(this, j5, value));
    }

    private final void updateSendersCounterIfLower(long value) {
        long j5;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            long j6 = 1152921504606846975L & j5;
            if (j6 >= value) {
                return;
            } else {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j6, (int) (j5 >> 60));
            }
        } while (!sendersAndCloseStatus$FU.compareAndSet(this, j5, constructSendersAndCloseStatus));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    protected boolean closeOrCancelImpl(Throwable cause, boolean cancel) {
        Symbol symbol;
        if (cancel) {
            markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$FU;
        symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        boolean a5 = a.a(atomicReferenceFieldUpdater, this, symbol, cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (a5) {
            invokeCloseHandler();
        }
        return a5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        Symbol symbol;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            long j5 = atomicLongFieldUpdater.get(this);
            if (globalCellIndex < Math.max(this.capacity + j5, getBufferEndCounter())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j5, j5 + 1)) {
                int i5 = BufferedChannelKt.SEGMENT_SIZE;
                long j6 = j5 / i5;
                int i6 = (int) (j5 % i5);
                if (channelSegment.id != j6) {
                    ChannelSegment<E> findSegmentReceive = findSegmentReceive(j6, channelSegment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                }
                Object updateCellReceive = updateCellReceive(channelSegment, i6, j5, null);
                symbol = BufferedChannelKt.FAILED;
                if (updateCellReceive != symbol) {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, null, 2, null)) != null) {
                        throw callUndeliveredElementCatchingException$default;
                    }
                } else if (j5 < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            }
        }
    }

    protected final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException("Channel was closed") : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
            ChannelSegment<E> channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = receiversCounter$kotlinx_coroutines_core / i5;
            if (channelSegment.id == j5 || (channelSegment = findSegmentReceive(j5, channelSegment)) != null) {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % i5), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            } else if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j5) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol symbol3;
        Symbol symbol4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$FU;
        if (a.a(atomicReferenceFieldUpdater2, this, null, handler)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            if (obj != symbol) {
                symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                if (obj == symbol2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = closeHandler$FU;
            symbol3 = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            symbol4 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
        } while (!a.a(atomicReferenceFieldUpdater, this, symbol3, symbol4));
        handler.invoke(getCloseCause());
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo3765receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m3763receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e5, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e5, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d4, code lost:
    
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01db, code lost:
    
        if (r3 != null) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        Symbol symbol;
        Symbol symbol2;
        boolean areEqual;
        Symbol symbol3;
        boolean areEqual2;
        Symbol symbol4;
        boolean areEqual3;
        Symbol symbol5;
        boolean areEqual4;
        Symbol symbol6;
        boolean areEqual5;
        Symbol symbol7;
        boolean areEqual6;
        String obj;
        ChannelSegment channelSegment;
        StringBuilder sb = new StringBuilder();
        int i5 = (int) (sendersAndCloseStatus$FU.get(this) >> 60);
        if (i5 == 2) {
            sb.append("closed,");
        } else if (i5 == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        int i6 = 0;
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            ChannelSegment channelSegment2 = (ChannelSegment) obj2;
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            if (channelSegment2 != channelSegment) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j5 = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j6 = ((ChannelSegment) next2).id;
                if (j5 > j6) {
                    next = next2;
                    j5 = j6;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment3 = (ChannelSegment) next;
        long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i7 = BufferedChannelKt.SEGMENT_SIZE;
            int i8 = i6;
            while (true) {
                if (i8 >= i7) {
                    break;
                }
                long j7 = (channelSegment3.id * BufferedChannelKt.SEGMENT_SIZE) + i8;
                if (j7 >= sendersCounter$kotlinx_coroutines_core && j7 >= receiversCounter$kotlinx_coroutines_core) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment3.getState$kotlinx_coroutines_core(i8);
                Object element$kotlinx_coroutines_core = channelSegment3.getElement$kotlinx_coroutines_core(i8);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    obj = (j7 >= receiversCounter$kotlinx_coroutines_core || j7 < sendersCounter$kotlinx_coroutines_core) ? (j7 >= sendersCounter$kotlinx_coroutines_core || j7 < receiversCounter$kotlinx_coroutines_core) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                    obj = (j7 >= receiversCounter$kotlinx_coroutines_core || j7 < sendersCounter$kotlinx_coroutines_core) ? (j7 >= sendersCounter$kotlinx_coroutines_core || j7 < receiversCounter$kotlinx_coroutines_core) ? "select" : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    obj = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    obj = "EB(" + state$kotlinx_coroutines_core + ')';
                } else {
                    symbol = BufferedChannelKt.RESUMING_BY_RCV;
                    if (Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol)) {
                        areEqual = true;
                    } else {
                        symbol2 = BufferedChannelKt.RESUMING_BY_EB;
                        areEqual = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol2);
                    }
                    if (areEqual) {
                        obj = "resuming_sender";
                    } else {
                        if (state$kotlinx_coroutines_core == null) {
                            areEqual2 = true;
                        } else {
                            symbol3 = BufferedChannelKt.IN_BUFFER;
                            areEqual2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol3);
                        }
                        if (areEqual2) {
                            areEqual3 = true;
                        } else {
                            symbol4 = BufferedChannelKt.DONE_RCV;
                            areEqual3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol4);
                        }
                        if (areEqual3) {
                            areEqual4 = true;
                        } else {
                            symbol5 = BufferedChannelKt.POISONED;
                            areEqual4 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol5);
                        }
                        if (areEqual4) {
                            areEqual5 = true;
                        } else {
                            symbol6 = BufferedChannelKt.INTERRUPTED_RCV;
                            areEqual5 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol6);
                        }
                        if (areEqual5) {
                            areEqual6 = true;
                        } else {
                            symbol7 = BufferedChannelKt.INTERRUPTED_SEND;
                            areEqual6 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol7);
                        }
                        if (areEqual6 ? true : Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            i8++;
                        } else {
                            obj = state$kotlinx_coroutines_core.toString();
                        }
                    }
                }
                if (element$kotlinx_coroutines_core != null) {
                    sb.append('(' + obj + ',' + element$kotlinx_coroutines_core + "),");
                } else {
                    sb.append(obj + ',');
                }
                i8++;
            }
            i6 = 0;
        }
        if (StringsKt.last(sb) == ',') {
            Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "this.deleteCharAt(index)");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo3766tryReceivePtdJZtk() {
        Object obj;
        ChannelSegment channelSegment;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        long j5 = receivers$FU.get(this);
        long j6 = sendersAndCloseStatus$FU.get(this);
        if (isClosedForReceive0(j6)) {
            return ChannelResult.INSTANCE.m3778closedJP2dKIU(getCloseCause());
        }
        if (j5 >= (j6 & 1152921504606846975L)) {
            return ChannelResult.INSTANCE.m3779failurePtdJZtk();
        }
        obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j7 = andIncrement / i5;
            int i6 = (int) (andIncrement % i5);
            if (channelSegment2.id != j7) {
                ChannelSegment findSegmentReceive = findSegmentReceive(j7, channelSegment2);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object updateCellReceive = updateCellReceive(channelSegment, i6, andIncrement, obj);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive == symbol) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i6);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.INSTANCE.m3779failurePtdJZtk();
            }
            symbol2 = BufferedChannelKt.FAILED;
            if (updateCellReceive != symbol2) {
                symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                if (updateCellReceive == symbol3) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                return ChannelResult.INSTANCE.m3780successJP2dKIU(updateCellReceive);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
        return ChannelResult.INSTANCE.m3778closedJP2dKIU(getCloseCause());
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m3780successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3767trySendJP2dKIU(E element) {
        Object obj;
        ChannelSegment channelSegment;
        if (shouldSendSuspend(sendersAndCloseStatus$FU.get(this))) {
            return ChannelResult.INSTANCE.m3779failurePtdJZtk();
        }
        obj = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(this);
            long j5 = andIncrement & 1152921504606846975L;
            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
            int i5 = BufferedChannelKt.SEGMENT_SIZE;
            long j6 = j5 / i5;
            int i6 = (int) (j5 % i5);
            if (channelSegment2.id != j6) {
                ChannelSegment findSegmentSend = findSegmentSend(j6, channelSegment2);
                if (findSegmentSend != null) {
                    channelSegment = findSegmentSend;
                } else if (isClosedForSend0) {
                    break;
                }
            } else {
                channelSegment = channelSegment2;
            }
            int updateCellSend = updateCellSend(channelSegment, i6, element, j5, obj, isClosedForSend0);
            if (updateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (updateCellSend == 1) {
                break;
            }
            if (updateCellSend != 2) {
                if (updateCellSend == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (updateCellSend != 4) {
                    if (updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else if (j5 < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (!isClosedForSend0) {
                    Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment, i6);
                    }
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m3779failurePtdJZtk();
                }
                channelSegment.onSlotCleaned();
            }
        }
        return ChannelResult.INSTANCE.m3778closedJP2dKIU(getSendException());
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        int i5;
        long j5;
        long constructEBCompletedAndPauseFlag;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long constructEBCompletedAndPauseFlag2;
        long j6;
        long constructEBCompletedAndPauseFlag3;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        do {
        } while (getBufferEndCounter() <= globalIndex);
        i5 = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i6 = 0; i6 < i5; i6++) {
            long bufferEndCounter = getBufferEndCounter();
            if (bufferEndCounter == (4611686018427387903L & completedExpandBuffersAndPauseFlag$FU.get(this)) && bufferEndCounter == getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$FU;
        do {
            j5 = atomicLongFieldUpdater2.get(this);
            constructEBCompletedAndPauseFlag = BufferedChannelKt.constructEBCompletedAndPauseFlag(j5 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j5, constructEBCompletedAndPauseFlag));
        while (true) {
            long bufferEndCounter2 = getBufferEndCounter();
            atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
            long j7 = atomicLongFieldUpdater.get(this);
            long j8 = j7 & 4611686018427387903L;
            boolean z5 = (4611686018427387904L & j7) != 0;
            if (bufferEndCounter2 == j8 && bufferEndCounter2 == getBufferEndCounter()) {
                break;
            } else if (!z5) {
                constructEBCompletedAndPauseFlag2 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j8, true);
                atomicLongFieldUpdater.compareAndSet(this, j7, constructEBCompletedAndPauseFlag2);
            }
        }
        do {
            j6 = atomicLongFieldUpdater.get(this);
            constructEBCompletedAndPauseFlag3 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j6 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, constructEBCompletedAndPauseFlag3));
    }
}
