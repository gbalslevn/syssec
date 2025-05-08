package com.ionspin.kotlin.bignum.integer.base63.array;

import com.adjust.sdk.Constants;
import com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic;
import com.ionspin.kotlin.bignum.integer.Quadruple;
import com.ionspin.kotlin.bignum.integer.Sextuple;
import com.ionspin.kotlin.bignum.integer.base32.BigInteger32Arithmetic;
import com.ionspin.kotlin.bignum.integer.util.DigitUtilKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.UCollectionsKt;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b$\n\u0002\u0010\u0011\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002ö\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u000bJ5\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0019\u0010\u0018\u001a\u00020\u0015*\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u001d\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\u001d\u0010&\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\"J\u001b\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001b\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010%J%\u00102\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J%\u00104\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00101J3\u00109\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J%\u0010<\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J3\u0010B\u001a\u00020?2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ%\u0010E\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ3\u0010G\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010\u000bJ%\u0010I\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010DJ%\u0010K\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010DJ+\u0010P\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ#\u0010T\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010DJ#\u0010W\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bU\u0010VJ+\u0010Z\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bX\u0010YJ%\u0010_\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\\H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010VJ5\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070b2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010dJ#\u0010i\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u00101J/\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040l2\u0006\u0010j\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010nJ\u001d\u0010q\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bp\u0010*J\u001d\u0010u\u001a\u00020r2\u0006\u0010.\u001a\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010tJ\u001d\u0010x\u001a\u00020\u00042\u0006\u0010.\u001a\u00020rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010wJ1\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040l2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010nJ\u001c\u0010}\u001a\u00020\u0019*\u00020\u00192\u0006\u0010{\u001a\u00020\u0019H\u0080\u0002¢\u0006\u0004\b|\u0010\u001bJ\u001c\u0010\u007f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010{\u001a\u00020\u0019H\u0080\u0002¢\u0006\u0004\b~\u0010\u001bJ\u001e\u0010\u0081\u0001\u001a\u00020\u0019*\u00020\u00192\u0006\u0010{\u001a\u00020\u0019H\u0080\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u001bJ\u001e\u0010\u0083\u0001\u001a\u00020\u0019*\u00020\u00192\u0006\u0010{\u001a\u00020\u0019H\u0080\u0002¢\u0006\u0005\b\u0082\u0001\u0010\u001bJ\u001f\u0010\u0086\u0001\u001a\u00020\u0019*\u00020\u00192\u0006\u0010/\u001a\u00020\u0007H\u0080\u0004¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001f\u0010\u0088\u0001\u001a\u00020\u0019*\u00020\u00192\u0006\u0010/\u001a\u00020\u0007H\u0080\u0004¢\u0006\u0006\b\u0087\u0001\u0010\u0085\u0001J%\u0010\u008b\u0001\u001a\u00020\u0019*\u00020\u00192\u0006\u0010.\u001a\u00020\u0004H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J-\u0010\u0090\u0001\u001a\u00020\u00042\b\u0010\u008d\u0001\u001a\u00030\u008c\u00012\u0006\u0010[\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J)\u0010\u0093\u0001\u001a\u00030\u008c\u00012\u0006\u0010.\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J(\u0010\u008b\u0001\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0095\u0001\u0010DJ(\u0010\u0097\u0001\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0096\u0001\u0010DJ$\u0010\u0088\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0098\u0001\u00101J$\u0010\u0086\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0099\u0001\u00101J#\u0010}\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009a\u0001\u0010DJ#\u0010\u007f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009b\u0001\u0010DJ$\u0010\u0081\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009c\u0001\u0010DJ#\u0010}\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u001fH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009d\u0001\u0010VJ#\u0010\u007f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u001fH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009e\u0001\u0010VJ$\u0010\u0081\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u001fH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u009f\u0001\u0010VJ$\u0010\u0083\u0001\u001a\u00020\u0004*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b \u0001\u0010DJ0\u0010¢\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040l*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¡\u0001\u0010nJ$\u0010¤\u0001\u001a\u00020\u0007*\u00020\u00042\u0006\u0010{\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b£\u0001\u0010;J%\u0010¤\u0001\u001a\u00020\u0007*\u00020\u00042\u0006\u0010{\u001a\u00020\u001fH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001b\u0010¨\u0001\u001a\u00020r*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b§\u0001\u0010tJ\u001b\u0010ª\u0001\u001a\u00020\u0004*\u00020rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b©\u0001\u0010wJ!\u0010®\u0001\u001a\u00020\u00042\u0007\u0010«\u0001\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\"\u0010³\u0001\u001a\u00020\u00042\b\u0010°\u0001\u001a\u00030¯\u0001H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b±\u0001\u0010²\u0001J\"\u0010¸\u0001\u001a\u00020\u00042\b\u0010µ\u0001\u001a\u00030´\u0001H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001J\"\u0010½\u0001\u001a\u00020\u00042\b\u0010º\u0001\u001a\u00030¹\u0001H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J$\u0010À\u0001\u001a\u00020\u00042\u0007\u0010¾\u0001\u001a\u00020\\H\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b¿\u0001\u0010\u00ad\u0001J$\u0010Ã\u0001\u001a\u00020\u00042\u0007\u0010Á\u0001\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010²\u0001J%\u0010Ç\u0001\u001a\u00020\u00042\b\u0010Å\u0001\u001a\u00030Ä\u0001H\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\bÆ\u0001\u0010·\u0001J%\u0010Ë\u0001\u001a\u00020\u00042\b\u0010É\u0001\u001a\u00030È\u0001H\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\bÊ\u0001\u0010¼\u0001R \u0010Í\u0001\u001a\u00030Ì\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001R(\u0010Ñ\u0001\u001a\u00020\u00048\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bÑ\u0001\u0010Î\u0001\u001a\u0006\bÒ\u0001\u0010Ð\u0001R(\u0010Ó\u0001\u001a\u00020\u00048\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bÓ\u0001\u0010Î\u0001\u001a\u0006\bÔ\u0001\u0010Ð\u0001R(\u0010Õ\u0001\u001a\u00020\u00048\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bÕ\u0001\u0010Î\u0001\u001a\u0006\bÖ\u0001\u0010Ð\u0001R(\u0010×\u0001\u001a\u00020\u00048\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\b×\u0001\u0010Î\u0001\u001a\u0006\bØ\u0001\u0010Ð\u0001R%\u0010Ù\u0001\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Î\u0001\u001a\u0006\bÚ\u0001\u0010Ð\u0001R\u001f\u0010Û\u0001\u001a\u00020\u00078\u0016X\u0096D¢\u0006\u0010\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u001f\u0010ß\u0001\u001a\u00020\u00078\u0006X\u0086D¢\u0006\u0010\n\u0006\bß\u0001\u0010Ü\u0001\u001a\u0006\bà\u0001\u0010Þ\u0001R(\u0010á\u0001\u001a\u00020\u001f8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001R%\u0010å\u0001\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bå\u0001\u0010Î\u0001\u001a\u0006\bæ\u0001\u0010Ð\u0001R(\u0010ç\u0001\u001a\u00020\u001f8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bç\u0001\u0010â\u0001\u001a\u0006\bè\u0001\u0010ä\u0001R(\u0010é\u0001\u001a\u00020\u001f8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bé\u0001\u0010â\u0001\u001a\u0006\bê\u0001\u0010ä\u0001R(\u0010ë\u0001\u001a\u00020\u001f8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0006\bë\u0001\u0010â\u0001\u001a\u0006\bì\u0001\u0010ä\u0001R\u001c\u0010í\u0001\u001a\u00020\u00198\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001R&\u0010ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040ñ\u00018\u0006ø\u0001\u0000¢\u0006\u0010\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006÷\u0001"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic;", "Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "<init>", "()V", "Lkotlin/ULongArray;", "first", "second", BuildConfig.FLAVOR, "firstCorrectedSize", "secondCorrectedSize", "multiplyWithCorrectedSize-mwLU0fg", "([J[JII)[J", "multiplyWithCorrectedSize", "firstCorrectedSizeStart", "secondCorrectedSizeStart", "basecaseMultiplyWithCorrectedSize-mwLU0fg", "basecaseMultiplyWithCorrectedSize", "firstUnsigned", "secondUnsigned", "karatsubaMultiplyWithCorrectedSizes-mwLU0fg", "karatsubaMultiplyWithCorrectedSizes", BuildConfig.FLAVOR, "isZero-QwZRm1k", "([J)Z", "isZero", "Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "signedAdd", "(Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;)Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "signedSubtract", "signedMultiply", "signedDivide", "Lkotlin/ULong;", "value", "numberOfLeadingZerosInAWord-VKZWuLQ", "(J)I", "numberOfLeadingZerosInAWord", "bitLength-QwZRm1k", "([J)I", "bitLength", "bitLength-VKZWuLQ", "bigInteger", "removeLeadingZeros-JIhQxVY", "([J)[J", "removeLeadingZeros", "countLeadingZeroWords-QwZRm1k", "countLeadingZeroWords", "operand", "places", "shiftLeft-GERUpyg", "([JI)[J", "shiftLeft", "shiftRight-GERUpyg", "shiftRight", "firstStart", "secondStart", "compareWithStartIndexes-MccmUSY", "([J[JII)I", "compareWithStartIndexes", "compare-GR1PJdc", "([J[J)I", "compare", "resultArray", "resultArrayStart", BuildConfig.FLAVOR, "baseAddIntoArray-KsfQWN0", "([JI[J[J)V", "baseAddIntoArray", "add-j68ebKY", "([J[J)[J", "add", "subtractWithStartIndexes-mwLU0fg", "subtractWithStartIndexes", "subtract-j68ebKY", "subtract", "multiply-j68ebKY", "multiply", "original", "numberOfWords", "extendULongArray-9R_UfW4", "([JIJ)[J", "extendULongArray", "firstUnchecked", "secondUnchecked", "toomCook3Multiply-j68ebKY", "toomCook3Multiply", "baseMultiply-ss9iZGw", "([JJ)[J", "baseMultiply", "baseMultiplyWithCorrectedSize-_EW1lsA", "([JJI)[J", "baseMultiplyWithCorrectedSize", "base", BuildConfig.FLAVOR, "exponent", "pow-GERUpyg", "pow", "dividend", "divisor", "Lkotlin/Triple;", "normalize-GR1PJdc", "([J[J)Lkotlin/Triple;", "normalize", "remainderNormalized", "normalizationShift", "denormalize-GERUpyg", "denormalize", "unnormalizedDividend", "unnormalizedDivisor", "Lkotlin/Pair;", "baseDivide-GR1PJdc", "([J[J)Lkotlin/Pair;", "baseDivide", "convertTo64BitRepresentation-JIhQxVY$bignum", "convertTo64BitRepresentation", "Lkotlin/UIntArray;", "convertTo32BitRepresentation-kqpWZOw$bignum", "([J)[I", "convertTo32BitRepresentation", "convertFrom32BitRepresentation-ehPNNiw$bignum", "([I)[J", "convertFrom32BitRepresentation", "divide-GR1PJdc", "divide", "other", "plus$bignum", "plus", "minus$bignum", "minus", "times$bignum", "times", "div$bignum", "div", "shr$bignum", "(Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;I)Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "shr", "shl$bignum", "shl", "and-SIFponk$bignum", "(Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;[J)Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "and", BuildConfig.FLAVOR, "number", "parseForBase-_llDaS8", "(Ljava/lang/String;I)[J", "parseForBase", "toString-tBf0fek", "([JI)Ljava/lang/String;", "toString", "mask", "and-j68ebKY", "xor-j68ebKY", "xor", "shl-GERUpyg$bignum", "shr-GERUpyg$bignum", "plus-j68ebKY$bignum", "minus-j68ebKY$bignum", "times-j68ebKY$bignum", "plus-ss9iZGw$bignum", "minus-ss9iZGw$bignum", "times-ss9iZGw$bignum", "div-j68ebKY$bignum", "divrem-GR1PJdc$bignum", "divrem", "compareTo-GR1PJdc$bignum", "compareTo", "compareTo-3yFGk1Y$bignum", "([JJ)I", "to32Bit-kqpWZOw$bignum", "to32Bit", "from32Bit-ehPNNiw$bignum", "from32Bit", "uLong", "fromULong--GCcj4Q", "(J)[J", "fromULong", "Lkotlin/UInt;", "uInt", "fromUInt-kOc6_GI", "(I)[J", "fromUInt", "Lkotlin/UShort;", "uShort", "fromUShort-jOPi9CM", "(S)[J", "fromUShort", "Lkotlin/UByte;", "uByte", "fromUByte-ab45Ak8", "(B)[J", "fromUByte", Constants.LONG, "fromLong-DHQ6RzY", "fromLong", "int", "fromInt-DHQ6RzY", "fromInt", BuildConfig.FLAVOR, "short", "fromShort-DHQ6RzY", "fromShort", BuildConfig.FLAVOR, "byte", "fromByte-DHQ6RzY", "fromByte", BuildConfig.FLAVOR, "_emitLongArray", "[J", "get_emitLongArray", "()[J", "ZERO", "getZERO-Y2RjT0g", "ONE", "getONE-Y2RjT0g", "TWO", "getTWO-Y2RjT0g", "TEN", "getTEN-Y2RjT0g", "reciprocalOf3In2ToThePowerOf63", "getReciprocalOf3In2ToThePowerOf63-Y2RjT0g", "basePowerOfTwo", "I", "getBasePowerOfTwo", "()I", "wordSizeInBits", "getWordSizeInBits", "baseMask", "J", "getBaseMask-s-VKNKU", "()J", "baseMaskArray", "getBaseMaskArray-Y2RjT0g", "lowMask", "getLowMask-s-VKNKU", "highMask", "getHighMask-s-VKNKU", "overflowMask", "getOverflowMask-s-VKNKU", "SIGNED_POSITIVE_TWO", "Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "getSIGNED_POSITIVE_TWO", "()Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", BuildConfig.FLAVOR, "powersOf10", "[Lkotlin/ULongArray;", "getPowersOf10", "()[Lkotlin/ULongArray;", "SignedULongArray", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BigInteger63Arithmetic implements BigIntegerArithmetic {
    public static final BigInteger63Arithmetic INSTANCE;
    private static final long[] ONE;
    private static final SignedULongArray SIGNED_POSITIVE_TWO;
    private static final long[] TEN;
    private static final long[] TWO;
    private static final long[] ZERO;
    private static final long[] _emitLongArray;
    private static final long baseMask;
    private static final long[] baseMaskArray;
    private static final int basePowerOfTwo;
    private static final long highMask;
    private static final long lowMask;
    private static final long overflowMask;
    private static final ULongArray[] powersOf10;
    private static final long[] reciprocalOf3In2ToThePowerOf63;
    private static final int wordSizeInBits;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", BuildConfig.FLAVOR, "Lkotlin/ULongArray;", "unsignedValue", BuildConfig.FLAVOR, "sign", "<init>", "([JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "copy-tBf0fek", "([JZ)Lcom/ionspin/kotlin/bignum/integer/base63/array/BigInteger63Arithmetic$SignedULongArray;", "copy", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "[J", "getUnsignedValue-Y2RjT0g", "()[J", "Z", "getSign", "()Z", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SignedULongArray {
        private final boolean sign;
        private final long[] unsignedValue;

        public /* synthetic */ SignedULongArray(long[] jArr, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(jArr, z5);
        }

        /* renamed from: copy-tBf0fek$default, reason: not valid java name */
        public static /* synthetic */ SignedULongArray m3027copytBf0fek$default(SignedULongArray signedULongArray, long[] jArr, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                jArr = signedULongArray.unsignedValue;
            }
            if ((i5 & 2) != 0) {
                z5 = signedULongArray.sign;
            }
            return signedULongArray.m3028copytBf0fek(jArr, z5);
        }

        /* renamed from: copy-tBf0fek, reason: not valid java name */
        public final SignedULongArray m3028copytBf0fek(long[] unsignedValue, boolean sign) {
            Intrinsics.checkNotNullParameter(unsignedValue, "unsignedValue");
            return new SignedULongArray(unsignedValue, sign, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignedULongArray)) {
                return false;
            }
            SignedULongArray signedULongArray = (SignedULongArray) other;
            return ULongArray.m3634equalsimpl0(this.unsignedValue, signedULongArray.unsignedValue) && this.sign == signedULongArray.sign;
        }

        public final boolean getSign() {
            return this.sign;
        }

        /* renamed from: getUnsignedValue-Y2RjT0g, reason: not valid java name and from getter */
        public final long[] getUnsignedValue() {
            return this.unsignedValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int m3637hashCodeimpl = ULongArray.m3637hashCodeimpl(this.unsignedValue) * 31;
            boolean z5 = this.sign;
            int i5 = z5;
            if (z5 != 0) {
                i5 = 1;
            }
            return m3637hashCodeimpl + i5;
        }

        public String toString() {
            return "SignedULongArray(unsignedValue=" + ((Object) ULongArray.m3641toStringimpl(this.unsignedValue)) + ", sign=" + this.sign + ')';
        }

        private SignedULongArray(long[] jArr, boolean z5) {
            this.unsignedValue = jArr;
            this.sign = z5;
        }
    }

    static {
        BigInteger63Arithmetic bigInteger63Arithmetic = new BigInteger63Arithmetic();
        INSTANCE = bigInteger63Arithmetic;
        _emitLongArray = new long[0];
        ZERO = new long[]{0};
        ONE = new long[]{1};
        TWO = new long[]{2};
        TEN = new long[]{10};
        reciprocalOf3In2ToThePowerOf63 = new long[]{3074457345618258603L};
        basePowerOfTwo = 63;
        wordSizeInBits = 63;
        baseMask = Long.MAX_VALUE;
        baseMaskArray = new long[]{Long.MAX_VALUE};
        lowMask = 4294967295L;
        highMask = 9223372032559808512L;
        overflowMask = Long.MIN_VALUE;
        SIGNED_POSITIVE_TWO = new SignedULongArray(bigInteger63Arithmetic.mo2949getTWOY2RjT0g(), true, null);
        powersOf10 = new ULongArray[]{ULongArray.m3628boximpl(new long[]{1}), ULongArray.m3628boximpl(new long[]{10}), ULongArray.m3628boximpl(new long[]{100}), ULongArray.m3628boximpl(new long[]{1000}), ULongArray.m3628boximpl(new long[]{10000}), ULongArray.m3628boximpl(new long[]{100000}), ULongArray.m3628boximpl(new long[]{1000000}), ULongArray.m3628boximpl(new long[]{10000000}), ULongArray.m3628boximpl(new long[]{100000000}), ULongArray.m3628boximpl(new long[]{1000000000}), ULongArray.m3628boximpl(new long[]{10000000000L}), ULongArray.m3628boximpl(new long[]{100000000000L}), ULongArray.m3628boximpl(new long[]{1000000000000L}), ULongArray.m3628boximpl(new long[]{10000000000000L}), ULongArray.m3628boximpl(new long[]{100000000000000L}), ULongArray.m3628boximpl(new long[]{1000000000000000L}), ULongArray.m3628boximpl(new long[]{10000000000000000L}), ULongArray.m3628boximpl(new long[]{100000000000000000L}), ULongArray.m3628boximpl(new long[]{1000000000000000000L}), ULongArray.m3628boximpl(new long[]{776627963145224192L, 1}), ULongArray.m3628boximpl(new long[]{7766279631452241920L, 10}), ULongArray.m3628boximpl(new long[]{3875820019684212736L, 108}), ULongArray.m3628boximpl(new long[]{1864712049423024128L, 1084}), ULongArray.m3628boximpl(new long[]{200376420520689664L, 10842}), ULongArray.m3628boximpl(new long[]{2003764205206896640L, 108420}), ULongArray.m3628boximpl(new long[]{1590897978359414784L, 1084202}), ULongArray.m3628boximpl(new long[]{6685607746739372032L, 10842021}), ULongArray.m3628boximpl(new long[]{2292473209410289664L, 108420217}), ULongArray.m3628boximpl(new long[]{4477988020393345024L, 1084202172}), ULongArray.m3628boximpl(new long[]{7886392056514347008L, 10842021724L}), ULongArray.m3628boximpl(new long[]{5076944270305263616L, 108420217248L}), ULongArray.m3628boximpl(new long[]{4652582518778757120L, 1084202172485L}), ULongArray.m3628boximpl(new long[]{408965003513692160L, 10842021724855L}), ULongArray.m3628boximpl(new long[]{4089650035136921600L, 108420217248550L}), ULongArray.m3628boximpl(new long[]{4003012203950112768L, 1084202172485504L}), ULongArray.m3628boximpl(new long[]{3136633892082024448L, 10842021724855044L}), ULongArray.m3628boximpl(new long[]{3696222810255917056L, 108420217248550443L}), ULongArray.m3628boximpl(new long[]{68739955140067328L, 1084202172485504434L}), ULongArray.m3628boximpl(new long[]{687399551400673280L, 1618649688000268532L, 1}), ULongArray.m3628boximpl(new long[]{6873995514006732800L, 6963124843147909512L, 11}), ULongArray.m3628boximpl(new long[]{4176350882083897344L, 5067644173495664471L, 117}), ULongArray.m3628boximpl(new long[]{4870020673419870208L, 4559581550682765674L, 1175}), ULongArray.m3628boximpl(new long[]{2583346549924823040L, 8702327359408553513L, 11754}), ULongArray.m3628boximpl(new long[]{7386721425538678784L, 4012925262392552860L, 117549}), ULongArray.m3628boximpl(new long[]{80237960548581376L, 3235764476506425376L, 1175494}), ULongArray.m3628boximpl(new long[]{802379605485813760L, 4687528654499926336L, 11754943}), ULongArray.m3628boximpl(new long[]{8023796054858137600L, 758426360725384320L, 117549435}), ULongArray.m3628boximpl(new long[]{6450984253743169536L, 7584263607253843208L, 1175494350}), ULongArray.m3628boximpl(new long[]{9169610316303040512L, 2055659777700225622L, 11754943508L}), ULongArray.m3628boximpl(new long[]{8685754831337422848L, 2109853703292704613L, 117549435082L}), ULongArray.m3628boximpl(new long[]{3847199981681246208L, 2651792959217494523L, 1175494350822L}), ULongArray.m3628boximpl(new long[]{1578511669393358848L, 8071185518465393618L, 11754943508222L}), ULongArray.m3628boximpl(new long[]{6561744657078812672L, 6924878889815729717L, 117549435082228L}), ULongArray.m3628boximpl(new long[]{1053842312804696064L, 4685184640173866521L, 1175494350822287L}), ULongArray.m3628boximpl(new long[]{1315051091192184832L, 734986217464786171L, 11754943508222875L}), ULongArray.m3628boximpl(new long[]{3927138875067072512L, 7349862174647861711L, 117549435082228750L}), ULongArray.m3628boximpl(new long[]{2377900603251621888L, 8935017488495186458L, 1175494350822287507L}), ULongArray.m3628boximpl(new long[]{5332261958806667264L, 6339826553258882310L, 2531571471368099271L, 1}), ULongArray.m3628boximpl(new long[]{7205759403792793600L, 8058033311460168257L, 6868970639971441100L, 12}), ULongArray.m3628boximpl(new long[]{7493989779944505344L, 6793356819763476113L, 4126102141730980352L, 127}), ULongArray.m3628boximpl(new long[]{1152921504606846976L, 3369963939651330482L, 4367533269890700295L, 1274}), ULongArray.m3628boximpl(new long[]{2305843009213693952L, 6029523285948977397L, 6781844551487899721L, 12744}), ULongArray.m3628boximpl(new long[]{4611686018427387904L, 4955000638361119124L, 3254841256895566560L, 127447}), ULongArray.m3628boximpl(new long[]{0, 3433146199337312205L, 4878296458391338181L, 1274473}), ULongArray.m3628boximpl(new long[]{0, 6661345882808794626L, 2666104399639502773L, 12744735}), ULongArray.m3628boximpl(new long[]{0, 2049854570104515604L, 8214299922685476121L, 127447352}), ULongArray.m3628boximpl(new long[]{0, 2051801627335604424L, 8356022932016554748L, 1274473528}), ULongArray.m3628boximpl(new long[]{0, 2071272199646492624L, 549880988472565210L, 12744735289L}), ULongArray.m3628boximpl(new long[]{0, 2265977922755374624L, 5498809884725652102L, 127447352890L}), ULongArray.m3628boximpl(new long[]{0, 4213035153844194624L, 8871238662982641982L, 1274473528905L}), ULongArray.m3628boximpl(new long[]{0, 5236863391022843008L, 5702038298133437552L, 12744735289059L}), ULongArray.m3628boximpl(new long[]{0, 6251773725954551040L, 1680150760205720677L, 127447352890596L}), ULongArray.m3628boximpl(new long[]{0, 7177505038416855552L, 7578135565202430968L, 1274473528905961L}), ULongArray.m3628boximpl(new long[]{0, 7211446126185124864L, 1994379357186103223L, 12744735289059618L}), ULongArray.m3628boximpl(new long[]{0, 7550857003867817984L, 1497049498151480621L, 127447352890596182L}), ULongArray.m3628boximpl(new long[]{0, 1721593743839973376L, 5747122944660030410L, 1274473528905961821L}), ULongArray.m3628boximpl(new long[]{0, 7992565401544957952L, 2130997225471649253L, 3521363252204842408L, 1}), ULongArray.m3628boximpl(new long[]{0, 6138677720611373056L, 2863228181006940922L, 7543516411484096658L, 13}), ULongArray.m3628boximpl(new long[]{0, 6046544984985075712L, 962165699505081802L, 1648187820002760119L, 138}), ULongArray.m3628boximpl(new long[]{0, 5125217628722102272L, 398284958196042218L, 7258506163172825383L, 1381}), ULongArray.m3628boximpl(new long[]{0, 5135316102947143680L, 3982849581960422185L, 8021457373744823174L, 13817}), ULongArray.m3628boximpl(new long[]{0, 5236300845197557760L, 2935007672185118623L, 6427597442610025280L, 138178}), ULongArray.m3628boximpl(new long[]{0, 6246148267701698560L, 1679960611286858811L, 8935742204971597955L, 1381786}), ULongArray.m3628boximpl(new long[]{0, 7121250455888330752L, 7576234076013812308L, 6347073718022997279L, 13817869}), ULongArray.m3628boximpl(new long[]{0, 6648900300899876864L, 1975364465299916623L, 8130504959101317950L, 138178696}), ULongArray.m3628boximpl(new long[]{0, 1925398751015337984L, 1306900579289614621L, 7518073296174973038L, 1381786968}), ULongArray.m3628boximpl(new long[]{0, 807243436443828224L, 3845633756041370404L, 1393756666911523917L, 13817869688L}), ULongArray.m3628boximpl(new long[]{0, 8072434364438282240L, 1562849412994600808L, 4714194632260463366L, 138178696881L}), ULongArray.m3628boximpl(new long[]{0, 6937367349544615936L, 6405122093091232280L, 1025086138330754621L, 1381786968815L}), ULongArray.m3628boximpl(new long[]{0, 4810069237462728704L, 8710988709783667959L, 1027489346452770408L, 13817869688151L}), ULongArray.m3628boximpl(new long[]{0, 1983832190353408000L, 4099538766143697323L, 1051521427672928281L, 138178696881511L}), ULongArray.m3628boximpl(new long[]{0, 1391577829824528384L, 4101899514017870000L, 1291842239874507006L, 1381786968815111L}), ULongArray.m3628boximpl(new long[]{0, 4692406261390508032L, 4125506992759596769L, 3695050361890294256L, 13817869688151111L}), ULongArray.m3628boximpl(new long[]{0, 807202429631201280L, 4361581780176864463L, 57015471483839332L, 138178696881511114L}), ULongArray.m3628boximpl(new long[]{0, 8072024296312012800L, 6722329654349541398L, 570154714838393324L, 1381786968815111140L}), ULongArray.m3628boximpl(new long[]{0, 6933266668281921536L, 2659692285511983332L, 5701547148383933247L, 4594497651296335592L, 1}), ULongArray.m3628boximpl(new long[]{0, 4769062424835784704L, 8150178781410281711L, 1675239262710677624L, 9051488365544252694L, 14}), ULongArray.m3628boximpl(new long[]{0, 1573764064083968000L, 7714811519264610651L, 7529020590252000440L, 7504535323749544669L, 149}), ULongArray.m3628boximpl(new long[]{0, 6514268603984904192L, 3361138897807900047L, 1503229607681797944L, 1258376942657240234L, 1498}), ULongArray.m3628boximpl(new long[]{0, 579081781865611264L, 5941272867514673053L, 5808924039963203635L, 3360397389717626533L, 14981}), ULongArray.m3628boximpl(new long[]{0, 5790817818656112640L, 4072496454018075682L, 2749008178503381508L, 5933857786611937912L, 149813})};
    }

    private BigInteger63Arithmetic() {
    }

    /* renamed from: basecaseMultiplyWithCorrectedSize-mwLU0fg, reason: not valid java name */
    private final long[] m2984basecaseMultiplyWithCorrectedSizemwLU0fg(long[] first, long[] second, int firstCorrectedSizeStart, int secondCorrectedSizeStart) {
        long[] mo2950getZEROY2RjT0g = mo2950getZEROY2RjT0g();
        int length = second.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            long j5 = second[i5];
            int i7 = i6 + 1;
            if (i6 <= secondCorrectedSizeStart) {
                BigInteger63Arithmetic bigInteger63Arithmetic = INSTANCE;
                mo2950getZEROY2RjT0g = bigInteger63Arithmetic.m3015plusj68ebKY$bignum(mo2950getZEROY2RjT0g, bigInteger63Arithmetic.m3020shlGERUpyg$bignum(bigInteger63Arithmetic.m2992baseMultiplyss9iZGw(first, j5), i6 * bigInteger63Arithmetic.getBasePowerOfTwo()));
            }
            i5++;
            i6 = i7;
        }
        return mo2950getZEROY2RjT0g;
    }

    /* renamed from: isZero-QwZRm1k, reason: not valid java name */
    private final boolean m2985isZeroQwZRm1k(long[] jArr) {
        if (ULongArray.m3634equalsimpl0(jArr, mo2950getZEROY2RjT0g())) {
            return true;
        }
        return (ULongArray.m3636getSizeimpl(jArr) == 1 && ULongArray.m3635getsVKNKU(jArr, 0) == 0) || ULongArray.m3636getSizeimpl(jArr) - m3001countLeadingZeroWordsQwZRm1k(jArr) == 0;
    }

    /* renamed from: karatsubaMultiplyWithCorrectedSizes-mwLU0fg, reason: not valid java name */
    private final long[] m2986karatsubaMultiplyWithCorrectedSizesmwLU0fg(long[] firstUnsigned, long[] secondUnsigned, int firstCorrectedSize, int secondCorrectedSize) {
        boolean z5 = true;
        DefaultConstructorMarker defaultConstructorMarker = null;
        SignedULongArray signedULongArray = new SignedULongArray(firstUnsigned, z5, defaultConstructorMarker);
        SignedULongArray signedULongArray2 = new SignedULongArray(secondUnsigned, z5, defaultConstructorMarker);
        int max = (Math.max(firstCorrectedSize, secondCorrectedSize) + 1) / 2;
        long[] mo2947getONEY2RjT0g = mo2947getONEY2RjT0g();
        int i5 = wordSizeInBits;
        long[] m3012minusss9iZGw$bignum = m3012minusss9iZGw$bignum(m3020shlGERUpyg$bignum(mo2947getONEY2RjT0g, max * i5), 1L);
        SignedULongArray m2988andSIFponk$bignum = m2988andSIFponk$bignum(signedULongArray, m3012minusss9iZGw$bignum);
        SignedULongArray shr$bignum = shr$bignum(signedULongArray, max * i5);
        SignedULongArray m2988andSIFponk$bignum2 = m2988andSIFponk$bignum(signedULongArray2, m3012minusss9iZGw$bignum);
        SignedULongArray shr$bignum2 = shr$bignum(signedULongArray2, max * i5);
        SignedULongArray times$bignum = times$bignum(shr$bignum, shr$bignum2);
        SignedULongArray times$bignum2 = times$bignum(m2988andSIFponk$bignum, m2988andSIFponk$bignum2);
        return plus$bignum(plus$bignum(shl$bignum(times$bignum, i5 * 2 * max), shl$bignum(minus$bignum(minus$bignum(times$bignum(plus$bignum(shr$bignum, m2988andSIFponk$bignum), plus$bignum(shr$bignum2, m2988andSIFponk$bignum2)), times$bignum), times$bignum2), i5 * max)), times$bignum2).getUnsignedValue();
    }

    /* renamed from: multiplyWithCorrectedSize-mwLU0fg, reason: not valid java name */
    private final long[] m2987multiplyWithCorrectedSizemwLU0fg(long[] first, long[] second, int firstCorrectedSize, int secondCorrectedSize) {
        return (m2985isZeroQwZRm1k(first) || m2985isZeroQwZRm1k(second)) ? mo2950getZEROY2RjT0g() : ((firstCorrectedSize >= 120 || secondCorrectedSize >= 120) && (firstCorrectedSize <= 15000 || secondCorrectedSize < 15000)) ? m2986karatsubaMultiplyWithCorrectedSizesmwLU0fg(first, second, firstCorrectedSize, secondCorrectedSize) : (firstCorrectedSize < 15000 || secondCorrectedSize < 15000) ? m2984basecaseMultiplyWithCorrectedSizemwLU0fg(first, second, firstCorrectedSize, secondCorrectedSize) : m3026toomCook3Multiplyj68ebKY(first, second);
    }

    private final SignedULongArray signedAdd(SignedULongArray first, SignedULongArray second) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        return first.getSign() ^ second.getSign() ? m2996compareToGR1PJdc$bignum(first.getUnsignedValue(), second.getUnsignedValue()) > 0 ? new SignedULongArray(m3011minusj68ebKY$bignum(first.getUnsignedValue(), second.getUnsignedValue()), first.getSign(), defaultConstructorMarker) : new SignedULongArray(m3011minusj68ebKY$bignum(second.getUnsignedValue(), first.getUnsignedValue()), second.getSign(), defaultConstructorMarker) : new SignedULongArray(m3015plusj68ebKY$bignum(first.getUnsignedValue(), second.getUnsignedValue()), first.getSign(), defaultConstructorMarker);
    }

    private final SignedULongArray signedDivide(SignedULongArray first, SignedULongArray second) {
        return new SignedULongArray(m3003divj68ebKY$bignum(first.getUnsignedValue(), second.getUnsignedValue()), !(first.getSign() ^ second.getSign()), null);
    }

    private final SignedULongArray signedMultiply(SignedULongArray first, SignedULongArray second) {
        return new SignedULongArray(m3023timesj68ebKY$bignum(first.getUnsignedValue(), second.getUnsignedValue()), !(first.getSign() ^ second.getSign()), null);
    }

    private final SignedULongArray signedSubtract(SignedULongArray first, SignedULongArray second) {
        return signedAdd(first, SignedULongArray.m3027copytBf0fek$default(second, null, !second.getSign(), 1, null));
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: add-j68ebKY */
    public long[] mo2935addj68ebKY(long[] first, long[] second) {
        long[] m3630constructorimpl;
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (m2985isZeroQwZRm1k(first)) {
            return second;
        }
        if (m2985isZeroQwZRm1k(second)) {
            return first;
        }
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first);
        int m3636getSizeimpl2 = ULongArray.m3636getSizeimpl(second) - m3001countLeadingZeroWordsQwZRm1k(second);
        Sextuple sextuple = m3636getSizeimpl > m3636getSizeimpl2 ? new Sextuple(Integer.valueOf(ULongArray.m3636getSizeimpl(first)), Integer.valueOf(ULongArray.m3636getSizeimpl(second)), ULongArray.m3628boximpl(first), ULongArray.m3628boximpl(second), Integer.valueOf(m3636getSizeimpl), Integer.valueOf(m3636getSizeimpl2)) : new Sextuple(Integer.valueOf(ULongArray.m3636getSizeimpl(second)), Integer.valueOf(ULongArray.m3636getSizeimpl(first)), ULongArray.m3628boximpl(second), ULongArray.m3628boximpl(first), Integer.valueOf(m3636getSizeimpl2), Integer.valueOf(m3636getSizeimpl));
        int intValue = ((Number) sextuple.component1()).intValue();
        ((Number) sextuple.component2()).intValue();
        boolean z5 = (ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(((ULongArray) sextuple.component3()).getStorage(), ((Number) sextuple.component5()).intValue() - 1) & 6917529027641081856L) == 0 && ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(((ULongArray) sextuple.component4()).getStorage(), ((Number) sextuple.component6()).intValue() - 1) & 6917529027641081856L) == 0) ? false : true;
        if (z5) {
            int i5 = intValue + 1;
            long[] jArr = new long[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                jArr[i6] = 0;
            }
            m3630constructorimpl = ULongArray.m3630constructorimpl(jArr);
        } else {
            long[] jArr2 = new long[intValue];
            for (int i7 = 0; i7 < intValue; i7++) {
                jArr2[i7] = 0;
            }
            m3630constructorimpl = ULongArray.m3630constructorimpl(jArr2);
        }
        m2990baseAddIntoArrayKsfQWN0(m3630constructorimpl, 0, first, second);
        return z5 ? m3017removeLeadingZerosJIhQxVY(m3630constructorimpl) : m3630constructorimpl;
    }

    /* renamed from: and-SIFponk$bignum, reason: not valid java name */
    public final SignedULongArray m2988andSIFponk$bignum(SignedULongArray receiver, long[] operand) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(operand, "operand");
        return new SignedULongArray(m2989andj68ebKY(receiver.getUnsignedValue(), operand), receiver.getSign(), null);
    }

    /* renamed from: and-j68ebKY, reason: not valid java name */
    public long[] m2989andj68ebKY(long[] operand, long[] mask) {
        Intrinsics.checkNotNullParameter(operand, "operand");
        Intrinsics.checkNotNullParameter(mask, "mask");
        Pair pair = ULongArray.m3636getSizeimpl(operand) > ULongArray.m3636getSizeimpl(mask) ? new Pair(ULongArray.m3628boximpl(operand), ULongArray.m3628boximpl(mask)) : new Pair(ULongArray.m3628boximpl(mask), ULongArray.m3628boximpl(operand));
        ((ULongArray) pair.component1()).getStorage();
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(((ULongArray) pair.component2()).getStorage());
        long[] jArr = new long[m3636getSizeimpl];
        for (int i5 = 0; i5 < m3636getSizeimpl; i5++) {
            jArr[i5] = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i5) & ULongArray.m3635getsVKNKU(mask, i5));
        }
        return ULongArray.m3630constructorimpl(jArr);
    }

    /* renamed from: baseAddIntoArray-KsfQWN0, reason: not valid java name */
    public final void m2990baseAddIntoArrayKsfQWN0(long[] resultArray, int resultArrayStart, long[] first, long[] second) {
        Intrinsics.checkNotNullParameter(resultArray, "resultArray");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        int i5 = 0;
        if (m2985isZeroQwZRm1k(first)) {
            ArraysKt.copyInto(first, resultArray, resultArrayStart, 0, ULongArray.m3636getSizeimpl(first));
            return;
        }
        if (m2985isZeroQwZRm1k(second)) {
            ArraysKt.copyInto(second, resultArray, resultArrayStart, 0, ULongArray.m3636getSizeimpl(second));
            return;
        }
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first);
        int m3636getSizeimpl2 = ULongArray.m3636getSizeimpl(second) - m3001countLeadingZeroWordsQwZRm1k(second);
        Sextuple sextuple = m3636getSizeimpl > m3636getSizeimpl2 ? new Sextuple(Integer.valueOf(ULongArray.m3636getSizeimpl(first)), Integer.valueOf(ULongArray.m3636getSizeimpl(second)), ULongArray.m3628boximpl(first), ULongArray.m3628boximpl(second), Integer.valueOf(m3636getSizeimpl), Integer.valueOf(m3636getSizeimpl2)) : new Sextuple(Integer.valueOf(ULongArray.m3636getSizeimpl(second)), Integer.valueOf(ULongArray.m3636getSizeimpl(first)), ULongArray.m3628boximpl(second), ULongArray.m3628boximpl(first), Integer.valueOf(m3636getSizeimpl2), Integer.valueOf(m3636getSizeimpl));
        int intValue = ((Number) sextuple.component1()).intValue();
        ((Number) sextuple.component2()).intValue();
        long[] storage = ((ULongArray) sextuple.component3()).getStorage();
        long[] storage2 = ((ULongArray) sextuple.component4()).getStorage();
        int intValue2 = ((Number) sextuple.component5()).intValue();
        int intValue3 = ((Number) sextuple.component6()).intValue();
        long j5 = 0;
        while (i5 < intValue3) {
            long m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 + ULongArray.m3635getsVKNKU(storage, i5)) + ULongArray.m3635getsVKNKU(storage2, i5));
            ULongArray.m3640setk8EXiF4(resultArray, i5 + resultArrayStart, ULong.m3622constructorimpl(m3007getBaseMasksVKNKU() & m3622constructorimpl));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl >>> 63);
            i5++;
        }
        while (j5 != 0) {
            if (i5 == intValue) {
                ULongArray.m3640setk8EXiF4(resultArray, intValue + resultArrayStart, j5);
                return;
            }
            long m3622constructorimpl2 = ULong.m3622constructorimpl(j5 + ULongArray.m3635getsVKNKU(storage, i5));
            ULongArray.m3640setk8EXiF4(resultArray, i5, ULong.m3622constructorimpl(m3007getBaseMasksVKNKU() & m3622constructorimpl2));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl2 >>> 63);
            i5++;
        }
        while (i5 < intValue2) {
            ULongArray.m3640setk8EXiF4(resultArray, i5 + resultArrayStart, ULongArray.m3635getsVKNKU(storage, i5));
            i5++;
        }
    }

    /* renamed from: baseDivide-GR1PJdc, reason: not valid java name */
    public final Pair<ULongArray, ULongArray> m2991baseDivideGR1PJdc(long[] unnormalizedDividend, long[] unnormalizedDivisor) {
        Intrinsics.checkNotNullParameter(unnormalizedDividend, "unnormalizedDividend");
        Intrinsics.checkNotNullParameter(unnormalizedDivisor, "unnormalizedDivisor");
        if (m2996compareToGR1PJdc$bignum(unnormalizedDivisor, unnormalizedDividend) > 0) {
            return new Pair<>(ULongArray.m3628boximpl(mo2950getZEROY2RjT0g()), ULongArray.m3628boximpl(unnormalizedDividend));
        }
        if (ULongArray.m3636getSizeimpl(unnormalizedDivisor) == 1 && ULongArray.m3636getSizeimpl(unnormalizedDividend) == 1) {
            return new Pair<>(ULongArray.m3628boximpl(m3017removeLeadingZerosJIhQxVY(new long[]{Long.divideUnsigned(ULongArray.m3635getsVKNKU(unnormalizedDividend, 0), ULongArray.m3635getsVKNKU(unnormalizedDivisor, 0))})), ULongArray.m3628boximpl(m3017removeLeadingZerosJIhQxVY(new long[]{Long.remainderUnsigned(ULongArray.m3635getsVKNKU(unnormalizedDividend, 0), ULongArray.m3635getsVKNKU(unnormalizedDivisor, 0))})));
        }
        if (mo2936bitLengthQwZRm1k(unnormalizedDividend) - mo2936bitLengthQwZRm1k(unnormalizedDivisor) == 0) {
            return new Pair<>(ULongArray.m3628boximpl(mo2947getONEY2RjT0g()), ULongArray.m3628boximpl(m3011minusj68ebKY$bignum(unnormalizedDividend, unnormalizedDivisor)));
        }
        Triple<ULongArray, ULongArray, Integer> m3013normalizeGR1PJdc = m3013normalizeGR1PJdc(unnormalizedDividend, unnormalizedDivisor);
        long[] storage = m3013normalizeGR1PJdc.component1().getStorage();
        long[] storage2 = m3013normalizeGR1PJdc.component2().getStorage();
        int intValue = m3013normalizeGR1PJdc.component3().intValue();
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(storage);
        int m3636getSizeimpl2 = ULongArray.m3636getSizeimpl(storage2);
        int m3636getSizeimpl3 = ULongArray.m3636getSizeimpl(storage2) - m3001countLeadingZeroWordsQwZRm1k(storage2);
        int i5 = m3636getSizeimpl - m3636getSizeimpl2;
        long[] m3629constructorimpl = ULongArray.m3629constructorimpl(i5);
        long[] m3020shlGERUpyg$bignum = m3020shlGERUpyg$bignum(storage2, getBasePowerOfTwo() * i5);
        if (m2996compareToGR1PJdc$bignum(storage, m3020shlGERUpyg$bignum) >= 0) {
            m3629constructorimpl = ULongArray.m3629constructorimpl(i5 + 1);
            ULongArray.m3640setk8EXiF4(m3629constructorimpl, i5, 1L);
            storage = m3011minusj68ebKY$bignum(storage, m3020shlGERUpyg$bignum);
        }
        int i6 = i5 - 1;
        if (i6 >= 0) {
            while (true) {
                int i7 = i6 - 1;
                int i8 = m3636getSizeimpl2 + i6;
                long[] m3006from32BitehPNNiw$bignum = m3006from32BitehPNNiw$bignum(BigInteger32Arithmetic.INSTANCE.m2965divideYnv0uTE(m3025to32BitkqpWZOw$bignum(i8 < ULongArray.m3636getSizeimpl(storage) ? m3016plusss9iZGw$bignum(m3020shlGERUpyg$bignum(new long[]{ULongArray.m3635getsVKNKU(storage, i8)}, getBasePowerOfTwo()), ULongArray.m3635getsVKNKU(storage, i8 - 1)) : i8 == ULongArray.m3636getSizeimpl(storage) ? new long[]{ULongArray.m3635getsVKNKU(storage, i8 - 1)} : mo2950getZEROY2RjT0g()), m3025to32BitkqpWZOw$bignum(new long[]{ULongArray.m3635getsVKNKU(storage2, m3636getSizeimpl2 - 1)})).getFirst().getStorage());
                ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, m2995compareTo3yFGk1Y$bignum(m3006from32BitehPNNiw$bignum, ULong.m3622constructorimpl(m3007getBaseMasksVKNKU() - 1)) < 0 ? ULongArray.m3635getsVKNKU(m3006from32BitehPNNiw$bignum, 0) : m3007getBaseMasksVKNKU());
                long[] m3020shlGERUpyg$bignum2 = m3020shlGERUpyg$bignum(m2993baseMultiplyWithCorrectedSize_EW1lsA(storage2, ULongArray.m3635getsVKNKU(m3629constructorimpl, i6), m3636getSizeimpl3), getBasePowerOfTwo() * i6);
                while (m2996compareToGR1PJdc$bignum(m3020shlGERUpyg$bignum2, storage) > 0) {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(m3629constructorimpl, i6) - ULong.m3622constructorimpl(1 & 4294967295L)));
                    m3020shlGERUpyg$bignum2 = m3020shlGERUpyg$bignum(m2993baseMultiplyWithCorrectedSize_EW1lsA(storage2, ULongArray.m3635getsVKNKU(m3629constructorimpl, i6), m3636getSizeimpl3), getBasePowerOfTwo() * i6);
                }
                storage = m3011minusj68ebKY$bignum(storage, m3020shlGERUpyg$bignum2);
                if (i7 < 0) {
                    break;
                }
                i6 = i7;
            }
        }
        while (m2996compareToGR1PJdc$bignum(storage, storage2) >= 0) {
            m3629constructorimpl = m3016plusss9iZGw$bignum(m3629constructorimpl, 1L);
            storage = m3011minusj68ebKY$bignum(storage, storage2);
        }
        return new Pair<>(ULongArray.m3628boximpl(m3017removeLeadingZerosJIhQxVY(m3629constructorimpl)), ULongArray.m3628boximpl(m3002denormalizeGERUpyg(storage, intValue)));
    }

    /* renamed from: baseMultiply-ss9iZGw, reason: not valid java name */
    public final long[] m2992baseMultiplyss9iZGw(long[] first, long second) {
        Intrinsics.checkNotNullParameter(first, "first");
        return m2993baseMultiplyWithCorrectedSize_EW1lsA(first, second, ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first));
    }

    /* renamed from: baseMultiplyWithCorrectedSize-_EW1lsA, reason: not valid java name */
    public final long[] m2993baseMultiplyWithCorrectedSize_EW1lsA(long[] first, long second, int firstCorrectedSize) {
        Intrinsics.checkNotNullParameter(first, "first");
        long m3622constructorimpl = ULong.m3622constructorimpl(m3009getLowMasksVKNKU() & second);
        long m3622constructorimpl2 = ULong.m3622constructorimpl(second >>> 32);
        int mo2936bitLengthQwZRm1k = mo2936bitLengthQwZRm1k(first) + m2994bitLengthVKZWuLQ(second);
        long[] m3629constructorimpl = ULongArray.m3629constructorimpl(mo2936bitLengthQwZRm1k % 63 != 0 ? (mo2936bitLengthQwZRm1k / 63) + 1 : mo2936bitLengthQwZRm1k / 63);
        int i5 = 0;
        int i6 = 0;
        long j5 = 0;
        while (i5 < firstCorrectedSize) {
            long m3622constructorimpl3 = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(first, i5) & m3009getLowMasksVKNKU());
            long m3622constructorimpl4 = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(first, i5) >>> 32);
            i5++;
            long m3622constructorimpl5 = ULong.m3622constructorimpl(m3622constructorimpl3 * m3622constructorimpl);
            long m3622constructorimpl6 = ULong.m3622constructorimpl(m3622constructorimpl5 >>> 63);
            long m3622constructorimpl7 = ULong.m3622constructorimpl(j5 + ULong.m3622constructorimpl(m3622constructorimpl5 & m3007getBaseMasksVKNKU()));
            long m3622constructorimpl8 = ULong.m3622constructorimpl(m3622constructorimpl6 + ULong.m3622constructorimpl(m3622constructorimpl7 >>> 63));
            long m3622constructorimpl9 = ULong.m3622constructorimpl(m3622constructorimpl7 & m3007getBaseMasksVKNKU());
            long m3622constructorimpl10 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl3 * m3622constructorimpl2) + ULong.m3622constructorimpl(m3622constructorimpl * m3622constructorimpl4));
            long m3622constructorimpl11 = ULong.m3622constructorimpl(m3622constructorimpl8 + ULong.m3622constructorimpl(m3622constructorimpl10 >>> 31));
            long m3622constructorimpl12 = ULong.m3622constructorimpl(m3622constructorimpl9 + ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl10 << 32) & m3007getBaseMasksVKNKU()));
            long m3622constructorimpl13 = ULong.m3622constructorimpl(m3622constructorimpl11 + ULong.m3622constructorimpl(m3622constructorimpl12 >>> 63));
            ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, ULong.m3622constructorimpl(m3622constructorimpl12 & m3007getBaseMasksVKNKU()));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl13 + ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl4 * m3622constructorimpl2) << 1));
            i6++;
        }
        if (j5 != 0) {
            ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, j5);
        }
        return m3629constructorimpl;
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: bitLength-QwZRm1k */
    public int mo2936bitLengthQwZRm1k(long[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (m2985isZeroQwZRm1k(value)) {
            return 0;
        }
        int m3636getSizeimpl = (ULongArray.m3636getSizeimpl(value) - m3001countLeadingZeroWordsQwZRm1k(value)) - 1;
        return m2994bitLengthVKZWuLQ(ULongArray.m3635getsVKNKU(value, m3636getSizeimpl)) + (m3636getSizeimpl * 63);
    }

    /* renamed from: bitLength-VKZWuLQ, reason: not valid java name */
    public final int m2994bitLengthVKZWuLQ(long value) {
        return 63 - m3014numberOfLeadingZerosInAWordVKZWuLQ(value);
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: compare-GR1PJdc */
    public int mo2937compareGR1PJdc(long[] first, long[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return m2997compareWithStartIndexesMccmUSY(first, second, ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first), ULongArray.m3636getSizeimpl(second) - m3001countLeadingZeroWordsQwZRm1k(second));
    }

    /* renamed from: compareTo-3yFGk1Y$bignum, reason: not valid java name */
    public final int m2995compareTo3yFGk1Y$bignum(long[] receiver, long j5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return mo2937compareGR1PJdc(receiver, new long[]{j5});
    }

    /* renamed from: compareTo-GR1PJdc$bignum, reason: not valid java name */
    public final int m2996compareToGR1PJdc$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2937compareGR1PJdc(receiver, other);
    }

    /* renamed from: compareWithStartIndexes-MccmUSY, reason: not valid java name */
    public final int m2997compareWithStartIndexesMccmUSY(long[] first, long[] second, int firstStart, int secondStart) {
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (firstStart > secondStart) {
            return 1;
        }
        if (secondStart > firstStart) {
            return -1;
        }
        int i5 = firstStart - 1;
        while (true) {
            if (i5 < 0) {
                z5 = false;
                z6 = true;
                break;
            }
            if (Long.compareUnsigned(ULongArray.m3635getsVKNKU(first, i5), ULongArray.m3635getsVKNKU(second, i5)) > 0) {
                z6 = false;
                z5 = true;
                break;
            }
            if (Long.compareUnsigned(ULongArray.m3635getsVKNKU(first, i5), ULongArray.m3635getsVKNKU(second, i5)) < 0) {
                z6 = false;
                z5 = false;
                break;
            }
            i5--;
        }
        if (z6) {
            return 0;
        }
        return z5 ? 1 : -1;
    }

    /* renamed from: convertFrom32BitRepresentation-ehPNNiw$bignum, reason: not valid java name */
    public final long[] m2998convertFrom32BitRepresentationehPNNiw$bignum(int[] operand) {
        int i5 = 2;
        int i6 = 0;
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (UIntArray.m3612getSizeimpl(operand) == 0) {
            return mo2950getZEROY2RjT0g();
        }
        if (UIntArray.m3612getSizeimpl(operand) == 1) {
            return new long[]{ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 0) & 4294967295L)};
        }
        int m2959bitLengthajY9A = BigInteger32Arithmetic.INSTANCE.m2959bitLengthajY9A(operand);
        int i7 = m2959bitLengthajY9A % 63 == 0 ? m2959bitLengthajY9A / 63 : (m2959bitLengthajY9A / 63) + 1;
        long[] m3629constructorimpl = ULongArray.m3629constructorimpl(i7);
        if (i7 > 0) {
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                int i10 = i8 % 32;
                int i11 = (i8 * 2) - (i8 / 32);
                if (i7 == i5) {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i6) & 4294967295L) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 1) & 4294967295L) << 32) & m3008getHighMasksVKNKU())));
                    if (UIntArray.m3612getSizeimpl(operand) == 4) {
                        ULongArray.m3640setk8EXiF4(m3629constructorimpl, 1, ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 1) & 4294967295L) >>> 31) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i5) & 4294967295L) << 1)) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 3) & 4294967295L) << 33)));
                    } else {
                        ULongArray.m3640setk8EXiF4(m3629constructorimpl, 1, ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 1) & 4294967295L) >>> 31) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i5) & 4294967295L) << 1)));
                    }
                } else if (i8 == 0) {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i8, ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i6) & 4294967295L) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, 1) & 4294967295L) << 32) & m3008getHighMasksVKNKU())));
                } else if (1 <= i8 && i8 < i7 - 1) {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i8, ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11) & 4294967295L) << i10) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11 - 1) & 4294967295L) >>> (32 - i10))) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11 + 1) & 4294967295L) << (i10 + 32)) & m3008getHighMasksVKNKU())));
                } else if (i8 == i7 - 1) {
                    if (i11 < UIntArray.m3612getSizeimpl(operand)) {
                        ULongArray.m3640setk8EXiF4(m3629constructorimpl, i8, ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11 - 1) & 4294967295L) >>> (32 - i10)) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11) & 4294967295L) << i10)));
                    } else {
                        ULongArray.m3640setk8EXiF4(m3629constructorimpl, i8, ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(operand, i11 - 1) & 4294967295L) >>> (32 - i10)));
                    }
                }
                if (i9 >= i7) {
                    break;
                }
                i8 = i9;
                i5 = 2;
                i6 = 0;
            }
        }
        return m3629constructorimpl;
    }

    /* renamed from: convertTo32BitRepresentation-kqpWZOw$bignum, reason: not valid java name */
    public final int[] m2999convertTo32BitRepresentationkqpWZOw$bignum(long[] operand) {
        Intrinsics.checkNotNullParameter(operand, "operand");
        long[] m3000convertTo64BitRepresentationJIhQxVY$bignum = m3000convertTo64BitRepresentationJIhQxVY$bignum(operand);
        int[] m3605constructorimpl = UIntArray.m3605constructorimpl(ULongArray.m3636getSizeimpl(m3000convertTo64BitRepresentationJIhQxVY$bignum) * 2);
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(m3000convertTo64BitRepresentationJIhQxVY$bignum);
        if (m3636getSizeimpl > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                int i7 = i5 * 2;
                UIntArray.m3616setVXSXFK8(m3605constructorimpl, i7, UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(m3000convertTo64BitRepresentationJIhQxVY$bignum, i5) & ULong.m3622constructorimpl(BigInteger32Arithmetic.INSTANCE.m2966getBasepVg5ArA() & 4294967295L))));
                UIntArray.m3616setVXSXFK8(m3605constructorimpl, i7 + 1, UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(m3000convertTo64BitRepresentationJIhQxVY$bignum, i5) >>> 32)));
                if (i6 >= m3636getSizeimpl) {
                    break;
                }
                i5 = i6;
            }
        }
        return BigInteger32Arithmetic.INSTANCE.m2977removeLeadingZeroshkIa6DI(m3605constructorimpl);
    }

    /* renamed from: convertTo64BitRepresentation-JIhQxVY$bignum, reason: not valid java name */
    public final long[] m3000convertTo64BitRepresentationJIhQxVY$bignum(long[] operand) {
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (m2985isZeroQwZRm1k(operand)) {
            return mo2950getZEROY2RjT0g();
        }
        int mo2936bitLengthQwZRm1k = mo2936bitLengthQwZRm1k(operand);
        int i5 = mo2936bitLengthQwZRm1k % 64 == 0 ? mo2936bitLengthQwZRm1k / 64 : (mo2936bitLengthQwZRm1k / 64) + 1;
        long[] m3629constructorimpl = ULongArray.m3629constructorimpl(i5);
        if (i5 > 0) {
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                int i8 = i6 % 63;
                int i9 = (i6 / 63) + i6;
                int i10 = i9 + 1;
                if (i10 < ULongArray.m3636getSizeimpl(operand)) {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i10) << (63 - i8)) | ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i9) >>> i8)));
                } else {
                    ULongArray.m3640setk8EXiF4(m3629constructorimpl, i6, ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i9) >>> i8));
                }
                if (i7 >= i5) {
                    break;
                }
                i6 = i7;
            }
        }
        return m3017removeLeadingZerosJIhQxVY(m3629constructorimpl);
    }

    /* renamed from: countLeadingZeroWords-QwZRm1k, reason: not valid java name */
    public final int m3001countLeadingZeroWordsQwZRm1k(long[] bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "bigInteger");
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(bigInteger) - 1;
        if (m3636getSizeimpl <= 0) {
            return 0;
        }
        long m3635getsVKNKU = ULongArray.m3635getsVKNKU(bigInteger, m3636getSizeimpl);
        while (m3635getsVKNKU == 0 && m3636getSizeimpl > 0) {
            m3636getSizeimpl--;
            m3635getsVKNKU = ULongArray.m3635getsVKNKU(bigInteger, m3636getSizeimpl);
        }
        if (ULongArray.m3635getsVKNKU(bigInteger, m3636getSizeimpl) == 0) {
            m3636getSizeimpl--;
        }
        return (ULongArray.m3636getSizeimpl(bigInteger) - m3636getSizeimpl) - 1;
    }

    /* renamed from: denormalize-GERUpyg, reason: not valid java name */
    public final long[] m3002denormalizeGERUpyg(long[] remainderNormalized, int normalizationShift) {
        Intrinsics.checkNotNullParameter(remainderNormalized, "remainderNormalized");
        return m3021shrGERUpyg$bignum(remainderNormalized, normalizationShift);
    }

    public final SignedULongArray div$bignum(SignedULongArray signedULongArray, SignedULongArray other) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return signedDivide(signedULongArray, other);
    }

    /* renamed from: div-j68ebKY$bignum, reason: not valid java name */
    public final long[] m3003divj68ebKY$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2938divideGR1PJdc(receiver, other).getFirst().getStorage();
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: divide-GR1PJdc */
    public Pair<ULongArray, ULongArray> mo2938divideGR1PJdc(long[] first, long[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return m2991baseDivideGR1PJdc(first, second);
    }

    /* renamed from: divrem-GR1PJdc$bignum, reason: not valid java name */
    public final Pair<ULongArray, ULongArray> m3004divremGR1PJdc$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2938divideGR1PJdc(receiver, other);
    }

    /* renamed from: extendULongArray-9R_UfW4, reason: not valid java name */
    public final long[] m3005extendULongArray9R_UfW4(long[] original, int numberOfWords, long value) {
        Intrinsics.checkNotNullParameter(original, "original");
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(original) + numberOfWords;
        long[] jArr = new long[m3636getSizeimpl];
        int i5 = 0;
        while (i5 < m3636getSizeimpl) {
            jArr[i5] = i5 < ULongArray.m3636getSizeimpl(original) ? ULongArray.m3635getsVKNKU(original, i5) : value;
            i5++;
        }
        return ULongArray.m3630constructorimpl(jArr);
    }

    /* renamed from: from32Bit-ehPNNiw$bignum, reason: not valid java name */
    public final long[] m3006from32BitehPNNiw$bignum(int[] receiver) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2998convertFrom32BitRepresentationehPNNiw$bignum(receiver);
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromByte-DHQ6RzY */
    public long[] mo2939fromByteDHQ6RzY(byte r42) {
        return new long[]{ULong.m3622constructorimpl(Math.abs((int) r42))};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromInt-DHQ6RzY */
    public long[] mo2940fromIntDHQ6RzY(int r42) {
        return new long[]{ULong.m3622constructorimpl(Math.abs(r42))};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromLong-DHQ6RzY */
    public long[] mo2941fromLongDHQ6RzY(long r32) {
        return r32 == Long.MIN_VALUE ? new long[]{0, 1} : new long[]{ULong.m3622constructorimpl(ULong.m3622constructorimpl(Math.abs(r32)) & m3007getBaseMasksVKNKU())};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromShort-DHQ6RzY */
    public long[] mo2942fromShortDHQ6RzY(short r42) {
        return new long[]{ULong.m3622constructorimpl(Math.abs((int) r42))};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromUByte-ab45Ak8 */
    public long[] mo2943fromUByteab45Ak8(byte uByte) {
        return new long[]{ULong.m3622constructorimpl(uByte & 255)};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromUInt-kOc6_GI */
    public long[] mo2944fromUIntkOc6_GI(int uInt) {
        return new long[]{ULong.m3622constructorimpl(uInt & 4294967295L)};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromULong--GCcj4Q */
    public long[] mo2945fromULongGCcj4Q(long uLong) {
        return ULong.m3622constructorimpl(m3010getOverflowMasksVKNKU() & uLong) != 0 ? new long[]{ULong.m3622constructorimpl(uLong & m3007getBaseMasksVKNKU()), 1} : new long[]{uLong};
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: fromUShort-jOPi9CM */
    public long[] mo2946fromUShortjOPi9CM(short uShort) {
        return new long[]{ULong.m3622constructorimpl(uShort & 65535)};
    }

    /* renamed from: getBaseMask-s-VKNKU, reason: not valid java name */
    public final long m3007getBaseMasksVKNKU() {
        return baseMask;
    }

    public int getBasePowerOfTwo() {
        return basePowerOfTwo;
    }

    /* renamed from: getHighMask-s-VKNKU, reason: not valid java name */
    public final long m3008getHighMasksVKNKU() {
        return highMask;
    }

    /* renamed from: getLowMask-s-VKNKU, reason: not valid java name */
    public final long m3009getLowMasksVKNKU() {
        return lowMask;
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: getONE-Y2RjT0g */
    public long[] mo2947getONEY2RjT0g() {
        return ONE;
    }

    /* renamed from: getOverflowMask-s-VKNKU, reason: not valid java name */
    public final long m3010getOverflowMasksVKNKU() {
        return overflowMask;
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: getTEN-Y2RjT0g */
    public long[] mo2948getTENY2RjT0g() {
        return TEN;
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: getTWO-Y2RjT0g */
    public long[] mo2949getTWOY2RjT0g() {
        return TWO;
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: getZERO-Y2RjT0g */
    public long[] mo2950getZEROY2RjT0g() {
        return ZERO;
    }

    public final SignedULongArray minus$bignum(SignedULongArray signedULongArray, SignedULongArray other) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return signedSubtract(signedULongArray, other);
    }

    /* renamed from: minus-j68ebKY$bignum, reason: not valid java name */
    public final long[] m3011minusj68ebKY$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2954subtractj68ebKY(receiver, other);
    }

    /* renamed from: minus-ss9iZGw$bignum, reason: not valid java name */
    public final long[] m3012minusss9iZGw$bignum(long[] receiver, long j5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return mo2954subtractj68ebKY(receiver, new long[]{j5});
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: multiply-j68ebKY */
    public long[] mo2951multiplyj68ebKY(long[] first, long[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return m2987multiplyWithCorrectedSizemwLU0fg(first, second, ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first), ULongArray.m3636getSizeimpl(second) - m3001countLeadingZeroWordsQwZRm1k(second));
    }

    /* renamed from: normalize-GR1PJdc, reason: not valid java name */
    public final Triple<ULongArray, ULongArray, Integer> m3013normalizeGR1PJdc(long[] dividend, long[] divisor) {
        Intrinsics.checkNotNullParameter(dividend, "dividend");
        Intrinsics.checkNotNullParameter(divisor, "divisor");
        int m3014numberOfLeadingZerosInAWordVKZWuLQ = m3014numberOfLeadingZerosInAWordVKZWuLQ(ULongArray.m3635getsVKNKU(divisor, ULongArray.m3636getSizeimpl(divisor) - 1));
        return new Triple<>(ULongArray.m3628boximpl(m3020shlGERUpyg$bignum(dividend, m3014numberOfLeadingZerosInAWordVKZWuLQ)), ULongArray.m3628boximpl(m3020shlGERUpyg$bignum(divisor, m3014numberOfLeadingZerosInAWordVKZWuLQ)), Integer.valueOf(m3014numberOfLeadingZerosInAWordVKZWuLQ));
    }

    /* renamed from: numberOfLeadingZerosInAWord-VKZWuLQ, reason: not valid java name */
    public int m3014numberOfLeadingZerosInAWordVKZWuLQ(long value) {
        int i5;
        long m3622constructorimpl = ULong.m3622constructorimpl(value >>> 32);
        if (m3622constructorimpl != 0) {
            i5 = 31;
            value = m3622constructorimpl;
        } else {
            i5 = 63;
        }
        long m3622constructorimpl2 = ULong.m3622constructorimpl(value >>> 16);
        if (m3622constructorimpl2 != 0) {
            i5 -= 16;
            value = m3622constructorimpl2;
        }
        long m3622constructorimpl3 = ULong.m3622constructorimpl(value >>> 8);
        if (m3622constructorimpl3 != 0) {
            i5 -= 8;
            value = m3622constructorimpl3;
        }
        long m3622constructorimpl4 = ULong.m3622constructorimpl(value >>> 4);
        if (m3622constructorimpl4 != 0) {
            i5 -= 4;
            value = m3622constructorimpl4;
        }
        long m3622constructorimpl5 = ULong.m3622constructorimpl(value >>> 2);
        if (m3622constructorimpl5 != 0) {
            i5 -= 2;
            value = m3622constructorimpl5;
        }
        return ULong.m3622constructorimpl(value >>> 1) != 0 ? i5 - 2 : i5 - ((int) value);
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: parseForBase-_llDaS8 */
    public long[] mo2952parseForBase_llDaS8(String number, int base) {
        Intrinsics.checkNotNullParameter(number, "number");
        long[] mo2950getZEROY2RjT0g = mo2950getZEROY2RjT0g();
        String lowerCase = number.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        for (int i5 = 0; i5 < lowerCase.length(); i5++) {
            char charAt = lowerCase.charAt(i5);
            BigInteger63Arithmetic bigInteger63Arithmetic = INSTANCE;
            mo2950getZEROY2RjT0g = bigInteger63Arithmetic.m3016plusss9iZGw$bignum(bigInteger63Arithmetic.m3024timesss9iZGw$bignum(mo2950getZEROY2RjT0g, ULong.m3622constructorimpl(base)), ULong.m3622constructorimpl(DigitUtilKt.toDigit(charAt, base)));
        }
        return m3017removeLeadingZerosJIhQxVY(mo2950getZEROY2RjT0g);
    }

    public final SignedULongArray plus$bignum(SignedULongArray signedULongArray, SignedULongArray other) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return signedAdd(signedULongArray, other);
    }

    /* renamed from: plus-j68ebKY$bignum, reason: not valid java name */
    public final long[] m3015plusj68ebKY$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2935addj68ebKY(receiver, other);
    }

    /* renamed from: plus-ss9iZGw$bignum, reason: not valid java name */
    public final long[] m3016plusss9iZGw$bignum(long[] receiver, long j5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return mo2935addj68ebKY(receiver, new long[]{j5});
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: pow-GERUpyg */
    public long[] mo2953powGERUpyg(long[] base, long exponent) {
        Intrinsics.checkNotNullParameter(base, "base");
        if (exponent == 0) {
            return mo2947getONEY2RjT0g();
        }
        if (exponent == 1) {
            return base;
        }
        if (ULongArray.m3636getSizeimpl(base) == 1 && ULongArray.m3635getsVKNKU(base, 0) == 10) {
            ULongArray[] uLongArrayArr = powersOf10;
            if (exponent < uLongArrayArr.length) {
                return uLongArrayArr[(int) exponent].getStorage();
            }
        }
        ULongArray.m3636getSizeimpl(base);
        m3001countLeadingZeroWordsQwZRm1k(base);
        long[] mo2947getONEY2RjT0g = mo2947getONEY2RjT0g();
        while (exponent > 1) {
            long j5 = 2;
            if (exponent % j5 == 0) {
                base = m3023timesj68ebKY$bignum(base, base);
                exponent /= j5;
            } else {
                mo2947getONEY2RjT0g = m3023timesj68ebKY$bignum(base, mo2947getONEY2RjT0g);
                base = m3023timesj68ebKY$bignum(base, base);
                exponent = (exponent - 1) / j5;
            }
        }
        return m3023timesj68ebKY$bignum(mo2947getONEY2RjT0g, base);
    }

    /* renamed from: removeLeadingZeros-JIhQxVY, reason: not valid java name */
    public final long[] m3017removeLeadingZerosJIhQxVY(long[] bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "bigInteger");
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(bigInteger) - m3001countLeadingZeroWordsQwZRm1k(bigInteger);
        if (m3636getSizeimpl == 0) {
            return mo2950getZEROY2RjT0g();
        }
        if (ULongArray.m3636getSizeimpl(bigInteger) == m3636getSizeimpl) {
            return bigInteger;
        }
        if (ULongArray.m3636getSizeimpl(bigInteger) - m3636getSizeimpl > 1000) {
            StringBuilder sb = new StringBuilder();
            sb.append("RLZ original array : ");
            sb.append(ULongArray.m3636getSizeimpl(bigInteger));
            sb.append(" contains: ");
            sb.append((ULongArray.m3636getSizeimpl(bigInteger) - m3636getSizeimpl) - 1);
            sb.append(" zeros");
            System.out.println((Object) sb.toString());
        }
        return ULongArray.m3630constructorimpl(ArraysKt.copyOfRange(bigInteger, 0, m3636getSizeimpl));
    }

    /* renamed from: shiftLeft-GERUpyg, reason: not valid java name */
    public long[] m3018shiftLeftGERUpyg(long[] operand, int places) {
        int m3001countLeadingZeroWordsQwZRm1k;
        long m3622constructorimpl;
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (m2985isZeroQwZRm1k(operand) || places == 0) {
            return operand;
        }
        if (!ULongArray.m3638isEmptyimpl(operand) && ULongArray.m3636getSizeimpl(operand) != (m3001countLeadingZeroWordsQwZRm1k = m3001countLeadingZeroWordsQwZRm1k(operand))) {
            int m3636getSizeimpl = ULongArray.m3636getSizeimpl(operand) - m3001countLeadingZeroWordsQwZRm1k;
            int m3014numberOfLeadingZerosInAWordVKZWuLQ = m3014numberOfLeadingZerosInAWordVKZWuLQ(ULongArray.m3635getsVKNKU(operand, m3636getSizeimpl - 1));
            int basePowerOfTwo2 = places / getBasePowerOfTwo();
            int basePowerOfTwo3 = places % getBasePowerOfTwo();
            int i5 = basePowerOfTwo3 > m3014numberOfLeadingZerosInAWordVKZWuLQ ? basePowerOfTwo2 + 1 : basePowerOfTwo2;
            int i6 = 0;
            if (basePowerOfTwo3 == 0) {
                int i7 = m3636getSizeimpl + i5;
                long[] jArr = new long[i7];
                while (i6 < i7) {
                    jArr[i6] = (i6 < 0 || i6 >= basePowerOfTwo2) ? ULongArray.m3635getsVKNKU(operand, i6 - basePowerOfTwo2) : 0L;
                    i6++;
                }
                return ULongArray.m3630constructorimpl(jArr);
            }
            int i8 = m3636getSizeimpl + i5;
            long[] jArr2 = new long[i8];
            while (i6 < i8) {
                if (i6 >= 0 && i6 < basePowerOfTwo2) {
                    m3622constructorimpl = 0;
                } else if (i6 == basePowerOfTwo2) {
                    m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i6 - basePowerOfTwo2) << basePowerOfTwo3) & INSTANCE.m3007getBaseMasksVKNKU());
                } else {
                    int i9 = basePowerOfTwo2 + 1;
                    if (i6 < m3636getSizeimpl + basePowerOfTwo2 && i9 <= i6) {
                        int i10 = i6 - basePowerOfTwo2;
                        long m3622constructorimpl2 = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i10) << basePowerOfTwo3);
                        BigInteger63Arithmetic bigInteger63Arithmetic = INSTANCE;
                        m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl2 & bigInteger63Arithmetic.m3007getBaseMasksVKNKU()) | ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i10 - 1) >>> (bigInteger63Arithmetic.getBasePowerOfTwo() - basePowerOfTwo3)));
                    } else {
                        if (i6 != i8 - 1) {
                            throw new RuntimeException(Intrinsics.stringPlus("Invalid case ", Integer.valueOf(i6)));
                        }
                        m3622constructorimpl = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i6 - i5) >>> (INSTANCE.getBasePowerOfTwo() - basePowerOfTwo3));
                    }
                }
                jArr2[i6] = m3622constructorimpl;
                i6++;
            }
            return ULongArray.m3630constructorimpl(jArr2);
        }
        return mo2950getZEROY2RjT0g();
    }

    /* renamed from: shiftRight-GERUpyg, reason: not valid java name */
    public long[] m3019shiftRightGERUpyg(long[] operand, int places) {
        long m3622constructorimpl;
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (ULongArray.m3638isEmptyimpl(operand) || places == 0) {
            return operand;
        }
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(operand) - m3001countLeadingZeroWordsQwZRm1k(operand);
        int basePowerOfTwo2 = places % getBasePowerOfTwo();
        int basePowerOfTwo3 = places / getBasePowerOfTwo();
        if (basePowerOfTwo3 >= m3636getSizeimpl) {
            return mo2950getZEROY2RjT0g();
        }
        if (basePowerOfTwo2 == 0) {
            ULongArray.m3630constructorimpl(ArraysKt.copyOfRange(operand, m3636getSizeimpl - basePowerOfTwo3, m3636getSizeimpl));
        }
        if (m3636getSizeimpl > 1 && m3636getSizeimpl - basePowerOfTwo3 == 1) {
            return new long[]{ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, m3636getSizeimpl - 1) >>> basePowerOfTwo2)};
        }
        int i5 = m3636getSizeimpl - basePowerOfTwo3;
        if (i5 == 0) {
            return mo2950getZEROY2RjT0g();
        }
        long[] jArr = new long[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 >= 0 && i6 < (m3636getSizeimpl - 1) - basePowerOfTwo3) {
                int i7 = i6 + basePowerOfTwo3;
                long m3622constructorimpl2 = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i7) >>> basePowerOfTwo2);
                long m3635getsVKNKU = ULongArray.m3635getsVKNKU(operand, i7 + 1);
                BigInteger63Arithmetic bigInteger63Arithmetic = INSTANCE;
                m3622constructorimpl = ULong.m3622constructorimpl(m3622constructorimpl2 | ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3635getsVKNKU << (bigInteger63Arithmetic.getBasePowerOfTwo() - basePowerOfTwo2)) & bigInteger63Arithmetic.m3007getBaseMasksVKNKU()));
            } else {
                if (i6 != (m3636getSizeimpl - 1) - basePowerOfTwo3) {
                    throw new RuntimeException(Intrinsics.stringPlus("Invalid case ", Integer.valueOf(i6)));
                }
                m3622constructorimpl = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i6 + basePowerOfTwo3) >>> basePowerOfTwo2);
            }
            jArr[i6] = m3622constructorimpl;
        }
        return ULongArray.m3630constructorimpl(jArr);
    }

    public final SignedULongArray shl$bignum(SignedULongArray signedULongArray, int i5) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        return new SignedULongArray(m3020shlGERUpyg$bignum(signedULongArray.getUnsignedValue(), i5), signedULongArray.getSign(), null);
    }

    /* renamed from: shl-GERUpyg$bignum, reason: not valid java name */
    public final long[] m3020shlGERUpyg$bignum(long[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m3018shiftLeftGERUpyg(receiver, i5);
    }

    public final SignedULongArray shr$bignum(SignedULongArray signedULongArray, int i5) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        return new SignedULongArray(m3021shrGERUpyg$bignum(signedULongArray.getUnsignedValue(), i5), signedULongArray.getSign(), null);
    }

    /* renamed from: shr-GERUpyg$bignum, reason: not valid java name */
    public final long[] m3021shrGERUpyg$bignum(long[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m3019shiftRightGERUpyg(receiver, i5);
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: subtract-j68ebKY */
    public long[] mo2954subtractj68ebKY(long[] first, long[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return m3022subtractWithStartIndexesmwLU0fg(first, second, ULongArray.m3636getSizeimpl(first) - m3001countLeadingZeroWordsQwZRm1k(first), ULongArray.m3636getSizeimpl(second) - m3001countLeadingZeroWordsQwZRm1k(second));
    }

    /* renamed from: subtractWithStartIndexes-mwLU0fg, reason: not valid java name */
    public final long[] m3022subtractWithStartIndexesmwLU0fg(long[] first, long[] second, int firstStart, int secondStart) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        int m2997compareWithStartIndexesMccmUSY = m2997compareWithStartIndexesMccmUSY(first, second, firstStart, secondStart);
        int i5 = secondStart + 1;
        boolean z5 = m2997compareWithStartIndexesMccmUSY == 1;
        if (m2997compareWithStartIndexesMccmUSY == 0) {
            return mo2950getZEROY2RjT0g();
        }
        if (i5 == 1 && ULongArray.m3635getsVKNKU(second, 0) == 0) {
            return first;
        }
        if (!z5) {
            throw new RuntimeException("subtract result less than zero");
        }
        Quadruple quadruple = z5 ? new Quadruple(ULongArray.m3628boximpl(first), ULongArray.m3628boximpl(second), Integer.valueOf(firstStart), Integer.valueOf(secondStart)) : new Quadruple(ULongArray.m3628boximpl(second), ULongArray.m3628boximpl(first), Integer.valueOf(secondStart), Integer.valueOf(firstStart));
        long[] storage = ((ULongArray) quadruple.component1()).getStorage();
        long[] storage2 = ((ULongArray) quadruple.component2()).getStorage();
        int intValue = ((Number) quadruple.component3()).intValue();
        int intValue2 = ((Number) quadruple.component4()).intValue();
        long[] jArr = new long[intValue];
        for (int i6 = 0; i6 < intValue; i6++) {
            jArr[i6] = 0;
        }
        long[] m3630constructorimpl = ULongArray.m3630constructorimpl(jArr);
        int i7 = 0;
        long j5 = 0;
        while (i7 < intValue2) {
            long m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(storage, i7) - ULongArray.m3635getsVKNKU(storage2, i7)) - j5);
            ULongArray.m3640setk8EXiF4(m3630constructorimpl, i7, ULong.m3622constructorimpl(m3007getBaseMasksVKNKU() & m3622constructorimpl));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl >>> 63);
            i7++;
        }
        while (j5 != 0) {
            long m3622constructorimpl2 = ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(storage, i7) - j5);
            ULongArray.m3640setk8EXiF4(m3630constructorimpl, i7, ULong.m3622constructorimpl(m3007getBaseMasksVKNKU() & m3622constructorimpl2));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl2 >>> 63);
            i7++;
        }
        while (i7 < intValue) {
            ULongArray.m3640setk8EXiF4(m3630constructorimpl, i7, ULongArray.m3635getsVKNKU(storage, i7));
            i7++;
        }
        return (m3001countLeadingZeroWordsQwZRm1k(m3630constructorimpl) == ULongArray.m3636getSizeimpl(m3630constructorimpl) - 1 && ULongArray.m3635getsVKNKU(m3630constructorimpl, 0) == 0) ? mo2950getZEROY2RjT0g() : m3017removeLeadingZerosJIhQxVY(m3630constructorimpl);
    }

    public final SignedULongArray times$bignum(SignedULongArray signedULongArray, SignedULongArray other) {
        Intrinsics.checkNotNullParameter(signedULongArray, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return signedMultiply(signedULongArray, other);
    }

    /* renamed from: times-j68ebKY$bignum, reason: not valid java name */
    public final long[] m3023timesj68ebKY$bignum(long[] receiver, long[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return mo2951multiplyj68ebKY(receiver, other);
    }

    /* renamed from: times-ss9iZGw$bignum, reason: not valid java name */
    public final long[] m3024timesss9iZGw$bignum(long[] receiver, long j5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2992baseMultiplyss9iZGw(receiver, j5);
    }

    /* renamed from: to32Bit-kqpWZOw$bignum, reason: not valid java name */
    public final int[] m3025to32BitkqpWZOw$bignum(long[] receiver) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2999convertTo32BitRepresentationkqpWZOw$bignum(receiver);
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: toString-tBf0fek */
    public String mo2955toStringtBf0fek(long[] operand, int base) {
        Intrinsics.checkNotNullParameter(operand, "operand");
        long[] copyOf = Arrays.copyOf(operand, operand.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        long[] m3630constructorimpl = ULongArray.m3630constructorimpl(copyOf);
        long[] jArr = {ULong.m3622constructorimpl(base)};
        StringBuilder sb = new StringBuilder();
        while (!ULongArray.m3634equalsimpl0(m3630constructorimpl, mo2950getZEROY2RjT0g())) {
            Pair<ULongArray, ULongArray> m3004divremGR1PJdc$bignum = m3004divremGR1PJdc$bignum(m3630constructorimpl, jArr);
            if (ULongArray.m3638isEmptyimpl(m3004divremGR1PJdc$bignum.getSecond().getStorage())) {
                sb.append(0);
            } else {
                sb.append(UStringsKt.m3724toStringJSWoG40(ULongArray.m3635getsVKNKU(m3004divremGR1PJdc$bignum.getSecond().getStorage(), 0), base));
            }
            m3630constructorimpl = m3004divremGR1PJdc$bignum.getFirst().getStorage();
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return StringsKt.reversed(sb2).toString();
    }

    /* renamed from: toomCook3Multiply-j68ebKY, reason: not valid java name */
    public final long[] m3026toomCook3Multiplyj68ebKY(long[] firstUnchecked, long[] secondUnchecked) {
        List m3628boximpl;
        List m3628boximpl2;
        boolean z5 = true;
        Intrinsics.checkNotNullParameter(firstUnchecked, "firstUnchecked");
        Intrinsics.checkNotNullParameter(secondUnchecked, "secondUnchecked");
        if (ULongArray.m3636getSizeimpl(firstUnchecked) % 3 != 0) {
            ULongArray m3628boximpl3 = ULongArray.m3628boximpl(firstUnchecked);
            int m3636getSizeimpl = (((ULongArray.m3636getSizeimpl(firstUnchecked) + 2) / 3) * 3) - ULongArray.m3636getSizeimpl(firstUnchecked);
            long[] jArr = new long[m3636getSizeimpl];
            for (int i5 = 0; i5 < m3636getSizeimpl; i5++) {
                jArr[i5] = 0;
            }
            m3628boximpl = CollectionsKt.plus((Collection) m3628boximpl3, (Iterable) ULongArray.m3628boximpl(ULongArray.m3630constructorimpl(jArr)));
        } else {
            m3628boximpl = ULongArray.m3628boximpl(firstUnchecked);
        }
        long[] uLongArray = UCollectionsKt.toULongArray(m3628boximpl);
        if (ULongArray.m3636getSizeimpl(secondUnchecked) % 3 != 0) {
            ULongArray m3628boximpl4 = ULongArray.m3628boximpl(secondUnchecked);
            int m3636getSizeimpl2 = (((ULongArray.m3636getSizeimpl(secondUnchecked) + 2) / 3) * 3) - ULongArray.m3636getSizeimpl(secondUnchecked);
            long[] jArr2 = new long[m3636getSizeimpl2];
            for (int i6 = 0; i6 < m3636getSizeimpl2; i6++) {
                jArr2[i6] = 0;
            }
            m3628boximpl2 = CollectionsKt.plus((Collection) m3628boximpl4, (Iterable) ULongArray.m3628boximpl(ULongArray.m3630constructorimpl(jArr2)));
        } else {
            m3628boximpl2 = ULongArray.m3628boximpl(secondUnchecked);
        }
        long[] uLongArray2 = UCollectionsKt.toULongArray(m3628boximpl2);
        int m3636getSizeimpl3 = ULongArray.m3636getSizeimpl(uLongArray);
        int m3636getSizeimpl4 = ULongArray.m3636getSizeimpl(uLongArray2);
        Pair pair = m3636getSizeimpl3 > m3636getSizeimpl4 ? new Pair(ULongArray.m3628boximpl(uLongArray), ULongArray.m3628boximpl(m3005extendULongArray9R_UfW4(uLongArray2, m3636getSizeimpl3 - m3636getSizeimpl4, 0L))) : m3636getSizeimpl3 < m3636getSizeimpl4 ? new Pair(ULongArray.m3628boximpl(m3005extendULongArray9R_UfW4(uLongArray, m3636getSizeimpl4 - m3636getSizeimpl3, 0L)), ULongArray.m3628boximpl(uLongArray2)) : new Pair(ULongArray.m3628boximpl(uLongArray), ULongArray.m3628boximpl(uLongArray2));
        long[] storage = ((ULongArray) pair.component1()).getStorage();
        long[] storage2 = ((ULongArray) pair.component2()).getStorage();
        int max = (Math.max(ULongArray.m3636getSizeimpl(uLongArray), ULongArray.m3636getSizeimpl(uLongArray2)) + 2) / 3;
        DefaultConstructorMarker defaultConstructorMarker = null;
        SignedULongArray signedULongArray = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage, RangesKt.until(0, max))), z5, defaultConstructorMarker);
        int i7 = max * 2;
        SignedULongArray signedULongArray2 = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage, RangesKt.until(max, i7))), z5, defaultConstructorMarker);
        int i8 = max * 3;
        SignedULongArray signedULongArray3 = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage, RangesKt.until(i7, i8))), z5, defaultConstructorMarker);
        SignedULongArray signedULongArray4 = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage2, RangesKt.until(0, max))), z5, defaultConstructorMarker);
        SignedULongArray signedULongArray5 = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage2, RangesKt.until(max, i7))), z5, defaultConstructorMarker);
        SignedULongArray signedULongArray6 = new SignedULongArray(UCollectionsKt.toULongArray(UArraysKt.m3680sliceZRhS8yI(storage2, RangesKt.until(i7, i8))), z5, defaultConstructorMarker);
        SignedULongArray plus$bignum = plus$bignum(signedULongArray, signedULongArray3);
        SignedULongArray plus$bignum2 = plus$bignum(plus$bignum, signedULongArray2);
        SignedULongArray minus$bignum = minus$bignum(plus$bignum, signedULongArray2);
        SignedULongArray plus$bignum3 = plus$bignum(minus$bignum, signedULongArray3);
        SignedULongArray signedULongArray7 = SIGNED_POSITIVE_TWO;
        SignedULongArray minus$bignum2 = minus$bignum(times$bignum(plus$bignum3, signedULongArray7), signedULongArray);
        SignedULongArray plus$bignum4 = plus$bignum(signedULongArray4, signedULongArray6);
        SignedULongArray plus$bignum5 = plus$bignum(plus$bignum4, signedULongArray5);
        SignedULongArray minus$bignum3 = minus$bignum(plus$bignum4, signedULongArray5);
        SignedULongArray minus$bignum4 = minus$bignum(times$bignum(plus$bignum(minus$bignum3, signedULongArray6), signedULongArray7), signedULongArray4);
        SignedULongArray times$bignum = times$bignum(signedULongArray, signedULongArray4);
        SignedULongArray times$bignum2 = times$bignum(plus$bignum2, plus$bignum5);
        SignedULongArray times$bignum3 = times$bignum(minus$bignum, minus$bignum3);
        SignedULongArray times$bignum4 = times$bignum(minus$bignum2, minus$bignum4);
        SignedULongArray times$bignum5 = times$bignum(signedULongArray3, signedULongArray6);
        SignedULongArray div$bignum = div$bignum(minus$bignum(times$bignum4, times$bignum2), new SignedULongArray(new long[]{3}, z5, defaultConstructorMarker));
        SignedULongArray shr$bignum = shr$bignum(minus$bignum(times$bignum2, times$bignum3), 1);
        SignedULongArray minus$bignum5 = minus$bignum(times$bignum3, times$bignum);
        SignedULongArray plus$bignum6 = plus$bignum(shr$bignum(minus$bignum(minus$bignum5, div$bignum), 1), times$bignum(signedULongArray7, times$bignum5));
        return plus$bignum(plus$bignum(plus$bignum(plus$bignum(times$bignum, shl$bignum(minus$bignum(shr$bignum, plus$bignum6), max * 63)), shl$bignum(minus$bignum(plus$bignum(minus$bignum5, shr$bignum), times$bignum5), max * 126)), shl$bignum(plus$bignum6, max * 189)), shl$bignum(times$bignum5, max * 252)).getUnsignedValue();
    }

    @Override // com.ionspin.kotlin.bignum.integer.BigIntegerArithmetic
    /* renamed from: xor-j68ebKY */
    public long[] mo2956xorj68ebKY(long[] operand, long[] mask) {
        Intrinsics.checkNotNullParameter(operand, "operand");
        Intrinsics.checkNotNullParameter(mask, "mask");
        if (ULongArray.m3636getSizeimpl(operand) < ULongArray.m3636getSizeimpl(mask)) {
            return mo2956xorj68ebKY(mask, operand);
        }
        int m3636getSizeimpl = ULongArray.m3636getSizeimpl(operand);
        long[] jArr = new long[m3636getSizeimpl];
        int i5 = 0;
        while (i5 < m3636getSizeimpl) {
            jArr[i5] = i5 < ULongArray.m3636getSizeimpl(mask) ? ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i5) ^ ULongArray.m3635getsVKNKU(mask, i5)) : ULong.m3622constructorimpl(ULongArray.m3635getsVKNKU(operand, i5));
            i5++;
        }
        return m3017removeLeadingZerosJIhQxVY(ULongArray.m3630constructorimpl(jArr));
    }
}
