package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a9\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a_\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u001f\u001a\u00020\u001b*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\"\u001a\u00020\u001b*\u00020\u001a2\u0006\u0010 \u001a\u00020\u001bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u001e\u001a\u0019\u0010'\u001a\u00020$*\u00020#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\"\u001d\u0010(\u001a\u00020\u001a8\u0000X\u0080\u0004ø\u0001\u0001¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {BuildConfig.FLAVOR, "model", "Lcoil/request/ImageRequest;", "requestOf", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "Landroidx/compose/ui/graphics/painter/Painter;", "placeholder", "error", "fallback", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "transformOf", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)Lkotlin/jvm/functions/Function1;", "Lcoil/compose/AsyncImagePainter$State$Loading;", BuildConfig.FLAVOR, "onLoading", "Lcoil/compose/AsyncImagePainter$State$Success;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Error;", "onError", "onStateOf", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/layout/ContentScale;", "Lcoil/size/Scale;", "toScale", "(Landroidx/compose/ui/layout/ContentScale;)Lcoil/size/Scale;", "Landroidx/compose/ui/unit/Constraints;", BuildConfig.FLAVOR, "width", "constrainWidth-K40F9xA", "(JF)F", "constrainWidth", "height", "constrainHeight-K40F9xA", "constrainHeight", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/IntSize;", "toIntSize-uvyYCjk", "(J)J", "toIntSize", "ZeroConstraints", "J", "getZeroConstraints", "()J", "coil-compose-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class UtilsKt {
    private static final long ZeroConstraints = Constraints.INSTANCE.m2587fixedJhjzzOo(0, 0);

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m2746constrainHeightK40F9xA(long j5, float f5) {
        return RangesKt.coerceIn(f5, Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m2747constrainWidthK40F9xA(long j5, float f5) {
        return RangesKt.coerceIn(f5, Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(final Function1<? super AsyncImagePainter.State.Loading, Unit> function1, final Function1<? super AsyncImagePainter.State.Success, Unit> function12, final Function1<? super AsyncImagePainter.State.Error, Unit> function13) {
        if (function1 == null && function12 == null && function13 == null) {
            return null;
        }
        return new Function1<AsyncImagePainter.State, Unit>() { // from class: coil.compose.UtilsKt$onStateOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AsyncImagePainter.State state) {
                invoke2(state);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AsyncImagePainter.State state) {
                if (state instanceof AsyncImagePainter.State.Loading) {
                    Function1<AsyncImagePainter.State.Loading, Unit> function14 = function1;
                    if (function14 != null) {
                        function14.invoke(state);
                        return;
                    }
                    return;
                }
                if (state instanceof AsyncImagePainter.State.Success) {
                    Function1<AsyncImagePainter.State.Success, Unit> function15 = function12;
                    if (function15 != null) {
                        function15.invoke(state);
                        return;
                    }
                    return;
                }
                if (!(state instanceof AsyncImagePainter.State.Error)) {
                    boolean z5 = state instanceof AsyncImagePainter.State.Empty;
                    return;
                }
                Function1<AsyncImagePainter.State.Error, Unit> function16 = function13;
                if (function16 != null) {
                    function16.invoke(state);
                }
            }
        };
    }

    public static final ImageRequest requestOf(Object obj, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1151830858, i5, -1, "coil.compose.requestOf (Utils.kt:21)");
        }
        return obj instanceof ImageRequest ? (ImageRequest) obj : new ImageRequest.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data(obj).build();
    }

    /* renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m2748toIntSizeuvyYCjk(long j5) {
        return IntSizeKt.IntSize(MathKt.roundToInt(Size.m1377getWidthimpl(j5)), MathKt.roundToInt(Size.m1375getHeightimpl(j5)));
    }

    public static final Scale toScale(ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.INSTANCE;
        return Intrinsics.areEqual(contentScale, companion.getFit()) ? true : Intrinsics.areEqual(contentScale, companion.getInside()) ? Scale.FIT : Scale.FILL;
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(final Painter painter, final Painter painter2, final Painter painter3) {
        return (painter == null && painter2 == null && painter3 == null) ? AsyncImagePainter.INSTANCE.getDefaultTransform() : new Function1<AsyncImagePainter.State, AsyncImagePainter.State>() { // from class: coil.compose.UtilsKt$transformOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
                if (state instanceof AsyncImagePainter.State.Loading) {
                    Painter painter4 = Painter.this;
                    AsyncImagePainter.State.Loading loading = (AsyncImagePainter.State.Loading) state;
                    return painter4 != null ? loading.copy(painter4) : loading;
                }
                if (!(state instanceof AsyncImagePainter.State.Error)) {
                    return state;
                }
                AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
                if (error.getResult().getThrowable() instanceof NullRequestDataException) {
                    Painter painter5 = painter3;
                    return painter5 != null ? AsyncImagePainter.State.Error.copy$default(error, painter5, null, 2, null) : error;
                }
                Painter painter6 = painter2;
                return painter6 != null ? AsyncImagePainter.State.Error.copy$default(error, painter6, null, 2, null) : error;
            }
        };
    }
}
