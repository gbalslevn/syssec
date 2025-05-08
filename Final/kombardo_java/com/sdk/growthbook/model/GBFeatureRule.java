package com.sdk.growthbook.model;

import com.sdk.growthbook.utils.Constants;
import com.sdk.growthbook.utils.GBFilter;
import com.sdk.growthbook.utils.GBFilter$$serializer;
import com.sdk.growthbook.utils.GBParentConditionInterface;
import com.sdk.growthbook.utils.GBParentConditionInterface$$serializer;
import com.sdk.growthbook.utils.GBTrackData;
import com.sdk.growthbook.utils.GBTrackData$$serializer;
import com.sdk.growthbook.utils.GBVariationMeta;
import com.sdk.growthbook.utils.GBVariationMeta$$serializer;
import com.sdk.growthbook.utils.OptionalProperty;
import com.sdk.growthbook.utils.OptionalPropertySerializer;
import com.sdk.growthbook.utils.RangeSerializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 }2\u00020\u0001:\u0002|}B\u008f\u0003\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\b\u0001\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0001\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u0012 \b\u0001\u0010\u001c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aj\u0002`\u001b\u0018\u00010\u0012\u0012\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\f\u0012\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\nj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\nj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\f\u0012\b\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-B¡\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u0012 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aj\u0002`\u001b\u0018\u00010\u0012\u0012\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\f\u0012\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\nj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010)\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\nj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\f¢\u0006\u0002\u0010.J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u001d\u0010Z\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bHÆ\u0003J!\u0010[\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aj\u0002`\u001b\u0018\u00010\u0012HÆ\u0003J\u001d\u0010\\\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\fHÆ\u0003J\u001d\u0010]\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\nj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\fHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010b\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u001d\u0010f\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\nj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\fHÆ\u0003J\u001d\u0010g\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00105J\u0011\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010HÆ\u0003J\u0011\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0016HÆ\u0003Jª\u0003\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b2 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aj\u0002`\u001b\u0018\u00010\u00122\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\f2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\nj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010)\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\nj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\fHÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020&2\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u0003HÖ\u0001J\t\u0010s\u001a\u00020\u0005HÖ\u0001J&\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00002\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zHÁ\u0001¢\u0006\u0002\b{R\u0015\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0019\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0013\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R%\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\nj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R$\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010;R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bC\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010;R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R%\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0015\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bG\u00100R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010;R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010;R0\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010?\u001a\u0004\bN\u0010OR4\u0010\u001c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001aj\u0002`\u001b\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010?\u001a\u0004\bQ\u0010RR\u0013\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R%\u0010)\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\nj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\bT\u0010=R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bU\u0010RR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bV\u0010R¨\u0006~"}, d2 = {"Lcom/sdk/growthbook/model/GBFeatureRule;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "condition", "Lkotlinx/serialization/json/JsonElement;", "Lcom/sdk/growthbook/utils/GBCondition;", "parentConditions", "Ljava/util/ArrayList;", "Lcom/sdk/growthbook/utils/GBParentConditionInterface;", "Lkotlin/collections/ArrayList;", "coverage", BuildConfig.FLAVOR, "force", "Lcom/sdk/growthbook/utils/OptionalProperty;", "variations", BuildConfig.FLAVOR, "key", "weights", "namespace", "Lkotlinx/serialization/json/JsonArray;", "hashAttribute", "hashVersion", "range", "Lkotlin/Pair;", "Lcom/sdk/growthbook/utils/GBBucketRange;", "ranges", "meta", "Lcom/sdk/growthbook/utils/GBVariationMeta;", "filters", "Lcom/sdk/growthbook/utils/GBFilter;", "seed", "name", "phase", "fallbackAttribute", "disableStickyBucketing", BuildConfig.FLAVOR, "bucketVersion", "minBucketVersion", "tracks", "Lcom/sdk/growthbook/utils/GBTrackData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Float;Lcom/sdk/growthbook/utils/OptionalProperty;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/Pair;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Float;Lcom/sdk/growthbook/utils/OptionalProperty;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/Pair;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getBucketVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCondition", "()Lkotlinx/serialization/json/JsonElement;", "getCoverage", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDisableStickyBucketing", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFallbackAttribute", "()Ljava/lang/String;", "getFilters", "()Ljava/util/ArrayList;", "getForce$annotations", "()V", "getForce", "()Lcom/sdk/growthbook/utils/OptionalProperty;", "getHashAttribute", "getHashVersion", "getId", "getKey", "getMeta", "getMinBucketVersion", "getName", "getNamespace", "()Lkotlinx/serialization/json/JsonArray;", "getParentConditions", "getPhase", "getRange$annotations", "getRange", "()Lkotlin/Pair;", "getRanges$annotations", "getRanges", "()Ljava/util/List;", "getSeed", "getTracks", "getVariations", "getWeights", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Float;Lcom/sdk/growthbook/utils/OptionalProperty;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/Pair;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/sdk/growthbook/model/GBFeatureRule;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBFeatureRule {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer bucketVersion;
    private final JsonElement condition;
    private final Float coverage;
    private final Boolean disableStickyBucketing;
    private final String fallbackAttribute;
    private final ArrayList<GBFilter> filters;
    private final OptionalProperty<JsonElement> force;
    private final String hashAttribute;
    private final Integer hashVersion;
    private final String id;
    private final String key;
    private final ArrayList<GBVariationMeta> meta;
    private final Integer minBucketVersion;
    private final String name;
    private final JsonArray namespace;
    private final ArrayList<GBParentConditionInterface> parentConditions;
    private final String phase;
    private final Pair<Float, Float> range;
    private final List<Pair<Float, Float>> ranges;
    private final String seed;
    private final ArrayList<GBTrackData> tracks;
    private final List<JsonElement> variations;
    private final List<Float> weights;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/model/GBFeatureRule$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/model/GBFeatureRule;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBFeatureRule> serializer() {
            return GBFeatureRule$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        ArrayListSerializer arrayListSerializer = new ArrayListSerializer(GBParentConditionInterface$$serializer.INSTANCE);
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, arrayListSerializer, null, new OptionalPropertySerializer(BuiltinSerializersKt.getNullable(jsonElementSerializer)), new ArrayListSerializer(jsonElementSerializer), null, new ArrayListSerializer(FloatSerializer.INSTANCE), null, null, null, null, null, new ArrayListSerializer(GBVariationMeta$$serializer.INSTANCE), new ArrayListSerializer(GBFilter$$serializer.INSTANCE), null, null, null, null, null, null, null, new ArrayListSerializer(GBTrackData$$serializer.INSTANCE)};
    }

    public GBFeatureRule() {
        this((String) null, (JsonElement) null, (ArrayList) null, (Float) null, (OptionalProperty) null, (List) null, (String) null, (List) null, (JsonArray) null, (String) null, (Integer) null, (Pair) null, (List) null, (ArrayList) null, (ArrayList) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (ArrayList) null, 8388607, (DefaultConstructorMarker) null);
    }

    @Serializable(with = OptionalPropertySerializer.class)
    public static /* synthetic */ void getForce$annotations() {
    }

    @Serializable(with = RangeSerializer.GBBucketRangeSerializer.class)
    public static /* synthetic */ void getRange$annotations() {
    }

    @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class)
    public static /* synthetic */ void getRanges$annotations() {
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBFeatureRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.condition != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.condition);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.parentConditions != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.parentConditions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.coverage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, FloatSerializer.INSTANCE, self.coverage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.force, OptionalProperty.NotPresent.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.force);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.variations != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.variations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.key != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.key);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.weights != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.weights);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.namespace != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, JsonArraySerializer.INSTANCE, self.namespace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.hashAttribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.hashAttribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.hashVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.hashVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.range != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, RangeSerializer.GBBucketRangeSerializer.INSTANCE, self.range);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.ranges != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, self.ranges);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.meta != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, kSerializerArr[13], self.meta);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.filters != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, kSerializerArr[14], self.filters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.seed != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.seed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.phase != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.phase);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.fallbackAttribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.fallbackAttribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.disableStickyBucketing != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, BooleanSerializer.INSTANCE, self.disableStickyBucketing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.bucketVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.bucketVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.minBucketVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.minBucketVersion);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 22) && self.tracks == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 22, kSerializerArr[22], self.tracks);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getHashVersion() {
        return this.hashVersion;
    }

    public final Pair<Float, Float> component12() {
        return this.range;
    }

    public final List<Pair<Float, Float>> component13() {
        return this.ranges;
    }

    public final ArrayList<GBVariationMeta> component14() {
        return this.meta;
    }

    public final ArrayList<GBFilter> component15() {
        return this.filters;
    }

    /* renamed from: component16, reason: from getter */
    public final String getSeed() {
        return this.seed;
    }

    /* renamed from: component17, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component18, reason: from getter */
    public final String getPhase() {
        return this.phase;
    }

    /* renamed from: component19, reason: from getter */
    public final String getFallbackAttribute() {
        return this.fallbackAttribute;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getCondition() {
        return this.condition;
    }

    /* renamed from: component20, reason: from getter */
    public final Boolean getDisableStickyBucketing() {
        return this.disableStickyBucketing;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getBucketVersion() {
        return this.bucketVersion;
    }

    /* renamed from: component22, reason: from getter */
    public final Integer getMinBucketVersion() {
        return this.minBucketVersion;
    }

    public final ArrayList<GBTrackData> component23() {
        return this.tracks;
    }

    public final ArrayList<GBParentConditionInterface> component3() {
        return this.parentConditions;
    }

    /* renamed from: component4, reason: from getter */
    public final Float getCoverage() {
        return this.coverage;
    }

    public final OptionalProperty<JsonElement> component5() {
        return this.force;
    }

    public final List<JsonElement> component6() {
        return this.variations;
    }

    /* renamed from: component7, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final List<Float> component8() {
        return this.weights;
    }

    /* renamed from: component9, reason: from getter */
    public final JsonArray getNamespace() {
        return this.namespace;
    }

    public final GBFeatureRule copy(String id, JsonElement condition, ArrayList<GBParentConditionInterface> parentConditions, Float coverage, OptionalProperty<? extends JsonElement> force, List<? extends JsonElement> variations, String key, List<Float> weights, JsonArray namespace, String hashAttribute, Integer hashVersion, Pair<Float, Float> range, List<Pair<Float, Float>> ranges, ArrayList<GBVariationMeta> meta, ArrayList<GBFilter> filters, String seed, String name, String phase, String fallbackAttribute, Boolean disableStickyBucketing, Integer bucketVersion, Integer minBucketVersion, ArrayList<GBTrackData> tracks) {
        Intrinsics.checkNotNullParameter(force, "force");
        return new GBFeatureRule(id, condition, parentConditions, coverage, force, variations, key, weights, namespace, hashAttribute, hashVersion, range, ranges, meta, filters, seed, name, phase, fallbackAttribute, disableStickyBucketing, bucketVersion, minBucketVersion, tracks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBFeatureRule)) {
            return false;
        }
        GBFeatureRule gBFeatureRule = (GBFeatureRule) other;
        return Intrinsics.areEqual(this.id, gBFeatureRule.id) && Intrinsics.areEqual(this.condition, gBFeatureRule.condition) && Intrinsics.areEqual(this.parentConditions, gBFeatureRule.parentConditions) && Intrinsics.areEqual((Object) this.coverage, (Object) gBFeatureRule.coverage) && Intrinsics.areEqual(this.force, gBFeatureRule.force) && Intrinsics.areEqual(this.variations, gBFeatureRule.variations) && Intrinsics.areEqual(this.key, gBFeatureRule.key) && Intrinsics.areEqual(this.weights, gBFeatureRule.weights) && Intrinsics.areEqual(this.namespace, gBFeatureRule.namespace) && Intrinsics.areEqual(this.hashAttribute, gBFeatureRule.hashAttribute) && Intrinsics.areEqual(this.hashVersion, gBFeatureRule.hashVersion) && Intrinsics.areEqual(this.range, gBFeatureRule.range) && Intrinsics.areEqual(this.ranges, gBFeatureRule.ranges) && Intrinsics.areEqual(this.meta, gBFeatureRule.meta) && Intrinsics.areEqual(this.filters, gBFeatureRule.filters) && Intrinsics.areEqual(this.seed, gBFeatureRule.seed) && Intrinsics.areEqual(this.name, gBFeatureRule.name) && Intrinsics.areEqual(this.phase, gBFeatureRule.phase) && Intrinsics.areEqual(this.fallbackAttribute, gBFeatureRule.fallbackAttribute) && Intrinsics.areEqual(this.disableStickyBucketing, gBFeatureRule.disableStickyBucketing) && Intrinsics.areEqual(this.bucketVersion, gBFeatureRule.bucketVersion) && Intrinsics.areEqual(this.minBucketVersion, gBFeatureRule.minBucketVersion) && Intrinsics.areEqual(this.tracks, gBFeatureRule.tracks);
    }

    public final Integer getBucketVersion() {
        return this.bucketVersion;
    }

    public final JsonElement getCondition() {
        return this.condition;
    }

    public final Float getCoverage() {
        return this.coverage;
    }

    public final Boolean getDisableStickyBucketing() {
        return this.disableStickyBucketing;
    }

    public final String getFallbackAttribute() {
        return this.fallbackAttribute;
    }

    public final ArrayList<GBFilter> getFilters() {
        return this.filters;
    }

    public final OptionalProperty<JsonElement> getForce() {
        return this.force;
    }

    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    public final Integer getHashVersion() {
        return this.hashVersion;
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final ArrayList<GBVariationMeta> getMeta() {
        return this.meta;
    }

    public final Integer getMinBucketVersion() {
        return this.minBucketVersion;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonArray getNamespace() {
        return this.namespace;
    }

    public final ArrayList<GBParentConditionInterface> getParentConditions() {
        return this.parentConditions;
    }

    public final String getPhase() {
        return this.phase;
    }

    public final Pair<Float, Float> getRange() {
        return this.range;
    }

    public final List<Pair<Float, Float>> getRanges() {
        return this.ranges;
    }

    public final String getSeed() {
        return this.seed;
    }

    public final ArrayList<GBTrackData> getTracks() {
        return this.tracks;
    }

    public final List<JsonElement> getVariations() {
        return this.variations;
    }

    public final List<Float> getWeights() {
        return this.weights;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        JsonElement jsonElement = this.condition;
        int hashCode2 = (hashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        ArrayList<GBParentConditionInterface> arrayList = this.parentConditions;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Float f5 = this.coverage;
        int hashCode4 = (((hashCode3 + (f5 == null ? 0 : f5.hashCode())) * 31) + this.force.hashCode()) * 31;
        List<JsonElement> list = this.variations;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.key;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Float> list2 = this.weights;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        JsonArray jsonArray = this.namespace;
        int hashCode8 = (hashCode7 + (jsonArray == null ? 0 : jsonArray.hashCode())) * 31;
        String str3 = this.hashAttribute;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.hashVersion;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Pair<Float, Float> pair = this.range;
        int hashCode11 = (hashCode10 + (pair == null ? 0 : pair.hashCode())) * 31;
        List<Pair<Float, Float>> list3 = this.ranges;
        int hashCode12 = (hashCode11 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ArrayList<GBVariationMeta> arrayList2 = this.meta;
        int hashCode13 = (hashCode12 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<GBFilter> arrayList3 = this.filters;
        int hashCode14 = (hashCode13 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        String str4 = this.seed;
        int hashCode15 = (hashCode14 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode16 = (hashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.phase;
        int hashCode17 = (hashCode16 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.fallbackAttribute;
        int hashCode18 = (hashCode17 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.disableStickyBucketing;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.bucketVersion;
        int hashCode20 = (hashCode19 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.minBucketVersion;
        int hashCode21 = (hashCode20 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ArrayList<GBTrackData> arrayList4 = this.tracks;
        return hashCode21 + (arrayList4 != null ? arrayList4.hashCode() : 0);
    }

    public String toString() {
        return "GBFeatureRule(id=" + this.id + ", condition=" + this.condition + ", parentConditions=" + this.parentConditions + ", coverage=" + this.coverage + ", force=" + this.force + ", variations=" + this.variations + ", key=" + this.key + ", weights=" + this.weights + ", namespace=" + this.namespace + ", hashAttribute=" + this.hashAttribute + ", hashVersion=" + this.hashVersion + ", range=" + this.range + ", ranges=" + this.ranges + ", meta=" + this.meta + ", filters=" + this.filters + ", seed=" + this.seed + ", name=" + this.name + ", phase=" + this.phase + ", fallbackAttribute=" + this.fallbackAttribute + ", disableStickyBucketing=" + this.disableStickyBucketing + ", bucketVersion=" + this.bucketVersion + ", minBucketVersion=" + this.minBucketVersion + ", tracks=" + this.tracks + ')';
    }

    @Deprecated
    public /* synthetic */ GBFeatureRule(int i5, String str, JsonElement jsonElement, ArrayList arrayList, Float f5, @Serializable(with = OptionalPropertySerializer.class) OptionalProperty optionalProperty, List list, String str2, List list2, JsonArray jsonArray, String str3, Integer num, @Serializable(with = RangeSerializer.GBBucketRangeSerializer.class) Pair pair, @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class) List list3, ArrayList arrayList2, ArrayList arrayList3, String str4, String str5, String str6, String str7, Boolean bool, Integer num2, Integer num3, ArrayList arrayList4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        if ((i5 & 2) == 0) {
            this.condition = null;
        } else {
            this.condition = jsonElement;
        }
        if ((i5 & 4) == 0) {
            this.parentConditions = null;
        } else {
            this.parentConditions = arrayList;
        }
        if ((i5 & 8) == 0) {
            this.coverage = null;
        } else {
            this.coverage = f5;
        }
        this.force = (i5 & 16) == 0 ? OptionalProperty.NotPresent.INSTANCE : optionalProperty;
        if ((i5 & 32) == 0) {
            this.variations = null;
        } else {
            this.variations = list;
        }
        if ((i5 & 64) == 0) {
            this.key = null;
        } else {
            this.key = str2;
        }
        if ((i5 & 128) == 0) {
            this.weights = null;
        } else {
            this.weights = list2;
        }
        if ((i5 & 256) == 0) {
            this.namespace = null;
        } else {
            this.namespace = jsonArray;
        }
        if ((i5 & 512) == 0) {
            this.hashAttribute = null;
        } else {
            this.hashAttribute = str3;
        }
        if ((i5 & 1024) == 0) {
            this.hashVersion = null;
        } else {
            this.hashVersion = num;
        }
        if ((i5 & 2048) == 0) {
            this.range = null;
        } else {
            this.range = pair;
        }
        if ((i5 & 4096) == 0) {
            this.ranges = null;
        } else {
            this.ranges = list3;
        }
        if ((i5 & 8192) == 0) {
            this.meta = null;
        } else {
            this.meta = arrayList2;
        }
        if ((i5 & 16384) == 0) {
            this.filters = null;
        } else {
            this.filters = arrayList3;
        }
        if ((32768 & i5) == 0) {
            this.seed = null;
        } else {
            this.seed = str4;
        }
        if ((65536 & i5) == 0) {
            this.name = null;
        } else {
            this.name = str5;
        }
        if ((131072 & i5) == 0) {
            this.phase = null;
        } else {
            this.phase = str6;
        }
        if ((262144 & i5) == 0) {
            this.fallbackAttribute = null;
        } else {
            this.fallbackAttribute = str7;
        }
        if ((524288 & i5) == 0) {
            this.disableStickyBucketing = null;
        } else {
            this.disableStickyBucketing = bool;
        }
        if ((1048576 & i5) == 0) {
            this.bucketVersion = null;
        } else {
            this.bucketVersion = num2;
        }
        if ((2097152 & i5) == 0) {
            this.minBucketVersion = null;
        } else {
            this.minBucketVersion = num3;
        }
        if ((i5 & 4194304) == 0) {
            this.tracks = null;
        } else {
            this.tracks = arrayList4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GBFeatureRule(String str, JsonElement jsonElement, ArrayList<GBParentConditionInterface> arrayList, Float f5, OptionalProperty<? extends JsonElement> force, List<? extends JsonElement> list, String str2, List<Float> list2, JsonArray jsonArray, String str3, Integer num, Pair<Float, Float> pair, List<Pair<Float, Float>> list3, ArrayList<GBVariationMeta> arrayList2, ArrayList<GBFilter> arrayList3, String str4, String str5, String str6, String str7, Boolean bool, Integer num2, Integer num3, ArrayList<GBTrackData> arrayList4) {
        Intrinsics.checkNotNullParameter(force, "force");
        this.id = str;
        this.condition = jsonElement;
        this.parentConditions = arrayList;
        this.coverage = f5;
        this.force = force;
        this.variations = list;
        this.key = str2;
        this.weights = list2;
        this.namespace = jsonArray;
        this.hashAttribute = str3;
        this.hashVersion = num;
        this.range = pair;
        this.ranges = list3;
        this.meta = arrayList2;
        this.filters = arrayList3;
        this.seed = str4;
        this.name = str5;
        this.phase = str6;
        this.fallbackAttribute = str7;
        this.disableStickyBucketing = bool;
        this.bucketVersion = num2;
        this.minBucketVersion = num3;
        this.tracks = arrayList4;
    }

    public /* synthetic */ GBFeatureRule(String str, JsonElement jsonElement, ArrayList arrayList, Float f5, OptionalProperty optionalProperty, List list, String str2, List list2, JsonArray jsonArray, String str3, Integer num, Pair pair, List list3, ArrayList arrayList2, ArrayList arrayList3, String str4, String str5, String str6, String str7, Boolean bool, Integer num2, Integer num3, ArrayList arrayList4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : jsonElement, (i5 & 4) != 0 ? null : arrayList, (i5 & 8) != 0 ? null : f5, (i5 & 16) != 0 ? OptionalProperty.NotPresent.INSTANCE : optionalProperty, (i5 & 32) != 0 ? null : list, (i5 & 64) != 0 ? null : str2, (i5 & 128) != 0 ? null : list2, (i5 & 256) != 0 ? null : jsonArray, (i5 & 512) != 0 ? null : str3, (i5 & 1024) != 0 ? null : num, (i5 & 2048) != 0 ? null : pair, (i5 & 4096) != 0 ? null : list3, (i5 & 8192) != 0 ? null : arrayList2, (i5 & 16384) != 0 ? null : arrayList3, (i5 & 32768) != 0 ? null : str4, (i5 & 65536) != 0 ? null : str5, (i5 & 131072) != 0 ? null : str6, (i5 & 262144) != 0 ? null : str7, (i5 & 524288) != 0 ? null : bool, (i5 & 1048576) != 0 ? null : num2, (i5 & 2097152) != 0 ? null : num3, (i5 & 4194304) != 0 ? null : arrayList4);
    }
}
