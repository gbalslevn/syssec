package dk.molslinjen.ui.views.reusable;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a{\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {BuildConfig.FLAVOR, "header", "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Shape;", "shape", "iconUrl", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "showBorder", "Landroidx/compose/ui/graphics/Color;", "borderColor", "Landroidx/compose/ui/unit/Dp;", "borderThickness", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "LabelCard-Tek12BE", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Ljava/lang/String;Ljava/lang/Integer;ZJFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LabelCard", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LabelCardKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03ed  */
    /* renamed from: LabelCard-Tek12BE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3391LabelCardTek12BE(final String header, final String str, Modifier modifier, Shape shape, String str2, Integer num, boolean z5, long j5, float f5, final Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Shape shape2;
        int i8;
        int i9;
        int i10;
        boolean z6;
        int i11;
        long j6;
        int i12;
        Shape shape3;
        Integer num2;
        boolean z7;
        String str3;
        Modifier modifier3;
        float f6;
        long j7;
        Shape shape4;
        Modifier modifier4;
        int i13;
        Modifier.Companion companion;
        boolean z8;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        float f7;
        Composer composer2;
        boolean changed;
        Object rememberedValue2;
        Object rememberedValue3;
        Composer.Companion companion2;
        final String str4;
        final Integer num3;
        final boolean z9;
        final long j8;
        final Shape shape5;
        final Modifier modifier5;
        Painter m2745rememberAsyncImagePainterMqRF_0;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Intrinsics.checkNotNullParameter(header, "header");
        Composer startRestartGroup = composer.startRestartGroup(-933375796);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(header) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i15 = i6 & 4;
        if (i15 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i5 & 3072) != 0) {
                if ((i6 & 8) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i14 = 2048;
                        i7 |= i14;
                    }
                } else {
                    shape2 = shape;
                }
                i14 = 1024;
                i7 |= i14;
            } else {
                shape2 = shape;
            }
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                i9 = 32 & i6;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changed(num) ? 131072 : 65536;
                }
                i10 = i6 & 64;
                if (i10 != 0) {
                    i7 |= 1572864;
                    z6 = z5;
                } else {
                    z6 = z5;
                    if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                    }
                }
                i11 = 128 & i6;
                if (i11 != 0) {
                    i7 |= 12582912;
                    j6 = j5;
                } else {
                    j6 = j5;
                    if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(j6) ? 8388608 : 4194304;
                    }
                }
                i12 = 256 & i6;
                if (i12 != 0) {
                    i7 |= 100663296;
                } else if ((i5 & 100663296) == 0) {
                    i7 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
                }
                if ((i6 & 512) != 0) {
                    i7 |= 805306368;
                } else if ((i5 & 805306368) == 0) {
                    i7 |= startRestartGroup.changedInstance(function0) ? 536870912 : 268435456;
                }
                if ((306783379 & i7) == 306783378 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i6 & 8) != 0) {
                            shape3 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium();
                            i7 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        String str5 = i8 != 0 ? null : str2;
                        Integer num4 = i9 != 0 ? null : num;
                        if (i10 != 0) {
                            z6 = false;
                        }
                        if (i11 != 0) {
                            j6 = AppColor.INSTANCE.m3253getBrandBlack10d7_KjU();
                        }
                        if (i12 != 0) {
                            num2 = num4;
                            z7 = z6;
                            str3 = str5;
                            modifier3 = modifier2;
                            f6 = Dp.m2599constructorimpl(1);
                        } else {
                            num2 = num4;
                            z7 = z6;
                            str3 = str5;
                            modifier3 = modifier2;
                            f6 = f5;
                        }
                        j7 = j6;
                        shape4 = shape3;
                        modifier4 = modifier3;
                        i13 = i7;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        str3 = str2;
                        num2 = num;
                        z7 = z6;
                        i13 = i7;
                        Modifier modifier6 = modifier2;
                        f6 = f5;
                        j7 = j6;
                        modifier4 = modifier6;
                        shape4 = shape2;
                    }
                    long j9 = j7;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-933375796, i13, -1, "dk.molslinjen.ui.views.reusable.LabelCard (LabelCard.kt:50)");
                    }
                    companion = Modifier.INSTANCE;
                    Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(companion, f6, j9, shape4);
                    AppColor appColor = AppColor.INSTANCE;
                    Modifier clip = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(modifier4, appColor.m3281getWhite0d7_KjU(), shape4), shape4);
                    if (!z7) {
                        m108borderxT4_qwU = companion;
                    }
                    Modifier then = clip.then(m108borderxT4_qwU);
                    boolean z10 = function0 != null;
                    startRestartGroup.startReplaceGroup(1731386964);
                    z8 = (1879048192 & i13) == 536870912;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: W1.t
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit LabelCard_Tek12BE$lambda$1$lambda$0;
                                LabelCard_Tek12BE$lambda$1$lambda$0 = LabelCardKt.LabelCard_Tek12BE$lambda$1$lambda$0(Function0.this);
                                return LabelCard_Tek12BE$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier height = IntrinsicKt.height(ClickableKt.m122clickableXHw0xAI$default(then, z10, null, null, (Function0) rememberedValue, 6, null), IntrinsicSize.Min);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Horizontal start = arrangement.getStart();
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    float f8 = f6;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion3.getTop(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    float f9 = 16;
                    Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m312paddingVpY3zN4(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f9), Dp.m2599constructorimpl(8)), 0.0f, 1, null);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
                    Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i16 = i13;
                    f7 = f8;
                    Shape shape6 = shape4;
                    Modifier modifier7 = modifier4;
                    TextKt.m940Text4IGK_g(header, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, (i13 & 14) | 384, 1572864, 65530);
                    composer2 = startRestartGroup;
                    final int dpToPx = ComposeExtensionsKt.dpToPx(4, composer2, 6);
                    composer2.startReplaceGroup(-260369874);
                    changed = composer2.changed(dpToPx);
                    rememberedValue2 = composer2.rememberedValue();
                    if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: W1.u
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                ContentTransform LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
                                LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4(dpToPx, (AnimatedContentTransitionScope) obj);
                                return LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceGroup();
                    AnimatedContentKt.AnimatedContent(str, null, (Function1) rememberedValue2, null, null, null, ComposableLambdaKt.rememberComposableLambda(444378576, true, new Function4<AnimatedContentScope, String, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.LabelCardKt$LabelCard$2$1$2
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, String str6, Composer composer3, Integer num5) {
                            invoke(animatedContentScope, str6, composer3, num5.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedContentScope AnimatedContent, String str6, Composer composer3, int i17) {
                            Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(444378576, i17, -1, "dk.molslinjen.ui.views.reusable.LabelCard.<anonymous>.<anonymous>.<anonymous> (LabelCard.kt:86)");
                            }
                            TextKt.m940Text4IGK_g(str6 == null ? BuildConfig.FLAVOR : str6, SkeletonKt.m3425skeletont9lfQc4$default(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(2), 0.0f, 0.0f, 13, null), str == null, null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 0, 1572864, 65532);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ((i16 >> 3) & 14) | 1572864, 58);
                    composer2.endNode();
                    composer2.startReplaceGroup(-494952864);
                    rememberedValue3 = composer2.rememberedValue();
                    companion2 = Composer.INSTANCE;
                    if (rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    final MutableState mutableState = (MutableState) rememberedValue3;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(-494950688);
                    if ((str3 != null && !((Boolean) mutableState.getValue()).booleanValue()) || num2 != null) {
                        if (num2 == null) {
                            composer2.startReplaceGroup(1836505986);
                            m2745rememberAsyncImagePainterMqRF_0 = PainterResources_androidKt.painterResource(num2.intValue(), composer2, (i16 >> 15) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1836583145);
                            composer2.startReplaceGroup(-494940907);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (rememberedValue4 == companion2.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: W1.v
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit LabelCard_Tek12BE$lambda$10$lambda$9$lambda$8;
                                        LabelCard_Tek12BE$lambda$10$lambda$9$lambda$8 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$9$lambda$8(MutableState.this, (AsyncImagePainter.State.Error) obj);
                                        return LabelCard_Tek12BE$lambda$10$lambda$9$lambda$8;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            composer2.endReplaceGroup();
                            m2745rememberAsyncImagePainterMqRF_0 = SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(str3, null, null, null, null, null, (Function1) rememberedValue4, null, 0, composer2, ((i16 >> 12) & 14) | 1572864, 446);
                            composer2.endReplaceGroup();
                        }
                        float f10 = 24;
                        ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.align(companion, companion3.getCenterVertically()), Dp.m2599constructorimpl(f9), 0.0f, Dp.m2599constructorimpl(f10), 0.0f, 10, null), Dp.m2599constructorimpl(f10)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, appColor.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597440, 40);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    num3 = num2;
                    z9 = z7;
                    j8 = j9;
                    shape5 = shape6;
                    modifier5 = modifier7;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    f7 = f5;
                    z9 = z6;
                    modifier5 = modifier2;
                    shape5 = shape2;
                    str4 = str2;
                    num3 = num;
                    long j10 = j6;
                    composer2 = startRestartGroup;
                    j8 = j10;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                    final float f11 = f7;
                    endRestartGroup.updateScope(new Function2() { // from class: W1.w
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LabelCard_Tek12BE$lambda$11;
                            LabelCard_Tek12BE$lambda$11 = LabelCardKt.LabelCard_Tek12BE$lambda$11(header, str, modifier5, shape5, str4, num3, z9, j8, f11, function0, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return LabelCard_Tek12BE$lambda$11;
                        }
                    });
                    return;
                }
                return;
            }
            i9 = 32 & i6;
            if (i9 != 0) {
            }
            i10 = i6 & 64;
            if (i10 != 0) {
            }
            i11 = 128 & i6;
            if (i11 != 0) {
            }
            i12 = 256 & i6;
            if (i12 != 0) {
            }
            if ((i6 & 512) != 0) {
            }
            if ((306783379 & i7) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            j7 = j6;
            shape4 = shape3;
            modifier4 = modifier3;
            i13 = i7;
            long j92 = j7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            companion = Modifier.INSTANCE;
            Modifier m108borderxT4_qwU2 = BorderKt.m108borderxT4_qwU(companion, f6, j92, shape4);
            AppColor appColor2 = AppColor.INSTANCE;
            Modifier clip2 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(modifier4, appColor2.m3281getWhite0d7_KjU(), shape4), shape4);
            if (!z7) {
            }
            Modifier then2 = clip2.then(m108borderxT4_qwU2);
            if (function0 != null) {
            }
            startRestartGroup.startReplaceGroup(1731386964);
            if ((1879048192 & i13) == 536870912) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue = new Function0() { // from class: W1.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit LabelCard_Tek12BE$lambda$1$lambda$0;
                    LabelCard_Tek12BE$lambda$1$lambda$0 = LabelCardKt.LabelCard_Tek12BE$lambda$1$lambda$0(Function0.this);
                    return LabelCard_Tek12BE$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier height2 = IntrinsicKt.height(ClickableKt.m122clickableXHw0xAI$default(then2, z10, null, null, (Function0) rememberedValue, 6, null), IntrinsicSize.Min);
            Arrangement arrangement2 = Arrangement.INSTANCE;
            Arrangement.Horizontal start2 = arrangement2.getStart();
            Alignment.Companion companion32 = Alignment.INSTANCE;
            float f82 = f6;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, companion32.getTop(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, height2);
            ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion42.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion42.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion42.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion42.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion42.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            float f92 = 16;
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(PaddingKt.m312paddingVpY3zN4(RowScope.weight$default(rowScopeInstance2, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f92), Dp.m2599constructorimpl(8)), 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default2);
            Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion42.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i162 = i13;
            f7 = f82;
            Shape shape62 = shape4;
            Modifier modifier72 = modifier4;
            TextKt.m940Text4IGK_g(header, null, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, (i13 & 14) | 384, 1572864, 65530);
            composer2 = startRestartGroup;
            final int dpToPx2 = ComposeExtensionsKt.dpToPx(4, composer2, 6);
            composer2.startReplaceGroup(-260369874);
            changed = composer2.changed(dpToPx2);
            rememberedValue2 = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1() { // from class: W1.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ContentTransform LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
                    LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4(dpToPx2, (AnimatedContentTransitionScope) obj);
                    return LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
                }
            };
            composer2.updateRememberedValue(rememberedValue2);
            composer2.endReplaceGroup();
            AnimatedContentKt.AnimatedContent(str, null, (Function1) rememberedValue2, null, null, null, ComposableLambdaKt.rememberComposableLambda(444378576, true, new Function4<AnimatedContentScope, String, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.LabelCardKt$LabelCard$2$1$2
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, String str6, Composer composer3, Integer num5) {
                    invoke(animatedContentScope, str6, composer3, num5.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedContentScope AnimatedContent, String str6, Composer composer3, int i17) {
                    Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(444378576, i17, -1, "dk.molslinjen.ui.views.reusable.LabelCard.<anonymous>.<anonymous>.<anonymous> (LabelCard.kt:86)");
                    }
                    TextKt.m940Text4IGK_g(str6 == null ? BuildConfig.FLAVOR : str6, SkeletonKt.m3425skeletont9lfQc4$default(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(2), 0.0f, 0.0f, 13, null), str == null, null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 0, 1572864, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, ((i162 >> 3) & 14) | 1572864, 58);
            composer2.endNode();
            composer2.startReplaceGroup(-494952864);
            rememberedValue3 = composer2.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (rememberedValue3 == companion2.getEmpty()) {
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-494950688);
            if (str3 != null) {
                if (num2 == null) {
                }
                float f102 = 24;
                ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance2.align(companion, companion32.getCenterVertically()), Dp.m2599constructorimpl(f92), 0.0f, Dp.m2599constructorimpl(f102), 0.0f, 10, null), Dp.m2599constructorimpl(f102)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, appColor2.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597440, 40);
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                str4 = str3;
                num3 = num2;
                z9 = z7;
                j8 = j92;
                shape5 = shape62;
                modifier5 = modifier72;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if (num2 == null) {
            }
            float f1022 = 24;
            ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance2.align(companion, companion32.getCenterVertically()), Dp.m2599constructorimpl(f92), 0.0f, Dp.m2599constructorimpl(f1022), 0.0f, 10, null), Dp.m2599constructorimpl(f1022)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, appColor2.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597440, 40);
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            str4 = str3;
            num3 = num2;
            z9 = z7;
            j8 = j92;
            shape5 = shape62;
            modifier5 = modifier72;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i5 & 3072) != 0) {
        }
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        i9 = 32 & i6;
        if (i9 != 0) {
        }
        i10 = i6 & 64;
        if (i10 != 0) {
        }
        i11 = 128 & i6;
        if (i11 != 0) {
        }
        i12 = 256 & i6;
        if (i12 != 0) {
        }
        if ((i6 & 512) != 0) {
        }
        if ((306783379 & i7) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        j7 = j6;
        shape4 = shape3;
        modifier4 = modifier3;
        i13 = i7;
        long j922 = j7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        companion = Modifier.INSTANCE;
        Modifier m108borderxT4_qwU22 = BorderKt.m108borderxT4_qwU(companion, f6, j922, shape4);
        AppColor appColor22 = AppColor.INSTANCE;
        Modifier clip22 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(modifier4, appColor22.m3281getWhite0d7_KjU(), shape4), shape4);
        if (!z7) {
        }
        Modifier then22 = clip22.then(m108borderxT4_qwU22);
        if (function0 != null) {
        }
        startRestartGroup.startReplaceGroup(1731386964);
        if ((1879048192 & i13) == 536870912) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z8) {
        }
        rememberedValue = new Function0() { // from class: W1.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit LabelCard_Tek12BE$lambda$1$lambda$0;
                LabelCard_Tek12BE$lambda$1$lambda$0 = LabelCardKt.LabelCard_Tek12BE$lambda$1$lambda$0(Function0.this);
                return LabelCard_Tek12BE$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier height22 = IntrinsicKt.height(ClickableKt.m122clickableXHw0xAI$default(then22, z10, null, null, (Function0) rememberedValue, 6, null), IntrinsicSize.Min);
        Arrangement arrangement22 = Arrangement.INSTANCE;
        Arrangement.Horizontal start22 = arrangement22.getStart();
        Alignment.Companion companion322 = Alignment.INSTANCE;
        float f822 = f6;
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(start22, companion322.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, height22);
        ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor32 = companion422.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy22, companion422.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion422.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion422.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion422.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        float f922 = 16;
        Modifier fillMaxHeight$default22 = SizeKt.fillMaxHeight$default(PaddingKt.m312paddingVpY3zN4(RowScope.weight$default(rowScopeInstance22, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f922), Dp.m2599constructorimpl(8)), 0.0f, 1, null);
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(arrangement22.getTop(), companion322.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default22);
        Function0<ComposeUiNode> constructor222 = companion422.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy22, companion422.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion422.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion422.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion422.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        int i1622 = i13;
        f7 = f822;
        Shape shape622 = shape4;
        Modifier modifier722 = modifier4;
        TextKt.m940Text4IGK_g(header, null, appColor22.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, (i13 & 14) | 384, 1572864, 65530);
        composer2 = startRestartGroup;
        final int dpToPx22 = ComposeExtensionsKt.dpToPx(4, composer2, 6);
        composer2.startReplaceGroup(-260369874);
        changed = composer2.changed(dpToPx22);
        rememberedValue2 = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1() { // from class: W1.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ContentTransform LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
                LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4(dpToPx22, (AnimatedContentTransitionScope) obj);
                return LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        composer2.endReplaceGroup();
        AnimatedContentKt.AnimatedContent(str, null, (Function1) rememberedValue2, null, null, null, ComposableLambdaKt.rememberComposableLambda(444378576, true, new Function4<AnimatedContentScope, String, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.LabelCardKt$LabelCard$2$1$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, String str6, Composer composer3, Integer num5) {
                invoke(animatedContentScope, str6, composer3, num5.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedContentScope AnimatedContent, String str6, Composer composer3, int i17) {
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(444378576, i17, -1, "dk.molslinjen.ui.views.reusable.LabelCard.<anonymous>.<anonymous>.<anonymous> (LabelCard.kt:86)");
                }
                TextKt.m940Text4IGK_g(str6 == null ? BuildConfig.FLAVOR : str6, SkeletonKt.m3425skeletont9lfQc4$default(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(2), 0.0f, 0.0f, 13, null), str == null, null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 0, 1572864, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, ((i1622 >> 3) & 14) | 1572864, 58);
        composer2.endNode();
        composer2.startReplaceGroup(-494952864);
        rememberedValue3 = composer2.rememberedValue();
        companion2 = Composer.INSTANCE;
        if (rememberedValue3 == companion2.getEmpty()) {
        }
        final MutableState mutableState22 = (MutableState) rememberedValue3;
        composer2.endReplaceGroup();
        composer2.startReplaceGroup(-494950688);
        if (str3 != null) {
        }
        if (num2 == null) {
        }
        float f10222 = 24;
        ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance22.align(companion, companion322.getCenterVertically()), Dp.m2599constructorimpl(f922), 0.0f, Dp.m2599constructorimpl(f10222), 0.0f, 10, null), Dp.m2599constructorimpl(f10222)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, appColor22.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597440, 40);
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str4 = str3;
        num3 = num2;
        z9 = z7;
        j8 = j922;
        shape5 = shape622;
        modifier5 = modifier722;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelCard_Tek12BE$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4(final int i5, AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 200, EasingFunctionsKt.getEaseOut()), 0.0f, 2, null).plus(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween(200, 200, EasingFunctionsKt.getEaseOut()), new Function1() { // from class: W1.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$2;
                LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$2 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$2(i5, ((Integer) obj).intValue());
                return Integer.valueOf(LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$2);
            }
        })), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(200, 0, EasingFunctionsKt.getEaseOut(), 2, null), 0.0f, 2, null).plus(EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(200, 0, EasingFunctionsKt.getEaseOut(), 2, null), new Function1() { // from class: W1.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$3;
                LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$3 = LabelCardKt.LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$3(i5, ((Integer) obj).intValue());
                return Integer.valueOf(LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$3);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$2(int i5, int i6) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int LabelCard_Tek12BE$lambda$10$lambda$6$lambda$5$lambda$4$lambda$3(int i5, int i6) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelCard_Tek12BE$lambda$10$lambda$9$lambda$8(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelCard_Tek12BE$lambda$11(String str, String str2, Modifier modifier, Shape shape, String str3, Integer num, boolean z5, long j5, float f5, Function0 function0, int i5, int i6, Composer composer, int i7) {
        m3391LabelCardTek12BE(str, str2, modifier, shape, str3, num, z5, j5, f5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
