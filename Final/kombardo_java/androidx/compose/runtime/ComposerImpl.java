package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.GroupKind;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\u009b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0004ç\u0002è\u0002BI\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u0019\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010\u0014J\u0019\u0010!\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\b'\u0010*J\u001f\u0010-\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020&H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020&H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0012H\u0002¢\u0006\u0004\b2\u0010\u0014J\u000f\u00103\u001a\u00020\u0012H\u0002¢\u0006\u0004\b3\u0010\u0014J\u000f\u00104\u001a\u00020\u0012H\u0002¢\u0006\u0004\b4\u0010\u0014J!\u00108\u001a\u00020\u00122\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b8\u00109J6\u0010?\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010\u001b2\u0006\u0010<\u001a\u00020;2\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J!\u0010B\u001a\u00020\u00122\u0006\u00106\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0004\bB\u0010CJ\u001f\u0010F\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u000205H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00122\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0012H\u0002¢\u0006\u0004\bJ\u0010\u0014J\u0017\u0010L\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u0017H\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017H\u0002¢\u0006\u0004\bO\u0010PJ/\u0010T\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u0017H\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\bV\u0010MJ\u0017\u0010W\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\bW\u0010MJ\u001f\u0010Y\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u0017H\u0002¢\u0006\u0004\bY\u0010PJ\u000f\u0010Z\u001a\u00020\u0012H\u0002¢\u0006\u0004\bZ\u0010\u0014J'\u0010^\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010a\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u0017H\u0002¢\u0006\u0004\ba\u0010PJ/\u0010d\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u0017H\u0002¢\u0006\u0004\bd\u0010UJ\u001b\u0010f\u001a\u00020\u0017*\u00020e2\u0006\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0012H\u0002¢\u0006\u0004\bh\u0010\u0014J\u000f\u0010i\u001a\u00020\u0012H\u0002¢\u0006\u0004\bi\u0010\u0014J9\u0010o\u001a\u00020\u00122\u000e\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0j2\u0006\u0010l\u001a\u00020&2\b\u0010m\u001a\u0004\u0018\u00010\u001b2\u0006\u0010n\u001a\u000205H\u0002¢\u0006\u0004\bo\u0010pJ+\u0010u\u001a\u00020\u00122\u001a\u0010t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020s\u0012\u0006\u0012\u0004\u0018\u00010s0r0qH\u0002¢\u0006\u0004\bu\u0010vJe\u0010~\u001a\u00028\u0000\"\u0004\b\u0000\u0010w2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00172\u001c\b\u0002\u0010{\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020z\u0012\u0006\u0012\u0004\u0018\u00010\u001b0r0q2\f\u0010}\u001a\b\u0012\u0004\u0012\u00028\u00000|H\u0002¢\u0006\u0004\b~\u0010\u007fJ8\u0010\u0082\u0001\u001a\u00020\u00122\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u001b0\u0080\u00012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010|H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J \u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001b*\u00020e2\u0006\u0010K\u001a\u00020\u0017H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0014J\u0011\u0010\u0087\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0014J\u001b\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020#H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0014J\u001a\u0010\u008d\u0001\u001a\u00020\u00122\u0007\u0010\u008c\u0001\u001a\u00020\u0017H\u0002¢\u0006\u0005\b\u008d\u0001\u0010\u001aJ\u0011\u0010\u008e\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008e\u0001\u0010\u0014J\u0011\u0010\u008f\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008f\u0001\u0010\u0014J\u0011\u0010\u0090\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0014J\u0019\u0010\u0091\u0001\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0005\b\u0091\u0001\u0010\u001aJ\u0011\u0010\u0092\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b\u0092\u0001\u0010\u0014J\u0019\u0010\u0093\u0001\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0005\b\u0093\u0001\u0010\u001aJ\u0011\u0010\u0094\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b\u0094\u0001\u0010\u0014J\u0011\u0010\u0095\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b\u0095\u0001\u0010\u0014J\u0011\u0010\u0096\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b\u0096\u0001\u0010\u0014J#\u0010\u0097\u0001\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0017¢\u0006\u0005\b\u0097\u0001\u0010\u001dJ\u0011\u0010\u0098\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b\u0098\u0001\u0010\u0014J\u0011\u0010\u009a\u0001\u001a\u00020\u0012H\u0000¢\u0006\u0005\b\u0099\u0001\u0010\u0014J\u0011\u0010\u009b\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u009b\u0001\u0010\u0014J\u0011\u0010\u009d\u0001\u001a\u00020\u0012H\u0000¢\u0006\u0005\b\u009c\u0001\u0010\u0014J\u0011\u0010\u009f\u0001\u001a\u00020\u0012H\u0000¢\u0006\u0005\b\u009e\u0001\u0010\u0014J\u0011\u0010 \u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b \u0001\u0010\u0014J\u0011\u0010¡\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b¡\u0001\u0010\u0014J(\u0010¤\u0001\u001a\u00020\u0012\"\u0005\b\u0000\u0010¢\u00012\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000|H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b¦\u0001\u0010\u0014J\u0011\u0010§\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b§\u0001\u0010\u0014J#\u0010¨\u0001\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0005\b¨\u0001\u0010\u001dJ\u0011\u0010©\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b©\u0001\u0010\u0014J\u000f\u0010ª\u0001\u001a\u00020\u0012¢\u0006\u0005\bª\u0001\u0010\u0014J\u000f\u0010«\u0001\u001a\u00020\u0012¢\u0006\u0005\b«\u0001\u0010\u0014J\u001a\u0010\u00ad\u0001\u001a\u00020\u00122\u0007\u0010¬\u0001\u001a\u00020\u0017H\u0016¢\u0006\u0005\b\u00ad\u0001\u0010\u001aJC\u0010°\u0001\u001a\u00020\u0012\"\u0005\b\u0000\u0010®\u0001\"\u0005\b\u0001\u0010¢\u00012\u0006\u0010 \u001a\u00028\u00002\u0019\u0010}\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120¯\u0001H\u0016¢\u0006\u0006\b°\u0001\u0010±\u0001J\u0014\u0010²\u0001\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0014\u0010´\u0001\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0006\b´\u0001\u0010³\u0001J\u001c\u0010µ\u0001\u001a\u0002052\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0017¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001c\u0010·\u0001\u001a\u0002052\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0017¢\u0006\u0006\b·\u0001\u0010¶\u0001J\u001a\u0010µ\u0001\u001a\u0002052\u0006\u0010 \u001a\u000205H\u0017¢\u0006\u0006\bµ\u0001\u0010¸\u0001J\u001b\u0010µ\u0001\u001a\u0002052\u0007\u0010 \u001a\u00030¹\u0001H\u0017¢\u0006\u0006\bµ\u0001\u0010º\u0001J\u001b\u0010µ\u0001\u001a\u0002052\u0007\u0010 \u001a\u00030»\u0001H\u0017¢\u0006\u0006\bµ\u0001\u0010¼\u0001J\u001b\u0010µ\u0001\u001a\u0002052\u0007\u0010 \u001a\u00030½\u0001H\u0017¢\u0006\u0006\bµ\u0001\u0010¾\u0001J\u001a\u0010µ\u0001\u001a\u0002052\u0006\u0010 \u001a\u00020\u0017H\u0017¢\u0006\u0006\bµ\u0001\u0010¿\u0001J\u001b\u0010À\u0001\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0005\bÀ\u0001\u0010\"J\u001b\u0010Á\u0001\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0005\bÁ\u0001\u0010\"J!\u0010Ã\u0001\u001a\u00020\u00122\r\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120|H\u0016¢\u0006\u0006\bÃ\u0001\u0010¥\u0001J\u001f\u0010Å\u0001\u001a\u00020\u00122\u000b\u0010 \u001a\u0007\u0012\u0002\b\u00030Ä\u0001H\u0017¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0011\u0010Ç\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\bÇ\u0001\u0010\u0014J)\u0010Ê\u0001\u001a\u00020\u00122\u0015\u0010É\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030Ä\u00010È\u0001H\u0017¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u0011\u0010Ì\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\bÌ\u0001\u0010\u0014J(\u0010Î\u0001\u001a\u00028\u0000\"\u0005\b\u0000\u0010¢\u00012\r\u0010\u0018\u001a\t\u0012\u0004\u0012\u00028\u00000Í\u0001H\u0017¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0012\u0010Ð\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J&\u0010Ö\u0001\u001a\u0002052\u0007\u0010Ò\u0001\u001a\u00020z2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0011\u0010×\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\b×\u0001\u0010\u0014J\u0011\u0010Ø\u0001\u001a\u00020\u0012H\u0017¢\u0006\u0005\bØ\u0001\u0010\u0014J\u001a\u0010Ù\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u000205H\u0017¢\u0006\u0005\bÙ\u0001\u0010IJ\u001a\u0010Ú\u0001\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u0015\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0017¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J-\u0010ß\u0001\u001a\u00020\u00122\u001a\u0010t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020s\u0012\u0006\u0012\u0004\u0018\u00010s0r0qH\u0017¢\u0006\u0005\bß\u0001\u0010vJ6\u0010á\u0001\u001a\u00020\u00122\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u001b0\u0080\u00012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00120|H\u0000¢\u0006\u0006\bà\u0001\u0010\u0083\u0001J \u0010ã\u0001\u001a\u00020\u00122\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00120|H\u0000¢\u0006\u0006\bâ\u0001\u0010¥\u0001J(\u0010æ\u0001\u001a\u0002052\u0014\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u001b0\u0080\u0001H\u0000¢\u0006\u0006\bä\u0001\u0010å\u0001J\u0014\u0010ç\u0001\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0006\bç\u0001\u0010³\u0001J\u001b\u0010è\u0001\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0005\bè\u0001\u0010\"J\u001c\u0010ê\u0001\u001a\u00020\u00122\b\u0010Ò\u0001\u001a\u00030é\u0001H\u0016¢\u0006\u0006\bê\u0001\u0010ë\u0001R!\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010ï\u0001R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010ð\u0001R\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\n\u0010ñ\u0001R\u0017\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\f\u0010ò\u0001R\u0017\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010ò\u0001R\u001d\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u000f\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001R \u0010÷\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010@0ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001b\u0010ù\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0019\u0010û\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010ý\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010ü\u0001R\u0017\u0010b\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bb\u0010ü\u0001R\u0018\u0010ÿ\u0001\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u001c\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0081\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0019\u0010\u0087\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0019\u0010\u0089\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u0088\u0002R\u0019\u0010\u008a\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u0088\u0002R\u001d\u0010{\u001a\n\u0012\u0005\u0012\u00030\u008c\u00020\u008b\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b{\u0010\u008d\u0002R\u0018\u0010\u008e\u0002\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u0080\u0002R\u0019\u0010\u008f\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\"\u0010\u0092\u0002\u001a\u000b\u0012\u0004\u0012\u00020&\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u0019\u0010\u0094\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0088\u0002R\u0018\u0010\u0095\u0002\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0080\u0002R\u0019\u0010\u0096\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0088\u0002R\u0019\u0010\u0097\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0002\u0010ü\u0001R\u0019\u0010\u0098\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010ü\u0001R\u0019\u0010\u0099\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010ü\u0001R\u0019\u0010\u009a\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u0088\u0002R\u0018\u0010\u009c\u0002\u001a\u00030\u009b\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001e\u0010\u009e\u0002\u001a\t\u0012\u0004\u0012\u00020z0ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0002\u0010ø\u0001R*\u0010 \u0002\u001a\u0002052\u0007\u0010\u009f\u0002\u001a\u0002058\u0000@BX\u0080\u000e¢\u0006\u0010\n\u0006\b \u0002\u0010\u0088\u0002\u001a\u0006\b¡\u0002\u0010¢\u0002R*\u0010£\u0002\u001a\u0002052\u0007\u0010\u009f\u0002\u001a\u0002058\u0000@BX\u0080\u000e¢\u0006\u0010\n\u0006\b£\u0002\u0010\u0088\u0002\u001a\u0006\b¤\u0002\u0010¢\u0002R)\u0010¥\u0002\u001a\u00020e8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¥\u0002\u0010¦\u0002\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0006\b©\u0002\u0010ª\u0002R)\u0010«\u0002\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b«\u0002\u0010ð\u0001\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010¯\u0002R\u001a\u0010±\u0002\u001a\u00030°\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010²\u0002R\u0019\u0010³\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010\u0088\u0002R\u001b\u0010´\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010\u0090\u0002R+\u0010µ\u0002\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bµ\u0002\u0010ò\u0001\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R\u0018\u0010»\u0002\u001a\u00030º\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R\u0019\u0010½\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001a\u0010À\u0002\u001a\u00030¿\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R/\u0010E\u001a\u0002052\u0007\u0010\u009f\u0002\u001a\u0002058\u0016@RX\u0097\u000e¢\u0006\u0016\n\u0005\bE\u0010\u0088\u0002\u0012\u0005\bÃ\u0002\u0010\u0014\u001a\u0006\bÂ\u0002\u0010¢\u0002R1\u0010Ä\u0002\u001a\u00020\u00172\u0007\u0010\u009f\u0002\u001a\u00020\u00178\u0016@RX\u0097\u000e¢\u0006\u0017\n\u0006\bÄ\u0002\u0010ü\u0001\u0012\u0005\bÇ\u0002\u0010\u0014\u001a\u0006\bÅ\u0002\u0010Æ\u0002R\u001d\u0010Ê\u0002\u001a\u0004\u0018\u00010\u001b*\u00020e8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÈ\u0002\u0010É\u0002R\u0017\u0010Ì\u0002\u001a\u0002058@X\u0080\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010¢\u0002R\u0018\u0010Ð\u0002\u001a\u00030Í\u00028WX\u0096\u0004¢\u0006\b\u001a\u0006\bÎ\u0002\u0010Ï\u0002R\u001e\u0010Ó\u0002\u001a\u0002058VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÒ\u0002\u0010\u0014\u001a\u0006\bÑ\u0002\u0010¢\u0002R\u001e\u0010Ö\u0002\u001a\u0002058VX\u0097\u0004¢\u0006\u000f\u0012\u0005\bÕ\u0002\u0010\u0014\u001a\u0006\bÔ\u0002\u0010¢\u0002R\u0017\u0010Ø\u0002\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b×\u0002\u0010Æ\u0002R\u0018\u0010Ü\u0002\u001a\u00030Ù\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÚ\u0002\u0010Û\u0002R\u0018\u0010à\u0002\u001a\u00030Ý\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÞ\u0002\u0010ß\u0002R\u0019\u0010ã\u0002\u001a\u0004\u0018\u00010z8@X\u0080\u0004¢\u0006\b\u001a\u0006\bá\u0002\u0010â\u0002R\u001a\u0010æ\u0002\u001a\u0005\u0018\u00010é\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bä\u0002\u0010å\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006é\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "Landroidx/compose/runtime/SlotTable;", "slotTable", BuildConfig.FLAVOR, "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Landroidx/compose/runtime/changelist/ChangeList;", "changes", "lateChanges", "Landroidx/compose/runtime/ControlledComposition;", "composition", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/ControlledComposition;)V", BuildConfig.FLAVOR, "startRoot", "()V", "endRoot", "abortRoot", BuildConfig.FLAVOR, "key", "startGroup", "(I)V", BuildConfig.FLAVOR, "dataKey", "(ILjava/lang/Object;)V", "endGroup", "skipGroup", "value", "updateSlot", "(Ljava/lang/Object;)V", "Landroidx/compose/runtime/Anchor;", "rememberObserverAnchor", "()Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "currentCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "group", "(I)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "parentScope", "currentProviders", "updateProviderMapGroup", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providers", "recordProviderUpdate", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "ensureWriter", "createFreshInsertTable", "forceFreshInsertTable", BuildConfig.FLAVOR, "isNode", "data", "startReaderGroup", "(ZLjava/lang/Object;)V", "objectKey", "Landroidx/compose/runtime/GroupKind;", "kind", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "start", "Landroidx/compose/runtime/Pending;", "newPending", "enterGroup", "(ZLandroidx/compose/runtime/Pending;)V", "expectedNodeCount", "inserting", "exitGroup", "(IZ)V", "end", "(Z)V", "recomposeToGroupEnd", "index", "insertedGroupVirtualIndex", "(I)I", "newCount", "updateNodeCountOverrides", "(II)V", "groupLocation", "recomposeGroup", "recomposeIndex", "nodeIndexOf", "(IIII)I", "rGroupIndexOf", "updatedNodeCount", "count", "updateNodeCount", "clearUpdatedNodeCounts", "oldGroup", "newGroup", "commonRoot", "recordUpsAndDowns", "(III)V", "nearestCommonRoot", "doRecordDownsFor", "rGroupIndex", "recomposeKey", "compoundKeyOf", "Landroidx/compose/runtime/SlotReader;", "groupCompoundKeyPart", "(Landroidx/compose/runtime/SlotReader;I)I", "skipReaderToGroupEnd", "addRecomposeScope", "Landroidx/compose/runtime/MovableContent;", "content", "locals", "parameter", "force", "invokeMovableContentLambda", "(Landroidx/compose/runtime/MovableContent;Landroidx/compose/runtime/PersistentCompositionLocalMap;Ljava/lang/Object;Z)V", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContentGuarded", "(Ljava/util/List;)V", "R", "from", "to", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidations", "Lkotlin/Function0;", "block", "recomposeMovableContent", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/compose/runtime/collection/ScopeMap;", "invalidationsRequested", "doCompose", "(Landroidx/compose/runtime/collection/ScopeMap;Lkotlin/jvm/functions/Function2;)V", "nodeAt", "(Landroidx/compose/runtime/SlotReader;I)Ljava/lang/Object;", "validateNodeExpected", "validateNodeNotExpected", "anchor", "recordInsert", "(Landroidx/compose/runtime/Anchor;)V", "recordDelete", "groupBeingRemoved", "reportFreeMovableContent", "reportAllMovableContent", "finalizeCompose", "cleanUpCompose", "startReplaceableGroup", "endReplaceableGroup", "startReplaceGroup", "endReplaceGroup", "startDefaults", "endDefaults", "startMovableGroup", "endMovableGroup", "changesApplied$runtime_release", "changesApplied", "collectParameterInformation", "dispose$runtime_release", "dispose", "deactivate$runtime_release", "deactivate", "startNode", "startReusableNode", "T", "factory", "createNode", "(Lkotlin/jvm/functions/Function0;)V", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "startReuseFromRoot", "endReuseFromRoot", "marker", "endToMarker", "V", "Lkotlin/Function2;", "apply", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "nextSlot", "()Ljava/lang/Object;", "nextSlotForCache", "changed", "(Ljava/lang/Object;)Z", "changedInstance", "(Z)Z", BuildConfig.FLAVOR, "(F)Z", BuildConfig.FLAVOR, "(J)Z", BuildConfig.FLAVOR, "(D)Z", "(I)Z", "updateValue", "updateCachedValue", "effect", "recordSideEffect", "Landroidx/compose/runtime/ProvidedValue;", "startProvider", "(Landroidx/compose/runtime/ProvidedValue;)V", "endProvider", BuildConfig.FLAVOR, "values", "startProviders", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "Landroidx/compose/runtime/CompositionLocal;", "consume", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "buildContext", "()Landroidx/compose/runtime/CompositionContext;", "scope", "instance", "tryImminentInvalidation$runtime_release", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Z", "tryImminentInvalidation", "skipCurrentGroup", "skipToGroupEnd", "deactivateToEndGroup", "startRestartGroup", "(I)Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/ScopeUpdateScope;", "endRestartGroup", "()Landroidx/compose/runtime/ScopeUpdateScope;", "insertMovableContentReferences", "composeContent$runtime_release", "composeContent", "prepareCompose$runtime_release", "prepareCompose", "recompose$runtime_release", "(Landroidx/compose/runtime/collection/ScopeMap;)Z", "recompose", "rememberedValue", "updateRememberedValue", "Landroidx/compose/runtime/RecomposeScope;", "recordUsed", "(Landroidx/compose/runtime/RecomposeScope;)V", "Landroidx/compose/runtime/Applier;", "getApplier", "()Landroidx/compose/runtime/Applier;", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/SlotTable;", "Ljava/util/Set;", "Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/ControlledComposition;", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/Stack;", "pendingStack", "Landroidx/compose/runtime/Stack;", "pending", "Landroidx/compose/runtime/Pending;", "nodeIndex", "I", "groupNodeCount", "Landroidx/compose/runtime/IntStack;", "parentStateStack", "Landroidx/compose/runtime/IntStack;", BuildConfig.FLAVOR, "nodeCountOverrides", "[I", "Landroidx/collection/MutableIntIntMap;", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "forceRecomposeScopes", "Z", "forciblyRecompose", "nodeExpected", BuildConfig.FLAVOR, "Landroidx/compose/runtime/Invalidation;", "Ljava/util/List;", "entersStack", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/compose/runtime/collection/IntMap;", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "derivedStateObserver", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "invalidateStack", "<set-?>", "isComposing", "isComposing$runtime_release", "()Z", "isDisposed", "isDisposed$runtime_release", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime_release", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime_release", "(Landroidx/compose/runtime/SlotReader;)V", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "Landroidx/compose/runtime/SlotWriter;", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "providerCache", "deferredChanges", "getDeferredChanges$runtime_release", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime_release", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/changelist/FixupList;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "getInserting", "getInserting$annotations", "compoundKeyHash", "getCompoundKeyHash", "()I", "getCompoundKeyHash$annotations", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "node", "getAreChildrenComposing$runtime_release", "areChildrenComposing", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "applyCoroutineContext", "getDefaultsInvalid", "getDefaultsInvalid$annotations", "defaultsInvalid", "getSkipping", "getSkipping$annotations", "skipping", "getCurrentMarker", "currentMarker", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentCompositionLocalMap", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "currentRecomposeScope", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScope", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ComposerChangeListWriter changeListWriter;
    private ChangeList changes;
    private int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private ChangeList deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private Anchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private ChangeList lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionContext parentContext;
    private Pending pending;
    private PersistentCompositionLocalMap providerCache;
    private IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private final Stack<Pending> pendingStack = new Stack<>();
    private final IntStack parentStateStack = new IntStack();
    private final List<Invalidation> invalidations = new ArrayList();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", BuildConfig.FLAVOR, "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CompositionContextHolder implements ReusableRememberObserver {
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010$\u001a\u00020!H\u0010¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b&\u0010'J\u001d\u0010-\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0010¢\u0006\u0004\b+\u0010,J\u000f\u0010/\u001a\u00020\u000bH\u0010¢\u0006\u0004\b.\u0010\rJ\u000f\u00101\u001a\u00020\u000bH\u0010¢\u0006\u0004\b0\u0010\rJ\u0017\u00106\u001a\u00020\u000b2\u0006\u00103\u001a\u000202H\u0010¢\u0006\u0004\b4\u00105J\u0019\u0010:\u001a\u0004\u0018\u0001072\u0006\u00103\u001a\u000202H\u0010¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b;\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\u0005\u001a\u00020\u00048\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0005\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010\u0006\u001a\u00020\u00048\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0006\u0010@\u001a\u0004\bC\u0010BR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\b\u0010D\u001a\u0004\bE\u0010FR0\u0010G\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010,R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020L0(8\u0006¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bN\u0010JR+\u0010S\u001a\u00020!2\u0006\u0010O\u001a\u00020!8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b$\u0010#\"\u0004\bR\u0010'R\u0014\u0010U\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bT\u0010BR\u0014\u0010Y\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", BuildConfig.FLAVOR, "compoundHashKey", BuildConfig.FLAVOR, "collectingParameterInformation", "collectingSourceInformation", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "<init>", "(Landroidx/compose/runtime/ComposerImpl;IZZLandroidx/compose/runtime/CompositionObserverHolder;)V", BuildConfig.FLAVOR, "dispose", "()V", "Landroidx/compose/runtime/Composer;", "composer", "registerComposer$runtime_release", "(Landroidx/compose/runtime/Composer;)V", "registerComposer", "unregisterComposer$runtime_release", "unregisterComposer", "Landroidx/compose/runtime/ControlledComposition;", "composition", "unregisterComposition$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;)V", "unregisterComposition", "Lkotlin/Function0;", "content", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitial", "invalidate$runtime_release", "invalidate", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope$runtime_release", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope", "scope", "updateCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", BuildConfig.FLAVOR, "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime_release", "(Ljava/util/Set;)V", "recordInspectionTable", "startComposing$runtime_release", "startComposing", "doneComposing$runtime_release", "doneComposing", "Landroidx/compose/runtime/MovableContentStateReference;", "reference", "insertMovableContent$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "reportRemovedComposition$runtime_release", "reportRemovedComposition", "I", "getCompoundHashKey$runtime_release", "()I", "Z", "getCollectingParameterInformation$runtime_release", "()Z", "getCollectingSourceInformation$runtime_release", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "Ljava/util/Set;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "Landroidx/compose/runtime/ComposerImpl;", "composers", "getComposers", "<set-?>", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "setCompositionLocalScope", "compositionLocalScope", "getCollectingCallByInformation$runtime_release", "collectingCallByInformation", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectCoroutineContext", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();

        /* renamed from: compositionLocalScope$delegate, reason: from kotlin metadata */
        private final MutableState compositionLocalScope = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;

        public CompositionContextImpl(int i5, boolean z5, boolean z6, CompositionObserverHolder compositionObserverHolder) {
            this.compoundHashKey = i5;
            this.collectingParameterInformation = z5;
            this.collectingSourceInformation = z6;
            this.observerHolder = compositionObserverHolder;
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, content);
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (ComposerImpl composerImpl : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(composerImpl.slotTable);
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime_release() {
            return ComposerImpl.this.parentContext.getCollectingCallByInformation$runtime_release();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCollectingParameterInformation$runtime_release, reason: from getter */
        public boolean getCollectingParameterInformation() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCollectingSourceInformation$runtime_release, reason: from getter */
        public boolean getCollectingSourceInformation() {
            return this.collectingSourceInformation;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCompoundHashKey$runtime_release, reason: from getter */
        public int getCompoundHashKey() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getObserverHolder$runtime_release, reason: from getter */
        public CompositionObserverHolder getObserverHolder() {
            return this.observerHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(ControlledComposition composition) {
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
            Set set = this.inspectionTables;
            if (set == null) {
                set = new HashSet();
                this.inspectionTables = set;
            }
            set.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Set set2 = (Set) it.next();
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(ControlledComposition composition) {
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap scope) {
            setCompositionLocalScope(scope);
        }
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier<?> applier, CompositionContext compositionContext, SlotTable slotTable, Set<RememberObserver> set, ChangeList changeList, ChangeList changeList2, ControlledComposition controlledComposition) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.composition = controlledComposition;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation() || compositionContext.getCollectingCallByInformation$runtime_release();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                ComposerImpl composerImpl = ComposerImpl.this;
                composerImpl.childrenComposing--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                ComposerImpl.this.childrenComposing++;
            }
        };
        this.invalidateStack = new Stack<>();
        SlotReader openReader = slotTable.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, this.changes);
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (this.writer.getClosed()) {
            return;
        }
        forceFreshInsertTable();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
    
        if (r0 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRecomposeScope() {
        Invalidation removeLocation;
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z5;
        if (getInserting()) {
            ControlledComposition composition = getComposition();
            Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) composition);
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        removeLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer.INSTANCE.getEmpty())) {
            ControlledComposition composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) composition2);
            updateValue(recomposeScopeImpl);
        } else {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        if (removeLocation == null) {
            boolean forcedRecompose = recomposeScopeImpl.getForcedRecompose();
            z5 = false;
            if (forcedRecompose) {
                recomposeScopeImpl.setForcedRecompose(false);
            }
        }
        z5 = true;
        recomposeScopeImpl.setRequiresRecompose(z5);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int group, int rGroupIndex, int recomposeGroup, int recomposeKey) {
        if (group == recomposeGroup) {
            return recomposeKey;
        }
        int groupCompoundKeyPart = groupCompoundKeyPart(this.reader, group);
        if (groupCompoundKeyPart == 126665345) {
            return groupCompoundKeyPart;
        }
        int parent = this.reader.parent(group);
        if (parent != recomposeGroup) {
            recomposeKey = compoundKeyOf(parent, rGroupIndexOf(parent), recomposeGroup, recomposeKey);
        }
        if (this.reader.hasObjectKey(group)) {
            rGroupIndex = 0;
        }
        return Integer.rotateLeft(Integer.rotateLeft(recomposeKey, 3) ^ groupCompoundKeyPart, 3) ^ rGroupIndex;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        forceFreshInsertTable();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    private final void doCompose(ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        Comparator comparator;
        long[] jArr;
        int i5;
        long[] jArr2;
        int i6;
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = SnapshotKt.currentSnapshot().getId();
            this.providerUpdates = null;
            MutableScatterMap<Object, Object> map = invalidationsRequested.getMap();
            Object[] objArr = map.keys;
            Object[] objArr2 = map.values;
            long[] jArr3 = map.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i7 = 0;
                while (true) {
                    long j5 = jArr3[i7];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i7 - length)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j5 & 255) < 128) {
                                int i11 = (i7 << 3) + i10;
                                Object obj = objArr[i11];
                                Object obj2 = objArr2[i11];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                                Anchor anchor = ((RecomposeScopeImpl) obj).getAnchor();
                                if (anchor != null) {
                                    int location = anchor.getLocation();
                                    List<Invalidation> list = this.invalidations;
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                    jArr2 = jArr3;
                                    if (obj2 == ScopeInvalidated.INSTANCE) {
                                        obj2 = null;
                                    }
                                    list.add(new Invalidation(recomposeScopeImpl, location, obj2));
                                } else {
                                    jArr2 = jArr3;
                                }
                                i6 = 8;
                            } else {
                                jArr2 = jArr3;
                                i6 = i8;
                            }
                            j5 >>= i6;
                            i10++;
                            i8 = i6;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        i5 = 1;
                        if (i9 != i8) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        i5 = 1;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i7 += i5;
                    jArr3 = jArr;
                }
            }
            List<Invalidation> list2 = this.invalidations;
            comparator = ComposerKt.InvalidationLocationAscending;
            CollectionsKt.sortWith(list2, comparator);
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object nextSlot = nextSlot();
                if (nextSlot != content && content != null) {
                    updateValue(content);
                }
                ComposerImpl$derivedStateObserver$1 composerImpl$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    derivedStateObservers.add(composerImpl$derivedStateObserver$1);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if ((!this.forciblyRecompose && !this.providersInvalid) || nextSlot == null || Intrinsics.areEqual(nextSlot, Composer.INSTANCE.getEmpty())) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextSlot, 2));
                        endGroup();
                    }
                    derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                    endRoot();
                    this.isComposing = false;
                    this.invalidations.clear();
                    createFreshInsertTable();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } finally {
                    derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                }
            } catch (Throwable th) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                createFreshInsertTable();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.INSTANCE.endSection(beginSection);
            throw th2;
        }
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group <= 0 || group == nearestCommonRoot) {
            return;
        }
        doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
        if (this.reader.isNode(group)) {
            this.changeListWriter.moveDown(nodeAt(this.reader, group));
        }
    }

    private final void end(boolean isNode) {
        int hashCode;
        Set set;
        List<KeyInfo> list;
        int hashCode2;
        int peek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int groupKey = this.writer.groupKey(parent);
            Object groupObjectKey = this.writer.groupObjectKey(parent);
            Object groupAux = this.writer.groupAux(parent);
            if (groupObjectKey != null) {
                hashCode2 = Integer.hashCode(groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (groupAux == null || groupKey != 207 || Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
                hashCode2 = Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupKey);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupAux.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(hashCode2, 3);
        } else {
            int parent2 = this.reader.getParent();
            int groupKey2 = this.reader.groupKey(parent2);
            Object groupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object groupAux2 = this.reader.groupAux(parent2);
            if (groupObjectKey2 != null) {
                hashCode = Integer.hashCode(groupObjectKey2 instanceof Enum ? ((Enum) groupObjectKey2).ordinal() : groupObjectKey2.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (groupAux2 == null || groupKey2 != 207 || Intrinsics.areEqual(groupAux2, Composer.INSTANCE.getEmpty())) {
                hashCode = Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupKey2);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupAux2.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(hashCode, 3);
        }
        int i5 = this.groupNodeCount;
        Pending pending = this.pending;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending.getKeyInfos();
            List<KeyInfo> used = pending.getUsed();
            Set fastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < size2) {
                KeyInfo keyInfo = keyInfos.get(i6);
                if (fastToSet.contains(keyInfo)) {
                    set = fastToSet;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i7 < size) {
                            KeyInfo keyInfo2 = used.get(i7);
                            if (keyInfo2 != keyInfo) {
                                int nodePositionOf = pending.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (nodePositionOf != i8) {
                                    int updatedNodeCountOf = pending.updatedNodeCountOf(keyInfo2);
                                    list = used;
                                    this.changeListWriter.moveNode(pending.getStartIndex() + nodePositionOf, i8 + pending.getStartIndex(), updatedNodeCountOf);
                                    pending.registerMoveNode(nodePositionOf, i8, updatedNodeCountOf);
                                } else {
                                    list = used;
                                }
                            } else {
                                list = used;
                                i6++;
                            }
                            i7++;
                            i8 += pending.updatedNodeCountOf(keyInfo2);
                            fastToSet = set;
                            used = list;
                        }
                        fastToSet = set;
                    }
                } else {
                    this.changeListWriter.removeNode(pending.nodePositionOf(keyInfo) + pending.getStartIndex(), keyInfo.getNodes());
                    pending.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    set = fastToSet;
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                }
                i6++;
                fastToSet = set;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i9 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int current = this.reader.getCurrent();
            recordDelete();
            this.changeListWriter.removeNode(i9, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, current, this.reader.getCurrent());
        }
        boolean inserting = getInserting();
        if (inserting) {
            if (isNode) {
                this.insertFixups.endNodeInsert();
                i5 = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i5);
                }
            }
        } else {
            if (isNode) {
                this.changeListWriter.moveUp();
            }
            int remainingSlots = this.reader.getRemainingSlots();
            if (remainingSlots > 0) {
                this.changeListWriter.trimValues(remainingSlots);
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i5 != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i5);
            }
            if (isNode) {
                i5 = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i5, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        boolean asBool;
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        asBool = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean isNode, Pending newPending) {
        this.pendingStack.push(this.pending);
        this.pending = newPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !inserting) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.parentStateStack.pop() + expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + expectedNodeCount;
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (this.sourceMarkersEnabled) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        SlotWriter openWriter = slotTable.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i5) {
        Object groupAux;
        if (slotReader.hasObjectKey(i5)) {
            Object groupObjectKey = slotReader.groupObjectKey(i5);
            if (groupObjectKey != null) {
                return groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode();
            }
            return 0;
        }
        int groupKey = slotReader.groupKey(i5);
        if (groupKey == 207 && (groupAux = slotReader.groupAux(i5)) != null && !Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
            groupKey = groupAux.hashCode();
        }
        return groupKey;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        List<? extends Object> collectNodesFrom;
        SlotReader slotReader;
        SlotReader reader;
        int[] iArr;
        IntMap intMap;
        ChangeList changeList3;
        ComposerChangeListWriter composerChangeListWriter3;
        int i5;
        int i6;
        SlotReader slotReader2;
        int i7 = 1;
        ComposerChangeListWriter composerChangeListWriter4 = this.changeListWriter;
        ChangeList changeList4 = this.lateChanges;
        ChangeList changeList5 = composerChangeListWriter4.getChangeList();
        try {
            composerChangeListWriter4.setChangeList(changeList4);
            this.changeListWriter.resetSlots();
            int size = references.size();
            int i8 = 0;
            int i9 = 0;
            while (i9 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = references.get(i9);
                    final MovableContentStateReference component1 = pair.component1();
                    MovableContentStateReference component2 = pair.component2();
                    Anchor anchor = component1.getAnchor();
                    int anchorIndex = component1.getSlotTable().anchorIndex(anchor);
                    IntRef intRef = new IntRef(i8, i7, null);
                    this.changeListWriter.determineMovableContentNodeIndex(intRef, anchor);
                    if (component2 == null) {
                        if (Intrinsics.areEqual(component1.getSlotTable(), this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader openReader = component1.getSlotTable().openReader();
                        try {
                            openReader.reposition(anchorIndex);
                            this.changeListWriter.moveReaderToAbsolute(anchorIndex);
                            final ChangeList changeList6 = new ChangeList();
                            slotReader2 = openReader;
                            try {
                                recomposeMovableContent$default(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1
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
                                        ComposerChangeListWriter composerChangeListWriter5;
                                        ComposerChangeListWriter composerChangeListWriter6;
                                        composerChangeListWriter5 = ComposerImpl.this.changeListWriter;
                                        ChangeList changeList7 = changeList6;
                                        ComposerImpl composerImpl = ComposerImpl.this;
                                        SlotReader slotReader3 = openReader;
                                        MovableContentStateReference movableContentStateReference = component1;
                                        ChangeList changeList8 = composerChangeListWriter5.getChangeList();
                                        try {
                                            composerChangeListWriter5.setChangeList(changeList7);
                                            SlotReader reader2 = composerImpl.getReader();
                                            int[] iArr2 = composerImpl.nodeCountOverrides;
                                            IntMap intMap2 = composerImpl.providerUpdates;
                                            composerImpl.nodeCountOverrides = null;
                                            composerImpl.providerUpdates = null;
                                            try {
                                                composerImpl.setReader$runtime_release(slotReader3);
                                                composerChangeListWriter6 = composerImpl.changeListWriter;
                                                boolean implicitRootStart = composerChangeListWriter6.getImplicitRootStart();
                                                try {
                                                    composerChangeListWriter6.setImplicitRootStart(false);
                                                    movableContentStateReference.getContent$runtime_release();
                                                    composerImpl.invokeMovableContentLambda(null, movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                                                    composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                    Unit unit = Unit.INSTANCE;
                                                } catch (Throwable th) {
                                                    composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                    throw th;
                                                }
                                            } finally {
                                                composerImpl.setReader$runtime_release(reader2);
                                                composerImpl.nodeCountOverrides = iArr2;
                                                composerImpl.providerUpdates = intMap2;
                                            }
                                        } finally {
                                            composerChangeListWriter5.setChangeList(changeList8);
                                        }
                                    }
                                }, 15, null);
                                this.changeListWriter.includeOperationsIn(changeList6, intRef);
                                Unit unit = Unit.INSTANCE;
                                slotReader2.close();
                                composerChangeListWriter2 = composerChangeListWriter4;
                                changeList2 = changeList5;
                                i5 = size;
                                i6 = i9;
                            } catch (Throwable th) {
                                th = th;
                                slotReader2.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            slotReader2 = openReader;
                        }
                    } else {
                        MovableContentState movableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(component2);
                        SlotTable slotTable = component2.getSlotTable();
                        Anchor anchor2 = component2.getAnchor();
                        collectNodesFrom = ComposerKt.collectNodesFrom(slotTable, anchor2);
                        if (!collectNodesFrom.isEmpty()) {
                            this.changeListWriter.copyNodesToNewAnchorLocation(collectNodesFrom, intRef);
                            if (Intrinsics.areEqual(component1.getSlotTable(), this.slotTable)) {
                                int anchorIndex2 = this.slotTable.anchorIndex(anchor);
                                updateNodeCount(anchorIndex2, updatedNodeCount(anchorIndex2) + collectNodesFrom.size());
                            }
                        }
                        this.changeListWriter.copySlotTableToAnchorLocation(movableContentStateResolve$runtime_release, this.parentContext, component2, component1);
                        SlotReader openReader2 = slotTable.openReader();
                        try {
                            reader = getReader();
                            int[] iArr2 = this.nodeCountOverrides;
                            IntMap intMap2 = this.providerUpdates;
                            this.nodeCountOverrides = null;
                            this.providerUpdates = null;
                            try {
                                setReader$runtime_release(openReader2);
                                int anchorIndex3 = slotTable.anchorIndex(anchor2);
                                openReader2.reposition(anchorIndex3);
                                this.changeListWriter.moveReaderToAbsolute(anchorIndex3);
                                ChangeList changeList7 = new ChangeList();
                                ComposerChangeListWriter composerChangeListWriter5 = this.changeListWriter;
                                ChangeList changeList8 = composerChangeListWriter5.getChangeList();
                                try {
                                    composerChangeListWriter5.setChangeList(changeList7);
                                    i5 = size;
                                    ComposerChangeListWriter composerChangeListWriter6 = this.changeListWriter;
                                    boolean implicitRootStart = composerChangeListWriter6.getImplicitRootStart();
                                    try {
                                        composerChangeListWriter6.setImplicitRootStart(false);
                                        ControlledComposition composition = component2.getComposition();
                                        ControlledComposition composition2 = component1.getComposition();
                                        Integer valueOf = Integer.valueOf(openReader2.getCurrent());
                                        composerChangeListWriter2 = composerChangeListWriter4;
                                        intMap = intMap2;
                                        changeList2 = changeList5;
                                        changeList3 = changeList8;
                                        i6 = i9;
                                        iArr = iArr2;
                                        slotReader = openReader2;
                                        composerChangeListWriter3 = composerChangeListWriter5;
                                        try {
                                            recomposeMovableContent(composition, composition2, valueOf, component2.getInvalidations$runtime_release(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1
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
                                                    ComposerImpl composerImpl = ComposerImpl.this;
                                                    component1.getContent$runtime_release();
                                                    composerImpl.invokeMovableContentLambda(null, component1.getLocals(), component1.getParameter(), true);
                                                }
                                            });
                                            try {
                                                composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                                try {
                                                    composerChangeListWriter3.setChangeList(changeList3);
                                                    this.changeListWriter.includeOperationsIn(changeList7, intRef);
                                                    Unit unit2 = Unit.INSTANCE;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    setReader$runtime_release(reader);
                                                    this.nodeCountOverrides = iArr;
                                                    this.providerUpdates = intMap;
                                                    throw th;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                composerChangeListWriter3.setChangeList(changeList3);
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            composerChangeListWriter6.setImplicitRootStart(implicitRootStart);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        iArr = iArr2;
                                        slotReader = openReader2;
                                        intMap = intMap2;
                                        composerChangeListWriter3 = composerChangeListWriter5;
                                        changeList3 = changeList8;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    iArr = iArr2;
                                    slotReader = openReader2;
                                    intMap = intMap2;
                                    changeList3 = changeList8;
                                    composerChangeListWriter3 = composerChangeListWriter5;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                iArr = iArr2;
                                slotReader = openReader2;
                                intMap = intMap2;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            slotReader = openReader2;
                        }
                        try {
                            setReader$runtime_release(reader);
                            this.nodeCountOverrides = iArr;
                            this.providerUpdates = intMap;
                            try {
                                slotReader.close();
                            } catch (Throwable th10) {
                                th = th10;
                                changeList = changeList2;
                                composerChangeListWriter = composerChangeListWriter2;
                                composerChangeListWriter.setChangeList(changeList);
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader.close();
                            throw th;
                        }
                    }
                    this.changeListWriter.skipToEndOfCurrentGroup();
                    i7 = 1;
                    i9 = i6 + 1;
                    size = i5;
                    changeList5 = changeList2;
                    composerChangeListWriter4 = composerChangeListWriter2;
                    i8 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter4;
                    changeList2 = changeList5;
                }
            }
            ComposerChangeListWriter composerChangeListWriter7 = composerChangeListWriter4;
            ChangeList changeList9 = changeList5;
            this.changeListWriter.endMovableContentPlacement();
            this.changeListWriter.moveReaderToAbsolute(0);
            composerChangeListWriter7.setChangeList(changeList9);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter4;
            changeList = changeList5;
        }
    }

    private final int insertedGroupVirtualIndex(int index) {
        return (-2) - index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        recordProviderUpdate(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(126665345, content);
        updateSlot(parameter);
        int compoundKeyHash = getCompoundKeyHash();
        try {
            this.compoundKeyHash = 126665345;
            boolean z5 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), locals)) {
                z5 = true;
            }
            m1211startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m1213getGroupULZAiWs(), locals);
            this.providerCache = null;
            if (!getInserting() || force) {
                boolean z6 = this.providersInvalid;
                this.providersInvalid = z5;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new Function2<Composer, Integer, Unit>(content, parameter) { // from class: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1
                    final /* synthetic */ Object $parameter;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$parameter = parameter;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i5) {
                        if ((i5 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(316014703, i5, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3293)");
                            }
                            throw null;
                        }
                    }
                }));
                this.providersInvalid = z6;
            } else {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope()));
            }
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash;
            endMovableGroup();
        } catch (Throwable th) {
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash;
            endMovableGroup();
            throw th;
        }
    }

    private final Object nodeAt(SlotReader slotReader, int i5) {
        return slotReader.node(i5);
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int parent = this.reader.parent(group);
        while (parent != recomposeGroup && !this.reader.isNode(parent)) {
            parent = this.reader.parent(parent);
        }
        if (this.reader.isNode(parent)) {
            recomposeIndex = 0;
        }
        if (parent == group) {
            return recomposeIndex;
        }
        int updatedNodeCount = (updatedNodeCount(parent) - this.reader.nodeCount(group)) + recomposeIndex;
        loop1: while (recomposeIndex < updatedNodeCount && parent != groupLocation) {
            parent++;
            while (parent < groupLocation) {
                int groupSize = this.reader.groupSize(parent) + parent;
                if (groupLocation >= groupSize) {
                    recomposeIndex += this.reader.isNode(parent) ? 1 : updatedNodeCount(parent);
                    parent = groupSize;
                }
            }
            break loop1;
        }
        return recomposeIndex;
    }

    private final int rGroupIndexOf(int group) {
        int parent = this.reader.parent(group) + 1;
        int i5 = 0;
        while (parent < group) {
            if (!this.reader.hasObjectKey(parent)) {
                i5++;
            }
            parent += this.reader.groupSize(parent);
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r7 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <R> R recomposeMovableContent(ControlledComposition from, ControlledComposition to, Integer index, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> invalidations, Function0<? extends R> block) {
        R invoke;
        boolean z5 = this.isComposing;
        int i5 = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = invalidations.size();
            for (int i6 = 0; i6 < size; i6++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = invalidations.get(i6);
                RecomposeScopeImpl component1 = pair.component1();
                Object component2 = pair.component2();
                if (component2 != null) {
                    tryImminentInvalidation$runtime_release(component1, component2);
                } else {
                    tryImminentInvalidation$runtime_release(component1, null);
                }
            }
            if (from != null) {
                invoke = (R) from.delegateInvalidations(to, index != null ? index.intValue() : -1, block);
            }
            invoke = block.invoke();
            this.isComposing = z5;
            this.nodeIndex = i5;
            return invoke;
        } catch (Throwable th) {
            this.isComposing = z5;
            this.nodeIndex = i5;
            throw th;
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i5, Object obj) {
        ControlledComposition controlledComposition3 = (i5 & 1) != 0 ? null : controlledComposition;
        ControlledComposition controlledComposition4 = (i5 & 2) != 0 ? null : controlledComposition2;
        Integer num2 = (i5 & 4) != 0 ? null : num;
        if ((i5 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, function0);
    }

    private final void recomposeToGroupEnd() {
        Invalidation firstInRange;
        boolean z5 = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i5 = this.nodeIndex;
        int compoundKeyHash = getCompoundKeyHash();
        int i6 = this.groupNodeCount;
        int i7 = this.rGroupIndex;
        firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrent(), groupSize);
        boolean z6 = false;
        int i8 = parent;
        while (firstInRange != null) {
            int location = firstInRange.getLocation();
            ComposerKt.removeLocation(this.invalidations, location);
            if (firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int current = this.reader.getCurrent();
                recordUpsAndDowns(i8, current, parent);
                this.nodeIndex = nodeIndexOf(location, current, parent, i5);
                this.rGroupIndex = rGroupIndexOf(current);
                int parent2 = this.reader.parent(current);
                this.compoundKeyHash = compoundKeyOf(parent2, rGroupIndexOf(parent2), parent, compoundKeyHash);
                this.providerCache = null;
                firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i8 = current;
                z6 = true;
            } else {
                this.invalidateStack.push(firstInRange.getScope());
                firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrent(), groupSize);
        }
        if (z6) {
            recordUpsAndDowns(i8, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i5 + updatedNodeCount;
            this.groupNodeCount = i6 + updatedNodeCount;
            this.rGroupIndex = i7;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash;
        this.isComposing = z5;
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrent());
        this.changeListWriter.removeCurrentGroup();
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
        } else {
            this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
            this.insertFixups = new FixupList();
        }
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap providers) {
        IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
        if (intMap == null) {
            intMap = new IntMap<>(0, 1, null);
            this.providerUpdates = intMap;
        }
        intMap.set(this.reader.getCurrent(), providers);
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        int nearestCommonRootOf;
        SlotReader slotReader = this.reader;
        nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, oldGroup, newGroup, commonRoot);
        while (oldGroup > 0 && oldGroup != nearestCommonRootOf) {
            if (slotReader.isNode(oldGroup)) {
                this.changeListWriter.moveUp();
            }
            oldGroup = slotReader.parent(oldGroup);
        }
        doRecordDownsFor(newGroup, nearestCommonRootOf);
    }

    private final Anchor rememberObserverAnchor() {
        int i5;
        int i6;
        if (getInserting()) {
            if (!ComposerKt.isAfterFirstChild(this.writer)) {
                return null;
            }
            int currentGroup = this.writer.getCurrentGroup() - 1;
            int parent = this.writer.parent(currentGroup);
            while (true) {
                int i7 = parent;
                i6 = currentGroup;
                currentGroup = i7;
                if (currentGroup == this.writer.getParent() || currentGroup < 0) {
                    break;
                }
                parent = this.writer.parent(currentGroup);
            }
            return this.writer.anchor(i6);
        }
        if (!ComposerKt.isAfterFirstChild(this.reader)) {
            return null;
        }
        int current = this.reader.getCurrent() - 1;
        int parent2 = this.reader.parent(current);
        while (true) {
            int i8 = parent2;
            i5 = current;
            current = i8;
            if (current == this.reader.getParent() || current < 0) {
                break;
            }
            parent2 = this.reader.parent(current);
        }
        return this.reader.anchor(i5);
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            ChangeList changeList = new ChangeList();
            this.deferredChanges = changeList;
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                try {
                    composerChangeListWriter.setChangeList(changeList);
                    reportFreeMovableContent(0);
                    this.changeListWriter.releaseMovableContent();
                    composerChangeListWriter.setChangeList(changeList2);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    composerChangeListWriter.setChangeList(changeList2);
                    throw th;
                }
            } finally {
                openReader.close();
            }
        }
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, false, 0);
        this.changeListWriter.endNodeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i5, boolean z5, int i6) {
        SlotReader slotReader = composerImpl.reader;
        if (slotReader.hasMark(i5)) {
            int groupKey = slotReader.groupKey(i5);
            Object groupObjectKey = slotReader.groupObjectKey(i5);
            if (groupKey != 206 || !Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                if (slotReader.isNode(i5)) {
                    return 1;
                }
                return slotReader.nodeCount(i5);
            }
            Object groupGet = slotReader.groupGet(i5, 0);
            CompositionContextHolder compositionContextHolder = groupGet instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet : null;
            if (compositionContextHolder != null) {
                for (ComposerImpl composerImpl2 : compositionContextHolder.getRef().getComposers()) {
                    composerImpl2.reportAllMovableContent();
                    composerImpl.parentContext.reportRemovedComposition$runtime_release(composerImpl2.getComposition());
                }
            }
            return slotReader.nodeCount(i5);
        }
        if (!slotReader.containsMark(i5)) {
            if (slotReader.isNode(i5)) {
                return 1;
            }
            return slotReader.nodeCount(i5);
        }
        int groupSize = slotReader.groupSize(i5) + i5;
        int i7 = 0;
        for (int i8 = i5 + 1; i8 < groupSize; i8 += slotReader.groupSize(i8)) {
            boolean isNode = slotReader.isNode(i8);
            if (isNode) {
                composerImpl.changeListWriter.endNodeMovement();
                composerImpl.changeListWriter.moveDown(slotReader.node(i8));
            }
            i7 += reportFreeMovableContent$reportGroup(composerImpl, i8, isNode || z5, isNode ? 0 : i6 + i7);
            if (isNode) {
                composerImpl.changeListWriter.endNodeMovement();
                composerImpl.changeListWriter.moveUp();
            }
        }
        if (slotReader.isNode(i5)) {
            return 1;
        }
        return i7;
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0078  */
    /* renamed from: start-BaiHCIY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m1211startBaiHCIY(int key, Object objectKey, int kind, Object data) {
        int rotateLeft;
        Object obj = objectKey;
        validateNodeNotExpected();
        int i5 = this.rGroupIndex;
        if (obj != null) {
            rotateLeft = Integer.rotateLeft((obj instanceof Enum ? ((Enum) obj).ordinal() : objectKey.hashCode()) ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        } else {
            if (data != null && key == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                this.compoundKeyHash = i5 ^ Integer.rotateLeft(data.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
                if (obj == null) {
                    this.rGroupIndex++;
                }
                GroupKind.Companion companion = GroupKind.INSTANCE;
                boolean z5 = kind == companion.m1213getGroupULZAiWs();
                Pending pending = null;
                if (!getInserting()) {
                    this.reader.beginEmpty();
                    int currentGroup = this.writer.getCurrentGroup();
                    if (z5) {
                        this.writer.startNode(key, Composer.INSTANCE.getEmpty());
                    } else if (data != null) {
                        SlotWriter slotWriter = this.writer;
                        if (obj == null) {
                            obj = Composer.INSTANCE.getEmpty();
                        }
                        slotWriter.startData(key, obj, data);
                    } else {
                        SlotWriter slotWriter2 = this.writer;
                        if (obj == null) {
                            obj = Composer.INSTANCE.getEmpty();
                        }
                        slotWriter2.startGroup(key, obj);
                    }
                    Pending pending2 = this.pending;
                    if (pending2 != null) {
                        KeyInfo keyInfo = new KeyInfo(key, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                        pending2.registerInsert(keyInfo, this.nodeIndex - pending2.getStartIndex());
                        pending2.recordUsed(keyInfo);
                    }
                    enterGroup(z5, null);
                    return;
                }
                boolean z6 = kind == companion.m1214getNodeULZAiWs() && this.reusing;
                if (this.pending == null) {
                    int groupKey = this.reader.getGroupKey();
                    if (!z6 && groupKey == key && Intrinsics.areEqual(objectKey, this.reader.getGroupObjectKey())) {
                        startReaderGroup(z5, data);
                    } else {
                        this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
                    }
                }
                Pending pending3 = this.pending;
                if (pending3 != null) {
                    KeyInfo next = pending3.getNext(key, objectKey);
                    if (z6 || next == null) {
                        this.reader.beginEmpty();
                        this.inserting = true;
                        this.providerCache = null;
                        ensureWriter();
                        this.writer.beginInsert();
                        int currentGroup2 = this.writer.getCurrentGroup();
                        if (z5) {
                            this.writer.startNode(key, Composer.INSTANCE.getEmpty());
                        } else if (data != null) {
                            SlotWriter slotWriter3 = this.writer;
                            if (obj == null) {
                                obj = Composer.INSTANCE.getEmpty();
                            }
                            slotWriter3.startData(key, obj, data);
                        } else {
                            SlotWriter slotWriter4 = this.writer;
                            if (obj == null) {
                                obj = Composer.INSTANCE.getEmpty();
                            }
                            slotWriter4.startGroup(key, obj);
                        }
                        this.insertAnchor = this.writer.anchor(currentGroup2);
                        KeyInfo keyInfo2 = new KeyInfo(key, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                        pending3.registerInsert(keyInfo2, this.nodeIndex - pending3.getStartIndex());
                        pending3.recordUsed(keyInfo2);
                        pending = new Pending(new ArrayList(), z5 ? 0 : this.nodeIndex);
                    } else {
                        pending3.recordUsed(next);
                        int location = next.getLocation();
                        this.nodeIndex = pending3.nodePositionOf(next) + pending3.getStartIndex();
                        int slotPositionOf = pending3.slotPositionOf(next);
                        int groupIndex = slotPositionOf - pending3.getGroupIndex();
                        pending3.registerMoveSlot(slotPositionOf, pending3.getGroupIndex());
                        this.changeListWriter.moveReaderRelativeTo(location);
                        this.reader.reposition(location);
                        if (groupIndex > 0) {
                            this.changeListWriter.moveCurrentGroup(groupIndex);
                        }
                        startReaderGroup(z5, data);
                    }
                }
                enterGroup(z5, pending);
                return;
            }
            rotateLeft = i5 ^ Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ key, 3);
        }
        this.compoundKeyHash = rotateLeft;
        if (obj == null) {
        }
        GroupKind.Companion companion2 = GroupKind.INSTANCE;
        if (kind == companion2.m1213getGroupULZAiWs()) {
        }
        Pending pending4 = null;
        if (!getInserting()) {
        }
    }

    private final void startGroup(int key) {
        m1211startBaiHCIY(key, null, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (data != null && this.reader.getGroupAux() != data) {
            this.changeListWriter.updateAuxData(data);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        int asInt;
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        IntStack intStack = this.providersInvalidStack;
        asInt = ComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = this.parentContext.getCollectingSourceInformation();
        }
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey());
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) != count) {
            if (group < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(group, count);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.getGroupsSize()];
                ArraysKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
                this.nodeCountOverrides = iArr;
            }
            iArr[group] = count;
        }
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int updatedNodeCount = updatedNodeCount(group);
        if (updatedNodeCount != newCount) {
            int i5 = newCount - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (group != -1) {
                int updatedNodeCount2 = updatedNodeCount(group) + i5;
                updateNodeCount(group, updatedNodeCount2);
                int i6 = size;
                while (true) {
                    if (-1 < i6) {
                        Pending peek = this.pendingStack.peek(i6);
                        if (peek != null && peek.updateNodeCount(group, updatedNodeCount2)) {
                            size = i6 - 1;
                            break;
                        }
                        i6--;
                    } else {
                        break;
                    }
                }
                if (group < 0) {
                    group = this.reader.getParent();
                } else if (this.reader.isNode(group)) {
                    return;
                } else {
                    group = this.reader.parent(group);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap parentScope, PersistentCompositionLocalMap currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder2 = parentScope.builder2();
        builder2.putAll(currentProviders);
        ?? build2 = builder2.build2();
        startGroup(204, ComposerKt.getProviderMaps());
        updateSlot(build2);
        updateSlot(currentProviders);
        endGroup();
        return build2;
    }

    private final void updateSlot(Object value) {
        nextSlot();
        updateValue(value);
    }

    private final int updatedNodeCount(int group) {
        int i5;
        if (group >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i5 = iArr[group]) < 0) ? this.reader.nodeCount(group) : i5;
        }
        MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
        if (mutableIntIntMap == null || !mutableIntIntMap.contains(group)) {
            return 0;
        }
        return mutableIntIntMap.get(group);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block) {
        if (getInserting()) {
            this.insertFixups.updateNode(value, block);
        } else {
            this.changeListWriter.updateNode(value, block);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object nextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (compositionContextHolder == null) {
            int compoundKeyHash = getCompoundKeyHash();
            boolean z5 = this.forceRecomposeScopes;
            boolean z6 = this.sourceMarkersEnabled;
            ControlledComposition composition = getComposition();
            CompositionImpl compositionImpl = composition instanceof CompositionImpl ? (CompositionImpl) composition : null;
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(compoundKeyHash, z5, z6, compositionImpl != null ? compositionImpl.getObserverHolder() : null));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(Object value) {
        if (Intrinsics.areEqual(nextSlot(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changedInstance(Object value) {
        if (nextSlot() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.sourceMarkersEnabled = true;
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    public final void composeContent$runtime_release(ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        doCompose(invalidationsRequested, content);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(Function0<? extends T> factory) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int peek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(factory, peek, anchor);
    }

    public final void deactivate$runtime_release() {
        this.invalidateStack.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!changed) {
            skipReaderToGroupEnd();
            return;
        }
        int current = this.reader.getCurrent();
        int end = this.reader.getEnd();
        this.changeListWriter.deactivateCurrentGroup();
        ComposerKt.removeRange(this.invalidations, current, end);
        this.reader.skipToGroupEnd();
    }

    public final void dispose$runtime_release() {
        Trace trace = Trace.INSTANCE;
        Object beginSection = trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            deactivate$runtime_release();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
            trace.endSection(beginSection);
        } catch (Throwable th) {
            Trace.INSTANCE.endSection(beginSection);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release == null || !currentRecomposeScope$runtime_release.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime_release.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        boolean asBool;
        endGroup();
        endGroup();
        asBool = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        boolean asBool;
        endGroup();
        endGroup();
        asBool = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl pop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (pop != null) {
            pop.setRequiresRecompose(false);
        }
        if (pop != null && (end = pop.end(this.compositionToken)) != null) {
            this.changeListWriter.endCompositionScope(end, getComposition());
        }
        if (pop != null && !pop.getSkipped$runtime_release() && (pop.getUsed() || this.forceRecomposeScopes)) {
            if (pop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                pop.setAnchor(anchor);
            }
            pop.setDefaultsInvalid(false);
            recomposeScopeImpl = pop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final void endReuseFromRoot() {
        if (!(!this.isComposing && this.reusingGroup == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int i5 = -marker;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i5) {
                    return;
                } else {
                    end(slotWriter.isNode(parent));
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= marker) {
                    return;
                } else {
                    end(slotReader.isNode(parent2));
                }
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing == 0 && stack.isNotEmpty()) {
            return stack.peek();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        if (!getSkipping() || this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    /* renamed from: getDeferredChanges$runtime_release, reason: from getter */
    public final ChangeList getDeferredChanges() {
        return this.deferredChanges;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    /* renamed from: getReader$runtime_release, reason: from getter */
    public final SlotReader getReader() {
        return this.reader;
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release()) == null || currentRecomposeScope$runtime_release.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* renamed from: isComposing$runtime_release, reason: from getter */
    public final boolean getIsComposing() {
        return this.isComposing;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next : Composer.INSTANCE.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next : Composer.INSTANCE.getEmpty();
    }

    public final void prepareCompose$runtime_release(Function0<Unit> block) {
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            block.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    public final boolean recompose$runtime_release(ScopeMap<RecomposeScopeImpl, Object> invalidationsRequested) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (invalidationsRequested.getSize() <= 0 && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        doCompose(invalidationsRequested, null);
        return this.changes.isNotEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(Function0<Unit> effect) {
        this.changeListWriter.sideEffect(effect);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope scope) {
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.setUsed(true);
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    public final void setReader$runtime_release(SlotReader slotReader) {
        this.reader = slotReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void skipCurrentGroup() {
        int rotateLeft;
        int hashCode;
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        int i5 = this.rGroupIndex;
        if (groupObjectKey != null) {
            rotateLeft = Integer.rotateLeft((groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()) ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        } else {
            if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
                this.compoundKeyHash = Integer.rotateLeft(groupAux.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ i5;
                startReaderGroup(slotReader.isNode(), null);
                recomposeToGroupEnd();
                slotReader.endGroup();
                if (groupObjectKey == null) {
                    hashCode = Integer.hashCode(groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
                } else {
                    if (groupAux != null && groupKey == 207 && !Intrinsics.areEqual(groupAux, Composer.INSTANCE.getEmpty())) {
                        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(groupAux.hashCode()) ^ Integer.rotateRight(getCompoundKeyHash() ^ i5, 3), 3);
                        return;
                    }
                    hashCode = Integer.rotateRight(getCompoundKeyHash() ^ i5, 3) ^ Integer.hashCode(groupKey);
                }
                this.compoundKeyHash = Integer.rotateRight(hashCode, 3);
            }
            rotateLeft = Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ groupKey, 3) ^ i5;
        }
        this.compoundKeyHash = rotateLeft;
        startReaderGroup(slotReader.isNode(), null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        if (groupObjectKey == null) {
        }
        this.compoundKeyHash = Integer.rotateRight(hashCode, 3);
    }

    @Override // androidx.compose.runtime.Composer
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void startDefaults() {
        m1211startBaiHCIY(-127, null, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startMovableGroup(int key, Object dataKey) {
        m1211startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m1211startBaiHCIY(125, null, GroupKind.INSTANCE.m1214getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProvider(ProvidedValue<?> value) {
        ValueHolder<?> valueHolder;
        int asInt;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        Object rememberedValue = rememberedValue();
        if (Intrinsics.areEqual(rememberedValue, Composer.INSTANCE.getEmpty())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) rememberedValue;
        }
        CompositionLocal<?> compositionLocal = value.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder<?> updatedStateOf$runtime_release = compositionLocal.updatedStateOf$runtime_release(value, valueHolder);
        boolean areEqual = Intrinsics.areEqual(updatedStateOf$runtime_release, valueHolder);
        if (!areEqual) {
            updateRememberedValue(updatedStateOf$runtime_release);
        }
        boolean z5 = true;
        boolean z6 = false;
        if (getInserting()) {
            if (value.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal)) {
                currentCompositionLocalScope = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
            }
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object groupAux = slotReader.groupAux(slotReader.getCurrent());
            Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupAux;
            currentCompositionLocalScope = (!(getSkipping() && areEqual) && (value.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal))) ? currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release) : persistentCompositionLocalMap;
            if (!this.reusing && persistentCompositionLocalMap == currentCompositionLocalScope) {
                z5 = false;
            }
            z6 = z5;
        }
        if (z6 && !getInserting()) {
            recordProviderUpdate(currentCompositionLocalScope);
        }
        IntStack intStack = this.providersInvalidStack;
        asInt = ComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = z6;
        this.providerCache = currentCompositionLocalScope;
        m1211startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m1213getGroupULZAiWs(), currentCompositionLocalScope);
    }

    @Override // androidx.compose.runtime.Composer
    public void startProviders(ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap updateProviderMapGroup;
        int asInt;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        boolean z5 = true;
        boolean z6 = false;
        if (getInserting()) {
            updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(values, currentCompositionLocalScope, null, 4, null));
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupGet2;
            PersistentCompositionLocalMap updateCompositionMap = CompositionLocalMapKt.updateCompositionMap(values, currentCompositionLocalScope, persistentCompositionLocalMap2);
            if (getSkipping() && !this.reusing && Intrinsics.areEqual(persistentCompositionLocalMap2, updateCompositionMap)) {
                skipGroup();
                updateProviderMapGroup = persistentCompositionLocalMap;
            } else {
                updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, updateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual(updateProviderMapGroup, persistentCompositionLocalMap)) {
                    z5 = false;
                }
                z6 = z5;
            }
        }
        if (z6 && !getInserting()) {
            recordProviderUpdate(updateProviderMapGroup);
        }
        IntStack intStack = this.providersInvalidStack;
        asInt = ComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = z6;
        this.providerCache = updateProviderMapGroup;
        m1211startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m1213getGroupULZAiWs(), updateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceGroup(int key) {
        if (this.pending != null) {
            m1211startBaiHCIY(key, null, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
            return;
        }
        validateNodeNotExpected();
        this.compoundKeyHash = this.rGroupIndex ^ Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ key, 3);
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(key, Composer.INSTANCE.getEmpty());
            enterGroup(false, null);
            return;
        }
        if (slotReader.getGroupKey() == key && !slotReader.getHasObjectKey()) {
            slotReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (!slotReader.isGroupEnd()) {
            int i5 = this.nodeIndex;
            int current = slotReader.getCurrent();
            recordDelete();
            this.changeListWriter.removeNode(i5, slotReader.skipGroup());
            ComposerKt.removeRange(this.invalidations, current, slotReader.getCurrent());
        }
        slotReader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureWriter();
        SlotWriter slotWriter = this.writer;
        slotWriter.beginInsert();
        int currentGroup = slotWriter.getCurrentGroup();
        slotWriter.startGroup(key, Composer.INSTANCE.getEmpty());
        this.insertAnchor = slotWriter.anchor(currentGroup);
        enterGroup(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceableGroup(int key) {
        m1211startBaiHCIY(key, null, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        if (!getInserting() && this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrent();
            this.reusing = true;
        }
        m1211startBaiHCIY(key, null, GroupKind.INSTANCE.m1213getGroupULZAiWs(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m1211startBaiHCIY(125, null, GroupKind.INSTANCE.m1215getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl scope, Object instance) {
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable());
        if (!this.isComposing || indexFor < this.reader.getCurrent()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, scope, instance);
        return true;
    }

    public final void updateCachedValue(Object value) {
        if (value instanceof RememberObserver) {
            if (getInserting()) {
                this.changeListWriter.remember((RememberObserver) value);
            }
            this.abandonSet.add(value);
            value = new RememberObserverHolder((RememberObserver) value, rememberObserverAnchor());
        }
        updateValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateCachedValue(value);
    }

    public final void updateValue(Object value) {
        if (getInserting()) {
            this.writer.update(value);
            return;
        }
        if (!this.reader.getHadNext()) {
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            SlotReader slotReader = this.reader;
            composerChangeListWriter.appendValue(slotReader.anchor(slotReader.getParent()), value);
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (!this.changeListWriter.getPastParent()) {
            this.changeListWriter.updateValue(value, groupSlotIndex);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
        SlotReader slotReader2 = this.reader;
        composerChangeListWriter2.updateAnchoredValue(value, slotReader2.anchor(slotReader2.getParent()), groupSlotIndex);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    private final void startGroup(int key, Object dataKey) {
        m1211startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m1213getGroupULZAiWs(), null);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object groupAux = this.writer.groupAux(parent);
                    Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getGroupsSize() > 0) {
            while (group > 0) {
                if (this.reader.groupKey(group) == 202 && Intrinsics.areEqual(this.reader.groupObjectKey(group), ComposerKt.getCompositionLocalMap())) {
                    IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
                    if (intMap == null || (persistentCompositionLocalMap = intMap.get(group)) == null) {
                        Object groupAux2 = this.reader.groupAux(group);
                        Intrinsics.checkNotNull(groupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                group = this.reader.parent(group);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.parentProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(boolean value) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && value == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(float value) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Float) && value == ((Number) nextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(long value) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && value == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(double value) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Double) && value == ((Number) nextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(int value) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && value == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }
}
