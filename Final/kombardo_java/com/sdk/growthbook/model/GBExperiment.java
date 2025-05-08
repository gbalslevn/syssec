package com.sdk.growthbook.model;

import com.sdk.growthbook.utils.GBFilter;
import com.sdk.growthbook.utils.GBFilter$$serializer;
import com.sdk.growthbook.utils.GBParentConditionInterface;
import com.sdk.growthbook.utils.GBParentConditionInterface$$serializer;
import com.sdk.growthbook.utils.GBVariationMeta;
import com.sdk.growthbook.utils.GBVariationMeta$$serializer;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0084\u00012\u00020\u0001:\u0004\u0083\u0001\u0084\u0001BË\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0012\u0012\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0001\u0010\u0019\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001b\u0018\u00010\u0007\u0012\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0016\u0012\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)BÙ\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0012\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001b\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0016\u0012\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0016\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010*J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J!\u0010c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001b\u0018\u00010\u0007HÆ\u0003J\u001d\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0016HÆ\u0003J\u001d\u0010e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010,J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010r\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\u0011\u0010s\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0012HÆ\u0003J\u001d\u0010t\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016HÆ\u0003Jä\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u00122\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001b\u0018\u00010\u00072\u001c\b\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u00162\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010vJ\u0013\u0010w\u001a\u00020\u000f2\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010y\u001a\u00020\u0003HÖ\u0001J\t\u0010z\u001a\u00020\u0005HÖ\u0001J)\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001HÁ\u0001¢\u0006\u0003\b\u0082\u0001R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0015\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\"\u0010\u0011\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0015\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b<\u0010,R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\bC\u00101\"\u0004\bD\u0010ER\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\bG\u00101\"\u0004\bH\u0010ER\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R.\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010@\"\u0004\bK\u0010BR\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\bL\u00101R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010>\"\u0004\bN\u0010OR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR%\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016¢\u0006\b\n\u0000\u001a\u0004\bR\u0010@R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010>\"\u0004\bT\u0010OR<\u0010\u0019\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010>\"\u0004\b\\\u0010OR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b]\u0010XR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010X\"\u0004\b_\u0010Z¨\u0006\u0085\u0001"}, d2 = {"Lcom/sdk/growthbook/model/GBExperiment;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "variations", BuildConfig.FLAVOR, "Lkotlinx/serialization/json/JsonElement;", "namespace", "Lkotlinx/serialization/json/JsonArray;", "hashAttribute", "weights", BuildConfig.FLAVOR, "active", BuildConfig.FLAVOR, "coverage", "condition", "Lcom/sdk/growthbook/utils/GBCondition;", "parentConditions", "Ljava/util/ArrayList;", "Lcom/sdk/growthbook/utils/GBParentConditionInterface;", "Lkotlin/collections/ArrayList;", "force", "hashVersion", "ranges", "Lkotlin/Pair;", "Lcom/sdk/growthbook/utils/GBBucketRange;", "meta", "Lcom/sdk/growthbook/utils/GBVariationMeta;", "filters", "Lcom/sdk/growthbook/utils/GBFilter;", "seed", "name", "phase", "fallBackAttribute", "disableStickyBucketing", "bucketVersion", "minBucketVersion", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Float;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Float;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getActive", "()Ljava/lang/Boolean;", "setActive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBucketVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCondition", "()Lkotlinx/serialization/json/JsonElement;", "setCondition", "(Lkotlinx/serialization/json/JsonElement;)V", "getCoverage", "()Ljava/lang/Float;", "setCoverage", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getDisableStickyBucketing", "getFallBackAttribute", "()Ljava/lang/String;", "getFilters", "()Ljava/util/ArrayList;", "setFilters", "(Ljava/util/ArrayList;)V", "getForce", "setForce", "(Ljava/lang/Integer;)V", "getHashAttribute", "getHashVersion", "setHashVersion", "getKey", "getMeta", "setMeta", "getMinBucketVersion", "getName", "setName", "(Ljava/lang/String;)V", "getNamespace", "()Lkotlinx/serialization/json/JsonArray;", "getParentConditions", "getPhase", "setPhase", "getRanges$annotations", "()V", "getRanges", "()Ljava/util/List;", "setRanges", "(Ljava/util/List;)V", "getSeed", "setSeed", "getVariations", "getWeights", "setWeights", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonArray;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Float;Lkotlinx/serialization/json/JsonElement;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/sdk/growthbook/model/GBExperiment;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GBExperiment {
    private Boolean active;
    private final Integer bucketVersion;
    private JsonElement condition;
    private Float coverage;
    private final Boolean disableStickyBucketing;
    private final String fallBackAttribute;
    private ArrayList<GBFilter> filters;
    private Integer force;
    private final String hashAttribute;
    private Integer hashVersion;
    private final String key;
    private ArrayList<GBVariationMeta> meta;
    private final Integer minBucketVersion;
    private String name;
    private final JsonArray namespace;
    private final ArrayList<GBParentConditionInterface> parentConditions;
    private String phase;
    private List<Pair<Float, Float>> ranges;
    private String seed;
    private final List<JsonElement> variations;
    private List<Float> weights;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(JsonElementSerializer.INSTANCE), null, null, new ArrayListSerializer(FloatSerializer.INSTANCE), null, null, null, new ArrayListSerializer(GBParentConditionInterface$$serializer.INSTANCE), null, null, null, new ArrayListSerializer(GBVariationMeta$$serializer.INSTANCE), new ArrayListSerializer(GBFilter$$serializer.INSTANCE), null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/model/GBExperiment$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/model/GBExperiment;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBExperiment> serializer() {
            return GBExperiment$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ GBExperiment(int i5, String str, List list, JsonArray jsonArray, String str2, List list2, Boolean bool, Float f5, JsonElement jsonElement, ArrayList arrayList, Integer num, Integer num2, @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class) List list3, ArrayList arrayList2, ArrayList arrayList3, String str3, String str4, String str5, String str6, Boolean bool2, Integer num3, Integer num4, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, GBExperiment$$serializer.INSTANCE.getDescriptor());
        }
        this.key = str;
        this.variations = (i5 & 2) == 0 ? new ArrayList() : list;
        if ((i5 & 4) == 0) {
            this.namespace = null;
        } else {
            this.namespace = jsonArray;
        }
        if ((i5 & 8) == 0) {
            this.hashAttribute = null;
        } else {
            this.hashAttribute = str2;
        }
        if ((i5 & 16) == 0) {
            this.weights = null;
        } else {
            this.weights = list2;
        }
        this.active = (i5 & 32) == 0 ? Boolean.TRUE : bool;
        if ((i5 & 64) == 0) {
            this.coverage = null;
        } else {
            this.coverage = f5;
        }
        if ((i5 & 128) == 0) {
            this.condition = null;
        } else {
            this.condition = jsonElement;
        }
        if ((i5 & 256) == 0) {
            this.parentConditions = null;
        } else {
            this.parentConditions = arrayList;
        }
        if ((i5 & 512) == 0) {
            this.force = null;
        } else {
            this.force = num;
        }
        if ((i5 & 1024) == 0) {
            this.hashVersion = null;
        } else {
            this.hashVersion = num2;
        }
        if ((i5 & 2048) == 0) {
            this.ranges = null;
        } else {
            this.ranges = list3;
        }
        if ((i5 & 4096) == 0) {
            this.meta = null;
        } else {
            this.meta = arrayList2;
        }
        if ((i5 & 8192) == 0) {
            this.filters = null;
        } else {
            this.filters = arrayList3;
        }
        if ((i5 & 16384) == 0) {
            this.seed = null;
        } else {
            this.seed = str3;
        }
        if ((32768 & i5) == 0) {
            this.name = null;
        } else {
            this.name = str4;
        }
        if ((65536 & i5) == 0) {
            this.phase = null;
        } else {
            this.phase = str5;
        }
        if ((131072 & i5) == 0) {
            this.fallBackAttribute = null;
        } else {
            this.fallBackAttribute = str6;
        }
        if ((262144 & i5) == 0) {
            this.disableStickyBucketing = null;
        } else {
            this.disableStickyBucketing = bool2;
        }
        if ((524288 & i5) == 0) {
            this.bucketVersion = null;
        } else {
            this.bucketVersion = num3;
        }
        if ((i5 & 1048576) == 0) {
            this.minBucketVersion = null;
        } else {
            this.minBucketVersion = num4;
        }
    }

    @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class)
    public static /* synthetic */ void getRanges$annotations() {
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBExperiment self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.key);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.variations, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.variations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.namespace != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, JsonArraySerializer.INSTANCE, self.namespace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hashAttribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.hashAttribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.weights != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.weights);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.active, Boolean.TRUE)) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.active);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.coverage != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, FloatSerializer.INSTANCE, self.coverage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.condition != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.condition);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.parentConditions != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.parentConditions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.force != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.force);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.hashVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.hashVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.ranges != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, self.ranges);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.meta != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, kSerializerArr[12], self.meta);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.filters != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, kSerializerArr[13], self.filters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.seed != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.seed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.phase != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.phase);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.fallBackAttribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.fallBackAttribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.disableStickyBucketing != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, BooleanSerializer.INSTANCE, self.disableStickyBucketing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.bucketVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.bucketVersion);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 20) && self.minBucketVersion == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.minBucketVersion);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getForce() {
        return this.force;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getHashVersion() {
        return this.hashVersion;
    }

    public final List<Pair<Float, Float>> component12() {
        return this.ranges;
    }

    public final ArrayList<GBVariationMeta> component13() {
        return this.meta;
    }

    public final ArrayList<GBFilter> component14() {
        return this.filters;
    }

    /* renamed from: component15, reason: from getter */
    public final String getSeed() {
        return this.seed;
    }

    /* renamed from: component16, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component17, reason: from getter */
    public final String getPhase() {
        return this.phase;
    }

    /* renamed from: component18, reason: from getter */
    public final String getFallBackAttribute() {
        return this.fallBackAttribute;
    }

    /* renamed from: component19, reason: from getter */
    public final Boolean getDisableStickyBucketing() {
        return this.disableStickyBucketing;
    }

    public final List<JsonElement> component2() {
        return this.variations;
    }

    /* renamed from: component20, reason: from getter */
    public final Integer getBucketVersion() {
        return this.bucketVersion;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getMinBucketVersion() {
        return this.minBucketVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonArray getNamespace() {
        return this.namespace;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    public final List<Float> component5() {
        return this.weights;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getActive() {
        return this.active;
    }

    /* renamed from: component7, reason: from getter */
    public final Float getCoverage() {
        return this.coverage;
    }

    /* renamed from: component8, reason: from getter */
    public final JsonElement getCondition() {
        return this.condition;
    }

    public final ArrayList<GBParentConditionInterface> component9() {
        return this.parentConditions;
    }

    public final GBExperiment copy(String key, List<? extends JsonElement> variations, JsonArray namespace, String hashAttribute, List<Float> weights, Boolean active, Float coverage, JsonElement condition, ArrayList<GBParentConditionInterface> parentConditions, Integer force, Integer hashVersion, List<Pair<Float, Float>> ranges, ArrayList<GBVariationMeta> meta, ArrayList<GBFilter> filters, String seed, String name, String phase, String fallBackAttribute, Boolean disableStickyBucketing, Integer bucketVersion, Integer minBucketVersion) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(variations, "variations");
        return new GBExperiment(key, variations, namespace, hashAttribute, weights, active, coverage, condition, parentConditions, force, hashVersion, ranges, meta, filters, seed, name, phase, fallBackAttribute, disableStickyBucketing, bucketVersion, minBucketVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GBExperiment)) {
            return false;
        }
        GBExperiment gBExperiment = (GBExperiment) other;
        return Intrinsics.areEqual(this.key, gBExperiment.key) && Intrinsics.areEqual(this.variations, gBExperiment.variations) && Intrinsics.areEqual(this.namespace, gBExperiment.namespace) && Intrinsics.areEqual(this.hashAttribute, gBExperiment.hashAttribute) && Intrinsics.areEqual(this.weights, gBExperiment.weights) && Intrinsics.areEqual(this.active, gBExperiment.active) && Intrinsics.areEqual((Object) this.coverage, (Object) gBExperiment.coverage) && Intrinsics.areEqual(this.condition, gBExperiment.condition) && Intrinsics.areEqual(this.parentConditions, gBExperiment.parentConditions) && Intrinsics.areEqual(this.force, gBExperiment.force) && Intrinsics.areEqual(this.hashVersion, gBExperiment.hashVersion) && Intrinsics.areEqual(this.ranges, gBExperiment.ranges) && Intrinsics.areEqual(this.meta, gBExperiment.meta) && Intrinsics.areEqual(this.filters, gBExperiment.filters) && Intrinsics.areEqual(this.seed, gBExperiment.seed) && Intrinsics.areEqual(this.name, gBExperiment.name) && Intrinsics.areEqual(this.phase, gBExperiment.phase) && Intrinsics.areEqual(this.fallBackAttribute, gBExperiment.fallBackAttribute) && Intrinsics.areEqual(this.disableStickyBucketing, gBExperiment.disableStickyBucketing) && Intrinsics.areEqual(this.bucketVersion, gBExperiment.bucketVersion) && Intrinsics.areEqual(this.minBucketVersion, gBExperiment.minBucketVersion);
    }

    public final Boolean getActive() {
        return this.active;
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

    public final String getFallBackAttribute() {
        return this.fallBackAttribute;
    }

    public final ArrayList<GBFilter> getFilters() {
        return this.filters;
    }

    public final Integer getForce() {
        return this.force;
    }

    public final String getHashAttribute() {
        return this.hashAttribute;
    }

    public final Integer getHashVersion() {
        return this.hashVersion;
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

    public final List<Pair<Float, Float>> getRanges() {
        return this.ranges;
    }

    public final String getSeed() {
        return this.seed;
    }

    public final List<JsonElement> getVariations() {
        return this.variations;
    }

    public final List<Float> getWeights() {
        return this.weights;
    }

    public int hashCode() {
        int hashCode = ((this.key.hashCode() * 31) + this.variations.hashCode()) * 31;
        JsonArray jsonArray = this.namespace;
        int hashCode2 = (hashCode + (jsonArray == null ? 0 : jsonArray.hashCode())) * 31;
        String str = this.hashAttribute;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<Float> list = this.weights;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.active;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Float f5 = this.coverage;
        int hashCode6 = (hashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        JsonElement jsonElement = this.condition;
        int hashCode7 = (hashCode6 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        ArrayList<GBParentConditionInterface> arrayList = this.parentConditions;
        int hashCode8 = (hashCode7 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Integer num = this.force;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.hashVersion;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<Pair<Float, Float>> list2 = this.ranges;
        int hashCode11 = (hashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ArrayList<GBVariationMeta> arrayList2 = this.meta;
        int hashCode12 = (hashCode11 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<GBFilter> arrayList3 = this.filters;
        int hashCode13 = (hashCode12 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        String str2 = this.seed;
        int hashCode14 = (hashCode13 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode15 = (hashCode14 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phase;
        int hashCode16 = (hashCode15 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fallBackAttribute;
        int hashCode17 = (hashCode16 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool2 = this.disableStickyBucketing;
        int hashCode18 = (hashCode17 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num3 = this.bucketVersion;
        int hashCode19 = (hashCode18 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.minBucketVersion;
        return hashCode19 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setActive(Boolean bool) {
        this.active = bool;
    }

    public final void setCondition(JsonElement jsonElement) {
        this.condition = jsonElement;
    }

    public final void setCoverage(Float f5) {
        this.coverage = f5;
    }

    public final void setFilters(ArrayList<GBFilter> arrayList) {
        this.filters = arrayList;
    }

    public final void setForce(Integer num) {
        this.force = num;
    }

    public final void setHashVersion(Integer num) {
        this.hashVersion = num;
    }

    public final void setMeta(ArrayList<GBVariationMeta> arrayList) {
        this.meta = arrayList;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPhase(String str) {
        this.phase = str;
    }

    public final void setRanges(List<Pair<Float, Float>> list) {
        this.ranges = list;
    }

    public final void setSeed(String str) {
        this.seed = str;
    }

    public final void setWeights(List<Float> list) {
        this.weights = list;
    }

    public String toString() {
        return "GBExperiment(key=" + this.key + ", variations=" + this.variations + ", namespace=" + this.namespace + ", hashAttribute=" + this.hashAttribute + ", weights=" + this.weights + ", active=" + this.active + ", coverage=" + this.coverage + ", condition=" + this.condition + ", parentConditions=" + this.parentConditions + ", force=" + this.force + ", hashVersion=" + this.hashVersion + ", ranges=" + this.ranges + ", meta=" + this.meta + ", filters=" + this.filters + ", seed=" + this.seed + ", name=" + this.name + ", phase=" + this.phase + ", fallBackAttribute=" + this.fallBackAttribute + ", disableStickyBucketing=" + this.disableStickyBucketing + ", bucketVersion=" + this.bucketVersion + ", minBucketVersion=" + this.minBucketVersion + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GBExperiment(String key, List<? extends JsonElement> variations, JsonArray jsonArray, String str, List<Float> list, Boolean bool, Float f5, JsonElement jsonElement, ArrayList<GBParentConditionInterface> arrayList, Integer num, Integer num2, List<Pair<Float, Float>> list2, ArrayList<GBVariationMeta> arrayList2, ArrayList<GBFilter> arrayList3, String str2, String str3, String str4, String str5, Boolean bool2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(variations, "variations");
        this.key = key;
        this.variations = variations;
        this.namespace = jsonArray;
        this.hashAttribute = str;
        this.weights = list;
        this.active = bool;
        this.coverage = f5;
        this.condition = jsonElement;
        this.parentConditions = arrayList;
        this.force = num;
        this.hashVersion = num2;
        this.ranges = list2;
        this.meta = arrayList2;
        this.filters = arrayList3;
        this.seed = str2;
        this.name = str3;
        this.phase = str4;
        this.fallBackAttribute = str5;
        this.disableStickyBucketing = bool2;
        this.bucketVersion = num3;
        this.minBucketVersion = num4;
    }

    public /* synthetic */ GBExperiment(String str, List list, JsonArray jsonArray, String str2, List list2, Boolean bool, Float f5, JsonElement jsonElement, ArrayList arrayList, Integer num, Integer num2, List list3, ArrayList arrayList2, ArrayList arrayList3, String str3, String str4, String str5, String str6, Boolean bool2, Integer num3, Integer num4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? new ArrayList() : list, (i5 & 4) != 0 ? null : jsonArray, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : list2, (i5 & 32) != 0 ? Boolean.TRUE : bool, (i5 & 64) != 0 ? null : f5, (i5 & 128) != 0 ? null : jsonElement, (i5 & 256) != 0 ? null : arrayList, (i5 & 512) != 0 ? null : num, (i5 & 1024) != 0 ? null : num2, (i5 & 2048) != 0 ? null : list3, (i5 & 4096) != 0 ? null : arrayList2, (i5 & 8192) != 0 ? null : arrayList3, (i5 & 16384) != 0 ? null : str3, (i5 & 32768) != 0 ? null : str4, (i5 & 65536) != 0 ? null : str5, (i5 & 131072) != 0 ? null : str6, (i5 & 262144) != 0 ? null : bool2, (i5 & 524288) != 0 ? null : num3, (i5 & 1048576) == 0 ? num4 : null);
    }
}
