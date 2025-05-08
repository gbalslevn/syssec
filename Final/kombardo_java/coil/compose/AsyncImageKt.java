package coil.compose;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009d\u0001\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aK\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\"\u001a\u001b\u0010'\u001a\u0004\u0018\u00010$*\u00020#H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {BuildConfig.FLAVOR, "model", BuildConfig.FLAVOR, "contentDescription", "Lcoil/ImageLoader;", "imageLoader", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "transform", BuildConfig.FLAVOR, "onState", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "AsyncImage-MvsnxeU", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "AsyncImage", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;I)V", "Lcoil/request/ImageRequest;", "request", "updateRequest", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Constraints;", "Lcoil/size/Size;", "toSizeOrNull-BRTryo0", "(J)Lcoil/size/Size;", "toSizeOrNull", "coil-compose-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AsyncImageKt {
    /* renamed from: AsyncImage-MvsnxeU */
    public static final void m2728AsyncImageMvsnxeU(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f5, ColorFilter colorFilter, int i5, Composer composer, final int i6, final int i7, final int i8) {
        final int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-2030202961);
        final Modifier modifier2 = (i8 & 8) != 0 ? Modifier.INSTANCE : modifier;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i8 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        final Function1<? super AsyncImagePainter.State, Unit> function13 = (i8 & 32) != 0 ? null : function12;
        final Alignment center = (i8 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final ContentScale fit = (i8 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final float f6 = (i8 & 256) != 0 ? 1.0f : f5;
        final ColorFilter colorFilter2 = (i8 & 512) != 0 ? null : colorFilter;
        if ((i8 & 1024) != 0) {
            i10 = i7 & (-15);
            i9 = DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I();
        } else {
            i9 = i5;
            i10 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2030202961, i6, i10, "coil.compose.AsyncImage (AsyncImage.kt:118)");
        }
        ImageRequest updateRequest = updateRequest(UtilsKt.requestOf(obj, startRestartGroup, 8), fit, startRestartGroup, 8 | ((i6 >> 18) & 112));
        int i11 = i6 >> 6;
        int i12 = i6 >> 9;
        int i13 = i12 & 57344;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = defaultTransform;
        Function1<? super AsyncImagePainter.State, Unit> function15 = function13;
        ContentScale contentScale2 = fit;
        int i14 = i9;
        AsyncImagePainter m2735rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m2735rememberAsyncImagePainter5jETZwI(updateRequest, imageLoader, function14, function15, contentScale2, i14, startRestartGroup, ((i10 << 15) & 458752) | (i11 & 7168) | (i11 & 896) | 72 | i13, 0);
        SizeResolver sizeResolver = updateRequest.getSizeResolver();
        Content(sizeResolver instanceof ConstraintsSizeResolver ? modifier2.then((Modifier) sizeResolver) : modifier2, m2735rememberAsyncImagePainter5jETZwI, str, center, fit, f6, colorFilter2, startRestartGroup, (i12 & 7168) | ((i6 << 3) & 896) | i13 | (i12 & 458752) | (3670016 & i12));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt$AsyncImage$1
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
                AsyncImageKt.m2728AsyncImageMvsnxeU(obj, str, imageLoader, modifier2, defaultTransform, function13, center, fit, f6, colorFilter2, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
            }
        });
    }

    public static final void Content(final Modifier modifier, final Painter painter, final String str, final Alignment alignment, final ContentScale contentScale, final float f5, final ColorFilter colorFilter, Composer composer, final int i5) {
        Modifier materializeWithCompositionLocalInjectionInternal;
        Composer startRestartGroup = composer.startRestartGroup(10290533);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10290533, i5, -1, "coil.compose.Content (AsyncImage.kt:156)");
        }
        Modifier then = ClipKt.clipToBounds(contentDescription(modifier, str)).then(new ContentPainterModifier(painter, alignment, contentScale, f5, colorFilter));
        AsyncImageKt$Content$1 asyncImageKt$Content$1 = new MeasurePolicy() { // from class: coil.compose.AsyncImageKt$Content$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.AsyncImageKt$Content$1$measure$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
        };
        startRestartGroup.startReplaceableGroup(544976794);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        materializeWithCompositionLocalInjectionInternal = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal(startRestartGroup, then);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        final Function0<ComposeUiNode> constructor = companion.getConstructor();
        startRestartGroup.startReplaceableGroup(1405779621);
        if (startRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil.compose.AsyncImageKt$Content$$inlined$Layout$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final ComposeUiNode invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            startRestartGroup.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, asyncImageKt$Content$1, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, density, companion.getSetDensity());
        Updater.m1227setimpl(m1226constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1227setimpl(m1226constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        Updater.m1227setimpl(m1226constructorimpl, materializeWithCompositionLocalInjectionInternal, companion.getSetModifier());
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt$Content$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                AsyncImageKt.Content(Modifier.this, painter, str, alignment, contentScale, f5, colorFilter, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
            }
        });
    }

    /* renamed from: access$toSizeOrNull-BRTryo0 */
    public static final /* synthetic */ Size m2729access$toSizeOrNullBRTryo0(long j5) {
        return m2730toSizeOrNullBRTryo0(j5);
    }

    private static final Modifier contentDescription(Modifier modifier, final String str) {
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: coil.compose.AsyncImageKt$contentDescription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2173getImageo7Vup1c());
            }
        }, 1, null) : modifier;
    }

    /* renamed from: toSizeOrNull-BRTryo0 */
    public static final Size m2730toSizeOrNullBRTryo0(long j5) {
        if (Constraints.m2582isZeroimpl(j5)) {
            return null;
        }
        return new Size(Constraints.m2574getHasBoundedWidthimpl(j5) ? Dimensions.Dimension(Constraints.m2578getMaxWidthimpl(j5)) : Dimension.Undefined.INSTANCE, Constraints.m2573getHasBoundedHeightimpl(j5) ? Dimensions.Dimension(Constraints.m2577getMaxHeightimpl(j5)) : Dimension.Undefined.INSTANCE);
    }

    public static final ImageRequest updateRequest(ImageRequest imageRequest, ContentScale contentScale, Composer composer, int i5) {
        SizeResolver sizeResolver;
        composer.startReplaceableGroup(402368983);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(402368983, i5, -1, "coil.compose.updateRequest (AsyncImage.kt:183)");
        }
        if (imageRequest.getDefined().getSizeResolver() == null) {
            if (Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getNone())) {
                sizeResolver = SizeResolvers.create(Size.ORIGINAL);
            } else {
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new ConstraintsSizeResolver();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                sizeResolver = (SizeResolver) rememberedValue;
            }
            imageRequest = ImageRequest.newBuilder$default(imageRequest, null, 1, null).size(sizeResolver).build();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageRequest;
    }
}
