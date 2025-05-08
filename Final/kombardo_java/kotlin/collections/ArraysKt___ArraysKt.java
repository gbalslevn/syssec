package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000æ\u0001\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a*\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000e\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0017\u0010\u0016\u001a)\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\f2\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u0002\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001f\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010 \u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010!\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\"\u001a\u001f\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b#\u0010\u0016\u001a'\u0010$\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u0019\u0010$\u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b$\u0010 \u001a\u0019\u0010$\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010¢\u0006\u0004\b$\u0010!\u001a!\u0010%\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b%\u0010\u0016\u001a\u001f\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b&\u0010\u0016\u001a\u0011\u0010&\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010\u0016\u001a-\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010)\u001a\u00020\r¢\u0006\u0004\b+\u0010,\u001a+\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\b\b\u0000\u0010\u0000*\u00020-*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b.\u0010/\u001a?\u00103\u001a\u00028\u0000\"\u0010\b\u0000\u00101*\n\u0012\u0006\b\u0000\u0012\u00028\u000100\"\b\b\u0001\u0010\u0000*\u00020-*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u00102\u001a\u00028\u0000¢\u0006\u0004\b3\u00104\u001a-\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010)\u001a\u00020\r¢\u0006\u0004\b5\u0010,\u001aC\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00108\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000006j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`7¢\u0006\u0004\b9\u0010:\u001aA\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00108\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000006j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`7¢\u0006\u0004\b;\u0010<\u001a9\u0010=\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u00101*\n\u0012\u0006\b\u0000\u0012\u00028\u000000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u00102\u001a\u00028\u0001¢\u0006\u0004\b=\u00104\u001a/\u0010@\u001a\u0012\u0012\u0004\u0012\u00028\u00000>j\b\u0012\u0004\u0012\u00028\u0000`?\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b@\u0010A\u001a%\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bB\u0010/\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070**\u00020\u0006¢\u0006\u0004\bB\u0010C\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0**\u00020\t¢\u0006\u0004\bB\u0010D\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0**\u00020\f¢\u0006\u0004\bB\u0010E\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100**\u00020\u000f¢\u0006\u0004\bB\u0010F\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020H0**\u00020G¢\u0006\u0004\bB\u0010I\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020K0**\u00020J¢\u0006\u0004\bB\u0010L\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030**\u00020M¢\u0006\u0004\bB\u0010N\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130**\u00020\u0012¢\u0006\u0004\bB\u0010O\u001a%\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000P\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bQ\u0010/\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00070P*\u00020\u0006¢\u0006\u0004\bQ\u0010C\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\n0P*\u00020\t¢\u0006\u0004\bQ\u0010D\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\r0P*\u00020\f¢\u0006\u0004\bQ\u0010E\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00100P*\u00020\u000f¢\u0006\u0004\bQ\u0010F\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020H0P*\u00020G¢\u0006\u0004\bQ\u0010I\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020K0P*\u00020J¢\u0006\u0004\bQ\u0010L\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030P*\u00020M¢\u0006\u0004\bQ\u0010N\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130P*\u00020\u0012¢\u0006\u0004\bQ\u0010O\u001a%\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bS\u0010T\u001a+\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000V0U\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bW\u0010X\u001aJ\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[0*\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010Y*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\b\\\u0010]\u001aH\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[0*\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010Y*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00010UH\u0086\u0004¢\u0006\u0004\b\\\u0010^\u001a\u007f\u0010k\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010a*\u00060_j\u0002``*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010b\u001a\u00028\u00012\b\b\u0002\u0010d\u001a\u00020c2\b\b\u0002\u0010e\u001a\u00020c2\b\b\u0002\u0010f\u001a\u00020c2\b\b\u0002\u0010g\u001a\u00020\r2\b\b\u0002\u0010h\u001a\u00020c2\u0016\b\u0002\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020c\u0018\u00010i¢\u0006\u0004\bk\u0010l\u001aq\u0010k\u001a\u00028\u0000\"\f\b\u0000\u0010a*\u00060_j\u0002``*\u00020\u00062\u0006\u0010b\u001a\u00028\u00002\b\b\u0002\u0010d\u001a\u00020c2\b\b\u0002\u0010e\u001a\u00020c2\b\b\u0002\u0010f\u001a\u00020c2\b\b\u0002\u0010g\u001a\u00020\r2\b\b\u0002\u0010h\u001a\u00020c2\u0016\b\u0002\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020c\u0018\u00010i¢\u0006\u0004\bk\u0010m\u001ai\u0010o\u001a\u00020n\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010d\u001a\u00020c2\b\b\u0002\u0010e\u001a\u00020c2\b\b\u0002\u0010f\u001a\u00020c2\b\b\u0002\u0010g\u001a\u00020\r2\b\b\u0002\u0010h\u001a\u00020c2\u0016\b\u0002\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020c\u0018\u00010i¢\u0006\u0004\bo\u0010p\u001a[\u0010o\u001a\u00020n*\u00020\u00062\b\b\u0002\u0010d\u001a\u00020c2\b\b\u0002\u0010e\u001a\u00020c2\b\b\u0002\u0010f\u001a\u00020c2\b\b\u0002\u0010g\u001a\u00020\r2\b\b\u0002\u0010h\u001a\u00020c2\u0016\b\u0002\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020c\u0018\u00010i¢\u0006\u0004\bo\u0010q\u001a%\u0010r\u001a\b\u0012\u0004\u0012\u00028\u00000U\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\br\u0010X\u001a%\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00000s\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bt\u0010u\u001a\u0011\u0010v\u001a\u00020\r*\u00020\f¢\u0006\u0004\bv\u0010w\"#\u0010{\u001a\u00020x\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\u0006\u001a\u0004\by\u0010z\"\u0015\u0010{\u001a\u00020x*\u00020\f8F¢\u0006\u0006\u001a\u0004\by\u0010|\"#\u0010\u007f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\u0006\u001a\u0004\b}\u0010~\"\u0015\u0010\u007f\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b}\u0010w\"\u0016\u0010\u007f\u001a\u00020\r*\u00020\u000f8F¢\u0006\u0007\u001a\u0005\b}\u0010\u0080\u0001¨\u0006\u0081\u0001"}, d2 = {"T", BuildConfig.FLAVOR, "element", BuildConfig.FLAVOR, "contains", "([Ljava/lang/Object;Ljava/lang/Object;)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([BB)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([SS)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([II)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([JJ)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([CC)Z", "first", "([Ljava/lang/Object;)Ljava/lang/Object;", "firstOrNull", "index", "getOrNull", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([II)Ljava/lang/Integer;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "([BB)I", "([SS)I", "([II)I", "([JJ)I", "([CC)I", "last", "lastIndexOf", "lastOrNull", "single", "([C)C", "singleOrNull", "n", BuildConfig.FLAVOR, "drop", "([Ljava/lang/Object;I)Ljava/util/List;", BuildConfig.FLAVOR, "filterNotNull", "([Ljava/lang/Object;)Ljava/util/List;", BuildConfig.FLAVOR, "C", "destination", "filterNotNullTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "takeLast", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "toCollection", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "([Ljava/lang/Object;)Ljava/util/HashSet;", "toList", "([B)Ljava/util/List;", "([S)Ljava/util/List;", "([I)Ljava/util/List;", "([J)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([F)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([D)Ljava/util/List;", BuildConfig.FLAVOR, "([Z)Ljava/util/List;", "([C)Ljava/util/List;", BuildConfig.FLAVOR, "toMutableList", BuildConfig.FLAVOR, "toSet", "([Ljava/lang/Object;)Ljava/util/Set;", BuildConfig.FLAVOR, "Lkotlin/collections/IndexedValue;", "withIndex", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "R", "other", "Lkotlin/Pair;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", BuildConfig.FLAVOR, "separator", "prefix", "postfix", "limit", "truncated", "Lkotlin/Function1;", "transform", "joinTo", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", BuildConfig.FLAVOR, "joinToString", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "([BLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "asIterable", "Lkotlin/sequences/Sequence;", "asSequence", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "sum", "([I)I", "Lkotlin/ranges/IntRange;", "getIndices", "([Ljava/lang/Object;)Lkotlin/ranges/IntRange;", "indices", "([I)Lkotlin/ranges/IntRange;", "getLastIndex", "([Ljava/lang/Object;)I", "lastIndex", "([J)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes2.dex */
public abstract class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> asSequence(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? SequencesKt.emptySequence() : new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }

    public static <T> boolean contains(T[] tArr, T t5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt.indexOf(tArr, t5) >= 0;
    }

    public static <T> List<T> drop(T[] tArr, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i5 >= 0) {
            return takeLast(tArr, RangesKt.coerceAtLeast(tArr.length - i5, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    public static <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static <T> IntRange getIndices(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, ArraysKt.getLastIndex(tArr));
    }

    public static <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T getOrNull(T[] tArr, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i5 < 0 || i5 >= tArr.length) {
            return null;
        }
        return tArr[i5];
    }

    public static <T> int indexOf(T[] tArr, T t5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i5 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i5 < length) {
                if (tArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i5 < length2) {
            if (Intrinsics.areEqual(t5, tArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (T t5 : tArr) {
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

    public static /* synthetic */ Appendable joinTo$default(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        CharSequence charSequence5 = (i6 & 2) != 0 ? ", " : charSequence;
        int i7 = i6 & 4;
        CharSequence charSequence6 = BuildConfig.FLAVOR;
        CharSequence charSequence7 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(objArr, appendable, charSequence5, charSequence7, charSequence6, (i6 & 16) != 0 ? -1 : i5, (i6 & 32) != 0 ? "..." : charSequence4, (i6 & 64) != 0 ? null : function1);
    }

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
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
        return joinToString(objArr, charSequence, charSequence6, charSequence5, i8, charSequence7, function1);
    }

    public static <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[ArraysKt.getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> int lastIndexOf(T[] tArr, T t5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (t5 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    length = i5;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i6 = length2 - 1;
                    if (Intrinsics.areEqual(t5, tArr[length2])) {
                        return length2;
                    }
                    if (i6 < 0) {
                        break;
                    }
                    length2 = i6;
                }
            }
        }
        return -1;
    }

    public static <T> T lastOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static <T> T single(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T singleOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static int sum(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        return i5;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return CollectionsKt.emptyList();
        }
        int length = tArr.length;
        if (i5 >= length) {
            return ArraysKt.toList(tArr);
        }
        if (i5 == 1) {
            return CollectionsKt.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(tArr[i6]);
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t5 : tArr) {
            destination.add(t5);
        }
        return destination;
    }

    public static <T> HashSet<T> toHashSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (HashSet) toCollection(tArr, new HashSet(MapsKt.mapCapacity(tArr.length)));
    }

    public static <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return ArraysKt.toMutableList(tArr);
        }
        return CollectionsKt.listOf(tArr[0]);
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    public static <T> Set<T> toSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length))) : SetsKt.setOf(tArr[0]) : SetsKt.emptySet();
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator it;
                it = ArrayIteratorKt.iterator(tArr);
                return it;
            }
        });
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, R[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i5 = 0; i5 < min; i5++) {
            arrayList.add(TuplesKt.to(tArr[i5], other[i5]));
        }
        return arrayList;
    }

    public static boolean contains(byte[] bArr, byte b5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return indexOf(bArr, b5) >= 0;
    }

    public static IntRange getIndices(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntRange(0, ArraysKt.getLastIndex(iArr));
    }

    public static int getLastIndex(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    public static Integer getOrNull(int[] iArr, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i5 < 0 || i5 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i5]);
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
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
        return joinToString(bArr, charSequence, charSequence6, charSequence5, i8, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b5 : bArr) {
            arrayList.add(Byte.valueOf(b5));
        }
        return arrayList;
    }

    public static boolean contains(short[] sArr, short s5) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return indexOf(sArr, s5) >= 0;
    }

    public static int getLastIndex(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    public static boolean contains(int[] iArr, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return indexOf(iArr, i5) >= 0;
    }

    public static final List<Short> toMutableList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s5 : sArr) {
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    public static boolean contains(long[] jArr, long j5) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return ArraysKt.indexOf(jArr, j5) >= 0;
    }

    public static final int indexOf(byte[] bArr, byte b5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (b5 == bArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(int[] iArr, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (i5 == iArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    public static char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List<Byte> toList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return CollectionsKt.listOf(Byte.valueOf(bArr[0]));
    }

    public static boolean contains(char[] cArr, char c5) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return indexOf(cArr, c5) >= 0;
    }

    public static List<Integer> toMutableList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(Integer.valueOf(i5));
        }
        return arrayList;
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r5 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(tArr[i5], r5));
            i5++;
        }
        return arrayList;
    }

    public static final int indexOf(short[] sArr, short s5) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (s5 == sArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (byte b5 : bArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b5)));
            } else {
                buffer.append(String.valueOf((int) b5));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int lastIndexOf(long[] jArr, long j5) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (j5 == jArr[length]) {
                    return length;
                }
                if (i5 < 0) {
                    break;
                }
                length = i5;
            }
        }
        return -1;
    }

    public static final List<Long> toMutableList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j5 : jArr) {
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    public static final int indexOf(int[] iArr, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (i5 == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public static List<Short> toList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return CollectionsKt.listOf(Short.valueOf(sArr[0]));
    }

    public static final List<Float> toMutableList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f5 : fArr) {
            arrayList.add(Float.valueOf(f5));
        }
        return arrayList;
    }

    public static int indexOf(long[] jArr, long j5) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (j5 == jArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d5 : dArr) {
            arrayList.add(Double.valueOf(d5));
        }
        return arrayList;
    }

    public static final int indexOf(char[] cArr, char c5) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (c5 == cArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static List<Integer> toList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return ArraysKt.toMutableList(iArr);
        }
        return CollectionsKt.listOf(Integer.valueOf(iArr[0]));
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z5 : zArr) {
            arrayList.add(Boolean.valueOf(z5));
        }
        return arrayList;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c5 : cArr) {
            arrayList.add(Character.valueOf(c5));
        }
        return arrayList;
    }

    public static List<Long> toList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return CollectionsKt.listOf(Long.valueOf(jArr[0]));
    }

    public static List<Float> toList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return CollectionsKt.listOf(Float.valueOf(fArr[0]));
    }

    public static List<Double> toList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return CollectionsKt.listOf(Double.valueOf(dArr[0]));
    }

    public static List<Boolean> toList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return CollectionsKt.listOf(Boolean.valueOf(zArr[0]));
    }

    public static List<Character> toList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return CollectionsKt.listOf(Character.valueOf(cArr[0]));
    }
}
