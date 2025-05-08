package coil.compose;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Precision;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import com.google.accompanist.drawablepainter.DrawablePainter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\b\u0007\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0002|}B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u000e*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u0001*\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\t*\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010\u000bJ\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bJ\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bR\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b1\u00102R/\u0010:\u001a\u0004\u0018\u00010\u00012\b\u00103\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010!\u001a\u00020 2\u0006\u00103\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R/\u0010&\u001a\u0004\u0018\u00010%2\b\u00103\u001a\u0004\u0018\u00010%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u00105\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bF\u0010G\"\u0004\bH\u0010\u0011R(\u0010I\u001a\u0004\u0018\u00010\u00012\b\u0010E\u001a\u0004\u0018\u00010\u00018\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bI\u0010J\"\u0004\bK\u00109R.\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR0\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bS\u0010N\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\"\u0010W\u001a\u00020V8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R+\u0010^\u001a\u00020]8\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR+\u0010n\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bj\u00105\u001a\u0004\bk\u0010l\"\u0004\bm\u0010\u0011R+\u0010\u0004\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bo\u00105\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR+\u0010\u0006\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00058F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bt\u00105\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001d\u0010{\u001a\u0002008VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\by\u0010z\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006~"}, d2 = {"Lcoil/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "Lcoil/request/ImageRequest;", "request", "Lcoil/ImageLoader;", "imageLoader", "<init>", "(Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V", BuildConfig.FLAVOR, "clear", "()V", "updateRequest", "(Lcoil/request/ImageRequest;)Lcoil/request/ImageRequest;", "Lcoil/compose/AsyncImagePainter$State;", "input", "updateState", "(Lcoil/compose/AsyncImagePainter$State;)V", "previous", "current", "Lcoil/compose/CrossfadePainter;", "maybeNewCrossfadePainter", "(Lcoil/compose/AsyncImagePainter$State;Lcoil/compose/AsyncImagePainter$State;)Lcoil/compose/CrossfadePainter;", "Lcoil/request/ImageResult;", "toState", "(Lcoil/request/ImageResult;)Lcoil/compose/AsyncImagePainter$State;", "Landroid/graphics/drawable/Drawable;", "toPainter", "(Landroid/graphics/drawable/Drawable;)Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "alpha", BuildConfig.FLAVOR, "applyAlpha", "(F)Z", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "onRemembered", "onForgotten", "onAbandoned", "Lkotlinx/coroutines/CoroutineScope;", "rememberScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/geometry/Size;", "drawSize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "<set-?>", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter", "alpha$delegate", "getAlpha", "()F", "setAlpha", "(F)V", "colorFilter$delegate", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "value", "_state", "Lcoil/compose/AsyncImagePainter$State;", "set_state", "_painter", "Landroidx/compose/ui/graphics/painter/Painter;", "set_painter", "Lkotlin/Function1;", "transform", "Lkotlin/jvm/functions/Function1;", "getTransform$coil_compose_base_release", "()Lkotlin/jvm/functions/Function1;", "setTransform$coil_compose_base_release", "(Lkotlin/jvm/functions/Function1;)V", "onState", "getOnState$coil_compose_base_release", "setOnState$coil_compose_base_release", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_base_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_base_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "I", "getFilterQuality-f-v9h1I$coil_compose_base_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_base_release", "(I)V", "isPreview", "Z", "isPreview$coil_compose_base_release", "()Z", "setPreview$coil_compose_base_release", "(Z)V", "state$delegate", "getState", "()Lcoil/compose/AsyncImagePainter$State;", "setState", "state", "request$delegate", "getRequest", "()Lcoil/request/ImageRequest;", "setRequest$coil_compose_base_release", "(Lcoil/request/ImageRequest;)V", "imageLoader$delegate", "getImageLoader", "()Lcoil/ImageLoader;", "setImageLoader$coil_compose_base_release", "(Lcoil/ImageLoader;)V", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "Companion", "State", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncImagePainter extends Painter implements RememberObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<State, State> DefaultTransform = new Function1<State, State>() { // from class: coil.compose.AsyncImagePainter$Companion$DefaultTransform$1
        @Override // kotlin.jvm.functions.Function1
        public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
            return state;
        }
    };
    private Painter _painter;
    private State _state;

    /* renamed from: alpha$delegate, reason: from kotlin metadata */
    private final MutableState alpha;

    /* renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter;
    private ContentScale contentScale;
    private final MutableStateFlow<Size> drawSize = StateFlowKt.MutableStateFlow(Size.m1370boximpl(Size.INSTANCE.m1384getZeroNHjbRc()));
    private int filterQuality;

    /* renamed from: imageLoader$delegate, reason: from kotlin metadata */
    private final MutableState imageLoader;
    private boolean isPreview;
    private Function1<? super State, Unit> onState;

    /* renamed from: painter$delegate, reason: from kotlin metadata */
    private final MutableState painter;
    private CoroutineScope rememberScope;

    /* renamed from: request$delegate, reason: from kotlin metadata */
    private final MutableState request;

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private final MutableState state;
    private Function1<? super State, ? extends State> transform;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcoil/compose/AsyncImagePainter$Companion;", BuildConfig.FLAVOR, "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcoil/compose/AsyncImagePainter$State;", BuildConfig.FLAVOR, "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Error", "Loading", "Success", "Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State$Success;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State;", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Empty extends State {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return null;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Lcoil/request/ErrorResult;", "result", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)V", "copy", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)Lcoil/compose/AsyncImagePainter$State$Error;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Lcoil/request/ErrorResult;", "getResult", "()Lcoil/request/ErrorResult;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final /* data */ class Error extends State {
            private final Painter painter;
            private final ErrorResult result;

            public Error(Painter painter, ErrorResult errorResult) {
                super(null);
                this.painter = painter;
                this.result = errorResult;
            }

            public static /* synthetic */ Error copy$default(Error error, Painter painter, ErrorResult errorResult, int i5, Object obj) {
                if ((i5 & 1) != 0) {
                    painter = error.painter;
                }
                if ((i5 & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter, errorResult);
            }

            public final Error copy(Painter painter, ErrorResult result) {
                return new Error(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }

            public int hashCode() {
                Painter painter = this.painter;
                return ((painter == null ? 0 : painter.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "copy", "(Landroidx/compose/ui/graphics/painter/Painter;)Lcoil/compose/AsyncImagePainter$State$Loading;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final /* data */ class Loading extends State {
            private final Painter painter;

            public Loading(Painter painter) {
                super(null);
                this.painter = painter;
            }

            public final Loading copy(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) other).painter);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Lcoil/request/SuccessResult;", "result", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/SuccessResult;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Lcoil/request/SuccessResult;", "getResult", "()Lcoil/request/SuccessResult;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final /* data */ class Success extends State {
            private final Painter painter;
            private final SuccessResult result;

            public Success(Painter painter, SuccessResult successResult) {
                super(null);
                this.painter = painter;
                this.result = successResult;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Painter getPainter();

        private State() {
        }
    }

    public AsyncImagePainter(ImageRequest imageRequest, ImageLoader imageLoader) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.painter = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.alpha = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.colorFilter = mutableStateOf$default3;
        State.Empty empty = State.Empty.INSTANCE;
        this._state = empty;
        this.transform = DefaultTransform;
        this.contentScale = ContentScale.INSTANCE.getFit();
        this.filterQuality = DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(empty, null, 2, null);
        this.state = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageRequest, null, 2, null);
        this.request = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageLoader, null, 2, null);
        this.imageLoader = mutableStateOf$default6;
    }

    private final void clear() {
        CoroutineScope coroutineScope = this.rememberScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.rememberScope = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float getAlpha() {
        return ((Number) this.alpha.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Painter getPainter() {
        return (Painter) this.painter.getValue();
    }

    private final CrossfadePainter maybeNewCrossfadePainter(State previous, State current) {
        ImageResult result;
        if (!(current instanceof State.Success)) {
            if (current instanceof State.Error) {
                result = ((State.Error) current).getResult();
            }
            return null;
        }
        result = ((State.Success) current).getResult();
        Transition create = result.getRequest().getTransitionFactory().create(AsyncImagePainterKt.access$getFakeTransitionTarget$p(), result);
        if (create instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) create;
            return new CrossfadePainter(previous instanceof State.Loading ? previous.getPainter() : null, current.getPainter(), this.contentScale, crossfadeTransition.getDurationMillis(), ((result instanceof SuccessResult) && ((SuccessResult) result).getIsPlaceholderCached()) ? false : true, crossfadeTransition.getPreferExactIntrinsicSize());
        }
        return null;
    }

    private final void setAlpha(float f5) {
        this.alpha.setValue(Float.valueOf(f5));
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter.setValue(colorFilter);
    }

    private final void setPainter(Painter painter) {
        this.painter.setValue(painter);
    }

    private final void setState(State state) {
        this.state.setValue(state);
    }

    private final void set_painter(Painter painter) {
        this._painter = painter;
        setPainter(painter);
    }

    private final void set_state(State state) {
        this._state = state;
        setState(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Painter toPainter(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? BitmapPainterKt.m1747BitmapPainterQZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) drawable).getBitmap()), 0L, 0L, this.filterQuality, 6, null) : new DrawablePainter(drawable.mutate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State toState(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(toPainter(successResult.getDrawable()), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        Drawable drawable = imageResult.getDrawable();
        return new State.Error(drawable != null ? toPainter(drawable) : null, (ErrorResult) imageResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest updateRequest(ImageRequest request) {
        ImageRequest.Builder target = ImageRequest.newBuilder$default(request, null, 1, null).target(new Target() { // from class: coil.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil.target.Target
            public void onError(Drawable error) {
            }

            @Override // coil.target.Target
            public void onStart(Drawable placeholder) {
                AsyncImagePainter.this.updateState(new AsyncImagePainter.State.Loading(placeholder != null ? AsyncImagePainter.this.toPainter(placeholder) : null));
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable result) {
            }
        });
        if (request.getDefined().getSizeResolver() == null) {
            target.size(new SizeResolver() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1
                @Override // coil.size.SizeResolver
                public final Object size(Continuation<? super coil.size.Size> continuation) {
                    final MutableStateFlow mutableStateFlow;
                    mutableStateFlow = AsyncImagePainter.this.drawSize;
                    return FlowKt.first(new Flow<coil.size.Size>() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1

                        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
                        /* renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2, reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2", f = "AsyncImagePainter.kt", l = {225}, m = "emit")
                            /* renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object emit(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                int i5;
                                coil.size.Size m2736toSizeOrNulluvyYCjk;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    int i6 = anonymousClass1.label;
                                    if ((i6 & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label = i6 - Integer.MIN_VALUE;
                                        Object obj2 = anonymousClass1.result;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        i5 = anonymousClass1.label;
                                        if (i5 != 0) {
                                            ResultKt.throwOnFailure(obj2);
                                            FlowCollector flowCollector = this.$this_unsafeFlow;
                                            m2736toSizeOrNulluvyYCjk = AsyncImagePainterKt.m2736toSizeOrNulluvyYCjk(((Size) obj).getPackedValue());
                                            if (m2736toSizeOrNulluvyYCjk != null) {
                                                anonymousClass1.label = 1;
                                                if (flowCollector.emit(m2736toSizeOrNulluvyYCjk, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        } else {
                                            if (i5 != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                anonymousClass1 = new AnonymousClass1(continuation);
                                Object obj22 = anonymousClass1.result;
                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i5 = anonymousClass1.label;
                                if (i5 != 0) {
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super coil.size.Size> flowCollector, Continuation continuation2) {
                            Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    }, continuation);
                }
            });
        }
        if (request.getDefined().getScale() == null) {
            target.scale(UtilsKt.toScale(this.contentScale));
        }
        if (request.getDefined().getPrecision() != Precision.EXACT) {
            target.precision(Precision.INEXACT);
        }
        return target.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State input) {
        State state = this._state;
        State invoke = this.transform.invoke(input);
        set_state(invoke);
        Painter maybeNewCrossfadePainter = maybeNewCrossfadePainter(state, invoke);
        if (maybeNewCrossfadePainter == null) {
            maybeNewCrossfadePainter = invoke.getPainter();
        }
        set_painter(maybeNewCrossfadePainter);
        if (this.rememberScope != null && state.getPainter() != invoke.getPainter()) {
            Object painter = state.getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object painter2 = invoke.getPainter();
            RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        Function1<? super State, Unit> function1 = this.onState;
        if (function1 != null) {
            function1.invoke(invoke);
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        setAlpha(alpha);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    public final ImageLoader getImageLoader() {
        return (ImageLoader) this.imageLoader.getValue();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1744getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        return painter != null ? painter.mo1744getIntrinsicSizeNHjbRc() : Size.INSTANCE.m1383getUnspecifiedNHjbRc();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageRequest getRequest() {
        return (ImageRequest) this.request.getValue();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        this.drawSize.setValue(Size.m1370boximpl(drawScope.mo1703getSizeNHjbRc()));
        Painter painter = getPainter();
        if (painter != null) {
            painter.m1749drawx_KDEd0(drawScope, drawScope.mo1703getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        if (this.rememberScope != null) {
            return;
        }
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.rememberScope = CoroutineScope;
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onRemembered();
        }
        if (!this.isPreview) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AsyncImagePainter$onRemembered$1(this, null), 3, null);
        } else {
            Drawable placeholder = ImageRequest.newBuilder$default(getRequest(), null, 1, null).defaults(getImageLoader().getDefaults()).build().getPlaceholder();
            updateState(new State.Loading(placeholder != null ? toPainter(placeholder) : null));
        }
    }

    public final void setContentScale$coil_compose_base_release(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    /* renamed from: setFilterQuality-vDHp3xo$coil_compose_base_release, reason: not valid java name */
    public final void m2731setFilterQualityvDHp3xo$coil_compose_base_release(int i5) {
        this.filterQuality = i5;
    }

    public final void setImageLoader$coil_compose_base_release(ImageLoader imageLoader) {
        this.imageLoader.setValue(imageLoader);
    }

    public final void setOnState$coil_compose_base_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    public final void setPreview$coil_compose_base_release(boolean z5) {
        this.isPreview = z5;
    }

    public final void setRequest$coil_compose_base_release(ImageRequest imageRequest) {
        this.request.setValue(imageRequest);
    }

    public final void setTransform$coil_compose_base_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }
}
