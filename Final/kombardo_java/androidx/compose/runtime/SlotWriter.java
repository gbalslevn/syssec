package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\bI\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 Ò\u00012\u00020\u0001:\u0002Ò\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0017J\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\u0019J\u001f\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0002¢\u0006\u0004\b+\u0010\u0017J\u0017\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b-\u0010\u0019J\u001f\u0010.\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010*J\u001f\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0002¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J'\u00106\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u0010&J!\u00107\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0002¢\u0006\u0004\b;\u0010*JG\u0010A\u001a\u00020\f2\u0006\u0010<\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2&\u0010@\u001a\"\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u0001`?H\u0002¢\u0006\u0004\bA\u0010BJ'\u0010E\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\bE\u0010&J\u0017\u0010F\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bI\u0010GJ\u001b\u0010\"\u001a\u00020\t*\u00020J2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010KJ\u0017\u0010H\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\bH\u0010GJ\u001b\u0010H\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bH\u0010KJ\u001b\u0010M\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010KJ#\u0010N\u001a\u00020\u000f*\u00020J2\u0006\u0010L\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010KJ\u001b\u0010Q\u001a\u00020\t*\u00020J2\u0006\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010KJ/\u0010T\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bT\u0010UJ'\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010Y\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b[\u0010GJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0014J\u0015\u0010\\\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\\\u0010GJ\u0015\u0010]\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b]\u0010GJ\u0017\u0010^\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b^\u0010_J\u0015\u0010`\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b`\u0010GJ\u0017\u0010a\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\ba\u0010_J\u0015\u0010b\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bb\u0010\u0014J\u0015\u0010c\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bc\u0010\u0014J\u001d\u0010d\u001a\u00020\f2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\bd\u00102J\u0017\u0010e\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\be\u0010_J\u0017\u0010e\u001a\u0004\u0018\u00010\u00012\u0006\u0010V\u001a\u00020>¢\u0006\u0004\be\u0010fJ\u0015\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\b\"\u0010GJ\u0015\u0010h\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\f¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020\u000f¢\u0006\u0004\bj\u0010\u0017J\u0019\u0010k\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bk\u0010\bJ\u001f\u0010l\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bl\u0010mJ\u0015\u0010o\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\t¢\u0006\u0004\bo\u0010\u0019J\u0017\u0010p\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bp\u0010qJ\r\u0010r\u001a\u00020\u000f¢\u0006\u0004\br\u0010\u0017J\u0017\u0010s\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bs\u0010qJ\u001f\u0010s\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bs\u0010mJ\u0017\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010qJ!\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010tJ\u001d\u0010u\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\bu\u0010ZJ)\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010vJ\u000f\u0010w\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bw\u0010xJ\u001f\u0010y\u001a\u0004\u0018\u00010\u00012\u0006\u0010V\u001a\u00020>2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\by\u0010zJ\u001f\u0010y\u001a\u0004\u0018\u00010\u00012\u0006\u0010{\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t¢\u0006\u0004\by\u0010|J\u0017\u0010~\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0004\b}\u0010GJ\u0018\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0004\b\u007f\u0010GJ\u0019\u0010\u0082\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0000¢\u0006\u0005\b\u0081\u0001\u0010GJ\u0018\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020\t¢\u0006\u0005\b\u0084\u0001\u0010\u0019J\u000f\u0010\u0085\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0085\u0001\u0010\u0017J\u000f\u0010\u0086\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0086\u0001\u0010\u0017J\u000f\u0010\u0087\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0087\u0001\u0010\u0017J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0017J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0010\u00108J!\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0005\b\u0089\u0001\u00108J,\u0010\u008a\u0001\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010!J\u0017\u0010\u008c\u0001\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\t¢\u0006\u0005\b\u008c\u0001\u0010\u0019J\u0018\u0010\u008c\u0001\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020>¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020\t¢\u0006\u0005\b\u008e\u0001\u0010!J\u0010\u0010\u008f\u0001\u001a\u00020\f¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0018\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010\u0091\u0001\u001a\u00020\t¢\u0006\u0005\b\u0092\u0001\u0010\u0019J2\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\t2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\f¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J0\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0007\u0010\u0091\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\t¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0018\u0010V\u001a\u00020>2\b\b\u0002\u0010'\u001a\u00020\t¢\u0006\u0005\bV\u0010\u0099\u0001J\u0019\u0010\u009a\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0005\b\u009a\u0001\u0010\u0019J\u0018\u0010\u009b\u0001\u001a\u00020\t2\u0006\u0010V\u001a\u00020>¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0013\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0016¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001c\u0010¡\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0006\b \u0001\u0010\u0099\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u0019\u0010¥\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\"\u0010¨\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R+\u0010¬\u0001\u001a\u0014\u0012\u0004\u0012\u00020>0ª\u0001j\t\u0012\u0004\u0012\u00020>`«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R7\u0010@\u001a\"\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000203\u0018\u0001`?8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010®\u0001R#\u0010±\u0001\u001a\f\u0012\u0005\u0012\u00030°\u0001\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010´\u0001R\u0019\u0010¶\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010´\u0001R\u0019\u0010·\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010´\u0001R\u0019\u0010¸\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010´\u0001R\u0019\u0010¹\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010´\u0001R\u0019\u0010º\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010´\u0001R\u0019\u0010»\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010´\u0001R\u0017\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\\\u0010´\u0001R\u0018\u0010½\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0018\u0010¿\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010¾\u0001R\u0018\u0010À\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010¾\u0001R+\u0010Â\u0001\u001a\u0014\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010Á\u0001\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010²\u0001R)\u0010Ä\u0001\u001a\u00020\t2\u0007\u0010Ã\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÄ\u0001\u0010´\u0001\u001a\u0005\bÅ\u0001\u0010!R)\u0010Æ\u0001\u001a\u00020\t2\u0007\u0010Ã\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÆ\u0001\u0010´\u0001\u001a\u0005\bÇ\u0001\u0010!R'\u0010\"\u001a\u00020\t2\u0007\u0010Ã\u0001\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\"\u0010´\u0001\u001a\u0005\bÈ\u0001\u0010!R*\u0010É\u0001\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010\u0090\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0015\u0010S\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010!R\u0013\u0010Ð\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010!R\u0012\u0010\r\u001a\u00020\f8F¢\u0006\u0007\u001a\u0005\b\r\u0010\u0090\u0001R\u0015\u0010,\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010!¨\u0006Ó\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/SlotTable;", "table", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", "value", "rawUpdate", "(Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "key", "objectKey", BuildConfig.FLAVOR, "isNode", "aux", BuildConfig.FLAVOR, "startGroup", "(ILjava/lang/Object;ZLjava/lang/Object;)V", "group", "containsGroupMark", "(I)Z", "containsAnyGroupMarks", "recalculateMarks", "()V", "updateContainsMark", "(I)V", "Landroidx/compose/runtime/PrioritySet;", "set", "updateContainsMarkNow", "(ILandroidx/compose/runtime/PrioritySet;)V", "childContainsAnyMarks", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "()I", "parent", "endGroup", "firstChild", "fixParentAnchorsFor", "(III)V", "index", "moveGroupGapTo", "moveSlotGapTo", "(II)V", "clearSlotGap", "size", "insertGroups", "insertSlots", "start", "len", "removeGroups", "(II)Z", "Landroidx/compose/runtime/GroupSourceInformation;", "sourceInformationOf", "(I)Landroidx/compose/runtime/GroupSourceInformation;", "removeSlots", "updateNodeOfGroup", "(ILjava/lang/Object;)V", "previousGapStart", "newGapStart", "updateAnchors", "gapStart", "Ljava/util/HashMap;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "removeAnchors", "(IILjava/util/HashMap;)Z", "originalLocation", "newLocation", "moveAnchors", "groupIndexToAddress", "(I)I", "dataIndex", "dataIndexToDataAddress", BuildConfig.FLAVOR, "([II)I", "address", "slotIndex", "updateDataIndex", "([III)V", "nodeIndex", "auxIndex", "gapLen", "capacity", "dataIndexToDataAnchor", "(IIII)I", "anchor", "dataAnchorToDataIndex", "(III)I", "parentIndexToAnchor", "(II)I", "parentAnchorToIndex", "nodeCount", "groupKey", "groupObjectKey", "(I)Ljava/lang/Object;", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "node", "(Landroidx/compose/runtime/Anchor;)Ljava/lang/Object;", "normalClose", "close", "(Z)V", "reset", "update", "appendSlot", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "count", "trimTailSlots", "updateAux", "(Ljava/lang/Object;)V", "updateToTableMaps", "updateNode", "(ILjava/lang/Object;)Ljava/lang/Object;", "slotIndexOfGroupSlotIndex", "(IILjava/lang/Object;)Ljava/lang/Object;", "skip", "()Ljava/lang/Object;", "slot", "(Landroidx/compose/runtime/Anchor;I)Ljava/lang/Object;", "groupIndex", "(II)Ljava/lang/Object;", "slotsStartIndex$runtime_release", "slotsStartIndex", "slotsEndIndex$runtime_release", "slotsEndIndex", "slotsEndAllIndex$runtime_release", "slotsEndAllIndex", "amount", "advanceBy", "skipToGroupEnd", "beginInsert", "endInsert", "dataKey", "startNode", "startData", "(ILjava/lang/Object;Ljava/lang/Object;)V", "ensureStarted", "(Landroidx/compose/runtime/Anchor;)V", "skipGroup", "removeGroup", "()Z", "offset", "moveGroup", "removeSourceGroup", BuildConfig.FLAVOR, "moveFrom", "(Landroidx/compose/runtime/SlotTable;IZ)Ljava/util/List;", "moveIntoGroupFrom", "(ILandroidx/compose/runtime/SlotTable;I)Ljava/util/List;", "(I)Landroidx/compose/runtime/Anchor;", "markGroup", "anchorIndex", "(Landroidx/compose/runtime/Anchor;)I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "tryAnchor$runtime_release", "tryAnchor", "Landroidx/compose/runtime/SlotTable;", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "groups", "[I", BuildConfig.FLAVOR, "slots", "[Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchors", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "groupGapStart", "I", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "Landroidx/compose/runtime/IntStack;", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "Landroidx/collection/MutableObjectList;", "deferredSlotWrites", "<set-?>", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "getParent", "closed", "Z", "getClosed", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "getCapacity", "getSlotsSize", "slotsSize", "getSize$runtime_release", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private PrioritySet pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startStack = new IntStack();
    private final IntStack endStack = new IntStack();
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", BuildConfig.FLAVOR, "()V", "moveGroup", BuildConfig.FLAVOR, "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", BuildConfig.FLAVOR, "toWriter", "updateFromCursor", BuildConfig.FLAVOR, "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            boolean z5;
            List<Anchor> list;
            int i5;
            int groupSize = fromWriter.groupSize(fromIndex);
            int i6 = fromIndex + groupSize;
            int dataIndex = fromWriter.dataIndex(fromIndex);
            int dataIndex2 = fromWriter.dataIndex(i6);
            int i7 = dataIndex2 - dataIndex;
            boolean containsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(groupSize);
            toWriter.insertSlots(i7, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i6) {
                fromWriter.moveGroupGapTo(i6);
            }
            if (fromWriter.slotsGapStart < dataIndex2) {
                fromWriter.moveSlotGapTo(dataIndex2, i6);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            ArraysKt.copyInto(fromWriter.groups, iArr, currentGroup * 5, fromIndex * 5, i6 * 5);
            Object[] objArr = toWriter.slots;
            int i8 = toWriter.currentSlot;
            ArraysKt.copyInto(fromWriter.slots, objArr, i8, dataIndex, dataIndex2);
            int parent = toWriter.getParent();
            SlotTableKt.access$updateParentAnchor(iArr, currentGroup, parent);
            int i9 = currentGroup - fromIndex;
            int i10 = currentGroup + groupSize;
            int dataIndex3 = i8 - toWriter.dataIndex(iArr, currentGroup);
            int i11 = toWriter.slotsGapOwner;
            int i12 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i13 = i11;
            int i14 = currentGroup;
            while (true) {
                z5 = false;
                if (i14 >= i10) {
                    break;
                }
                if (i14 != currentGroup) {
                    i5 = i10;
                    SlotTableKt.access$updateParentAnchor(iArr, i14, SlotTableKt.access$parentAnchor(iArr, i14) + i9);
                } else {
                    i5 = i10;
                }
                int i15 = dataIndex3;
                SlotTableKt.access$updateDataAnchor(iArr, i14, toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i14) + dataIndex3, i13 >= i14 ? toWriter.slotsGapStart : 0, i12, length));
                if (i14 == i13) {
                    i13++;
                }
                i14++;
                dataIndex3 = i15;
                i10 = i5;
            }
            int i16 = i10;
            toWriter.slotsGapOwner = i13;
            int access$locationOf = SlotTableKt.access$locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime_release());
            int access$locationOf2 = SlotTableKt.access$locationOf(fromWriter.anchors, i6, fromWriter.getSize$runtime_release());
            if (access$locationOf < access$locationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(access$locationOf2 - access$locationOf);
                for (int i17 = access$locationOf; i17 < access$locationOf2; i17++) {
                    Anchor anchor = (Anchor) arrayList.get(i17);
                    anchor.setLocation$runtime_release(anchor.getLocation() + i9);
                    arrayList2.add(anchor);
                }
                toWriter.anchors.addAll(SlotTableKt.access$locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime_release()), arrayList2);
                arrayList.subList(access$locationOf, access$locationOf2).clear();
                list = arrayList2;
            } else {
                list = CollectionsKt.emptyList();
            }
            if (!list.isEmpty()) {
                HashMap hashMap = fromWriter.sourceInformationMap;
                HashMap hashMap2 = toWriter.sourceInformationMap;
                if (hashMap != null && hashMap2 != null) {
                    int size = list.size();
                    for (int i18 = 0; i18 < size; i18++) {
                    }
                }
            }
            toWriter.getParent();
            toWriter.sourceInformationOf(parent);
            int parent2 = fromWriter.parent(fromIndex);
            if (removeSourceGroup) {
                if (updateFromCursor) {
                    boolean z6 = parent2 >= 0;
                    if (z6) {
                        fromWriter.startGroup();
                        fromWriter.advanceBy(parent2 - fromWriter.getCurrentGroup());
                        fromWriter.startGroup();
                    }
                    fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                    boolean removeGroup = fromWriter.removeGroup();
                    if (z6) {
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                        fromWriter.skipToGroupEnd();
                        fromWriter.endGroup();
                    }
                    z5 = removeGroup;
                } else {
                    z5 = fromWriter.removeGroups(fromIndex, groupSize);
                    fromWriter.removeSlots(dataIndex, i7, fromIndex - 1);
                }
            }
            if (z5) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            toWriter.nodeCount += SlotTableKt.access$isNode(iArr, currentGroup) ? 1 : SlotTableKt.access$nodeCount(iArr, currentGroup);
            if (updateToCursor) {
                toWriter.currentGroup = i16;
                toWriter.currentSlot = i8 + i7;
            }
            if (containsAnyGroupMarks) {
                toWriter.updateContainsMark(parent);
            }
            return list;
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i5, SlotWriter slotWriter2, boolean z5, boolean z6, boolean z7, int i6, Object obj) {
            if ((i6 & 32) != 0) {
                z7 = true;
            }
            return companion.moveGroup(slotWriter, i5, slotWriter2, z5, z6, z7);
        }

        private Companion() {
        }
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime_release();
        this.calledByMap = slotTable.getCalledByMap$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
    }

    private final int auxIndex(int[] iArr, int i5) {
        return dataIndex(iArr, i5) + SlotTableKt.access$countOneBits(SlotTableKt.access$groupInfo(iArr, i5) >> 29);
    }

    private final boolean childContainsAnyMarks(int group) {
        int i5 = group + 1;
        int groupSize = group + groupSize(group);
        while (i5 < groupSize) {
            if (SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(i5))) {
                return true;
            }
            i5 += groupSize(i5);
        }
        return false;
    }

    private final void clearSlotGap() {
        int i5 = this.slotsGapStart;
        ArraysKt.fill(this.slots, (Object) null, i5, this.slotsGapLen + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        return group >= 0 && SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(group));
    }

    private final boolean containsGroupMark(int group) {
        return group >= 0 && SlotTableKt.access$containsMark(this.groups, groupIndexToAddress(group));
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        return anchor < 0 ? (capacity - gapLen) + anchor + 1 : anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex < this.slotsGapStart ? dataIndex : dataIndex + this.slotsGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        return index > gapStart ? -(((capacity - gapLen) - index) + 1) : index;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int parentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            SlotTableKt.access$updateParentAnchor(this.groups, groupIndexToAddress(firstChild), parentIndexToAnchor);
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(firstChild)) + firstChild;
            fixParentAnchorsFor(firstChild, access$groupSize, firstChild + 1);
            firstChild = access$groupSize;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int groupIndexToAddress(int index) {
        return index < this.groupGapStart ? index : index + this.groupGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i5 = this.currentGroup;
            moveGroupGapTo(i5);
            int i6 = this.groupGapStart;
            int i7 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i8 = length - i7;
            if (i7 < size) {
                int max = Math.max(Math.max(length * 2, i8 + size), 32);
                int[] iArr2 = new int[max * 5];
                int i9 = max - i8;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i6 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i6 + i9) * 5, (i7 + i6) * 5, length * 5);
                this.groups = iArr2;
                i7 = i9;
            }
            int i10 = this.currentGroupEnd;
            if (i10 >= i6) {
                this.currentGroupEnd = i10 + size;
            }
            int i11 = i6 + size;
            this.groupGapStart = i11;
            this.groupGapLen = i7 - size;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(i8 > 0 ? dataIndex(i5 + size) : 0, this.slotsGapOwner >= i6 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i12 = i6; i12 < i11; i12++) {
                SlotTableKt.access$updateDataAnchor(this.groups, i12, dataIndexToDataAnchor);
            }
            int i13 = this.slotsGapOwner;
            if (i13 >= i6) {
                this.slotsGapOwner = i13 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i5 = this.slotsGapStart;
            int i6 = this.slotsGapLen;
            if (i6 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i7 = length - i6;
                int max = Math.max(Math.max(length * 2, i7 + size), 32);
                Object[] objArr2 = new Object[max];
                for (int i8 = 0; i8 < max; i8++) {
                    objArr2[i8] = null;
                }
                int i9 = max - i7;
                ArraysKt.copyInto(objArr, objArr2, 0, 0, i5);
                ArraysKt.copyInto(objArr, objArr2, i5 + i9, i6 + i5, length);
                this.slots = objArr2;
                i6 = i9;
            }
            int i10 = this.currentSlotEnd;
            if (i10 >= i5) {
                this.currentSlotEnd = i10 + size;
            }
            this.slotsGapStart = i5 + size;
            this.slotsGapLen = i6 - size;
        }
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = slotWriter.parent;
        }
        slotWriter.markGroup(i5);
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        Anchor anchor;
        int anchorIndex;
        int i5 = size + originalLocation;
        int size$runtime_release = getSize$runtime_release();
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, originalLocation, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (access$locationOf >= 0) {
            while (access$locationOf < this.anchors.size() && (anchorIndex = anchorIndex((anchor = this.anchors.get(access$locationOf)))) >= originalLocation && anchorIndex < i5) {
                arrayList.add(anchor);
                this.anchors.remove(access$locationOf);
            }
        }
        int i6 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i7 = 0; i7 < size2; i7++) {
            Anchor anchor2 = (Anchor) arrayList.get(i7);
            int anchorIndex2 = anchorIndex(anchor2) + i6;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor2.setLocation$runtime_release(-(size$runtime_release - anchorIndex2));
            } else {
                anchor2.setLocation$runtime_release(anchorIndex2);
            }
            this.anchors.add(SlotTableKt.access$locationOf(this.anchors, anchorIndex2, size$runtime_release), anchor2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int i5 = this.groupGapLen;
        int i6 = this.groupGapStart;
        if (i6 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i6, index);
            }
            if (i5 > 0) {
                int[] iArr = this.groups;
                int i7 = index * 5;
                int i8 = i5 * 5;
                int i9 = i6 * 5;
                if (index < i6) {
                    ArraysKt.copyInto(iArr, iArr, i8 + i7, i7, i9);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i9, i9 + i8, i7 + i8);
                }
            }
            if (index < i6) {
                i6 = index + i5;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i6 < capacity);
            while (i6 < capacity) {
                int access$parentAnchor = SlotTableKt.access$parentAnchor(this.groups, i6);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(access$parentAnchor), index);
                if (parentIndexToAnchor != access$parentAnchor) {
                    SlotTableKt.access$updateParentAnchor(this.groups, i6, parentIndexToAnchor);
                }
                i6++;
                if (i6 == index) {
                    i6 += i5;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int i5 = this.slotsGapLen;
        int i6 = this.slotsGapStart;
        int i7 = this.slotsGapOwner;
        if (i6 != index) {
            Object[] objArr = this.slots;
            if (index < i6) {
                ArraysKt.copyInto(objArr, objArr, index + i5, index, i6);
            } else {
                ArraysKt.copyInto(objArr, objArr, i6, i6 + i5, index + i5);
            }
        }
        int min = Math.min(group + 1, getSize$runtime_release());
        if (i7 != min) {
            int length = this.slots.length - i5;
            if (min < i7) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i7);
                int i8 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress);
                    if (!(access$dataAnchor >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    SlotTableKt.access$updateDataAnchor(this.groups, groupIndexToAddress, -((length - access$dataAnchor) + 1));
                    groupIndexToAddress++;
                    if (groupIndexToAddress == i8) {
                        groupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i7);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress3);
                    if (!(access$dataAnchor2 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    SlotTableKt.access$updateDataAnchor(this.groups, groupIndexToAddress3, access$dataAnchor2 + length + 1);
                    groupIndexToAddress3++;
                    if (groupIndexToAddress3 == this.groupGapStart) {
                        groupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = index;
    }

    private final int nodeIndex(int[] iArr, int i5) {
        return dataIndex(iArr, i5);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : getSize$runtime_release() + index + 2;
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime_release() - index) + 2);
    }

    private final Object rawUpdate(Object value) {
        Object skip = skip();
        set(value);
        return skip;
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        int i5 = size + gapStart;
        int access$locationOf = SlotTableKt.access$locationOf(this.anchors, i5, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i6 = access$locationOf + 1;
        int i7 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            int anchorIndex = anchorIndex(anchor);
            if (anchorIndex < gapStart) {
                break;
            }
            if (anchorIndex < i5) {
                anchor.setLocation$runtime_release(Integer.MIN_VALUE);
                if (sourceInformationMap != null) {
                    sourceInformationMap.remove(anchor);
                }
                if (i7 == 0) {
                    i7 = access$locationOf + 1;
                }
                i6 = access$locationOf;
            }
            access$locationOf--;
        }
        boolean z5 = i6 < i7;
        if (z5) {
            this.anchors.subList(i6, i7).clear();
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            r0 = arrayList.isEmpty() ? false : removeAnchors(start, len, this.sourceInformationMap);
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i5 = this.slotsGapOwner;
            if (i5 > start) {
                this.slotsGapOwner = Math.max(start, i5 - len);
            }
            int i6 = this.currentGroupEnd;
            if (i6 >= this.groupGapStart) {
                this.currentGroupEnd = i6 - len;
            }
            int i7 = this.parent;
            if (containsGroupMark(i7)) {
                updateContainsMark(i7);
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i5 = this.slotsGapLen;
            int i6 = start + len;
            moveSlotGapTo(i6, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i5 + len;
            ArraysKt.fill(this.slots, (Object) null, start, i6);
            int i7 = this.currentSlotEnd;
            if (i7 >= start) {
                this.currentSlotEnd = i7 - len;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int slotIndex(int[] iArr, int i5) {
        return i5 >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.access$slotAnchor(iArr, i5), this.slotsGapLen, this.slots.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor tryAnchor$runtime_release;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor$runtime_release = tryAnchor$runtime_release(group)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor$runtime_release);
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        Anchor anchor;
        int location;
        Anchor anchor2;
        int location2;
        int i5;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart >= newGapStart) {
            for (int access$locationOf = SlotTableKt.access$locationOf(this.anchors, newGapStart, capacity); access$locationOf < this.anchors.size() && (location = (anchor = this.anchors.get(access$locationOf)).getLocation()) >= 0; access$locationOf++) {
                anchor.setLocation$runtime_release(-(capacity - location));
            }
            return;
        }
        for (int access$locationOf2 = SlotTableKt.access$locationOf(this.anchors, previousGapStart, capacity); access$locationOf2 < this.anchors.size() && (location2 = (anchor2 = this.anchors.get(access$locationOf2)).getLocation()) < 0 && (i5 = location2 + capacity) < newGapStart; access$locationOf2++) {
            anchor2.setLocation$runtime_release(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(null, 1, 0 == true ? 1 : 0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(group);
        }
    }

    private final void updateContainsMarkNow(int group, PrioritySet set) {
        int groupIndexToAddress = groupIndexToAddress(group);
        boolean childContainsAnyMarks = childContainsAnyMarks(group);
        if (SlotTableKt.access$containsMark(this.groups, groupIndexToAddress) != childContainsAnyMarks) {
            SlotTableKt.access$updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            int parent = parent(group);
            if (parent >= 0) {
                set.add(parent);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i5, int i6) {
        SlotTableKt.access$updateDataAnchor(iArr, i5, dataIndexToDataAnchor(i6, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if (!(groupIndexToAddress < iArr.length && SlotTableKt.access$isNode(iArr, groupIndexToAddress))) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + index + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = value;
    }

    public final void advanceBy(int amount) {
        boolean z5 = false;
        if (!(amount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
            return;
        }
        int i5 = this.currentGroup + amount;
        if (i5 >= this.parent && i5 <= this.currentGroupEnd) {
            z5 = true;
        }
        if (!z5) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }
        this.currentGroup = i5;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i5));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.access$search(arrayList, index, getSize$runtime_release());
        if (access$search >= 0) {
            return arrayList.get(access$search);
        }
        if (index > this.groupGapStart) {
            index = -(getSize$runtime_release() - index);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(access$search + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(Anchor anchor) {
        int location = anchor.getLocation();
        return location < 0 ? location + getSize$runtime_release() : location;
    }

    public final void appendSlot(Anchor anchor, Object value) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i5 = this.currentSlot;
        int i6 = this.currentSlotEnd;
        int anchorIndex = anchorIndex(anchor);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(anchorIndex + 1));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
        insertSlots(1, anchorIndex);
        if (i5 >= dataIndex) {
            i5++;
            i6++;
        }
        this.slots[dataIndex] = value;
        this.currentSlot = i5;
        this.currentSlotEnd = i6;
    }

    public final void beginInsert() {
        int i5 = this.insertCount;
        this.insertCount = i5 + 1;
        if (i5 == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void close(boolean normalClose) {
        this.closed = true;
        if (normalClose && this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final int endGroup() {
        MutableObjectList<Object> mutableObjectList;
        boolean z5 = this.insertCount > 0;
        int i5 = this.currentGroup;
        int i6 = this.currentGroupEnd;
        int i7 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i7);
        int i8 = this.nodeCount;
        int i9 = i5 - i7;
        boolean access$isNode = SlotTableKt.access$isNode(this.groups, groupIndexToAddress);
        if (z5) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = mutableIntObjectMap.get(i7)) != null) {
                Object[] objArr = mutableObjectList.content;
                int i10 = mutableObjectList._size;
                for (int i11 = 0; i11 < i10; i11++) {
                    rawUpdate(objArr[i11]);
                }
                mutableIntObjectMap.remove(i7);
            }
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, i9);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i8);
            this.nodeCount = this.nodeCountStack.pop() + (access$isNode ? 1 : i8);
            int parent = parent(this.groups, i7);
            this.parent = parent;
            int size$runtime_release = parent < 0 ? getSize$runtime_release() : groupIndexToAddress(parent + 1);
            int dataIndex = size$runtime_release >= 0 ? dataIndex(this.groups, size$runtime_release) : 0;
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
        } else {
            if (!(i5 == i6)) {
                ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
            }
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
            int access$nodeCount = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress);
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, i9);
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i8);
            int pop = this.startStack.pop();
            restoreCurrentGroupEnd();
            this.parent = pop;
            int parent2 = parent(this.groups, i7);
            int pop2 = this.nodeCountStack.pop();
            this.nodeCount = pop2;
            if (parent2 == pop) {
                this.nodeCount = pop2 + (access$isNode ? 0 : i8 - access$nodeCount);
            } else {
                int i12 = i9 - access$groupSize;
                int i13 = access$isNode ? 0 : i8 - access$nodeCount;
                if (i12 != 0 || i13 != 0) {
                    while (parent2 != 0 && parent2 != pop && (i13 != 0 || i12 != 0)) {
                        int groupIndexToAddress2 = groupIndexToAddress(parent2);
                        if (i12 != 0) {
                            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2) + i12);
                        }
                        if (i13 != 0) {
                            int[] iArr = this.groups;
                            SlotTableKt.access$updateNodeCount(iArr, groupIndexToAddress2, SlotTableKt.access$nodeCount(iArr, groupIndexToAddress2) + i13);
                        }
                        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress2)) {
                            i13 = 0;
                        }
                        parent2 = parent(this.groups, parent2);
                    }
                }
                this.nodeCount += i13;
            }
        }
        return i8;
    }

    public final void endInsert() {
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i5 = this.insertCount - 1;
        this.insertCount = i5;
        if (i5 == 0) {
            if (!(this.nodeCountStack.getTos() == this.startStack.getTos())) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void ensureStarted(int index) {
        boolean z5 = false;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i5 = this.parent;
        if (i5 != index) {
            if (index >= i5 && index < this.currentGroupEnd) {
                z5 = true;
            }
            if (!z5) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + index + " must be a subgroup of the group at " + i5);
            }
            int i6 = this.currentGroup;
            int i7 = this.currentSlot;
            int i8 = this.currentSlotEnd;
            this.currentGroup = index;
            startGroup();
            this.currentGroup = i6;
            this.currentSlot = i7;
            this.currentSlotEnd = i8;
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        return SlotTableKt.access$hasAux(this.groups, groupIndexToAddress) ? this.slots[auxIndex(this.groups, groupIndexToAddress)] : Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(int index) {
        return SlotTableKt.access$key(this.groups, groupIndexToAddress(index));
    }

    public final Object groupObjectKey(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.access$hasObjectKey(this.groups, groupIndexToAddress)) {
            return this.slots[SlotTableKt.access$objectKeyIndex(this.groups, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int index) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(index));
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int capacity;
        int groupSize;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else {
            if (group > this.startStack.peekOr(0)) {
                groupSize = groupSize(group);
            } else {
                int indexOf = this.startStack.indexOf(group);
                if (indexOf < 0) {
                    groupSize = groupSize(group);
                } else {
                    capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            capacity = groupSize + group;
        }
        return index > group && index < capacity;
    }

    public final boolean indexInParent(int index) {
        int i5 = this.parent;
        return (index > i5 && index < this.currentGroupEnd) || (i5 == 0 && index == 0);
    }

    public final boolean isNode() {
        int i5 = this.currentGroup;
        return i5 < this.currentGroupEnd && SlotTableKt.access$isNode(this.groups, groupIndexToAddress(i5));
    }

    public final void markGroup(int group) {
        int groupIndexToAddress = groupIndexToAddress(group);
        if (SlotTableKt.access$hasMark(this.groups, groupIndexToAddress)) {
            return;
        }
        SlotTableKt.access$updateMark(this.groups, groupIndexToAddress, true);
        if (SlotTableKt.access$containsMark(this.groups, groupIndexToAddress)) {
            return;
        }
        updateContainsMark(parent(group));
    }

    public final List<Anchor> moveFrom(SlotTable table, int index, boolean removeSourceGroup) {
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (index != 0 || this.currentGroup != 0 || this.table.getGroupsSize() != 0 || SlotTableKt.access$groupSize(table.getGroups(), index) != table.getGroupsSize()) {
            SlotWriter openWriter = table.openWriter();
            try {
                List<Anchor> moveGroup = INSTANCE.moveGroup(openWriter, index, this, true, true, removeSourceGroup);
                openWriter.close(true);
                return moveGroup;
            } catch (Throwable th) {
                openWriter.close(false);
                throw th;
            }
        }
        int[] iArr = this.groups;
        Object[] objArr = this.slots;
        ArrayList<Anchor> arrayList = this.anchors;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        int[] groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        Object[] slots = table.getSlots();
        int slotsSize = table.getSlotsSize();
        HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime_release = table.getSourceInformationMap$runtime_release();
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime_release = table.getCalledByMap$runtime_release();
        this.groups = groups;
        this.slots = slots;
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = groupsSize;
        this.groupGapLen = (groups.length / 5) - groupsSize;
        this.slotsGapStart = slotsSize;
        this.slotsGapLen = slots.length - slotsSize;
        this.slotsGapOwner = groupsSize;
        this.sourceInformationMap = sourceInformationMap$runtime_release;
        this.calledByMap = calledByMap$runtime_release;
        table.setTo$runtime_release(iArr, 0, objArr, 0, arrayList, hashMap, mutableIntObjectMap);
        return this.anchors;
    }

    public final void moveGroup(int offset) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (!(offset >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (offset == 0) {
            return;
        }
        int i5 = this.currentGroup;
        int i6 = this.parent;
        int i7 = this.currentGroupEnd;
        int i8 = i5;
        for (int i9 = offset; i9 > 0; i9--) {
            i8 += SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i8));
            if (!(i8 <= i7)) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
        }
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(i8));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i8));
        int i10 = i8 + access$groupSize;
        int dataIndex3 = dataIndex(this.groups, groupIndexToAddress(i10));
        int i11 = dataIndex3 - dataIndex2;
        insertSlots(i11, Math.max(this.currentGroup - 1, 0));
        insertGroups(access$groupSize);
        int[] iArr = this.groups;
        int groupIndexToAddress = groupIndexToAddress(i10) * 5;
        ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i5) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
        if (i11 > 0) {
            Object[] objArr = this.slots;
            ArraysKt.copyInto(objArr, objArr, dataIndex, dataIndexToDataAddress(dataIndex2 + i11), dataIndexToDataAddress(dataIndex3 + i11));
        }
        int i12 = dataIndex2 + i11;
        int i13 = i12 - dataIndex;
        int i14 = this.slotsGapStart;
        int i15 = this.slotsGapLen;
        int length = this.slots.length;
        int i16 = this.slotsGapOwner;
        int i17 = i5 + access$groupSize;
        int i18 = i5;
        while (i18 < i17) {
            int groupIndexToAddress2 = groupIndexToAddress(i18);
            int i19 = i14;
            int i20 = i13;
            updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i13, i16 < groupIndexToAddress2 ? 0 : i19, i15, length));
            i18++;
            i14 = i19;
            i13 = i20;
        }
        moveAnchors(i10, i5, access$groupSize);
        if (removeGroups(i10, access$groupSize)) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        fixParentAnchorsFor(i6, this.currentGroupEnd, i5);
        if (i11 > 0) {
            removeSlots(i12, i11, i10 - 1);
        }
    }

    public final List<Anchor> moveIntoGroupFrom(int offset, SlotTable table, int index) {
        ComposerKt.runtimeCheck(this.insertCount <= 0 && groupSize(this.currentGroup + offset) == 1);
        int i5 = this.currentGroup;
        int i6 = this.currentSlot;
        int i7 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter openWriter = table.openWriter();
        try {
            List<Anchor> moveGroup$default = Companion.moveGroup$default(INSTANCE, openWriter, index, this, false, true, false, 32, null);
            openWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i5;
            this.currentSlot = i6;
            this.currentSlotEnd = i7;
            return moveGroup$default;
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    public final Object node(int index) {
        int groupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int index) {
        return SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress(index));
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final boolean removeGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i5 = this.currentGroup;
        int i6 = this.currentSlot;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i5));
        int skipGroup = skipGroup();
        sourceInformationOf(this.parent);
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty() && prioritySet.peek() >= i5) {
                prioritySet.takeMax();
            }
        }
        boolean removeGroups = removeGroups(i5, this.currentGroup - i5);
        removeSlots(dataIndex, this.currentSlot - dataIndex, i5 - 1);
        this.currentGroup = i5;
        this.currentSlot = i6;
        this.nodeCount -= skipGroup;
        return removeGroups;
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final void set(Object value) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = value;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i5 = this.currentSlot;
        this.currentSlot = i5 + 1;
        return objArr[dataIndexToDataAddress(i5)];
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress);
    }

    public final void skipToGroupEnd() {
        int i5 = this.currentGroupEnd;
        this.currentGroup = i5;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i5));
    }

    public final Object slot(Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i5 = slotIndex + index;
        if (!(i5 >= slotIndex && i5 < dataIndex(this.groups, groupIndexToAddress(group + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + index + " for group " + group);
        }
        return i5;
    }

    public final int slotsEndAllIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + groupSize(groupIndex)));
    }

    public final int slotsEndIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsStartIndex$runtime_release(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(0, companion.getEmpty(), false, companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.INSTANCE.getEmpty());
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final void trimTailSlots(int count) {
        ComposerKt.runtimeCheck(count > 0);
        int i5 = this.parent;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i5));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i5 + 1)) - count;
        ComposerKt.runtimeCheck(dataIndex >= slotIndex);
        removeSlots(dataIndex, count, i5);
        int i6 = this.currentSlot;
        if (i6 >= slotIndex) {
            this.currentSlot = i6 - count;
        }
    }

    public final Anchor tryAnchor$runtime_release(int group) {
        if (group < 0 || group >= getSize$runtime_release()) {
            return null;
        }
        return SlotTableKt.access$find(this.anchors, group, getSize$runtime_release());
    }

    public final Object update(Object value) {
        if (this.insertCount <= 0 || this.currentSlot == this.slotsGapStart) {
            return rawUpdate(value);
        }
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i5 = 1;
        int i6 = 0;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(i6, i5, defaultConstructorMarker);
        }
        this.deferredSlotWrites = mutableIntObjectMap;
        int i7 = this.parent;
        MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i7);
        if (mutableObjectList == null) {
            mutableObjectList = new MutableObjectList<>(i6, i5, defaultConstructorMarker);
            mutableIntObjectMap.set(i7, mutableObjectList);
        }
        mutableObjectList.add(value);
        return Composer.INSTANCE.getEmpty();
    }

    public final void updateAux(Object value) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!SlotTableKt.access$hasAux(this.groups, groupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = value;
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i5) {
        return i5 >= getCapacity() ? this.slots.length - this.slotsGapLen : dataAnchorToDataIndex(SlotTableKt.access$dataAnchor(iArr, i5), this.slotsGapLen, this.slots.length);
    }

    private final int parent(int[] iArr, int i5) {
        return parentAnchorToIndex(SlotTableKt.access$parentAnchor(iArr, groupIndexToAddress(i5)));
    }

    public final boolean isNode(int index) {
        return SlotTableKt.access$isNode(this.groups, groupIndexToAddress(index));
    }

    public final Object slot(int groupIndex, int index) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
        int i5 = index + slotIndex;
        if (slotIndex <= i5 && i5 < dataIndex) {
            return this.slots[dataIndexToDataAddress(i5)];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final void updateNode(Anchor anchor, Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    public final Object set(int index, Object value) {
        return set(this.currentGroup, index, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int access$groupSize;
        int i5 = this.parent;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (objArr != false) {
            int i6 = this.currentGroup;
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(i6));
            insertGroups(1);
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
            int groupIndexToAddress = groupIndexToAddress(i6);
            Composer.Companion companion = Composer.INSTANCE;
            int i7 = objectKey != companion.getEmpty() ? 1 : 0;
            int i8 = (isNode || aux == companion.getEmpty()) ? 0 : 1;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (dataIndexToDataAnchor >= 0 && this.slotsGapOwner < i6) {
                dataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - dataIndexToDataAnchor) + 1);
            }
            SlotTableKt.access$initGroup(this.groups, groupIndexToAddress, key, isNode, i7, i8, this.parent, dataIndexToDataAnchor);
            int i9 = (isNode ? 1 : 0) + i7 + i8;
            if (i9 > 0) {
                insertSlots(i9, i6);
                Object[] objArr2 = this.slots;
                int i10 = this.currentSlot;
                if (isNode) {
                    objArr2[i10] = aux;
                    i10++;
                }
                if (i7 != 0) {
                    objArr2[i10] = objectKey;
                    i10++;
                }
                if (i8 != 0) {
                    objArr2[i10] = aux;
                    i10++;
                }
                this.currentSlot = i10;
            }
            this.nodeCount = 0;
            access$groupSize = i6 + 1;
            this.parent = i6;
            this.currentGroup = access$groupSize;
            if (i5 >= 0) {
                sourceInformationOf(i5);
            }
        } else {
            this.startStack.push(i5);
            saveCurrentGroupEnd();
            int i11 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i11);
            if (!Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress2);
            this.parent = i11;
            this.currentGroup = i11 + 1;
            access$groupSize = i11 + SlotTableKt.access$groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = access$groupSize;
    }

    public final Object set(int group, int index, Object value) {
        int dataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        Object[] objArr = this.slots;
        Object obj = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = value;
        return obj;
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }
}
