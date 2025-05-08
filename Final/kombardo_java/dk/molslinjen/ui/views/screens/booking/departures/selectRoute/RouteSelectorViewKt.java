package dk.molslinjen.ui.views.screens.booking.departures.selectRoute;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.extensions.domain.HarborExtensionsKt;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.HarborReference;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorViewKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aO\u0010\f\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0011\u001a\u00020\u0006*\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a=\u0010\u0016\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001c²\u0006\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\nX\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u00020\u001a8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "routeDirectionGroup", BuildConfig.FLAVOR, "lineIconUrl", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", BuildConfig.FLAVOR, "showRouteSelector", "Lkotlin/Function0;", "flipDirection", BuildConfig.FLAVOR, "showRouteSwitchWithText", "RouteSelectorView", "(Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/BoxScope;", "Ldk/molslinjen/domain/model/config/Subline;", "subline", "RouteIconView", "(Landroidx/compose/foundation/layout/BoxScope;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "containerHeight", "TravelPointLabelCards", "(Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", BuildConfig.FLAVOR, "rotationAngleAnimation", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteSelectorViewKt {
    private static final void RouteIconView(final BoxScope boxScope, final Subline subline, final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        String skip;
        Composer startRestartGroup = composer.startRestartGroup(-1602620256);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(subline) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1602620256, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteIconView (RouteSelectorView.kt:123)");
            }
            startRestartGroup.startReplaceGroup(-279117165);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-279115341);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-279112863);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new RouteSelectorViewKt$RouteIconView$1$1(mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(subline, str, (Function2) rememberedValue3, startRestartGroup, (i6 >> 3) & 126);
            if ((subline == null && str == null) || ((Boolean) mutableState.getValue()).booleanValue()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: P2.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RouteIconView$lambda$18;
                            RouteIconView$lambda$18 = RouteSelectorViewKt.RouteIconView$lambda$18(BoxScope.this, subline, str, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return RouteIconView$lambda$18;
                        }
                    });
                    return;
                }
                return;
            }
            float f5 = 16;
            String m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(str == null ? subline != null ? subline.getIconUrl() : null : str, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3456, 2);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 4;
            float f7 = 8;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(BackgroundKt.m103backgroundbw27NRU(companion2, ((Boolean) mutableState2.getValue()).booleanValue() ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3280getTransparent0d7_KjU(), RoundedCornerShapeKt.m462RoundedCornerShapea9UjIt4$default(Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 12, null)), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(28));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Modifier align = boxScope.align(m314paddingqDBjuR0, companion3.getTopCenter());
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, align);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(BoxScopeInstance.INSTANCE.align(companion2, companion3.getTopStart()), Dp.m2599constructorimpl(f5));
            startRestartGroup.startReplaceGroup(-1933242714);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: P2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteIconView$lambda$25$lambda$20$lambda$19;
                        RouteIconView$lambda$25$lambda$20$lambda$19 = RouteSelectorViewKt.RouteIconView$lambda$25$lambda$20$lambda$19(MutableState.this, mutableState, (AsyncImagePainter.State.Loading) obj);
                        return RouteIconView$lambda$25$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1933234864);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: P2.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteIconView$lambda$25$lambda$22$lambda$21;
                        RouteIconView$lambda$25$lambda$22$lambda$21 = RouteSelectorViewKt.RouteIconView$lambda$25$lambda$22$lambda$21(MutableState.this, (AsyncImagePainter.State.Success) obj);
                        return RouteIconView$lambda$25$lambda$22$lambda$21;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function1 function12 = (Function1) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1933238089);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: P2.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteIconView$lambda$25$lambda$24$lambda$23;
                        RouteIconView$lambda$25$lambda$24$lambda$23 = RouteSelectorViewKt.RouteIconView$lambda$25$lambda$24$lambda$23(MutableState.this, (AsyncImagePainter.State.Error) obj);
                        return RouteIconView$lambda$25$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AsyncImagePainter m2745rememberAsyncImagePainterMqRF_0 = SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, function1, function12, (Function1) rememberedValue6, null, 0, startRestartGroup, 1794048, 398);
            if (subline == null || (skip = subline.getName()) == null) {
                skip = Accessibility.INSTANCE.getSkip();
            }
            ImageKt.Image(m2745rememberAsyncImagePainterMqRF_0, skip, m325height3ABfNKs, null, null, 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0, 2, null), composer2, 1572864, 56);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: P2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteIconView$lambda$26;
                    RouteIconView$lambda$26 = RouteSelectorViewKt.RouteIconView$lambda$26(BoxScope.this, subline, str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteIconView$lambda$26;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteIconView$lambda$18(BoxScope boxScope, Subline subline, String str, int i5, Composer composer, int i6) {
        RouteIconView(boxScope, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteIconView$lambda$25$lambda$20$lambda$19(MutableState mutableState, MutableState mutableState2, AsyncImagePainter.State.Loading it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Boolean bool = Boolean.FALSE;
        mutableState.setValue(bool);
        mutableState2.setValue(bool);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteIconView$lambda$25$lambda$22$lambda$21(MutableState mutableState, AsyncImagePainter.State.Success it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteIconView$lambda$25$lambda$24$lambda$23(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteIconView$lambda$26(BoxScope boxScope, Subline subline, String str, int i5, Composer composer, int i6) {
        RouteIconView(boxScope, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void RouteSelectorView(final RouteDirectionGroup routeDirectionGroup, final String str, final Function1<? super RouteDirection, Unit> function1, final Function0<Unit> flipDirection, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        List<RouteDirectionDetails> routes;
        RouteDirectionDetails routeDirectionDetails;
        Intrinsics.checkNotNullParameter(flipDirection, "flipDirection");
        Composer startRestartGroup = composer.startRestartGroup(1568016527);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(routeDirectionGroup) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(flipDirection) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568016527, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorView (RouteSelectorView.kt:62)");
            }
            startRestartGroup.startReplaceGroup(-845174312);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Subline subline = (routeDirectionGroup == null || (routes = routeDirectionGroup.getRoutes()) == null || (routeDirectionDetails = (RouteDirectionDetails) CollectionsKt.firstOrNull((List) routes)) == null) ? null : routeDirectionDetails.getSubline();
            boolean z6 = (str == null && subline == null) ? false : true;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            RouteIconView(boxScopeInstance, subline, str, startRestartGroup, ((i7 << 3) & 896) | 6);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, z6 ? Dp.m2599constructorimpl(24) : Dp.m2599constructorimpl(0), 0.0f, 0.0f, 13, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            TravelPointLabelCards(routeDirectionGroup, mutableIntState, function1, startRestartGroup, (i7 & 14) | 48 | (i7 & 896));
            if (z5) {
                startRestartGroup.startReplaceGroup(-1653794944);
                String language = Locale.getDefault().getLanguage();
                composer2 = startRestartGroup;
                LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(Intrinsics.areEqual(language, "da") ? R.raw.animation_lottie_change_direction_right_da : Intrinsics.areEqual(language, "sv") ? R.raw.animation_lottie_change_direction_right_sv : R.raw.animation_lottie_change_direction_right_en)), null, null, null, null, null, startRestartGroup, 0, 62);
                composer2.startReplaceGroup(-2131544361);
                Object rememberedValue2 = composer2.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer2.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState = (MutableState) rememberedValue2;
                composer2.endReplaceGroup();
                final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_changeDirection, composer2, 6);
                LottieComposition RouteSelectorView$lambda$13$lambda$12$lambda$1 = RouteSelectorView$lambda$13$lambda$12$lambda$1(rememberLottieComposition);
                float f5 = ((Boolean) mutableState.getValue()).booleanValue() ? 1.0f : -1.0f;
                Modifier align = boxScopeInstance.align(ClipKt.clip(SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(48)), RoundedCornerShapeKt.getCircleShape()), companion3.getCenter());
                composer2.startReplaceGroup(-2131528129);
                boolean z7 = (i7 & 7168) == 2048;
                Object rememberedValue3 = composer2.rememberedValue();
                if (z7 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: P2.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit RouteSelectorView$lambda$13$lambda$12$lambda$4$lambda$3;
                            RouteSelectorView$lambda$13$lambda$12$lambda$4$lambda$3 = RouteSelectorViewKt.RouteSelectorView$lambda$13$lambda$12$lambda$4$lambda$3(MutableState.this, flipDirection);
                            return RouteSelectorView$lambda$13$lambda$12$lambda$4$lambda$3;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(align, false, null, null, (Function0) rememberedValue3, 7, null);
                composer2.startReplaceGroup(-2131522650);
                boolean changed = composer2.changed(stringResource);
                Object rememberedValue4 = composer2.rememberedValue();
                if (changed || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: P2.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit RouteSelectorView$lambda$13$lambda$12$lambda$6$lambda$5;
                            RouteSelectorView$lambda$13$lambda$12$lambda$6$lambda$5 = RouteSelectorViewKt.RouteSelectorView$lambda$13$lambda$12$lambda$6$lambda$5(stringResource, (SemanticsPropertyReceiver) obj);
                            return RouteSelectorView$lambda$13$lambda$12$lambda$6$lambda$5;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                LottieAnimationKt.LottieAnimation(RouteSelectorView$lambda$13$lambda$12$lambda$1, SemanticsModifierKt.semantics$default(m122clickableXHw0xAI$default, false, (Function1) rememberedValue4, 1, null), false, false, null, f5, 0, false, false, false, null, false, false, null, null, null, false, null, composer2, 0, 0, 262108);
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1652579000);
                Object[] objArr = new Object[0];
                composer2.startReplaceGroup(-2131518133);
                Object rememberedValue5 = composer2.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: P2.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState RouteSelectorView$lambda$13$lambda$12$lambda$8$lambda$7;
                            RouteSelectorView$lambda$13$lambda$12$lambda$8$lambda$7 = RouteSelectorViewKt.RouteSelectorView$lambda$13$lambda$12$lambda$8$lambda$7();
                            return RouteSelectorView$lambda$13$lambda$12$lambda$8$lambda$7;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue5, composer2, 3072, 6);
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(((Number) mutableState2.getValue()).floatValue(), AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, null, null, composer2, 0, 28);
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_switch, composer2, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_changeDirection, composer2, 6);
                Modifier align2 = boxScopeInstance.align(ClipKt.clip(SizeKt.m331size3ABfNKs(RotateKt.rotate(companion2, RouteSelectorView$lambda$13$lambda$12$lambda$9(animateFloatAsState)), Dp.m2599constructorimpl(48)), RoundedCornerShapeKt.getCircleShape()), companion3.getCenter());
                composer2.startReplaceGroup(-2131495020);
                boolean changed2 = composer2.changed(mutableState2) | ((i7 & 7168) == 2048);
                Object rememberedValue6 = composer2.rememberedValue();
                if (changed2 || rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: P2.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit RouteSelectorView$lambda$13$lambda$12$lambda$11$lambda$10;
                            RouteSelectorView$lambda$13$lambda$12$lambda$11$lambda$10 = RouteSelectorViewKt.RouteSelectorView$lambda$13$lambda$12$lambda$11$lambda$10(MutableState.this, flipDirection);
                            return RouteSelectorView$lambda$13$lambda$12$lambda$11$lambda$10;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                composer2.endReplaceGroup();
                ImageKt.Image(painterResource, stringResource2, ClickableKt.m122clickableXHw0xAI$default(align2, false, null, null, (Function0) rememberedValue6, 7, null), null, null, 0.0f, null, composer2, 0, 120);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorView$lambda$14;
                    RouteSelectorView$lambda$14 = RouteSelectorViewKt.RouteSelectorView$lambda$14(RouteDirectionGroup.this, str, function1, flipDirection, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorView$lambda$14;
                }
            });
        }
    }

    private static final LottieComposition RouteSelectorView$lambda$13$lambda$12$lambda$1(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorView$lambda$13$lambda$12$lambda$11$lambda$10(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Float.valueOf(((Number) mutableState.getValue()).floatValue() + 180.0f));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorView$lambda$13$lambda$12$lambda$4$lambda$3(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorView$lambda$13$lambda$12$lambda$6$lambda$5(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState RouteSelectorView$lambda$13$lambda$12$lambda$8$lambda$7() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        return mutableStateOf$default;
    }

    private static final float RouteSelectorView$lambda$13$lambda$12$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorView$lambda$14(RouteDirectionGroup routeDirectionGroup, String str, Function1 function1, Function0 function0, boolean z5, int i5, Composer composer, int i6) {
        RouteSelectorView(routeDirectionGroup, str, function1, function0, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TravelPointLabelCards(final RouteDirectionGroup routeDirectionGroup, final MutableState<Integer> mutableState, final Function1<? super RouteDirection, Unit> function1, Composer composer, final int i5) {
        int i6;
        char c5;
        Function0 function0;
        Composer composer2;
        HarborReference arrivalHarbor;
        HarborReference departureHarbor;
        Composer startRestartGroup = composer.startRestartGroup(-1217614155);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(routeDirectionGroup) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(mutableState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1217614155, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectRoute.TravelPointLabelCards (RouteSelectorView.kt:173)");
            }
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(25));
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String stringResource = StringResources_androidKt.stringResource(R.string.common_from, startRestartGroup, 6);
            Function0 function02 = null;
            String harborName = (routeDirectionGroup == null || (departureHarbor = routeDirectionGroup.getDepartureHarbor()) == null) ? null : HarborExtensionsKt.harborName(departureHarbor, routeDirectionGroup.getUseRegionsAsHarbors());
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            startRestartGroup.startReplaceGroup(-1303858312);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: P2.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TravelPointLabelCards$lambda$39$lambda$28$lambda$27;
                        TravelPointLabelCards$lambda$39$lambda$28$lambda$27 = RouteSelectorViewKt.TravelPointLabelCards$lambda$39$lambda$28$lambda$27(MutableState.this, (LayoutCoordinates) obj);
                        return TravelPointLabelCards$lambda$39$lambda$28$lambda$27;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(weight$default, (Function1) rememberedValue);
            startRestartGroup.startReplaceGroup(-1303851148);
            float pxToDp = ComposeExtensionsKt.pxToDp(mutableState.getValue().intValue(), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            Modifier m335sizeInqDBjuR0$default = SizeKt.m335sizeInqDBjuR0$default(onGloballyPositioned, 0.0f, pxToDp, 0.0f, 0.0f, 13, null);
            startRestartGroup.startReplaceGroup(-1303848444);
            if (function1 == null) {
                function0 = null;
                c5 = 256;
            } else {
                startRestartGroup.startReplaceGroup(-882538081);
                c5 = 256;
                boolean z6 = (i7 & 896) == 256;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: P2.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TravelPointLabelCards$lambda$39$lambda$32$lambda$31$lambda$30;
                            TravelPointLabelCards$lambda$39$lambda$32$lambda$31$lambda$30 = RouteSelectorViewKt.TravelPointLabelCards$lambda$39$lambda$32$lambda$31$lambda$30(Function1.this);
                            return TravelPointLabelCards$lambda$39$lambda$32$lambda$31$lambda$30;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                function0 = (Function0) rememberedValue2;
            }
            startRestartGroup.endReplaceGroup();
            LabelCardKt.m3391LabelCardTek12BE(stringResource, harborName, m335sizeInqDBjuR0$default, null, null, null, false, 0L, 0.0f, function0, startRestartGroup, 0, 504);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.common_to, startRestartGroup, 6);
            String harborName2 = (routeDirectionGroup == null || (arrivalHarbor = routeDirectionGroup.getArrivalHarbor()) == null) ? null : HarborExtensionsKt.harborName(arrivalHarbor, routeDirectionGroup.getUseRegionsAsHarbors());
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            startRestartGroup.startReplaceGroup(-1303835048);
            boolean z7 = i8 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: P2.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TravelPointLabelCards$lambda$39$lambda$34$lambda$33;
                        TravelPointLabelCards$lambda$39$lambda$34$lambda$33 = RouteSelectorViewKt.TravelPointLabelCards$lambda$39$lambda$34$lambda$33(MutableState.this, (LayoutCoordinates) obj);
                        return TravelPointLabelCards$lambda$39$lambda$34$lambda$33;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(weight$default2, (Function1) rememberedValue3);
            startRestartGroup.startReplaceGroup(-1303827884);
            float pxToDp2 = ComposeExtensionsKt.pxToDp(mutableState.getValue().intValue(), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            Modifier m335sizeInqDBjuR0$default2 = SizeKt.m335sizeInqDBjuR0$default(onGloballyPositioned2, 0.0f, pxToDp2, 0.0f, 0.0f, 13, null);
            startRestartGroup.startReplaceGroup(-1303825182);
            if (function1 != null) {
                startRestartGroup.startReplaceGroup(-882514819);
                boolean z8 = (i7 & 896) == 256;
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: P2.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TravelPointLabelCards$lambda$39$lambda$38$lambda$37$lambda$36;
                            TravelPointLabelCards$lambda$39$lambda$38$lambda$37$lambda$36 = RouteSelectorViewKt.TravelPointLabelCards$lambda$39$lambda$38$lambda$37$lambda$36(Function1.this);
                            return TravelPointLabelCards$lambda$39$lambda$38$lambda$37$lambda$36;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                function02 = (Function0) rememberedValue4;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LabelCardKt.m3391LabelCardTek12BE(stringResource2, harborName2, m335sizeInqDBjuR0$default2, null, null, null, false, 0L, 0.0f, function02, composer2, 0, 504);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P2.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TravelPointLabelCards$lambda$40;
                    TravelPointLabelCards$lambda$40 = RouteSelectorViewKt.TravelPointLabelCards$lambda$40(RouteDirectionGroup.this, mutableState, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TravelPointLabelCards$lambda$40;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelPointLabelCards$lambda$39$lambda$28$lambda$27(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()) > ((Number) mutableState.getValue()).intValue()) {
            mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelPointLabelCards$lambda$39$lambda$32$lambda$31$lambda$30(Function1 function1) {
        function1.invoke(RouteDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelPointLabelCards$lambda$39$lambda$34$lambda$33(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()) > ((Number) mutableState.getValue()).intValue()) {
            mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelPointLabelCards$lambda$39$lambda$38$lambda$37$lambda$36(Function1 function1) {
        function1.invoke(RouteDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelPointLabelCards$lambda$40(RouteDirectionGroup routeDirectionGroup, MutableState mutableState, Function1 function1, int i5, Composer composer, int i6) {
        TravelPointLabelCards(routeDirectionGroup, mutableState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
