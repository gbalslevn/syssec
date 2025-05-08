package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ah\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u008c\u0001\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0094\u0001\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a8\u0010 \u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "color", "contentColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface", "onClick", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "backgroundColor", BuildConfig.FLAVOR, "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surface", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Dp invoke() {
            return Dp.m2597boximpl(m907invokeD9Ej5fM());
        }

        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m907invokeD9Ej5fM() {
            return Dp.m2599constructorimpl(0);
        }
    }, 1, null);

    /* renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m900SurfaceT9BRK9s(Modifier modifier, Shape shape, long j5, long j6, float f5, float f6, BorderStroke borderStroke, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i5, int i6) {
        Modifier modifier2 = (i6 & 1) != 0 ? Modifier.INSTANCE : modifier;
        Shape rectangleShape = (i6 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long surface = (i6 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j5;
        long m827contentColorForek8zF_U = (i6 & 8) != 0 ? ColorSchemeKt.m827contentColorForek8zF_U(surface, composer, (i5 >> 6) & 14) : j6;
        float m2599constructorimpl = (i6 & 16) != 0 ? Dp.m2599constructorimpl(0) : f5;
        float m2599constructorimpl2 = (i6 & 32) != 0 ? Dp.m2599constructorimpl(0) : f6;
        BorderStroke borderStroke2 = (i6 & 64) != 0 ? null : borderStroke;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i5, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float m2599constructorimpl3 = Dp.m2599constructorimpl(((Dp) composer.consume(providableCompositionLocal)).getValue() + m2599constructorimpl);
        final Modifier modifier3 = modifier2;
        final Shape shape2 = rectangleShape;
        final long j7 = surface;
        final BorderStroke borderStroke3 = borderStroke2;
        final float f7 = m2599constructorimpl2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(m827contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m2597boximpl(m2599constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(-70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SurfaceKt$Surface$1$3", f = "Surface.kt", l = {}, m = "invokeSuspend")
            /* renamed from: androidx.compose.material3.SurfaceKt$Surface$1$3, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                long m906surfaceColorAtElevationCLU3JFs;
                Modifier m905surfaceXOJAsU;
                if ((i7 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-70914509, i7, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:108)");
                }
                Modifier modifier4 = Modifier.this;
                Shape shape3 = shape2;
                m906surfaceColorAtElevationCLU3JFs = SurfaceKt.m906surfaceColorAtElevationCLU3JFs(j7, m2599constructorimpl3, composer2, 0);
                m905surfaceXOJAsU = SurfaceKt.m905surfaceXOJAsU(modifier4, shape3, m906surfaceColorAtElevationCLU3JFs, borderStroke3, ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(f7));
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m905surfaceXOJAsU, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                    }
                }), Unit.INSTANCE, new AnonymousClass3(null));
                Function2<Composer, Integer, Unit> function22 = function2;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, pointerInput);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function22.invoke(composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m901Surfaced85dljk(final boolean z5, final Function0<Unit> function0, Modifier modifier, boolean z6, Shape shape, long j5, long j6, float f5, float f6, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i5, int i6, int i7) {
        final Modifier modifier2 = (i7 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z7 = (i7 & 8) != 0 ? true : z6;
        final Shape rectangleShape = (i7 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i7 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j5;
        long m827contentColorForek8zF_U = (i7 & 64) != 0 ? ColorSchemeKt.m827contentColorForek8zF_U(surface, composer, (i5 >> 15) & 14) : j6;
        float m2599constructorimpl = (i7 & 128) != 0 ? Dp.m2599constructorimpl(0) : f5;
        float m2599constructorimpl2 = (i7 & 256) != 0 ? Dp.m2599constructorimpl(0) : f6;
        final BorderStroke borderStroke2 = (i7 & 512) != 0 ? null : borderStroke;
        final MutableInteractionSource mutableInteractionSource2 = (i7 & 1024) != 0 ? null : mutableInteractionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, i5, i6, "androidx.compose.material3.Surface (Surface.kt:306)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float m2599constructorimpl3 = Dp.m2599constructorimpl(((Dp) composer.consume(providableCompositionLocal)).getValue() + m2599constructorimpl);
        final float f7 = m2599constructorimpl2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(m827contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m2597boximpl(m2599constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(-1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                long m906surfaceColorAtElevationCLU3JFs;
                Modifier m905surfaceXOJAsU;
                if ((i8 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164547968, i8, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:312)");
                }
                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                Shape shape2 = rectangleShape;
                m906surfaceColorAtElevationCLU3JFs = SurfaceKt.m906surfaceColorAtElevationCLU3JFs(surface, m2599constructorimpl3, composer2, 0);
                m905surfaceXOJAsU = SurfaceKt.m905surfaceXOJAsU(minimumInteractiveComponentSize, shape2, m906surfaceColorAtElevationCLU3JFs, borderStroke2, ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(f7));
                Modifier m451selectableO2vRcR0$default = SelectableKt.m451selectableO2vRcR0$default(m905surfaceXOJAsU, z5, mutableInteractionSource2, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z7, null, function0, 16, null);
                Function2<Composer, Integer, Unit> function22 = function2;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m451selectableO2vRcR0$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function22.invoke(composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m902Surfaceo_FOJdg(final Function0<Unit> function0, Modifier modifier, boolean z5, Shape shape, long j5, long j6, float f5, float f6, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i5, int i6, int i7) {
        final Modifier modifier2 = (i7 & 2) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z6 = (i7 & 4) != 0 ? true : z5;
        final Shape rectangleShape = (i7 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i7 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j5;
        long m827contentColorForek8zF_U = (i7 & 32) != 0 ? ColorSchemeKt.m827contentColorForek8zF_U(surface, composer, (i5 >> 12) & 14) : j6;
        float m2599constructorimpl = (i7 & 64) != 0 ? Dp.m2599constructorimpl(0) : f5;
        final float m2599constructorimpl2 = (i7 & 128) != 0 ? Dp.m2599constructorimpl(0) : f6;
        final BorderStroke borderStroke2 = (i7 & 256) != 0 ? null : borderStroke;
        final MutableInteractionSource mutableInteractionSource2 = (i7 & 512) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, i5, i6, "androidx.compose.material3.Surface (Surface.kt:203)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        final float m2599constructorimpl3 = Dp.m2599constructorimpl(((Dp) composer.consume(providableCompositionLocal)).getValue() + m2599constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(m827contentColorForek8zF_U)), providableCompositionLocal.provides(Dp.m2597boximpl(m2599constructorimpl3))}, ComposableLambdaKt.rememberComposableLambda(1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                long m906surfaceColorAtElevationCLU3JFs;
                Modifier m905surfaceXOJAsU;
                if ((i8 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1279702876, i8, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:209)");
                }
                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                Shape shape2 = rectangleShape;
                m906surfaceColorAtElevationCLU3JFs = SurfaceKt.m906surfaceColorAtElevationCLU3JFs(surface, m2599constructorimpl3, composer2, 0);
                m905surfaceXOJAsU = SurfaceKt.m905surfaceXOJAsU(minimumInteractiveComponentSize, shape2, m906surfaceColorAtElevationCLU3JFs, borderStroke2, ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(m2599constructorimpl2));
                Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m905surfaceXOJAsU, mutableInteractionSource2, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z6, null, null, function0, 24, null);
                Function2<Composer, Integer, Unit> function22 = function2;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m120clickableO2vRcR0$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function22.invoke(composer2, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m905surfaceXOJAsU(Modifier modifier, Shape shape, long j5, BorderStroke borderStroke, float f5) {
        Shape shape2;
        Modifier modifier2;
        Modifier then = modifier.then(f5 > 0.0f ? GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, false, null, 0L, 0L, 0, 124895, null) : Modifier.INSTANCE);
        if (borderStroke != null) {
            shape2 = shape;
            modifier2 = BorderKt.border(Modifier.INSTANCE, borderStroke, shape2);
        } else {
            shape2 = shape;
            modifier2 = Modifier.INSTANCE;
        }
        return ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(then.then(modifier2), j5, shape2), shape2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m906surfaceColorAtElevationCLU3JFs(long j5, float f5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i5, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        long m825applyTonalElevationRFCenO8 = ColorSchemeKt.m825applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j5, f5, composer, (i5 << 3) & 1008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m825applyTonalElevationRFCenO8;
    }
}
