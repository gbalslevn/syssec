package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0006\u0010\t\u001a\u001f\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\t\u001a'\u0010\r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001d\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0011\u0010\t\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0012\u0010\u0007\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0012\u0010\t\u001a\u001d\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u001d\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0013\u0010\t\u001a\u001f\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0014\u0010\u0007\u001a\u001f\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0014\u0010\t\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019\u001a=\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001e*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u001f\u0010 \u001a=\u0010$\u001a\u00028\u0000\"\u0010\b\u0000\u0010\"*\n\u0012\u0006\b\u0000\u0012\u00028\u00010!\"\b\b\u0001\u0010\u0000*\u00020\u001e*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%\u001a+\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)\u001a+\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b*\u0010\u0017\u001a+\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b+\u0010\u0019\u001a#\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b,\u0010 \u001a-\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000-*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b.\u0010 \u001a?\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000/j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`0¢\u0006\u0004\b2\u00103\u001a\u0017\u00106\u001a\u000205*\b\u0012\u0004\u0012\u00020\u000304¢\u0006\u0004\b6\u00107\u001a\u0017\u0010:\u001a\u000209*\b\u0012\u0004\u0012\u00020804¢\u0006\u0004\b:\u0010;\u001a\u0017\u0010=\u001a\u00020<*\b\u0012\u0004\u0012\u00020\u000b04¢\u0006\u0004\b=\u0010>\u001a\u0017\u0010A\u001a\u00020@*\b\u0012\u0004\u0012\u00020?04¢\u0006\u0004\bA\u0010B\u001a7\u0010C\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\"*\n\u0012\u0006\b\u0000\u0012\u00028\u00000!*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010#\u001a\u00028\u0001¢\u0006\u0004\bC\u0010%\u001a-\u0010F\u001a\u0012\u0012\u0004\u0012\u00028\u00000Dj\b\u0012\u0004\u0012\u00028\u0000`E\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bF\u0010G\u001a#\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bH\u0010 \u001a#\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bJ\u0010 \u001a#\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000004¢\u0006\u0004\bJ\u0010K\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bM\u0010N\u001aC\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010O*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\bQ\u0010\u001d\u001a)\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000R0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bS\u0010T\u001a#\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bU\u0010 \u001a4\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000L\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bW\u0010X\u001a#\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000Y\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bZ\u0010N\u001a4\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000L\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\b[\u0010X\u001a7\u0010\\\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u001d\u0010^\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b^\u0010_\u001a\u001b\u0010`\u001a\u0004\u0018\u000108*\b\u0012\u0004\u0012\u0002080\u0001H\u0007¢\u0006\u0004\b`\u0010a\u001a+\u0010`\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000-*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b`\u0010b\u001a\u001b\u0010c\u001a\u0004\u0018\u000108*\b\u0012\u0004\u0012\u0002080\u0001H\u0007¢\u0006\u0004\bc\u0010a\u001a+\u0010c\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000-*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bc\u0010b\u001a3\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010d\u001a\u00020\u000bH\u0007¢\u0006\u0004\be\u0010\u0017\u001a.\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bf\u0010g\u001a4\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bf\u0010i\u001a.\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bj\u0010g\u001a.\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bj\u0010k\u001a4\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bj\u0010i\u001a4\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000042\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bj\u0010l\u001aG\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010d\u001a\u00020\u000b2\b\b\u0002\u0010m\u001a\u00020\u000b2\b\b\u0002\u0010n\u001a\u00020\u0003H\u0007¢\u0006\u0004\bo\u0010p\u001aF\u0010r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010q0\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010O*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\br\u0010i\u001a}\u0010}\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010u*\u00060sj\u0002`t*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010v\u001a\u00028\u00012\b\b\u0002\u0010x\u001a\u00020w2\b\b\u0002\u0010y\u001a\u00020w2\b\b\u0002\u0010z\u001a\u00020w2\b\b\u0002\u0010{\u001a\u00020\u000b2\b\b\u0002\u0010|\u001a\u00020w2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020w\u0018\u00010\u001a¢\u0006\u0004\b}\u0010~\u001aj\u0010\u0080\u0001\u001a\u00020\u007f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010x\u001a\u00020w2\b\b\u0002\u0010y\u001a\u00020w2\b\b\u0002\u0010z\u001a\u00020w2\b\b\u0002\u0010{\u001a\u00020\u000b2\b\b\u0002\u0010|\u001a\u00020w2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020w\u0018\u00010\u001a¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a'\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u001c\u0010\u0087\u0001\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0001H\u0007¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0088\u0001"}, d2 = {"T", BuildConfig.FLAVOR, "element", BuildConfig.FLAVOR, "contains", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", BuildConfig.FLAVOR, "(Ljava/util/List;)Ljava/lang/Object;", "firstOrNull", BuildConfig.FLAVOR, "index", "getOrNull", "(Ljava/util/List;I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "last", "lastOrNull", "single", "singleOrNull", "n", "drop", "(Ljava/lang/Iterable;I)Ljava/util/List;", "dropLast", "(Ljava/util/List;I)Ljava/util/List;", "Lkotlin/Function1;", "predicate", "filter", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", BuildConfig.FLAVOR, "filterNotNull", "(Ljava/lang/Iterable;)Ljava/util/List;", BuildConfig.FLAVOR, "C", "destination", "filterNotNullTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "Lkotlin/ranges/IntRange;", "indices", "slice", "(Ljava/util/List;Lkotlin/ranges/IntRange;)Ljava/util/List;", "take", "takeLast", "reversed", BuildConfig.FLAVOR, "sorted", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toBooleanArray", "(Ljava/util/Collection;)[Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toFloatArray", "(Ljava/util/Collection;)[F", BuildConfig.FLAVOR, "toIntArray", "(Ljava/util/Collection;)[I", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toLongArray", "(Ljava/util/Collection;)[J", "toCollection", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "(Ljava/lang/Iterable;)Ljava/util/HashSet;", "toList", BuildConfig.FLAVOR, "toMutableList", "(Ljava/util/Collection;)Ljava/util/List;", BuildConfig.FLAVOR, "toSet", "(Ljava/lang/Iterable;)Ljava/util/Set;", "R", "transform", "map", "Lkotlin/collections/IndexedValue;", "withIndex", "(Ljava/lang/Iterable;)Ljava/lang/Iterable;", "distinct", "other", "intersect", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;", BuildConfig.FLAVOR, "toMutableSet", "union", "all", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Z", "any", "(Ljava/lang/Iterable;)Z", "maxOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "minOrNull", "size", "chunked", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/List;", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;Ljava/lang/Iterable;)Ljava/util/List;", "step", "partialWindows", "windowed", "(Ljava/lang/Iterable;IIZ)Ljava/util/List;", "Lkotlin/Pair;", "zip", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", BuildConfig.FLAVOR, "separator", "prefix", "postfix", "limit", "truncated", "joinTo", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", BuildConfig.FLAVOR, "joinToString", "(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;", "sumOfInt", "(Ljava/lang/Iterable;)I", "sum", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public abstract class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> boolean all(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    public static <T> Sequence<T> asSequence(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return windowed(iterable, i5, i5, true);
    }

    public static <T> boolean contains(Iterable<? extends T> iterable, T t5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t5) : CollectionsKt.indexOf(iterable, t5) >= 0;
    }

    public static <T> List<T> distinct(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.toList(CollectionsKt.toMutableSet(iterable));
    }

    public static <T> List<T> drop(Iterable<? extends T> iterable, int i5) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return CollectionsKt.toList(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i5;
            if (size <= 0) {
                return CollectionsKt.emptyList();
            }
            if (size == 1) {
                return CollectionsKt.listOf(CollectionsKt.last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i5 < size2) {
                        arrayList.add(list.get(i5));
                        i5++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i5);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i6 = 0;
        for (T t5 : iterable) {
            if (i6 >= i5) {
                arrayList.add(t5);
            } else {
                i6++;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> dropLast(List<? extends T> list, int i5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i5 >= 0) {
            return CollectionsKt.take(list, RangesKt.coerceAtLeast(list.size() - i5, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }

    public static <T> List<T> filter(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t5 : iterable) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    public static <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T getOrNull(List<? extends T> list, int i5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return list.get(i5);
    }

    public static <T> int indexOf(Iterable<? extends T> iterable, T t5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t5);
        }
        int i5 = 0;
        for (T t6 : iterable) {
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t5, t6)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (T t5 : iterable) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            StringsKt.appendElement(buffer, t5, function1);
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        CharSequence charSequence5 = (i6 & 2) != 0 ? ", " : charSequence;
        int i7 = i6 & 4;
        CharSequence charSequence6 = BuildConfig.FLAVOR;
        CharSequence charSequence7 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(iterable, appendable, charSequence5, charSequence7, charSequence6, (i6 & 16) != 0 ? -1 : i5, (i6 & 32) != 0 ? "..." : charSequence4, (i6 & 64) != 0 ? null : function1);
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i5, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        int i7 = i6 & 2;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i8 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence6, charSequence5, i8, charSequence7, function1);
    }

    public static <T> T last(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T lastOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> List<R> map(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    /* renamed from: maxOrNull */
    public static Float m3668maxOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOrNull */
    public static Float m3669minOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, T t5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean z5 = false;
        for (T t6 : iterable) {
            boolean z6 = true;
            if (!z5 && Intrinsics.areEqual(t6, t5)) {
                z5 = true;
                z6 = false;
            }
            if (z6) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Iterable<? extends T> iterable, T t5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Object) t5);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, iterable);
        arrayList.add(t5);
        return arrayList;
    }

    public static <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    public static <T> T single(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T singleOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> List<T> slice(List<? extends T> list, IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : CollectionsKt.toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        ArraysKt.sort((Comparable[]) array);
        return ArraysKt.asList(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        ArraysKt___ArraysJvmKt.sortWith(array, comparator);
        return ArraysKt.asList(array);
    }

    public static int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += it.next().intValue();
        }
        return i5;
    }

    public static <T> List<T> take(Iterable<? extends T> iterable, int i5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return CollectionsKt.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i5 >= ((Collection) iterable).size()) {
                return CollectionsKt.toList(iterable);
            }
            if (i5 == 1) {
                return CollectionsKt.listOf(CollectionsKt.first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i5);
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> takeLast(List<? extends T> list, int i5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return CollectionsKt.emptyList();
        }
        int size = list.size();
        if (i5 >= size) {
            return CollectionsKt.toList(list);
        }
        if (i5 == 1) {
            return CollectionsKt.listOf(CollectionsKt.last((List) list));
        }
        ArrayList arrayList = new ArrayList(i5);
        if (list instanceof RandomAccess) {
            for (int i6 = size - i5; i6 < size; i6++) {
                arrayList.add(list.get(i6));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i5);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static boolean[] toBooleanArray(Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            zArr[i5] = it.next().booleanValue();
            i5++;
        }
        return zArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            fArr[i5] = it.next().floatValue();
            i5++;
        }
        return fArr;
    }

    public static <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 12))));
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = it.next().intValue();
            i5++;
        }
        return iArr;
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt.emptyList();
        }
        if (size != 1) {
            return CollectionsKt.toMutableList(collection);
        }
        return CollectionsKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static long[] toLongArray(Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr[i5] = it.next().longValue();
            i5++;
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return CollectionsKt.toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return SetsKt.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(MapsKt.mapCapacity(collection.size())));
        }
        return SetsKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = CollectionsKt.toMutableSet(iterable);
        CollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i5, int i6, boolean z5) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(i5, i6);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i5, i6, z5, false);
            while (windowedIterator.hasNext()) {
                arrayList.add((List) windowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i6) + (size % i6 == 0 ? 0 : 1));
        int i7 = 0;
        while (i7 >= 0 && i7 < size) {
            int coerceAtMost = RangesKt.coerceAtMost(i5, size - i7);
            if (coerceAtMost < i5 && !z5) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(coerceAtMost);
            for (int i8 = 0; i8 < coerceAtMost; i8++) {
                arrayList3.add(list.get(i8 + i7));
            }
            arrayList2.add(arrayList3);
            i7 += i6;
        }
        return arrayList2;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator it;
                it = iterable.iterator();
                return it;
            }
        });
    }

    public static <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), CollectionsKt.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection convertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(elements);
        if (convertToListIfNotCollection.isEmpty()) {
            return CollectionsKt.toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            if (!convertToListIfNotCollection.contains(t5)) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T t5) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t5);
        return arrayList;
    }

    public static <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T singleOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return CollectionsKt.plus((Collection) iterable, (Iterable) elements);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, iterable);
        CollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> T single(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt.addAll(arrayList2, elements);
        return arrayList2;
    }
}
