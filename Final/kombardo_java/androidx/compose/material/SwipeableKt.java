package androidx.compose.material;

import android.support.v4.media.session.a;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001aW\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a/\u0010!\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"\"\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"T", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/material/SwipeableState;", "state", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "anchors", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "enabled", "reverseDirection", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Lkotlin/Function2;", "Landroidx/compose/material/ThresholdConfig;", "thresholds", "Landroidx/compose/material/ResistanceConfig;", "resistance", "Landroidx/compose/ui/unit/Dp;", "velocityThreshold", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "swipeable", "offset", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "findBounds", "(FLjava/util/Set;)Ljava/util/List;", "lastValue", "velocity", "computeTarget", "(FFLjava/util/Set;Lkotlin/jvm/functions/Function2;FF)F", "getOffset", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", BuildConfig.FLAVOR, "SwipeableDeprecation", "Ljava/lang/String;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SwipeableKt {
    private static final String SwipeableDeprecation = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.";

    public static final /* synthetic */ Float access$getOffset(Map map, Object obj) {
        return getOffset(map, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 < r6.invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5)).floatValue()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r3 > r6.invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0)).floatValue()) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float computeTarget(float f5, float f6, Set<Float> set, Function2<? super Float, ? super Float, Float> function2, float f7, float f8) {
        List<Float> findBounds = findBounds(f5, set);
        int size = findBounds.size();
        if (size == 0) {
            return f6;
        }
        if (size == 1) {
            return findBounds.get(0).floatValue();
        }
        float floatValue = findBounds.get(0).floatValue();
        float floatValue2 = findBounds.get(1).floatValue();
        if (f6 <= f5) {
            if (f7 >= f8) {
                return floatValue2;
            }
        } else if (f7 <= (-f8)) {
            return floatValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v9 */
    private static final List<Float> findBounds(float f5, Set<Float> set) {
        Object obj;
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= f5 + 0.001d) {
                arrayList.add(obj2);
            }
        }
        Float f6 = null;
        int i5 = 1;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            float floatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    Object obj3 = arrayList.get(i6);
                    float floatValue2 = ((Number) obj3).floatValue();
                    if (Float.compare(floatValue, floatValue2) < 0) {
                        obj = obj3;
                        floatValue = floatValue2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Float f7 = (Float) obj;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj4 : set2) {
            if (((Number) obj4).floatValue() >= f5 - 0.001d) {
                arrayList2.add(obj4);
            }
        }
        if (!arrayList2.isEmpty()) {
            ?? r13 = arrayList2.get(0);
            float floatValue3 = ((Number) r13).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            boolean z5 = r13;
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj5 = arrayList2.get(i5);
                    float floatValue4 = ((Number) obj5).floatValue();
                    r13 = z5;
                    if (Float.compare(floatValue3, floatValue4) > 0) {
                        r13 = obj5;
                        floatValue3 = floatValue4;
                    }
                    if (i5 == lastIndex2) {
                        break;
                    }
                    i5++;
                    z5 = r13;
                }
            }
            f6 = r13;
        }
        Float f8 = f6;
        if (f7 == null) {
            return CollectionsKt.listOfNotNull(f8);
        }
        if (f8 != null && !Intrinsics.areEqual(f7, f8)) {
            return CollectionsKt.listOf((Object[]) new Float[]{f7, f8});
        }
        return CollectionsKt.listOf(f7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t5) {
        T t6;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t6 = null;
                break;
            }
            t6 = it.next();
            if (Intrinsics.areEqual(((Map.Entry) t6).getValue(), t5)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) t6;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    @Deprecated
    /* renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m744swipeablepPrIpRY(Modifier modifier, final SwipeableState<T> swipeableState, final Map<Float, ? extends T> map, final Orientation orientation, final boolean z5, final boolean z6, final MutableInteractionSource mutableInteractionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, final ResistanceConfig resistanceConfig, final float f5) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SwipeableKt$swipeable$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i5) {
                Modifier draggable;
                composer.startReplaceGroup(43594985);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(43594985, i5, -1, "androidx.compose.material.swipeable.<anonymous> (Swipeable.kt:596)");
                }
                if (!map.isEmpty()) {
                    if (CollectionsKt.distinct(map.values()).size() == map.size()) {
                        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                        swipeableState.ensureInit$material_release(map);
                        Object obj = map;
                        Object obj2 = swipeableState;
                        boolean changed = composer.changed(swipeableState) | composer.changedInstance(map) | composer.changed(resistanceConfig) | composer.changed(function2) | composer.changed(density) | composer.changed(f5);
                        SwipeableState<T> swipeableState2 = swipeableState;
                        Map<Float, T> map2 = map;
                        ResistanceConfig resistanceConfig2 = resistanceConfig;
                        Function2<T, T, ThresholdConfig> function22 = function2;
                        float f6 = f5;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object swipeableKt$swipeable$3$3$1 = new SwipeableKt$swipeable$3$3$1(swipeableState2, map2, resistanceConfig2, density, function22, f6, null);
                            composer.updateRememberedValue(swipeableKt$swipeable$3$3$1);
                            rememberedValue = swipeableKt$swipeable$3$3$1;
                        }
                        EffectsKt.LaunchedEffect(obj, obj2, (Function2) rememberedValue, composer, 0);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        boolean isAnimationRunning = swipeableState.isAnimationRunning();
                        DraggableState draggableState = swipeableState.getDraggableState();
                        Orientation orientation2 = orientation;
                        boolean z7 = z5;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean changed2 = composer.changed(swipeableState);
                        SwipeableState<T> swipeableState3 = swipeableState;
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new SwipeableKt$swipeable$3$4$1(swipeableState3, null);
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        draggable = DraggableKt.draggable(companion, draggableState, orientation2, (r20 & 4) != 0 ? true : z7, (r20 & 8) != 0 ? null : mutableInteractionSource2, (r20 & 16) != 0 ? false : isAnimationRunning, (r20 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (r20 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) rememberedValue2, (r20 & 128) != 0 ? false : z6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return draggable;
                    }
                    throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.");
                }
                throw new IllegalArgumentException("You must have at least one anchor.");
            }
        });
    }
}
