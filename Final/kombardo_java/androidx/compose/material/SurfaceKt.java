package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a^\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0082\u0001\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a8\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a,\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "color", "contentColor", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/ui/unit/Dp;", "elevation", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface", "onClick", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surface", "Landroidx/compose/material/ElevationOverlay;", "elevationOverlay", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0081  */
    /* renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m736SurfaceFjzlyU(Modifier modifier, Shape shape, long j5, long j6, BorderStroke borderStroke, float f5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Shape shape2;
        long j7;
        long j8;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        float f6;
        Modifier modifier2;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1412203386);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            shape2 = shape;
            i7 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i5 & 384) != 0) {
                if ((i6 & 4) == 0) {
                    j7 = j5;
                    if (startRestartGroup.changed(j7)) {
                        i10 = 256;
                        i7 |= i10;
                    }
                } else {
                    j7 = j5;
                }
                i10 = 128;
                i7 |= i10;
            } else {
                j7 = j5;
            }
            if ((i5 & 3072) != 0) {
                j8 = j6;
                i7 |= ((i6 & 8) == 0 && startRestartGroup.changed(j8)) ? 2048 : 1024;
            } else {
                j8 = j6;
            }
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                borderStroke2 = borderStroke;
                i7 |= startRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    f6 = f5;
                    i7 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                    if ((i6 & 64) == 0) {
                        i7 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier2 = i11 == 0 ? Modifier.INSTANCE : modifier;
                            if (i12 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i6 & 4) != 0) {
                                i7 &= -897;
                                j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                            }
                            if ((i6 & 8) != 0) {
                                long m673contentColorForek8zF_U = ColorsKt.m673contentColorForek8zF_U(j7, startRestartGroup, (i7 >> 6) & 14);
                                i7 &= -7169;
                                j8 = m673contentColorForek8zF_U;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            }
                            if (i9 != 0) {
                                f6 = Dp.m2599constructorimpl(0);
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i6 & 4) != 0) {
                                i7 &= -897;
                            }
                            if ((i6 & 8) != 0) {
                                i7 &= -7169;
                            }
                            modifier2 = modifier;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1412203386, i7, -1, "androidx.compose.material.Surface (Surface.kt:108)");
                        }
                        final float m2599constructorimpl = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + f6);
                        final Modifier modifier4 = modifier2;
                        final Shape shape3 = shape2;
                        final long j9 = j7;
                        final BorderStroke borderStroke3 = borderStroke2;
                        final float f7 = f6;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j8)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl))}, ComposableLambdaKt.rememberComposableLambda(-1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", l = {}, m = "invokeSuspend")
                            /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                                int label;

                                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                            public final void invoke(Composer composer2, int i13) {
                                long m741surfaceColorAtElevationcq6XJ1M;
                                Modifier m740surface8ww4TTg;
                                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1822160838, i13, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:114)");
                                }
                                Modifier modifier5 = Modifier.this;
                                Shape shape4 = shape3;
                                m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j9, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl, composer2, 0);
                                m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(modifier5, shape4, m741surfaceColorAtElevationcq6XJ1M, borderStroke3, f7);
                                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m740surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                                    }
                                }), Unit.INSTANCE, new AnonymousClass2(null));
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
                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                    }
                    final long j10 = j7;
                    final BorderStroke borderStroke4 = borderStroke2;
                    final float f8 = f6;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier5 = modifier3;
                        final Shape shape4 = shape2;
                        final long j11 = j8;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
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

                            public final void invoke(Composer composer2, int i13) {
                                SurfaceKt.m736SurfaceFjzlyU(Modifier.this, shape4, j10, j11, borderStroke4, f8, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                f6 = f5;
                if ((i6 & 64) == 0) {
                }
                if ((i7 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i11 == 0) {
                }
                if (i12 != 0) {
                }
                if ((i6 & 4) != 0) {
                }
                if ((i6 & 8) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float m2599constructorimpl2 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + f6);
                final Modifier modifier42 = modifier2;
                final Shape shape32 = shape2;
                final long j92 = j7;
                final BorderStroke borderStroke32 = borderStroke2;
                final float f72 = f6;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j8)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(-1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", l = {}, m = "invokeSuspend")
                    /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                        int label;

                        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                    public final void invoke(Composer composer2, int i13) {
                        long m741surfaceColorAtElevationcq6XJ1M;
                        Modifier m740surface8ww4TTg;
                        if ((i13 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1822160838, i13, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:114)");
                        }
                        Modifier modifier52 = Modifier.this;
                        Shape shape42 = shape32;
                        m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j92, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl2, composer2, 0);
                        m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(modifier52, shape42, m741surfaceColorAtElevationcq6XJ1M, borderStroke32, f72);
                        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m740surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                            }
                        }), Unit.INSTANCE, new AnonymousClass2(null));
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
                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                final long j102 = j7;
                final BorderStroke borderStroke42 = borderStroke2;
                final float f82 = f6;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            borderStroke2 = borderStroke;
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            f6 = f5;
            if ((i6 & 64) == 0) {
            }
            if ((i7 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i11 == 0) {
            }
            if (i12 != 0) {
            }
            if ((i6 & 4) != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final float m2599constructorimpl22 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + f6);
            final Modifier modifier422 = modifier2;
            final Shape shape322 = shape2;
            final long j922 = j7;
            final BorderStroke borderStroke322 = borderStroke2;
            final float f722 = f6;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j8)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl22))}, ComposableLambdaKt.rememberComposableLambda(-1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", l = {}, m = "invokeSuspend")
                /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                public final void invoke(Composer composer2, int i13) {
                    long m741surfaceColorAtElevationcq6XJ1M;
                    Modifier m740surface8ww4TTg;
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1822160838, i13, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:114)");
                    }
                    Modifier modifier52 = Modifier.this;
                    Shape shape42 = shape322;
                    m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j922, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl22, composer2, 0);
                    m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(modifier52, shape42, m741surfaceColorAtElevationcq6XJ1M, borderStroke322, f722);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m740surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                        }
                    }), Unit.INSTANCE, new AnonymousClass2(null));
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
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            final long j1022 = j7;
            final BorderStroke borderStroke422 = borderStroke2;
            final float f822 = f6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i5 & 384) != 0) {
        }
        if ((i5 & 3072) != 0) {
        }
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        borderStroke2 = borderStroke;
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        f6 = f5;
        if ((i6 & 64) == 0) {
        }
        if ((i7 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i11 == 0) {
        }
        if (i12 != 0) {
        }
        if ((i6 & 4) != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float m2599constructorimpl222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + f6);
        final Modifier modifier4222 = modifier2;
        final Shape shape3222 = shape2;
        final long j9222 = j7;
        final BorderStroke borderStroke3222 = borderStroke2;
        final float f7222 = f6;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j8)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl222))}, ComposableLambdaKt.rememberComposableLambda(-1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", l = {}, m = "invokeSuspend")
            /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            public final void invoke(Composer composer2, int i13) {
                long m741surfaceColorAtElevationcq6XJ1M;
                Modifier m740surface8ww4TTg;
                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1822160838, i13, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:114)");
                }
                Modifier modifier52 = Modifier.this;
                Shape shape42 = shape3222;
                m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j9222, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl222, composer2, 0);
                m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(modifier52, shape42, m741surfaceColorAtElevationcq6XJ1M, borderStroke3222, f7222);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m740surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                    }
                }), Unit.INSTANCE, new AnonymousClass2(null));
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
        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        final long j10222 = j7;
        final BorderStroke borderStroke4222 = borderStroke2;
        final float f8222 = f6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /* renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m737SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean z5, Shape shape, long j5, long j6, BorderStroke borderStroke, float f5, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        boolean z6;
        int i9;
        long j7;
        int i10;
        BorderStroke borderStroke2;
        int i11;
        int i12;
        final Modifier modifier2;
        final Shape rectangleShape;
        final long j8;
        float m2599constructorimpl;
        MutableInteractionSource mutableInteractionSource2;
        final boolean z7;
        final long j9;
        final float f6;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1560876237);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i14 = i6 & 2;
        if (i14 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(shape) ? 2048 : 1024;
                    if ((i5 & 24576) == 0) {
                        if ((i6 & 16) == 0 && startRestartGroup.changed(j5)) {
                            i13 = 16384;
                            i7 |= i13;
                        }
                        i13 = 8192;
                        i7 |= i13;
                    }
                    if ((196608 & i5) != 0) {
                        j7 = j6;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(j7)) ? 131072 : 65536;
                    } else {
                        j7 = j6;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        borderStroke2 = borderStroke;
                        i7 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        i11 = i6 & 128;
                        if (i11 != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(f5) ? 8388608 : 4194304;
                        }
                        i12 = i6 & 256;
                        if (i12 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i7 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i6 & 512) != 0) {
                            i7 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i7 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            if ((i7 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    modifier2 = i14 == 0 ? Modifier.INSTANCE : modifier;
                                    if (i8 != 0) {
                                        z6 = true;
                                    }
                                    rectangleShape = i9 == 0 ? RectangleShapeKt.getRectangleShape() : shape;
                                    if ((i6 & 16) == 0) {
                                        i7 &= -57345;
                                        j8 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                                    } else {
                                        j8 = j5;
                                    }
                                    if ((i6 & 32) != 0) {
                                        j7 = ColorsKt.m673contentColorForek8zF_U(j8, startRestartGroup, (i7 >> 12) & 14);
                                        i7 &= -458753;
                                    }
                                    if (i10 != 0) {
                                        borderStroke2 = null;
                                    }
                                    m2599constructorimpl = i11 == 0 ? Dp.m2599constructorimpl(0) : f5;
                                    if (i12 != 0) {
                                        mutableInteractionSource2 = null;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1560876237, i7, -1, "androidx.compose.material.Surface (Surface.kt:218)");
                                        }
                                        final float m2599constructorimpl2 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
                                        final Modifier modifier3 = modifier2;
                                        final Shape shape2 = rectangleShape;
                                        final long j10 = j8;
                                        final BorderStroke borderStroke4 = borderStroke2;
                                        final float f7 = m2599constructorimpl;
                                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                        final boolean z8 = z6;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl2))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                                            public final void invoke(Composer composer2, int i15) {
                                                long m741surfaceColorAtElevationcq6XJ1M;
                                                Modifier m740surface8ww4TTg;
                                                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                                                }
                                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                                Shape shape3 = shape2;
                                                m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j10, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl2, composer2, 0);
                                                m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke4, f7);
                                                Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource4, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z8, null, null, function0, 24, null);
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
                                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        z7 = z6;
                                        j9 = j7;
                                        f6 = m2599constructorimpl;
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i6 & 16) != 0) {
                                        i7 &= -57345;
                                    }
                                    if ((i6 & 32) != 0) {
                                        i7 &= -458753;
                                    }
                                    modifier2 = modifier;
                                    rectangleShape = shape;
                                    j8 = j5;
                                    m2599constructorimpl = f5;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final float m2599constructorimpl22 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
                                final Modifier modifier32 = modifier2;
                                final Shape shape22 = rectangleShape;
                                final long j102 = j8;
                                final BorderStroke borderStroke42 = borderStroke2;
                                final float f72 = m2599constructorimpl;
                                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                final boolean z82 = z6;
                                MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl22))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                                    public final void invoke(Composer composer2, int i15) {
                                        long m741surfaceColorAtElevationcq6XJ1M;
                                        Modifier m740surface8ww4TTg;
                                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                                        }
                                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                        Shape shape3 = shape22;
                                        m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j102, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl22, composer2, 0);
                                        m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke42, f72);
                                        Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource42, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z82, null, null, function0, 24, null);
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
                                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z7 = z6;
                                j9 = j7;
                                f6 = m2599constructorimpl;
                                borderStroke3 = borderStroke2;
                                mutableInteractionSource3 = mutableInteractionSource52;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                rectangleShape = shape;
                                j8 = j5;
                                mutableInteractionSource3 = mutableInteractionSource;
                                z7 = z6;
                                j9 = j7;
                                borderStroke3 = borderStroke2;
                                f6 = f5;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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

                                    public final void invoke(Composer composer2, int i15) {
                                        SurfaceKt.m737SurfaceLPr_se0(function0, modifier2, z7, rectangleShape, j8, j9, borderStroke3, f6, mutableInteractionSource3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i6 & 16) == 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 != 0) {
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final float m2599constructorimpl222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
                        final Modifier modifier322 = modifier2;
                        final Shape shape222 = rectangleShape;
                        final long j1022 = j8;
                        final BorderStroke borderStroke422 = borderStroke2;
                        final float f722 = m2599constructorimpl;
                        final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                        final boolean z822 = z6;
                        MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl222))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                            public final void invoke(Composer composer2, int i15) {
                                long m741surfaceColorAtElevationcq6XJ1M;
                                Modifier m740surface8ww4TTg;
                                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                                }
                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                Shape shape3 = shape222;
                                m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j1022, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl222, composer2, 0);
                                m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke422, f722);
                                Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource422, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z822, null, null, function0, 24, null);
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
                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z7 = z6;
                        j9 = j7;
                        f6 = m2599constructorimpl;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource522;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i11 = i6 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 256;
                    if (i12 != 0) {
                    }
                    if ((i6 & 512) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i6 & 16) == 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 != 0) {
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final float m2599constructorimpl2222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
                    final Modifier modifier3222 = modifier2;
                    final Shape shape2222 = rectangleShape;
                    final long j10222 = j8;
                    final BorderStroke borderStroke4222 = borderStroke2;
                    final float f7222 = m2599constructorimpl;
                    final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
                    final boolean z8222 = z6;
                    MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl2222))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                        public final void invoke(Composer composer2, int i15) {
                            long m741surfaceColorAtElevationcq6XJ1M;
                            Modifier m740surface8ww4TTg;
                            if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                            }
                            Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                            Shape shape3 = shape2222;
                            m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j10222, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl2222, composer2, 0);
                            m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke4222, f7222);
                            Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource4222, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z8222, null, null, function0, 24, null);
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
                    }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z7 = z6;
                    j9 = j7;
                    f6 = m2599constructorimpl;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource3 = mutableInteractionSource5222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i5 & 24576) == 0) {
                }
                if ((196608 & i5) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                borderStroke2 = borderStroke;
                i11 = i6 & 128;
                if (i11 != 0) {
                }
                i12 = i6 & 256;
                if (i12 != 0) {
                }
                if ((i6 & 512) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i14 == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if ((i6 & 16) == 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 == 0) {
                }
                if (i12 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float m2599constructorimpl22222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
                final Modifier modifier32222 = modifier2;
                final Shape shape22222 = rectangleShape;
                final long j102222 = j8;
                final BorderStroke borderStroke42222 = borderStroke2;
                final float f72222 = m2599constructorimpl;
                final MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
                final boolean z82222 = z6;
                MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl22222))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                    public final void invoke(Composer composer2, int i15) {
                        long m741surfaceColorAtElevationcq6XJ1M;
                        Modifier m740surface8ww4TTg;
                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                        }
                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                        Shape shape3 = shape22222;
                        m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j102222, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl22222, composer2, 0);
                        m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke42222, f72222);
                        Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource42222, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z82222, null, null, function0, 24, null);
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
                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                z7 = z6;
                j9 = j7;
                f6 = m2599constructorimpl;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource52222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z6 = z5;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            borderStroke2 = borderStroke;
            i11 = i6 & 128;
            if (i11 != 0) {
            }
            i12 = i6 & 256;
            if (i12 != 0) {
            }
            if ((i6 & 512) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i14 == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if ((i6 & 16) == 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 == 0) {
            }
            if (i12 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final float m2599constructorimpl222222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
            final Modifier modifier322222 = modifier2;
            final Shape shape222222 = rectangleShape;
            final long j1022222 = j8;
            final BorderStroke borderStroke422222 = borderStroke2;
            final float f722222 = m2599constructorimpl;
            final MutableInteractionSource mutableInteractionSource422222 = mutableInteractionSource2;
            final boolean z822222 = z6;
            MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl222222))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

                public final void invoke(Composer composer2, int i15) {
                    long m741surfaceColorAtElevationcq6XJ1M;
                    Modifier m740surface8ww4TTg;
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape3 = shape222222;
                    m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j1022222, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl222222, composer2, 0);
                    m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke422222, f722222);
                    Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource422222, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z822222, null, null, function0, 24, null);
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
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            z7 = z6;
            j9 = j7;
            f6 = m2599constructorimpl;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource522222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        borderStroke2 = borderStroke;
        i11 = i6 & 128;
        if (i11 != 0) {
        }
        i12 = i6 & 256;
        if (i12 != 0) {
        }
        if ((i6 & 512) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i14 == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 == 0) {
        }
        if (i12 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float m2599constructorimpl2222222 = Dp.m2599constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).getValue() + m2599constructorimpl);
        final Modifier modifier3222222 = modifier2;
        final Shape shape2222222 = rectangleShape;
        final long j10222222 = j8;
        final BorderStroke borderStroke4222222 = borderStroke2;
        final float f7222222 = m2599constructorimpl;
        final MutableInteractionSource mutableInteractionSource4222222 = mutableInteractionSource2;
        final boolean z8222222 = z6;
        MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m2597boximpl(m2599constructorimpl2222222))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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

            public final void invoke(Composer composer2, int i15) {
                long m741surfaceColorAtElevationcq6XJ1M;
                Modifier m740surface8ww4TTg;
                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                }
                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                Shape shape3 = shape2222222;
                m741surfaceColorAtElevationcq6XJ1M = SurfaceKt.m741surfaceColorAtElevationcq6XJ1M(j10222222, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), m2599constructorimpl2222222, composer2, 0);
                m740surface8ww4TTg = SurfaceKt.m740surface8ww4TTg(minimumInteractiveComponentSize, shape3, m741surfaceColorAtElevationcq6XJ1M, borderStroke4222222, f7222222);
                Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(m740surface8ww4TTg, mutableInteractionSource4222222, RippleKt.m718rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z8222222, null, null, function0, 24, null);
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
        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z6;
        j9 = j7;
        f6 = m2599constructorimpl;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource5222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m740surface8ww4TTg(Modifier modifier, Shape shape, long j5, BorderStroke borderStroke, float f5) {
        return ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(ShadowKt.m1270shadows4CzXII$default(modifier, f5, shape, false, 0L, 0L, 24, null).then(borderStroke != null ? BorderKt.border(Modifier.INSTANCE, borderStroke, shape) : Modifier.INSTANCE), j5, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m741surfaceColorAtElevationcq6XJ1M(long j5, ElevationOverlay elevationOverlay, float f5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i5, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:495)");
        }
        if (!Color.m1487equalsimpl0(j5, MaterialTheme.INSTANCE.getColors(composer, 6).m671getSurface0d7_KjU()) || elevationOverlay == null) {
            composer.startReplaceGroup(1082239839);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1082171732);
            j5 = elevationOverlay.mo686apply7g2Lkgo(j5, f5, composer, (i5 & 14) | ((i5 >> 3) & 112) | ((i5 << 3) & 896));
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j5;
    }
}
