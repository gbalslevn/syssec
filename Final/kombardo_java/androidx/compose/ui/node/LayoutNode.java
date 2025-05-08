package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 \u0080\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\b\u0080\u0003\u0081\u0003\u0082\u0003\u0083\u0003B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010%\u001a\u00020\u000eH\u0000¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010(\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'H\u0017¢\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0000H\u0000¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0004\b/\u0010\u0010J\u001f\u00104\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0000¢\u0006\u0004\b2\u00103J\u000f\u00106\u001a\u00020\u000eH\u0000¢\u0006\u0004\b5\u0010\u0010J'\u0010;\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0000¢\u0006\u0004\b9\u0010:J\u000f\u0010=\u001a\u00020\u000eH\u0000¢\u0006\u0004\b<\u0010\u0010J\u0017\u0010B\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H\u0000¢\u0006\u0004\b@\u0010AJ\u000f\u0010D\u001a\u00020\u000eH\u0000¢\u0006\u0004\bC\u0010\u0010J\u000f\u0010E\u001a\u00020\u0016H\u0016¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n¢\u0006\u0004\bH\u0010IJ\u0015\u0010K\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n¢\u0006\u0004\bK\u0010IJ\u0015\u0010L\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n¢\u0006\u0004\bL\u0010IJ\u0015\u0010M\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n¢\u0006\u0004\bM\u0010IJ\u0015\u0010N\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n¢\u0006\u0004\bN\u0010IJ\u0015\u0010O\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n¢\u0006\u0004\bO\u0010IJ\u0015\u0010P\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n¢\u0006\u0004\bP\u0010IJ\u0015\u0010Q\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n¢\u0006\u0004\bQ\u0010IJ\u000f\u0010S\u001a\u00020\u000eH\u0000¢\u0006\u0004\bR\u0010\u0010J\u000f\u0010U\u001a\u00020\u000eH\u0000¢\u0006\u0004\bT\u0010\u0010J\u001f\u0010Y\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0000¢\u0006\u0004\bX\u00103J\u000f\u0010[\u001a\u00020\u000eH\u0000¢\u0006\u0004\bZ\u0010\u0010J\u000f\u0010]\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\\\u0010\u0010J!\u0010d\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020^2\b\u0010a\u001a\u0004\u0018\u00010`H\u0000¢\u0006\u0004\bb\u0010cJ6\u0010m\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020e2\u0006\u0010h\u001a\u00020g2\b\b\u0002\u0010i\u001a\u00020\b2\b\b\u0002\u0010j\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ6\u0010p\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020e2\u0006\u0010n\u001a\u00020g2\b\b\u0002\u0010i\u001a\u00020\b2\b\b\u0002\u0010j\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\bo\u0010lJ\u0017\u0010s\u001a\u00020\u000e2\u0006\u0010q\u001a\u00020\u0000H\u0000¢\u0006\u0004\br\u0010\u0014J-\u0010y\u001a\u00020\u000e2\b\b\u0002\u0010t\u001a\u00020\b2\b\b\u0002\u0010u\u001a\u00020\b2\b\b\u0002\u0010v\u001a\u00020\bH\u0000¢\u0006\u0004\bw\u0010xJ-\u0010{\u001a\u00020\u000e2\b\b\u0002\u0010t\u001a\u00020\b2\b\b\u0002\u0010u\u001a\u00020\b2\b\b\u0002\u0010v\u001a\u00020\bH\u0000¢\u0006\u0004\bz\u0010xJ\u000f\u0010}\u001a\u00020\u000eH\u0000¢\u0006\u0004\b|\u0010\u0010J\u000f\u0010\u007f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b~\u0010\u0010J\u001c\u0010\u0082\u0001\u001a\u00020\u000e2\b\b\u0002\u0010t\u001a\u00020\bH\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u000e2\b\b\u0002\u0010t\u001a\u00020\bH\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0081\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u0010J\u0011\u0010\u0088\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0087\u0001\u0010\u0010J#\u0010\u008d\u0001\u001a\u00020\b2\f\b\u0002\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J#\u0010\u008f\u0001\u001a\u00020\b2\f\b\u0002\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008c\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0090\u0001\u0010\u0010J\u0011\u0010\u0093\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0092\u0001\u0010\u0010J\u0011\u0010\u0095\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0094\u0001\u0010\u0010J\u0011\u0010\u0097\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u0096\u0001\u0010\u0010J\u0011\u0010\u0098\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0098\u0001\u0010\u0010J\u0011\u0010\u0099\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0099\u0001\u0010\u0010J\u0011\u0010\u009b\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u009a\u0001\u0010\u0010J\u0011\u0010\u009d\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0005\b\u009c\u0001\u0010\u0010J\u0011\u0010\u009e\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009e\u0001\u0010\u0010J\u0011\u0010\u009f\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009f\u0001\u0010\u0010J\u0011\u0010 \u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\b \u0001\u0010\u0010R\u0015\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010¡\u0001R'\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u000b\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R9\u0010¨\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020\n8W@WX\u0097\u000e¢\u0006\u001f\n\u0006\b¨\u0001\u0010¢\u0001\u0012\u0005\b«\u0001\u0010\u0010\u001a\u0006\b©\u0001\u0010¤\u0001\"\u0006\bª\u0001\u0010¦\u0001R)\u0010¬\u0001\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010¡\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010\u0081\u0001R5\u0010±\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00008\u0000@BX\u0080\u000e¢\u0006\u0017\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0005\bµ\u0001\u0010\u0014R\u0019\u0010¶\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010¢\u0001R\u001e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\"\u0010»\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0000\u0018\u00010º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010½\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¡\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010²\u0001R,\u0010?\u001a\u0004\u0018\u00010>2\t\u0010§\u0001\u001a\u0004\u0018\u00010>8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0005\b?\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001R3\u0010Ä\u0001\u001a\f\u0018\u00010Â\u0001j\u0005\u0018\u0001`Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R'\u0010\u0015\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0015\u0010¢\u0001\u001a\u0006\bÊ\u0001\u0010¤\u0001\"\u0006\bË\u0001\u0010¦\u0001R\u0019\u0010Ì\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010¡\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001e\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00000º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010¼\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010¡\u0001R4\u0010Ô\u0001\u001a\u00030Ò\u00012\b\u0010Ó\u0001\u001a\u00030Ò\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R\u001b\u0010Ú\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R4\u0010Ý\u0001\u001a\u00030Ü\u00012\b\u0010Ó\u0001\u001a\u00030Ü\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R4\u0010ä\u0001\u001a\u00030ã\u00012\b\u0010Ó\u0001\u001a\u00030ã\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R4\u0010ë\u0001\u001a\u00030ê\u00012\b\u0010Ó\u0001\u001a\u00030ê\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R4\u0010ò\u0001\u001a\u00030ñ\u00012\b\u0010Ó\u0001\u001a\u00030ñ\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R*\u0010ù\u0001\u001a\u00030ø\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R\u001a\u0010ÿ\u0001\u001a\u00030ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010ú\u0001R0\u0010\u0080\u0002\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u001f\n\u0006\b\u0080\u0002\u0010¡\u0001\u0012\u0005\b\u0083\u0002\u0010\u0010\u001a\u0006\b\u0081\u0002\u0010®\u0001\"\u0006\b\u0082\u0002\u0010\u0081\u0001R \u0010\u0085\u0002\u001a\u00030\u0084\u00028\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0085\u0002\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R \u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R,\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008e\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008f\u0002\u0010\u0090\u0002\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001c\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R)\u0010\u0098\u0002\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0098\u0002\u0010¡\u0001\u001a\u0006\b\u0099\u0002\u0010®\u0001\"\u0006\b\u009a\u0002\u0010\u0081\u0001R\u0019\u0010\u009b\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001b\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009c\u0002R8\u0010\u009f\u0002\u001a\u0011\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u009e\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009f\u0002\u0010 \u0002\u001a\u0006\b¡\u0002\u0010¢\u0002\"\u0006\b£\u0002\u0010¤\u0002R8\u0010¥\u0002\u001a\u0011\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u009e\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¥\u0002\u0010 \u0002\u001a\u0006\b¦\u0002\u0010¢\u0002\"\u0006\b§\u0002\u0010¤\u0002R)\u0010¨\u0002\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¨\u0002\u0010¡\u0001\u001a\u0006\b©\u0002\u0010®\u0001\"\u0006\bª\u0002\u0010\u0081\u0001R*\u0010«\u0002\u001a\u00020\b2\u0007\u0010§\u0001\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\u0010\n\u0006\b«\u0002\u0010¡\u0001\u001a\u0006\b«\u0002\u0010®\u0001R\u0018\u0010¯\u0002\u001a\u00030¬\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u001a\u0010²\u0002\u001a\u0005\u0018\u00010\u0095\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b°\u0002\u0010±\u0002R\u0016\u0010³\u0002\u001a\u0004\u0018\u00010\b8F¢\u0006\b\u001a\u0006\b³\u0002\u0010´\u0002R\u001e\u0010¸\u0002\u001a\t\u0012\u0004\u0012\u00020\u00000µ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\b¶\u0002\u0010·\u0002R\u001f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030¹\u00020µ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bº\u0002\u0010·\u0002R\u001f\u0010½\u0002\u001a\n\u0012\u0005\u0012\u00030¹\u00020µ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\b¼\u0002\u0010·\u0002R\u001e\u0010À\u0002\u001a\t\u0012\u0004\u0012\u00020\u00000º\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b¾\u0002\u0010¿\u0002R\u001e\u0010Â\u0002\u001a\t\u0012\u0004\u0012\u00020\u00000µ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÁ\u0002\u0010·\u0002R\u0019\u0010Ä\u0002\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\bÃ\u0002\u0010´\u0001R\u0017\u0010Å\u0002\u001a\u00020\b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0002\u0010®\u0001R\u0018\u0010É\u0002\u001a\u00030Æ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R\u001f\u0010Í\u0002\u001a\n\u0018\u00010Ê\u0002R\u00030\u0089\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002R\u001d\u0010Ñ\u0002\u001a\b0Î\u0002R\u00030\u0089\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÏ\u0002\u0010Ð\u0002R\u001a\u0010Ô\u0002\u001a\u0005\u0018\u00010Í\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bÒ\u0002\u0010Ó\u0002R%\u0010×\u0002\u001a\t\u0012\u0004\u0012\u00020\u00000º\u00018@X\u0081\u0004¢\u0006\u000f\u0012\u0005\bÖ\u0002\u0010\u0010\u001a\u0006\bÕ\u0002\u0010¿\u0002R\u0017\u0010Ø\u0002\u001a\u00020\b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bØ\u0002\u0010®\u0001R\u0017\u0010Ú\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÙ\u0002\u0010®\u0001R\u0016\u0010J\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010¤\u0001R\u0016\u0010G\u001a\u00020\n8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÜ\u0002\u0010¤\u0001R\u0017\u0010Þ\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÝ\u0002\u0010®\u0001R\u0018\u0010â\u0002\u001a\u00030ß\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bà\u0002\u0010á\u0002R\u0017\u0010ã\u0002\u001a\u00020\b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bã\u0002\u0010®\u0001R\u0014\u0010ä\u0002\u001a\u00020\b8F¢\u0006\b\u001a\u0006\bä\u0002\u0010®\u0001R\u0017\u0010æ\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\b\u001a\u0006\bå\u0002\u0010¤\u0001R\u0018\u0010è\u0002\u001a\u00030ø\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010ü\u0001R\u0018\u0010ê\u0002\u001a\u00030ø\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bé\u0002\u0010ü\u0001R\u0018\u0010ì\u0002\u001a\u00030\u0095\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bë\u0002\u0010±\u0002R\u0018\u0010î\u0002\u001a\u00030\u0095\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bí\u0002\u0010±\u0002R\u0017\u0010ð\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bï\u0002\u0010®\u0001R(\u0010\u001e\u001a\u00020\u001d2\u0007\u0010Ó\u0001\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\bñ\u0002\u0010ò\u0002\"\u0005\bó\u0002\u0010 R\u0018\u0010÷\u0002\u001a\u00030ô\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bõ\u0002\u0010ö\u0002R\u0017\u0010ù\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bø\u0002\u0010®\u0001R\u0017\u0010û\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bú\u0002\u0010®\u0001R\u0017\u0010ý\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bü\u0002\u0010®\u0001R\u0017\u0010ÿ\u0002\u001a\u00020\b8@X\u0080\u0004¢\u0006\b\u001a\u0006\bþ\u0002\u0010®\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0084\u0003"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", BuildConfig.FLAVOR, "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", BuildConfig.FLAVOR, "isVirtual", BuildConfig.FLAVOR, "semanticsId", "<init>", "(ZI)V", BuildConfig.FLAVOR, "recreateUnfoldedChildrenIfDirty", "()V", "invalidateUnfoldedVirtualChildren", "child", "onChildRemoved", "(Landroidx/compose/ui/node/LayoutNode;)V", "depth", BuildConfig.FLAVOR, "debugTreeToString", "(I)Ljava/lang/String;", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getOrCreateIntrinsicsPolicy", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "onDensityOrLayoutDirectionChanged", "Landroidx/compose/ui/Modifier;", "modifier", "applyModifier", "(Landroidx/compose/ui/Modifier;)V", "resetModifierState", "invalidateFocusOnAttach", "clearSubtreePlacementIntrinsicsUsage", "updateChildrenIfDirty$ui_release", "updateChildrenIfDirty", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getInteropView", "()Landroid/view/View;", "index", "instance", "insertAt$ui_release", "(ILandroidx/compose/ui/node/LayoutNode;)V", "insertAt", "onZSortedChildrenInvalidated$ui_release", "onZSortedChildrenInvalidated", "count", "removeAt$ui_release", "(II)V", "removeAt", "removeAll$ui_release", "removeAll", "from", "to", "move$ui_release", "(III)V", "move", "invalidateSemantics$ui_release", "invalidateSemantics", "Landroidx/compose/ui/node/Owner;", "owner", "attach$ui_release", "(Landroidx/compose/ui/node/Owner;)V", "attach", "detach$ui_release", "detach", "toString", "()Ljava/lang/String;", "height", "minLookaheadIntrinsicWidth", "(I)I", "width", "minLookaheadIntrinsicHeight", "maxLookaheadIntrinsicWidth", "maxLookaheadIntrinsicHeight", "minIntrinsicWidth", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "invalidateLayer$ui_release", "invalidateLayer", "invalidateParentData$ui_release", "invalidateParentData", "x", "y", "place$ui_release", "place", "replace$ui_release", "replace", "lookaheadReplace$ui_release", "lookaheadReplace", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "draw$ui_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTest", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "hitTestSemantics", "it", "rescheduleRemeasureOrRelayout$ui_release", "rescheduleRemeasureOrRelayout", "forceRequest", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestRemeasure$ui_release", "(ZZZ)V", "requestRemeasure", "requestLookaheadRemeasure$ui_release", "requestLookaheadRemeasure", "invalidateMeasurements$ui_release", "invalidateMeasurements", "invalidateOnPositioned$ui_release", "invalidateOnPositioned", "requestRelayout$ui_release", "(Z)V", "requestRelayout", "requestLookaheadRelayout$ui_release", "requestLookaheadRelayout", "dispatchOnPositionedCallbacks$ui_release", "dispatchOnPositionedCallbacks", "invalidateLayers$ui_release", "invalidateLayers", "Landroidx/compose/ui/unit/Constraints;", "constraints", "lookaheadRemeasure-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)Z", "lookaheadRemeasure", "remeasure-_Sx5XlM$ui_release", "remeasure", "markLayoutPending$ui_release", "markLayoutPending", "markMeasurePending$ui_release", "markMeasurePending", "markLookaheadLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadMeasurePending$ui_release", "markLookaheadMeasurePending", "forceRemeasure", "onLayoutComplete", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "resetSubtreeIntrinsicsUsage", "onReuse", "onDeactivate", "onRelease", "Z", "I", "getSemanticsId", "()I", "setSemanticsId", "(I)V", "<set-?>", "compositeKeyHash", "getCompositeKeyHash", "setCompositeKeyHash", "getCompositeKeyHash$annotations", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "()Z", "setVirtualLookaheadRoot$ui_release", "newRoot", "lookaheadRoot", "Landroidx/compose/ui/node/LayoutNode;", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "virtualChildrenCount", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "Landroidx/compose/runtime/collection/MutableVector;", "_unfoldedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "unfoldedVirtualChildrenListDirty", "_foldedParent", "Landroidx/compose/ui/node/Owner;", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "getDepth$ui_release", "setDepth$ui_release", "ignoreRemeasureRequests", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_zSortedChildren", "zSortedChildrenInvalidated", "Landroidx/compose/ui/layout/MeasurePolicy;", "value", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "previousIntrinsicsUsageByParent", "canMultiMeasure", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "getCanMultiMeasure$ui_release$annotations", "Landroidx/compose/ui/node/NodeChain;", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "_modifier", "Landroidx/compose/ui/Modifier;", "pendingModifier", "Lkotlin/Function1;", "onAttach", "Lkotlin/jvm/functions/Function1;", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "isDeactivated", BuildConfig.FLAVOR, "getZIndex", "()F", "zIndex", "getInnerLayerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "isPlacedInLookahead", "()Ljava/lang/Boolean;", BuildConfig.FLAVOR, "getFoldedChildren$ui_release", "()Ljava/util/List;", "foldedChildren", "Landroidx/compose/ui/layout/Measurable;", "getChildMeasurables$ui_release", "childMeasurables", "getChildLookaheadMeasurables$ui_release", "childLookaheadMeasurables", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_children", "getChildren$ui_release", "children", "getParent$ui_release", "parent", "isAttached", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePassDelegate", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "collapsedSemantics", "getZSortedChildren", "getZSortedChildren$annotations", "zSortedChildren", "isValidOwnerScope", "getHasFixedInnerContentConstraints$ui_release", "hasFixedInnerContentConstraints", "getWidth", "getHeight", "getAlignmentLinesRequired$ui_release", "alignmentLinesRequired", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "mDrawScope", "isPlaced", "isPlacedByParent", "getPlaceOrder$ui_release", "placeOrder", "getMeasuredByParent$ui_release", "measuredByParent", "getMeasuredByParentInLookahead$ui_release", "measuredByParentInLookahead", "getInnerCoordinator$ui_release", "innerCoordinator", "getOuterCoordinator$ui_release", "outerCoordinator", "getApplyingModifierOnAttach$ui_release", "applyingModifierOnAttach", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getMeasurePending$ui_release", "measurePending", "getLayoutPending$ui_release", "layoutPending", "getLookaheadMeasurePending$ui_release", "lookaheadMeasurePending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPending", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, Owner.OnLayoutCompletedListener {
    private SemanticsConfiguration _collapsedSemantics;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private Modifier _modifier;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isDeactivated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private boolean needsOnPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private Modifier pendingModifier;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List list, long j5) {
            return (MeasureResult) m2008measure3p2s80s(measureScope, (List<? extends Measurable>) list, j5);
        }

        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m2008measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
            throw new IllegalStateException("Undefined measure and it is required");
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo2007getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m2631getZeroMYxV2XQ();
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }
    };
    private static final Comparator<LayoutNode> ZComparator = new Comparator() { // from class: q.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int ZComparator$lambda$41;
            ZComparator$lambda$41 = LayoutNode.ZComparator$lambda$41((LayoutNode) obj, (LayoutNode) obj2);
            return ZComparator$lambda$41;
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "Constructor", "Lkotlin/jvm/functions/Function0;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "Ljava/util/Comparator;", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "maxIntrinsicHeight", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", BuildConfig.FLAVOR, "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.error = str;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
            return ((Number) m2009maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i5)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
            return ((Number) m2010maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i5)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
            return ((Number) m2011minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i5)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
            return ((Number) m2012minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i5)).intValue();
        }

        /* renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m2009maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m2010maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m2011minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m2012minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode(boolean z5, int i5) {
        this.isVirtual = z5;
        this.semanticsId = i5;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LayoutNode.this.getLayoutDelegate().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.access$getDefaultDensity$p();
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.INSTANCE.getEmpty();
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ZComparator$lambda$41(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return layoutNode.getZIndex() == layoutNode2.getZIndex() ? Intrinsics.compare(layoutNode.getPlaceOrder$ui_release(), layoutNode2.getPlaceOrder$ui_release()) : Float.compare(layoutNode.getZIndex(), layoutNode2.getZIndex());
    }

    private final void applyModifier(Modifier modifier) {
        this._modifier = modifier;
        this.nodes.updateFrom$ui_release(modifier);
        this.layoutDelegate.updateParentData();
        if (this.lookaheadRoot == null && this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(512))) {
            setLookaheadRoot(this);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode = content[i5];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i5++;
            } while (i5 < size);
        }
    }

    private final String debugTreeToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < depth; i5++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i6 = 0;
            do {
                sb.append(content[i6].debugTreeToString(depth + 1));
                i6++;
            } while (i6 < size);
        }
        String sb2 = sb.toString();
        if (depth != 0) {
            return sb2;
        }
        String substring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        return layoutNode.debugTreeToString(i5);
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy = getOuterCoordinator$ui_release().getWrappedBy();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(innerCoordinator$ui_release, wrappedBy)) {
                    break;
                }
                if ((innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                }
                innerCoordinator$ui_release = innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getWrappedBy() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layer was not set");
        throw new KotlinNothingValueException();
    }

    private final IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            return intrinsicsPolicy;
        }
        IntrinsicsPolicy intrinsicsPolicy2 = new IntrinsicsPolicy(this, getMeasurePolicy());
        this.intrinsicsPolicy = intrinsicsPolicy2;
        return intrinsicsPolicy2;
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m1999hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j5, HitTestResult hitTestResult, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        boolean z7 = z5;
        if ((i5 & 8) != 0) {
            z6 = true;
        }
        layoutNode.m2003hitTestM_7yMNQ$ui_release(j5, hitTestResult, z7, z6);
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m2074constructorimpl(1024) | NodeKind.m2074constructorimpl(2048) | NodeKind.m2074constructorimpl(4096))) {
            for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
                if (((NodeKind.m2074constructorimpl(1024) & head.getKindSet()) != 0) | ((NodeKind.m2074constructorimpl(2048) & head.getKindSet()) != 0) | ((NodeKind.m2074constructorimpl(4096) & head.getKindSet()) != 0)) {
                    NodeKindKt.autoInvalidateInsertedNode(head);
                }
            }
        }
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m2001lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m2020getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m2005lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = child._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                int i5 = 0;
                do {
                    content[i5].getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
                    i5++;
                } while (i5 < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i5 = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                do {
                    LayoutNode layoutNode = content[i5];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i5++;
                } while (i5 < size);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m2002remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m2019getLastConstraintsDWUhwKw();
        }
        return layoutNode.m2006remeasure_Sx5XlM$ui_release(constraints);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z5);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = true;
        }
        if ((i5 & 4) != 0) {
            z7 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z5, z6, z7);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        layoutNode.requestRelayout$ui_release(z5);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = true;
        }
        if ((i5 & 4) != 0) {
            z7 = true;
        }
        layoutNode.requestRemeasure$ui_release(z5, z6, z7);
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    private final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        if (layoutNode != null) {
            this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
            NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
            for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                outerCoordinator$ui_release.ensureLookaheadDelegateCreated();
            }
        }
        invalidateMeasurements$ui_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void attach$ui_release(Owner owner) {
        boolean z5;
        LayoutNode parent$ui_release;
        Modifier modifier;
        LayoutNode layoutNode;
        int size;
        NodeCoordinator outerCoordinator$ui_release;
        NodeCoordinator wrapped;
        Function1<? super Owner, Unit> function1;
        int i5 = 0;
        if (!(this.owner == null)) {
            InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString$default(this, 0, 1, null));
        }
        LayoutNode layoutNode2 = this._foldedParent;
        if (layoutNode2 != null) {
            if (!Intrinsics.areEqual(layoutNode2 != null ? layoutNode2.owner : null, owner)) {
                z5 = false;
                if (!z5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attaching to a different owner(");
                    sb.append(owner);
                    sb.append(") than the parent's owner(");
                    LayoutNode parent$ui_release2 = getParent$ui_release();
                    sb.append(parent$ui_release2 != null ? parent$ui_release2.owner : null);
                    sb.append("). This tree: ");
                    sb.append(debugTreeToString$default(this, 0, 1, null));
                    sb.append(" Parent tree: ");
                    LayoutNode layoutNode3 = this._foldedParent;
                    sb.append(layoutNode3 != null ? debugTreeToString$default(layoutNode3, 0, 1, null) : null);
                    InlineClassHelperKt.throwIllegalStateException(sb.toString());
                }
                parent$ui_release = getParent$ui_release();
                if (parent$ui_release == null) {
                    getMeasurePassDelegate$ui_release().setPlaced$ui_release(true);
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.setPlaced(true);
                    }
                }
                getOuterCoordinator$ui_release().setWrappedBy$ui_release(parent$ui_release == null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
                this.owner = owner;
                this.depth = (parent$ui_release == null ? parent$ui_release.depth : -1) + 1;
                modifier = this.pendingModifier;
                if (modifier != null) {
                    applyModifier(modifier);
                }
                this.pendingModifier = null;
                if (this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
                    invalidateSemantics$ui_release();
                }
                owner.onAttach(this);
                if (this.isVirtualLookaheadRoot) {
                    LayoutNode layoutNode4 = this._foldedParent;
                    if (layoutNode4 == null || (layoutNode = layoutNode4.lookaheadRoot) == null) {
                        layoutNode = this.lookaheadRoot;
                    }
                    setLookaheadRoot(layoutNode);
                    if (this.lookaheadRoot == null && this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(512))) {
                        setLookaheadRoot(this);
                    }
                } else {
                    setLookaheadRoot(this);
                }
                if (!getIsDeactivated()) {
                    this.nodes.markAsAttached();
                }
                MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
                size = vector.getSize();
                if (size > 0) {
                    LayoutNode[] content = vector.getContent();
                    do {
                        content[i5].attach$ui_release(owner);
                        i5++;
                    } while (i5 < size);
                }
                if (!getIsDeactivated()) {
                    this.nodes.runAttachLifecycle();
                }
                invalidateMeasurements$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateMeasurements$ui_release();
                }
                wrapped = getInnerCoordinator$ui_release().getWrapped();
                for (outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                    outerCoordinator$ui_release.onLayoutNodeAttach();
                }
                function1 = this.onAttach;
                if (function1 != null) {
                    function1.invoke(owner);
                }
                this.layoutDelegate.updateParentData();
                if (getIsDeactivated()) {
                    invalidateFocusOnAttach();
                    return;
                }
                return;
            }
        }
        z5 = true;
        if (!z5) {
        }
        parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null) {
        }
        getOuterCoordinator$ui_release().setWrappedBy$ui_release(parent$ui_release == null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.owner = owner;
        this.depth = (parent$ui_release == null ? parent$ui_release.depth : -1) + 1;
        modifier = this.pendingModifier;
        if (modifier != null) {
        }
        this.pendingModifier = null;
        if (this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
        }
        owner.onAttach(this);
        if (this.isVirtualLookaheadRoot) {
        }
        if (!getIsDeactivated()) {
        }
        MutableVector<LayoutNode> vector2 = this._foldedChildren.getVector();
        size = vector2.getSize();
        if (size > 0) {
        }
        if (!getIsDeactivated()) {
        }
        invalidateMeasurements$ui_release();
        if (parent$ui_release != null) {
        }
        wrapped = getInnerCoordinator$ui_release().getWrapped();
        while (!Intrinsics.areEqual(outerCoordinator$ui_release, wrapped)) {
            outerCoordinator$ui_release.onLayoutNodeAttach();
        }
        function1 = this.onAttach;
        if (function1 != null) {
        }
        this.layoutDelegate.updateParentData();
        if (getIsDeactivated()) {
        }
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode = content[i5];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i5++;
            } while (i5 < size);
        }
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            sb.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null);
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(sb.toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release = getMeasurePassDelegate$ui_release();
            UsageByParent usageByParent = UsageByParent.NotUsed;
            measurePassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        if (this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        this.nodes.runDetachLifecycle$ui_release();
        this.ignoreRemeasureRequests = true;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            LayoutNode[] content = vector.getContent();
            int i5 = 0;
            do {
                content[i5].detach$ui_release();
                i5++;
            } while (i5 < size);
        }
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui_release();
        owner.onDetach(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release2 != null) {
            lookaheadPassDelegate$ui_release2.onNodeDetached();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || getIsDeactivated() || !isPlaced()) {
            return;
        }
        NodeChain nodeChain = this.nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(256);
        if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & m2074constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & m2074constructorimpl) != 0) {
                    DelegatingNode delegatingNode = head;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) delegatingNode;
                            globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m1990requireCoordinator64DMado(globalPositionAwareModifierNode, NodeKind.m2074constructorimpl(256)));
                        } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNode.getDelegate();
                            int i5 = 0;
                            delegatingNode = delegatingNode;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        delegatingNode = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNode != 0) {
                                            mutableVector.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        mutableVector.add(delegate);
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode = delegatingNode;
                            }
                            if (i5 == 1) {
                            }
                        }
                        delegatingNode = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    public final void draw$ui_release(Canvas canvas, GraphicsLayer graphicsLayer) {
        getOuterCoordinator$ui_release().draw(canvas, graphicsLayer);
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, false, 5, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, false, 5, null);
        }
        Constraints m2019getLastConstraintsDWUhwKw = this.layoutDelegate.m2019getLastConstraintsDWUhwKw();
        if (m2019getLastConstraintsDWUhwKw != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo2084measureAndLayout0kLqBqw(this, m2019getLastConstraintsDWUhwKw.getValue());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        return (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) ? false : true;
    }

    public final boolean getApplyingModifierOnAttach$ui_release() {
        return this.pendingModifier != null;
    }

    /* renamed from: getCanMultiMeasure$ui_release, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (!isAttached() || getIsDeactivated()) {
            return null;
        }
        if (!this.nodes.m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8)) || this._collapsedSemantics != null) {
            return this._collapsedSemantics;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0 */
            /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v11 */
            /* JADX WARN: Type inference failed for: r4v3 */
            /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
            /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r4v7 */
            /* JADX WARN: Type inference failed for: r4v8 */
            /* JADX WARN: Type inference failed for: r4v9 */
            /* JADX WARN: Type inference failed for: r6v7, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int aggregateChildKindSet;
                NodeChain nodes = LayoutNode.this.getNodes();
                int m2074constructorimpl = NodeKind.m2074constructorimpl(8);
                Ref$ObjectRef<SemanticsConfiguration> ref$ObjectRef2 = ref$ObjectRef;
                aggregateChildKindSet = nodes.getAggregateChildKindSet();
                if ((aggregateChildKindSet & m2074constructorimpl) != 0) {
                    for (Modifier.Node tail = nodes.getTail(); tail != null; tail = tail.getParent()) {
                        if ((tail.getKindSet() & m2074constructorimpl) != 0) {
                            DelegatingNode delegatingNode = tail;
                            MutableVector mutableVector = null;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) delegatingNode;
                                    if (semanticsModifierNode.getIsClearingSemantics()) {
                                        ?? semanticsConfiguration = new SemanticsConfiguration();
                                        ref$ObjectRef2.element = semanticsConfiguration;
                                        semanticsConfiguration.setClearingSemantics(true);
                                    }
                                    if (semanticsModifierNode.getMergeDescendants()) {
                                        ref$ObjectRef2.element.setMergingSemanticsOfDescendants(true);
                                    }
                                    semanticsModifierNode.applySemantics(ref$ObjectRef2.element);
                                } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNode.getDelegate();
                                    int i5 = 0;
                                    delegatingNode = delegatingNode;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                            i5++;
                                            if (i5 == 1) {
                                                delegatingNode = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != 0) {
                                                    mutableVector.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNode = delegatingNode;
                                    }
                                    if (i5 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                }
            }
        });
        T t5 = ref$ObjectRef.element;
        this._collapsedSemantics = (SemanticsConfiguration) t5;
        return (SemanticsConfiguration) t5;
    }

    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public Density getDensity() {
        return this.density;
    }

    /* renamed from: getDepth$ui_release, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long m2061getLastMeasurementConstraintsmsEJaDk$ui_release = getInnerCoordinator$ui_release().m2061getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m2576getHasFixedWidthimpl(m2061getLastMeasurementConstraintsmsEJaDk$ui_release) && Constraints.m2575getHasFixedHeightimpl(m2061getLastMeasurementConstraintsmsEJaDk$ui_release);
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator();
    }

    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getView();
        }
        return null;
    }

    /* renamed from: getInteropViewFactoryHolder$ui_release, reason: from getter */
    public final AndroidViewHolder getInteropViewFactoryHolder() {
        return this.interopViewFactoryHolder;
    }

    /* renamed from: getIntrinsicsUsageByParent$ui_release, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    /* renamed from: getLayoutDelegate$ui_release, reason: from getter */
    public final LayoutNodeLayoutDelegate getLayoutDelegate() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    /* renamed from: getLookaheadRoot$ui_release, reason: from getter */
    public final LayoutNode getLookaheadRoot() {
        return this.lookaheadRoot;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        UsageByParent measuredByParent$ui_release;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        return (lookaheadPassDelegate$ui_release == null || (measuredByParent$ui_release = lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release()) == null) ? UsageByParent.NotUsed : measuredByParent$ui_release;
    }

    /* renamed from: getModifier, reason: from getter */
    public Modifier get_modifier() {
        return this._modifier;
    }

    /* renamed from: getNeedsOnPositionedDispatch$ui_release, reason: from getter */
    public final boolean getNeedsOnPositionedDispatch() {
        return this.needsOnPositionedDispatch;
    }

    /* renamed from: getNodes$ui_release, reason: from getter */
    public final NodeChain getNodes() {
        return this.nodes;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator();
    }

    /* renamed from: getOwner$ui_release, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    /* renamed from: getSubcompositionsState$ui_release, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m2003hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().m2064hitTestYqVAtuI(NodeCoordinator.INSTANCE.getPointerInputSource(), NodeCoordinator.m2048fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, false, 2, null), hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m2004hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().m2064hitTestYqVAtuI(NodeCoordinator.INSTANCE.getSemanticsSource(), NodeCoordinator.m2048fromParentPosition8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, false, 2, null), hitSemanticsEntities, true, isInLayer);
    }

    public final void insertAt$ui_release(int index, LayoutNode instance) {
        if (!(instance._foldedParent == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot insert ");
            sb.append(instance);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            sb.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null);
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        if (!(instance.owner == null)) {
            InlineClassHelperKt.throwIllegalStateException("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null));
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui_release();
        if (instance.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, false, 7, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, false, 7, null);
        }
    }

    public final void invalidateOnPositioned$ui_release() {
        if (getLayoutPending$ui_release() || getMeasurePending$ui_release() || this.needsOnPositionedDispatch) {
            return;
        }
        LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    /* renamed from: isDeactivated, reason: from getter */
    public boolean getIsDeactivated() {
        return this.isDeactivated;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui_release().isPlacedByParent();
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* renamed from: isVirtualLookaheadRoot$ui_release, reason: from getter */
    public final boolean getIsVirtualLookaheadRoot() {
        return this.isVirtualLookaheadRoot;
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m2005lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.m2023remeasureBRTryo0(constraints.getValue());
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final int maxIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    public final int maxIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    public final int maxLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(width);
    }

    public final int maxLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(height);
    }

    public final int minIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    public final int minIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    public final int minLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(width);
    }

    public final int minLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(height);
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i5 = 0; i5 < count; i5++) {
            this._foldedChildren.add(from > to ? to + i5 : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i5 : from));
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached()) {
            invalidateSemantics$ui_release();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int m2074constructorimpl = NodeKind.m2074constructorimpl(128);
        boolean m2075getIncludeSelfInTraversalH91voCI = NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(m2074constructorimpl);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (!m2075getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(innerCoordinator$ui_release, m2075getIncludeSelfInTraversalH91voCI); access$headNode != null && (access$headNode.getAggregateChildKindSet() & m2074constructorimpl) != 0; access$headNode = access$headNode.getChild()) {
            if ((access$headNode.getKindSet() & m2074constructorimpl) != 0) {
                DelegatingNode delegatingNode = access$headNode;
                MutableVector mutableVector = null;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNode).onPlaced(getInnerCoordinator$ui_release());
                    } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                        Modifier.Node delegate = delegatingNode.getDelegate();
                        int i5 = 0;
                        delegatingNode = delegatingNode;
                        while (delegate != null) {
                            if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                i5++;
                                if (i5 == 1) {
                                    delegatingNode = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (delegatingNode != 0) {
                                        mutableVector.add(delegatingNode);
                                        delegatingNode = 0;
                                    }
                                    mutableVector.add(delegate);
                                }
                            }
                            delegate = delegate.getChild();
                            delegatingNode = delegatingNode;
                        }
                        if (i5 == 1) {
                        }
                    }
                    delegatingNode = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (access$headNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
            outerCoordinator$ui_release.onRelease();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onReuse();
        }
        if (getIsDeactivated()) {
            this.isDeactivated = false;
            invalidateSemantics$ui_release();
        } else {
            resetModifierState();
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        rescheduleRemeasureOrRelayout$ui_release(this);
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.onZSortedChildrenInvalidated$ui_release();
        }
    }

    public final void place$ui_release(int x5, int y5) {
        Placeable.PlacementScope placementScope;
        NodeCoordinator innerCoordinator$ui_release;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null || (innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release()) == null || (placementScope = innerCoordinator$ui_release.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this).getPlacementScope();
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, getMeasurePassDelegate$ui_release(), x5, y5, 0.0f, 4, null);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m2006remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate$ui_release().m2027remeasureBRTryo0(constraints.getValue());
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this._foldedChildren.clear();
                return;
            }
            onChildRemoved(this._foldedChildren.get(size));
        }
    }

    public final void removeAt$ui_release(int index, int count) {
        if (!(count >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + count + ") must be greater than 0");
        }
        int i5 = (count + index) - 1;
        if (index > i5) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.get(i5));
            this._foldedChildren.removeAt(i5);
            if (i5 == index) {
                return;
            } else {
                i5--;
            }
        }
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, forceRequest);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        if (!(this.lookaheadRoot != null)) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        Owner owner = this.owner;
        if (owner == null || this.ignoreRemeasureRequests || this.isVirtual) {
            return;
        }
        owner.onRequestMeasure(this, true, forceRequest, scheduleMeasureAndLayout);
        if (invalidateIntrinsics) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, null);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, forceRequest, scheduleMeasureAndLayout, 2, null);
        if (invalidateIntrinsics) {
            getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
        }
        if (it.getLookaheadMeasurePending$ui_release()) {
            requestLookaheadRemeasure$ui_release$default(it, true, false, false, 6, null);
            return;
        }
        if (it.getLookaheadLayoutPending$ui_release()) {
            it.requestLookaheadRelayout$ui_release(true);
        }
        if (it.getMeasurePending$ui_release()) {
            requestRemeasure$ui_release$default(it, true, false, false, 6, null);
        } else if (it.getLayoutPending$ui_release()) {
            it.requestRelayout$ui_release(true);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode = content[i5];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i5++;
            } while (i5 < size);
        }
    }

    public final void setCanMultiMeasure$ui_release(boolean z5) {
        this.canMultiMeasure = z5;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositeKeyHash(int i5) {
        this.compositeKeyHash = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositionLocalMap(CompositionLocalMap compositionLocalMap) {
        this.compositionLocalMap = compositionLocalMap;
        setDensity((Density) compositionLocalMap.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) compositionLocalMap.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) compositionLocalMap.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain nodeChain = this.nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(32768);
        if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & m2074constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & m2074constructorimpl) != 0) {
                    DelegatingNode delegatingNode = head;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node = ((CompositionLocalConsumerModifierNode) delegatingNode).getNode();
                            if (node.getIsAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(node);
                            } else {
                                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                        } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNode.getDelegate();
                            int i5 = 0;
                            delegatingNode = delegatingNode;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        delegatingNode = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNode != 0) {
                                            mutableVector.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        mutableVector.add(delegate);
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode = delegatingNode;
                            }
                            if (i5 == 1) {
                            }
                        }
                        delegatingNode = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density density) {
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        onDensityOrLayoutDirectionChanged();
        for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
            if ((NodeKind.m2074constructorimpl(16) & head.getKindSet()) != 0) {
                ((PointerInputModifierNode) head).onDensityChange();
            } else if (head instanceof CacheDrawModifierNode) {
                ((CacheDrawModifierNode) head).invalidateDrawCache();
            }
        }
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z5) {
        this.innerLayerCoordinatorIsDirty = z5;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            onDensityOrLayoutDirectionChanged();
            NodeChain nodeChain = this.nodes;
            int m2074constructorimpl = NodeKind.m2074constructorimpl(4);
            if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & m2074constructorimpl) != 0) {
                for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                    if ((head.getKindSet() & m2074constructorimpl) != 0) {
                        DelegatingNode delegatingNode = head;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof DrawModifierNode) {
                                DrawModifierNode drawModifierNode = (DrawModifierNode) delegatingNode;
                                if (drawModifierNode instanceof CacheDrawModifierNode) {
                                    ((CacheDrawModifierNode) drawModifierNode).invalidateDrawCache();
                                }
                            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNode.getDelegate();
                                int i5 = 0;
                                delegatingNode = delegatingNode;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            delegatingNode = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                mutableVector.add(delegatingNode);
                                                delegatingNode = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i5 == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            intrinsicsPolicy.updateFrom(getMeasurePolicy());
        }
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier modifier) {
        if (!(!this.isVirtual || get_modifier() == Modifier.INSTANCE)) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        if (getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (isAttached()) {
            applyModifier(modifier);
        } else {
            this.pendingModifier = modifier;
        }
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z5) {
        this.needsOnPositionedDispatch = z5;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public void setSemanticsId(int i5) {
        this.semanticsId = i5;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.viewConfiguration, viewConfiguration)) {
            return;
        }
        this.viewConfiguration = viewConfiguration;
        NodeChain nodeChain = this.nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
        if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & m2074constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & m2074constructorimpl) != 0) {
                    DelegatingNode delegatingNode = head;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) delegatingNode).onViewConfigurationChange();
                        } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNode.getDelegate();
                            int i5 = 0;
                            delegatingNode = delegatingNode;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        delegatingNode = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNode != 0) {
                                            mutableVector.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        mutableVector.add(delegate);
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode = delegatingNode;
                            }
                            if (i5 == 1) {
                            }
                        }
                        delegatingNode = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public /* synthetic */ LayoutNode(boolean z5, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i5);
    }
}
