package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 µ\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004µ\u0002¶\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J@\u00102\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101JH\u00106\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105JH\u00108\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00105J\u0013\u00109\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b9\u0010:J\"\u0010@\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\"\u0010B\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010?J*\u0010G\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bG\u0010KJ\u001f\u0010M\u001a\u00020\u00192\u0006\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010NJ\u001a\u0010Q\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010T\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\r\u0010U\u001a\u00020\t¢\u0006\u0004\bU\u0010VJ\u000f\u0010Y\u001a\u00020\u0019H\u0010¢\u0006\u0004\bW\u0010XJ\u000f\u0010Z\u001a\u00020\u0019H&¢\u0006\u0004\bZ\u0010XJ\u001f\u0010^\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[H\u0014¢\u0006\u0004\b^\u0010_J\u000f\u0010a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b`\u0010XJ\r\u0010b\u001a\u00020\u0019¢\u0006\u0004\bb\u0010XJ8\u0010e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0014ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ*\u0010e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u001bH\u0014ø\u0001\u0000¢\u0006\u0004\bc\u0010gJ\r\u0010h\u001a\u00020\u0019¢\u0006\u0004\bh\u0010XJ@\u0010j\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\u0010f\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0004\bi\u0010\u001eJ\u001f\u0010k\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bk\u0010$J!\u0010l\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\bl\u0010$J\r\u0010m\u001a\u00020\u0019¢\u0006\u0004\bm\u0010XJ-\u0010o\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010n\u001a\u00020\t¢\u0006\u0004\bo\u0010pJ8\u0010s\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\bq\u0010rJ:\u0010u\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010rJ\r\u0010w\u001a\u00020v¢\u0006\u0004\bw\u0010xJ\u001a\u0010{\u001a\u00020*2\u0006\u0010y\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bz\u0010PJ\u001a\u0010~\u001a\u00020*2\u0006\u0010|\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b}\u0010PJ\u001c\u0010\u0081\u0001\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010PJ'\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J/\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020*2\u0006\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J&\u0010\u008b\u0001\u001a\u00020\u00192\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010=\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001d\u0010\u008e\u0001\u001a\u00020\u00192\u0006\u0010=\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J#\u0010\u008f\u0001\u001a\u00020v2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\tH\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001c\u0010\u0092\u0001\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010PJ'\u0010\u0095\u0001\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J'\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001J$\u0010\u009a\u0001\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001H\u0004¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u009c\u0001\u0010XJ\u000f\u0010\u009d\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u009d\u0001\u0010XJ-\u0010¡\u0001\u001a\u00020\u00192\u0006\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020\t2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\tH\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001d\u0010¤\u0001\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001d\u0010¦\u0001\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010£\u0001J\u0011\u0010§\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0005\b§\u0001\u0010XJ\u0011\u0010¨\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0005\b¨\u0001\u0010XJ\u001b\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010©\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u000f\u0010\u00ad\u0001\u001a\u00020\t¢\u0006\u0005\b\u00ad\u0001\u0010VJ\u001f\u0010±\u0001\u001a\u00030®\u00012\b\u0010¯\u0001\u001a\u00030®\u0001H\u0004ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010PJ'\u0010´\u0001\u001a\u00020\u00152\u0006\u0010+\u001a\u00020*2\b\u0010¯\u0001\u001a\u00030®\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b²\u0001\u0010³\u0001R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R'\u0010¸\u0001\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0005\bº\u0001\u0010V\"\u0005\b»\u0001\u0010'R'\u0010¼\u0001\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¼\u0001\u0010¹\u0001\u001a\u0005\b½\u0001\u0010V\"\u0005\b¾\u0001\u0010'R+\u0010¿\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R+\u0010Å\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010À\u0001\u001a\u0006\bÆ\u0001\u0010Â\u0001\"\u0006\bÇ\u0001\u0010Ä\u0001R\u0019\u0010È\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010¹\u0001R\u0019\u0010É\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¹\u0001RD\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0015\u0010Ê\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0004@BX\u0084\u000e¢\u0006\u000f\n\u0005\b\u001a\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ï\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R)\u0010Û\u0001\u001a\u0012\u0012\u0005\u0012\u00030Ú\u0001\u0012\u0004\u0012\u00020[\u0018\u00010Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R6\u0010\u0014\u001a\u00020\u00132\u0007\u0010Ê\u0001\u001a\u00020\u00138\u0016@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b\u0014\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R0\u0010\u0016\u001a\u00020\u00152\u0007\u0010Ê\u0001\u001a\u00020\u00158\u0006@DX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0016\u0010Õ\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R\u001b\u0010æ\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001c\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R3\u0010ì\u0001\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00190ë\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\bì\u0001\u0010í\u0001\u0012\u0005\bî\u0001\u0010XR\u001e\u0010ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R)\u0010ò\u0001\u001a\u00020\t2\u0007\u0010Ê\u0001\u001a\u00020\t8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\bò\u0001\u0010¹\u0001\u001a\u0005\bó\u0001\u0010VR.\u0010f\u001a\u0005\u0018\u00010ô\u00012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010ô\u00018\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\bf\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010ø\u0001R\u0018\u0010ü\u0001\u001a\u00030ù\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001R\u0017\u0010ÿ\u0001\u001a\u00020\u000b8&X¦\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u0018\u0010\u0082\u0002\u001a\u00030Ñ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0017\u0010\u0084\u0002\u001a\u00020\u00158VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010ã\u0001R\u0017\u0010\u0086\u0002\u001a\u00020\u00158VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010ã\u0001R\u0019\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0017\u0010\u008c\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001b\u0010\u008f\u0002\u001a\u00030\u008d\u00028Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010ß\u0001R\u0018\u0010\u0093\u0002\u001a\u00030\u0090\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R\u0019\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010\u0088\u0002R\u0016\u0010\u0097\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0002\u0010VR\u0016\u0010\u0098\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0002\u0010VR,\u0010\u009e\u0002\u001a\u00030Ö\u00012\b\u0010\u0099\u0002\u001a\u00030Ö\u00018P@PX\u0090\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R0\u0010¤\u0002\u001a\u0005\u0018\u00010\u009f\u00022\n\u0010Ê\u0001\u001a\u0005\u0018\u00010\u009f\u00028&@dX¦\u000e¢\u0006\u0010\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R\u001a\u0010¨\u0002\u001a\u0005\u0018\u00010¥\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0002\u0010§\u0002R\u0016\u0010ª\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\b©\u0002\u0010\u008b\u0002R\u0016\u0010¬\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\b«\u0002\u0010\u008b\u0002R\u0017\u0010¯\u0002\u001a\u00020H8DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u001e\u0010²\u0002\u001a\u00030°\u00028@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b±\u0002\u0010ß\u0001R\u0016\u0010³\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0002\u0010VR\u001b\u0010¯\u0001\u001a\u00030®\u00018Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b´\u0002\u0010ß\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006·\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", BuildConfig.FLAVOR, "includeTail", "Landroidx/compose/ui/Modifier$Node;", "headNode", "(Z)Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/NodeKind;", "type", "hasNode-H91voCI", "(I)Z", "hasNode", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", BuildConfig.FLAVOR, "layerBlock", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "explicitLayer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "graphicsLayer", "drawContainedDrawModifiers", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "invokeOnLayoutChange", "updateLayerParameters", "(Z)V", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestSource", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "isTouchEvent", "isInLayer", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hit", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "hitNear", "speculativeHit-JHbHoSQ", "speculativeHit", "toCoordinator", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/node/NodeCoordinator;", "ancestor", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformFromAncestor-EL8BTi8", "transformFromAncestor", "offset", "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "ancestorToLocal", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "clipBounds", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/geometry/MutableRect;Z)V", "bounds", "fromParentRect", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "offsetFromEdge-MK-Hz9U", "(J)J", "offsetFromEdge", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "head", "isTransparent", "()Z", "replace$ui_release", "()V", "replace", "ensureLookaheadDelegateCreated", BuildConfig.FLAVOR, "width", "height", "onMeasureResultChanged", "(II)V", "onCoordinatesUsed$ui_release", "onCoordinatesUsed", "onMeasured", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "releaseLayer", "placeSelfApparentToRealOffset-MLgxB_4", "placeSelfApparentToRealOffset", "draw", "performDraw", "onPlaced", "forceUpdateLayerParameters", "updateLayerBlock", "(Lkotlin/jvm/functions/Function1;Z)V", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTest", "hitTestChild-YqVAtuI", "hitTestChild", "Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "relativeToScreen", "screenToLocal-MK-Hz9U", "screenToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "relativeToLocal", "localToWindow-MK-Hz9U", "localToWindow", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "transformToScreen-58bKbWc", "([F)V", "transformToScreen", "localBoundingBoxOf", "(Landroidx/compose/ui/layout/LayoutCoordinates;Z)Landroidx/compose/ui/geometry/Rect;", "localToRoot-MK-Hz9U", "localToRoot", "toParentPosition-8S9VItk", "(JZ)J", "toParentPosition", "fromParentPosition-8S9VItk", "fromParentPosition", "Landroidx/compose/ui/graphics/Paint;", "paint", "drawBorder", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Paint;)V", "onLayoutNodeAttach", "onRelease", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "(Landroidx/compose/ui/geometry/MutableRect;ZZ)V", "rectInParent", "withinLayerBounds-k-4lQ0M", "(J)Z", "withinLayerBounds", "isPointerInBounds-k-4lQ0M", "isPointerInBounds", "invalidateLayer", "onLayoutModifierNodeChanged", "other", "findCommonAncestor$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)Landroidx/compose/ui/node/NodeCoordinator;", "findCommonAncestor", "shouldSharePointerInputWithSiblings", "Landroidx/compose/ui/geometry/Size;", "minimumTouchTargetSize", "calculateMinimumTouchTargetPadding-E7KxVPU", "calculateMinimumTouchTargetPadding", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "distanceInMinimumTouchTarget", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "forcePlaceWithLookaheadOffset", "Z", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "forceMeasureWithLookaheadConstraints", "getForceMeasureWithLookaheadConstraints$ui_release", "setForceMeasureWithLookaheadConstraints$ui_release", "wrapped", "Landroidx/compose/ui/node/NodeCoordinator;", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "released", "isClipping", "<set-?>", "Lkotlin/jvm/functions/Function1;", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/Density;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastLayerAlpha", "F", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "oldAlignmentLines", "Ljava/util/Map;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "getZIndex", "()F", "setZIndex", "(F)V", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "Lkotlin/Function2;", "drawBlock", "Lkotlin/jvm/functions/Function2;", "getDrawBlock$annotations", "Lkotlin/Function0;", "invalidateParentLayer", "Lkotlin/jvm/functions/Function0;", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "density", "getFontScale", "fontScale", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "getChild", "child", "getHasMeasureResult", "hasMeasureResult", "isAttached", "value", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureResult", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "lookaheadDelegate", BuildConfig.FLAVOR, "getParentData", "()Ljava/lang/Object;", "parentData", "getParentLayoutCoordinates", "parentLayoutCoordinates", "getParentCoordinates", "parentCoordinates", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "lastMeasurementConstraints", "isValidOwnerScope", "getMinimumTouchTargetSize-NH-jbRc", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            LayerPositionalProperties layerPositionalProperties;
            LayerPositionalProperties layerPositionalProperties2;
            LayerPositionalProperties layerPositionalProperties3;
            if (nodeCoordinator.isValidOwnerScope()) {
                layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                    return;
                }
                layerPositionalProperties2 = NodeCoordinator.tmpLayerPositionalProperties;
                layerPositionalProperties2.copyFrom(layerPositionalProperties);
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                layerPositionalProperties3 = NodeCoordinator.tmpLayerPositionalProperties;
                if (layerPositionalProperties3.hasSameValuesAs(layerPositionalProperties)) {
                    return;
                }
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner owner = layoutNode.getOwner();
                if (owner != null) {
                    owner.requestOnPositionedCallback(layoutNode);
                }
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m1547constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo2070childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m2003hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo2071entityTypeOLwlOKw() {
            return NodeKind.m2074constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != 0) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    Modifier.Node delegate = node.getDelegate();
                    int i5 = 0;
                    node = node;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != 0) {
                                    mutableVector.add(node);
                                    node = 0;
                                }
                                mutableVector.add(delegate);
                            }
                        }
                        delegate = delegate.getChild();
                        node = node;
                    }
                    if (i5 == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            return true;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo2070childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m2004hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo2071entityTypeOLwlOKw() {
            return NodeKind.m2074constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
            boolean z5 = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsClearingSemantics()) {
                z5 = true;
            }
            return !z5;
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m2648getZeronOccac();
    private final Function2<Canvas, GraphicsLayer, Unit> drawBlock = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
            invoke2(canvas, graphicsLayer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Canvas canvas, final GraphicsLayer graphicsLayer) {
            OwnerSnapshotObserver snapshotObserver;
            Function1 function1;
            if (NodeCoordinator.this.getLayoutNode().isPlaced()) {
                snapshotObserver = NodeCoordinator.this.getSnapshotObserver();
                NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                function1 = NodeCoordinator.onCommitAffectingLayer;
                final NodeCoordinator nodeCoordinator2 = NodeCoordinator.this;
                snapshotObserver.observeReads$ui_release(nodeCoordinator, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        NodeCoordinator.this.drawContainedDrawModifiers(canvas, graphicsLayer);
                    }
                });
                NodeCoordinator.this.lastLayerDrawingWasSkipped = false;
                return;
            }
            NodeCoordinator.this.lastLayerDrawingWasSkipped = true;
        }
    };
    private final Function0<Unit> invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
            NodeCoordinator wrappedBy = NodeCoordinator.this.getWrappedBy();
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    };

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", BuildConfig.FLAVOR, "()V", "ExpectAttachedLayoutCoordinates", BuildConfig.FLAVOR, "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", BuildConfig.FLAVOR, "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", BuildConfig.FLAVOR, "childHitTest", BuildConfig.FLAVOR, "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", BuildConfig.FLAVOR, "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI */
        void mo2070childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo2071entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    /* renamed from: ancestorToLocal-S_NoaFU */
    private final long m2047ancestorToLocalS_NoaFU(NodeCoordinator ancestor, long offset, boolean includeMotionFrameOfReference) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        return (nodeCoordinator == null || Intrinsics.areEqual(ancestor, nodeCoordinator)) ? m2060fromParentPosition8S9VItk(offset, includeMotionFrameOfReference) : m2060fromParentPosition8S9VItk(nodeCoordinator.m2047ancestorToLocalS_NoaFU(ancestor, offset, includeMotionFrameOfReference), includeMotionFrameOfReference);
    }

    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node m2063headH91voCI = m2063headH91voCI(NodeKind.m2074constructorimpl(4));
        if (m2063headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m2013draweZhPAX0$ui_release(canvas, IntSizeKt.m2668toSizeozmzZPI(mo1948getSizeYbymL2g()), this, m2063headH91voCI, graphicsLayer);
        }
    }

    /* renamed from: fromParentPosition-8S9VItk$default */
    public static /* synthetic */ long m2048fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j5, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return nodeCoordinator.m2060fromParentPosition8S9VItk(j5, z5);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float m2640getXimpl = IntOffset.m2640getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - m2640getXimpl);
        bounds.setRight(bounds.getRight() - m2640getXimpl);
        float m2641getYimpl = IntOffset.m2641getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - m2641getYimpl);
        bounds.setBottom(bounds.getBottom() - m2641getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m2661getWidthimpl(mo1948getSizeYbymL2g()), IntSize.m2660getHeightimpl(mo1948getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: hasNode-H91voCI */
    private final boolean m2049hasNodeH91voCI(int type) {
        Modifier.Node headNode = headNode(NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(type));
        return headNode != null && DelegatableNodeKt.m1989has64DMado(headNode, type);
    }

    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.getChild();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    /* renamed from: hit-1hIXUjU */
    public final void m2050hit1hIXUjU(final Modifier.Node node, final HitTestSource hitTestSource, final long j5, final HitTestResult hitTestResult, final boolean z5, final boolean z6) {
        if (node == null) {
            mo1996hitTestChildYqVAtuI(hitTestSource, j5, hitTestResult, z5, z6);
        } else {
            hitTestResult.hit(node, z6, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
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

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Node m2073nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m2073nextUntilhw7D004 = NodeCoordinatorKt.m2073nextUntilhw7D004(node, hitTestSource.mo2071entityTypeOLwlOKw(), NodeKind.m2074constructorimpl(2));
                    nodeCoordinator.m2050hit1hIXUjU(m2073nextUntilhw7D004, hitTestSource, j5, hitTestResult, z5, z6);
                }
            });
        }
    }

    /* renamed from: hitNear-JHbHoSQ */
    public final void m2051hitNearJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j5, final HitTestResult hitTestResult, final boolean z5, final boolean z6, final float f5) {
        if (node == null) {
            mo1996hitTestChildYqVAtuI(hitTestSource, j5, hitTestResult, z5, z6);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f5, z6, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
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

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Node m2073nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m2073nextUntilhw7D004 = NodeCoordinatorKt.m2073nextUntilhw7D004(node, hitTestSource.mo2071entityTypeOLwlOKw(), NodeKind.m2074constructorimpl(2));
                    nodeCoordinator.m2051hitNearJHbHoSQ(m2073nextUntilhw7D004, hitTestSource, j5, hitTestResult, z5, z6, f5);
                }
            });
        }
    }

    /* renamed from: offsetFromEdge-MK-Hz9U */
    private final long m2052offsetFromEdgeMKHz9U(long pointerPosition) {
        float m1337getXimpl = Offset.m1337getXimpl(pointerPosition);
        float max = Math.max(0.0f, m1337getXimpl < 0.0f ? -m1337getXimpl : m1337getXimpl - getMeasuredWidth());
        float m1338getYimpl = Offset.m1338getYimpl(pointerPosition);
        return OffsetKt.Offset(max, Math.max(0.0f, m1338getYimpl < 0.0f ? -m1338getYimpl : m1338getYimpl - getMeasuredHeight()));
    }

    /* renamed from: placeSelf-MLgxB_4 */
    private final void m2053placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            if (!(layerBlock == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != explicitLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = explicitLayer;
            }
            if (this.layer == null) {
                OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, explicitLayer);
                createLayer.mo2080resizeozmzZPI(getMeasuredSize());
                createLayer.mo2079movegyyYBs(position);
                this.layer = createLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, layerBlock, false, 2, null);
        }
        if (!IntOffset.m2639equalsimpl0(getPosition(), position)) {
            m2067setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo2079movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
        if (getIsPlacingForAlignment()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z5, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z5, z6);
    }

    /* renamed from: speculativeHit-JHbHoSQ */
    public final void m2054speculativeHitJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j5, final HitTestResult hitTestResult, final boolean z5, final boolean z6, final float f5) {
        Modifier.Node m2073nextUntilhw7D004;
        if (node == null) {
            mo1996hitTestChildYqVAtuI(hitTestSource, j5, hitTestResult, z5, z6);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            hitTestResult.speculativeHit(node, f5, z6, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
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

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Node m2073nextUntilhw7D0042;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m2073nextUntilhw7D0042 = NodeCoordinatorKt.m2073nextUntilhw7D004(node, hitTestSource.mo2071entityTypeOLwlOKw(), NodeKind.m2074constructorimpl(2));
                    nodeCoordinator.m2054speculativeHitJHbHoSQ(m2073nextUntilhw7D0042, hitTestSource, j5, hitTestResult, z5, z6, f5);
                }
            });
        } else {
            m2073nextUntilhw7D004 = NodeCoordinatorKt.m2073nextUntilhw7D004(node, hitTestSource.mo2071entityTypeOLwlOKw(), NodeKind.m2074constructorimpl(2));
            m2054speculativeHitJHbHoSQ(m2073nextUntilhw7D004, hitTestSource, j5, hitTestResult, z5, z6, f5);
        }
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: toParentPosition-8S9VItk$default */
    public static /* synthetic */ long m2055toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j5, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return nodeCoordinator.m2068toParentPosition8S9VItk(j5, z5);
    }

    /* renamed from: transformFromAncestor-EL8BTi8 */
    private final void m2056transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (Intrinsics.areEqual(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.m2056transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m2639equalsimpl0(getPosition(), IntOffset.INSTANCE.m2648getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m1552resetimpl(fArr);
            Matrix.m1561translateimpl$default(fArr, -IntOffset.m2640getXimpl(getPosition()), -IntOffset.m2641getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m1558timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo2076inverseTransform58bKbWc(matrix);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8 */
    private final void m2057transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator nodeCoordinator = this;
        while (!Intrinsics.areEqual(nodeCoordinator, ancestor)) {
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.mo2081transform58bKbWc(matrix);
            }
            if (!IntOffset.m2639equalsimpl0(nodeCoordinator.getPosition(), IntOffset.INSTANCE.m2648getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m1552resetimpl(fArr);
                Matrix.m1561translateimpl$default(fArr, IntOffset.m2640getXimpl(r1), IntOffset.m2641getYimpl(r1), 0.0f, 4, null);
                Matrix.m1558timesAssign58bKbWc(matrix, fArr);
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z5);
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            if (this.layerBlock == null) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            return;
        }
        final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
        if (function1 == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
        reusableGraphicsLayerScope.reset();
        reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
        reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
        reusableGraphicsLayerScope.m1590setSizeuvyYCjk(IntSizeKt.m2668toSizeozmzZPI(mo1948getSizeYbymL2g()));
        getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope3;
                Function1<GraphicsLayerScope, Unit> function12 = function1;
                reusableGraphicsLayerScope2 = NodeCoordinator.graphicsLayerScope;
                function12.invoke(reusableGraphicsLayerScope2);
                reusableGraphicsLayerScope3 = NodeCoordinator.graphicsLayerScope;
                reusableGraphicsLayerScope3.updateOutline$ui_release();
            }
        });
        LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.layerPositionalProperties = layerPositionalProperties;
        }
        layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
        ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
        this.isClipping = reusableGraphicsLayerScope.getClip();
        this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
        if (!invokeOnLayoutChange || (owner = getLayoutNode().getOwner()) == null) {
            return;
        }
        owner.onLayoutChange(getLayoutNode());
    }

    public static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        nodeCoordinator.updateLayerParameters(z5);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU */
    protected final long m2058calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1377getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m1375getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight()) / 2.0f));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw */
    public final float m2059distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m1377getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m1375getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long m2058calculateMinimumTouchTargetPaddingE7KxVPU = m2058calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float m1377getWidthimpl = Size.m1377getWidthimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU);
        float m1375getHeightimpl = Size.m1375getHeightimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU);
        long m2052offsetFromEdgeMKHz9U = m2052offsetFromEdgeMKHz9U(pointerPosition);
        if ((m1377getWidthimpl > 0.0f || m1375getHeightimpl > 0.0f) && Offset.m1337getXimpl(m2052offsetFromEdgeMKHz9U) <= m1377getWidthimpl && Offset.m1338getYimpl(m2052offsetFromEdgeMKHz9U) <= m1375getHeightimpl) {
            return Offset.m1336getDistanceSquaredimpl(m2052offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float m2640getXimpl = IntOffset.m2640getXimpl(getPosition());
        float m2641getYimpl = IntOffset.m2641getYimpl(getPosition());
        canvas.translate(m2640getXimpl, m2641getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-m2640getXimpl, -m2641getYimpl);
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m2661getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m2660getHeightimpl(getMeasuredSize()) - 0.5f), paint);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int m2074constructorimpl = NodeKind.m2074constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent = tail2.getNode().getParent(); parent != null; parent = parent.getParent()) {
                if ((parent.getKindSet() & m2074constructorimpl) != 0 && parent == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return layoutNode2 == getLayoutNode() ? this : layoutNode == other.getLayoutNode() ? other : layoutNode.getInnerCoordinator$ui_release();
    }

    /* renamed from: fromParentPosition-8S9VItk */
    public long m2060fromParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        if (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) {
            position = IntOffsetKt.m2649minusNvtHpc(position, getPosition());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo2078mapOffset8S9VItk(position, true) : position;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    /* renamed from: getForceMeasureWithLookaheadConstraints$ui_release, reason: from getter */
    public final boolean getForceMeasureWithLookaheadConstraints() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release */
    public final long m2061getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc */
    public final long m2062getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo213toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo2007getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m2074constructorimpl(64) & tail.getKindSet()) != 0) {
                int m2074constructorimpl = NodeKind.m2074constructorimpl(64);
                MutableVector mutableVector = null;
                DelegatingNode delegatingNode = tail;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof ParentDataModifierNode) {
                        ref$ObjectRef.element = ((ParentDataModifierNode) delegatingNode).modifyParentData(getLayoutNode().getDensity(), ref$ObjectRef.element);
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
        return ref$ObjectRef.element;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo1948getSizeYbymL2g() {
        return getMeasuredSize();
    }

    public abstract Modifier.Node getTail();

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* renamed from: head-H91voCI */
    public final Modifier.Node m2063headH91voCI(int type) {
        boolean m2075getIncludeSelfInTraversalH91voCI = NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!m2075getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m2075getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & type) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & type) != 0) {
                return headNode;
            }
            if (headNode == tail) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: hitTest-YqVAtuI */
    public final void m2064hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Modifier.Node m2063headH91voCI = m2063headH91voCI(hitTestSource.mo2071entityTypeOLwlOKw());
        if (!m2069withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float m2059distanceInMinimumTouchTargettz77jQw = m2059distanceInMinimumTouchTargettz77jQw(pointerPosition, m2062getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(m2059distanceInMinimumTouchTargettz77jQw) || Float.isNaN(m2059distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(m2059distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m2051hitNearJHbHoSQ(m2063headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, m2059distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (m2063headH91voCI == null) {
            mo1996hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m2065isPointerInBoundsk4lQ0M(pointerPosition)) {
            m2050hit1hIXUjU(m2063headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float m2059distanceInMinimumTouchTargettz77jQw2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m2059distanceInMinimumTouchTargettz77jQw(pointerPosition, m2062getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(m2059distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(m2059distanceInMinimumTouchTargettz77jQw2)) {
            if (hitTestResult.isHitInMinimumTouchTargetBetter(m2059distanceInMinimumTouchTargettz77jQw2, isInLayer)) {
                m2051hitNearJHbHoSQ(m2063headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, m2059distanceInMinimumTouchTargettz77jQw2);
                return;
            }
        }
        m2054speculativeHitJHbHoSQ(m2063headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, m2059distanceInMinimumTouchTargettz77jQw2);
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public void mo1996hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m2064hitTestYqVAtuI(hitTestSource, m2048fromParentPosition8S9VItk$default(nodeCoordinator, pointerPosition, false, 2, null), hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    /* renamed from: isPointerInBounds-k-4lQ0M */
    protected final boolean m2065isPointerInBoundsk4lQ0M(long pointerPosition) {
        float m1337getXimpl = Offset.m1337getXimpl(pointerPosition);
        float m1338getYimpl = Offset.m1338getYimpl(pointerPosition);
        return m1337getXimpl >= 0.0f && m1338getYimpl >= 0.0f && m1337getXimpl < ((float) getMeasuredWidth()) && m1338getYimpl < ((float) getMeasuredHeight());
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!sourceCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + sourceCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m2661getWidthimpl(sourceCoordinates.mo1948getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m2660getHeightimpl(sourceCoordinates.mo1948getSizeYbymL2g()));
        while (coordinator != findCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, clipBounds, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo1949localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo1950localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo1950localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) sourceCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m1345unaryMinusF1C5BW0(sourceCoordinates.mo1950localPositionOfS_NoaFU(this, Offset.m1345unaryMinusF1C5BW0(relativeToSource), includeMotionFrameOfReference));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            relativeToSource = coordinator.m2068toParentPosition8S9VItk(relativeToSource, includeMotionFrameOfReference);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m2047ancestorToLocalS_NoaFU(findCommonAncestor$ui_release, relativeToSource, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo1951localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        long j5 = relativeToLocal;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j5 = m2055toParentPosition8S9VItk$default(nodeCoordinator, j5, false, 2, null);
        }
        return j5;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo1952localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo2083calculatePositionInWindowMKHz9U(mo1951localToRootMKHz9U(relativeToLocal));
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
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
    protected void onMeasureResultChanged(int width, int height) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo2080resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m1966setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int m2074constructorimpl = NodeKind.m2074constructorimpl(4);
        boolean m2075getIncludeSelfInTraversalH91voCI = NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(m2074constructorimpl);
        Modifier.Node tail = getTail();
        if (m2075getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node headNode = headNode(m2075getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m2074constructorimpl) != 0; headNode = headNode.getChild()) {
                if ((headNode.getKindSet() & m2074constructorimpl) != 0) {
                    DelegatingNode delegatingNode = headNode;
                    MutableVector mutableVector = null;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof DrawModifierNode) {
                            ((DrawModifierNode) delegatingNode).onMeasureResultChanged();
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
                if (headNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    public final void onMeasured() {
        Modifier.Node parent;
        if (m2049hasNodeH91voCI(NodeKind.m2074constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int m2074constructorimpl = NodeKind.m2074constructorimpl(128);
                boolean m2075getIncludeSelfInTraversalH91voCI = NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(m2074constructorimpl);
                if (m2075getIncludeSelfInTraversalH91voCI) {
                    parent = getTail();
                } else {
                    parent = getTail().getParent();
                    if (parent == null) {
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    }
                }
                for (Modifier.Node headNode = headNode(m2075getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m2074constructorimpl) != 0; headNode = headNode.getChild()) {
                    if ((headNode.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNode = headNode;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) delegatingNode).mo177onRemeasuredozmzZPI(getMeasuredSize());
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
                    if (headNode == parent) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            } catch (Throwable th) {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                throw th;
            }
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
    public final void onPlaced() {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(128);
        boolean m2075getIncludeSelfInTraversalH91voCI = NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(m2074constructorimpl);
        Modifier.Node tail = getTail();
        if (!m2075getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m2075getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & m2074constructorimpl) != 0; headNode = headNode.getChild()) {
            if ((headNode.getKindSet() & m2074constructorimpl) != 0) {
                DelegatingNode delegatingNode = headNode;
                MutableVector mutableVector = null;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNode).onPlaced(this);
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
            if (headNode == tail) {
                return;
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public abstract void performDraw(Canvas canvas, GraphicsLayer graphicsLayer);

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo1947placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m2053placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, layerBlock, null);
            return;
        }
        m2053placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4 */
    public final void m2066placeSelfApparentToRealOffsetMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        m2053placeSelfMLgxB_4(IntOffset.m2644plusqkQi6aY(position, getApparentToRealOffset()), zIndex, layerBlock, layer);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long m2062getMinimumTouchTargetSizeNHjbRc = m2062getMinimumTouchTargetSizeNHjbRc();
                    float m1377getWidthimpl = Size.m1377getWidthimpl(m2062getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float m1375getHeightimpl = Size.m1375getHeightimpl(m2062getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-m1377getWidthimpl, -m1375getHeightimpl, IntSize.m2661getWidthimpl(mo1948getSizeYbymL2g()) + m1377getWidthimpl, IntSize.m2660getHeightimpl(mo1948getSizeYbymL2g()) + m1375getHeightimpl);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m2661getWidthimpl(mo1948getSizeYbymL2g()), IntSize.m2660getHeightimpl(mo1948getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float m2640getXimpl = IntOffset.m2640getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + m2640getXimpl);
        bounds.setRight(bounds.getRight() + m2640getXimpl);
        float m2641getYimpl = IntOffset.m2641getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + m2641getYimpl);
        bounds.setBottom(bounds.getBottom() + m2641getYimpl);
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo1965placeAtf8xVGno(getPosition(), this.zIndex, graphicsLayer);
        } else {
            mo1947placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1953screenToLocalMKHz9U(long relativeToScreen) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return mo1949localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo1914screenToLocalMKHz9U(relativeToScreen));
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z5) {
        this.forcePlaceWithLookaheadOffset = z5;
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.get$width() != measureResult2.get$width() || measureResult.get$height() != measureResult2.get$height()) {
                onMeasureResultChanged(measureResult.get$width(), measureResult.get$height());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map map2 = this.oldAlignmentLines;
            if (map2 == null) {
                map2 = new LinkedHashMap();
                this.oldAlignmentLines = map2;
            }
            map2.clear();
            map2.putAll(measureResult.getAlignmentLines());
        }
    }

    /* renamed from: setPosition--gyyYBs */
    protected void m2067setPositiongyyYBs(long j5) {
        this.position = j5;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(NodeKind.m2074constructorimpl(16)));
        if (headNode != null && headNode.getIsAttached()) {
            int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
            if (!headNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = headNode.getNode();
            if ((node.getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & m2074constructorimpl) != 0) {
                        DelegatingNode delegatingNode = node;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) delegatingNode).sharePointerInputWithSiblings()) {
                                    return true;
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
                    node = node.getChild();
                }
            }
        }
        return false;
    }

    /* renamed from: toParentPosition-8S9VItk */
    public long m2068toParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo2078mapOffset8S9VItk(position, false);
        }
        return (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m2650plusNvtHpc(position, getPosition()) : position;
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m2058calculateMinimumTouchTargetPaddingE7KxVPU = m2058calculateMinimumTouchTargetPaddingE7KxVPU(m2062getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1377getWidthimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m1375getHeightimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m1377getWidthimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m1375getHeightimpl(m2058calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo1954transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m1552resetimpl(matrix);
        coordinator.m2057transformToAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
        m2056transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo1955transformToScreen58bKbWc(float[] matrix) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        m2057transformToAncestorEL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this)), matrix);
        requireOwner.mo1912localToScreen58bKbWc(matrix);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        if (!(layerBlock == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z5 = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (!layoutNode.isAttached() || layerBlock == null) {
            this.layerBlock = null;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner = layoutNode.getOwner()) != null) {
                    owner.onLayoutChange(layoutNode);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.layerBlock = layerBlock;
        if (this.layer != null) {
            if (z5) {
                updateLayerParameters$default(this, false, 1, null);
                return;
            }
            return;
        }
        OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), this.drawBlock, this.invalidateParentLayer, null, 4, null);
        createLayer$default.mo2080resizeozmzZPI(getMeasuredSize());
        createLayer$default.mo2079movegyyYBs(getPosition());
        this.layer = createLayer$default;
        updateLayerParameters$default(this, false, 1, null);
        layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
        this.invalidateParentLayer.invoke();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo1956windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo1949localPositionOfR5De75A(findRootCoordinates, Offset.m1341minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo2082calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    /* renamed from: withinLayerBounds-k-4lQ0M */
    public final boolean m2069withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m1350isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo2077isInLayerk4lQ0M(pointerPosition);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo1965placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m2053placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, null, layer);
            return;
        }
        m2053placeSelfMLgxB_4(position, zIndex, null, layer);
    }
}
