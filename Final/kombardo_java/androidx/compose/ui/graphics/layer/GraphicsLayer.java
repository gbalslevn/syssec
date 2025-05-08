package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¿\u00012\u00020\u0001:\u0002¿\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u0019\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u0011J<\u00102\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\f0-ø\u0001\u0000¢\u0006\u0004\b0\u00101J!\u00108\u001a\u00020\f2\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u00020\fH\u0000¢\u0006\u0004\b9\u0010\u0011J\u000f\u0010<\u001a\u00020\fH\u0000¢\u0006\u0004\b;\u0010\u0011J\u0015\u0010=\u001a\u00020\f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b=\u0010>J.\u0010E\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020?2\b\b\u0002\u0010\u000b\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020Aø\u0001\u0000¢\u0006\u0004\bC\u0010DJ$\u0010G\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020?2\b\b\u0002\u0010\u000b\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bF\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010KR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010LR\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010MR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\f0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR \u0010P\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\f0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010V\u001a\u00020?8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010X\u001a\u00020@8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bX\u0010WR\u0016\u0010Y\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010_R\u0016\u0010a\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010UR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR$\u0010l\u001a\u00020S2\u0006\u0010k\u001a\u00020S8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bl\u0010U\u001a\u0004\bl\u0010mR0\u0010\t\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\t\u0010W\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR0\u0010\u000b\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n8\u0006@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u000b\u0010W\u001a\u0004\bs\u0010p\"\u0004\bt\u0010rR0\u0010u\u001a\u00020?2\u0006\u0010n\u001a\u00020?8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bu\u0010W\u001a\u0004\bv\u0010p\"\u0004\bw\u0010rR0\u0010x\u001a\u00020S2\u0006\u0010n\u001a\u00020S8F@FX\u0086\u000e¢\u0006\u0018\n\u0004\bx\u0010U\u0012\u0004\b|\u0010\u0011\u001a\u0004\by\u0010m\"\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R/\u0010\u0084\u0001\u001a\u00020\u007f2\u0006\u0010n\u001a\u00020\u007f8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R)\u0010\u0089\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R1\u0010\u008d\u0001\u001a\u00030\u008a\u00012\u0007\u0010n\u001a\u00030\u008a\u00018F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\u001a\u0006\b\u008b\u0001\u0010\u0081\u0001\"\u0006\b\u008c\u0001\u0010\u0083\u0001R/\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008e\u00012\t\u0010n\u001a\u0005\u0018\u00010\u008e\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R)\u0010\u0096\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0094\u0001\u0010\u0086\u0001\"\u0006\b\u0095\u0001\u0010\u0088\u0001R)\u0010\u0099\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0086\u0001\"\u0006\b\u0098\u0001\u0010\u0088\u0001R)\u0010\u009c\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0001\u0010\u0086\u0001\"\u0006\b\u009b\u0001\u0010\u0088\u0001R)\u0010\u009f\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009d\u0001\u0010\u0086\u0001\"\u0006\b\u009e\u0001\u0010\u0088\u0001R)\u0010¢\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b \u0001\u0010\u0086\u0001\"\u0006\b¡\u0001\u0010\u0088\u0001R)\u0010¥\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b£\u0001\u0010\u0086\u0001\"\u0006\b¤\u0001\u0010\u0088\u0001R)\u0010¨\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¦\u0001\u0010\u0086\u0001\"\u0006\b§\u0001\u0010\u0088\u0001R)\u0010«\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b©\u0001\u0010\u0086\u0001\"\u0006\bª\u0001\u0010\u0088\u0001R)\u0010®\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¬\u0001\u0010\u0086\u0001\"\u0006\b\u00ad\u0001\u0010\u0088\u0001R/\u0010´\u0001\u001a\u0005\u0018\u00010¯\u00012\t\u0010n\u001a\u0005\u0018\u00010¯\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u0014\u0010·\u0001\u001a\u00020[8F¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R/\u0010»\u0001\u001a\u00030¸\u00012\u0007\u0010n\u001a\u00030¸\u00018F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\u001a\u0005\b¹\u0001\u0010p\"\u0005\bº\u0001\u0010rR/\u0010¾\u0001\u001a\u00030¸\u00012\u0007\u0010n\u001a\u00030¸\u00018F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\u001a\u0005\b¼\u0001\u0010p\"\u0005\b½\u0001\u0010r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006À\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "impl", "Landroidx/compose/ui/graphics/layer/LayerManager;", "layerManager", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "Landroidx/compose/ui/unit/IntSize;", "size", BuildConfig.FLAVOR, "setPosition-VbeCjmY", "(JJ)V", "setPosition", "recordInternal", "()V", "graphicsLayer", "addSubLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/graphics/Canvas;", "androidCanvas", "transformCanvas", "(Landroid/graphics/Canvas;)V", "recreateDisplayListIfNeeded", "onAddedToParentLayer", "onRemovedFromParentLayer", "Landroid/graphics/RectF;", "obtainPathBounds", "()Landroid/graphics/RectF;", "configureOutlineAndClip", "Landroidx/compose/ui/graphics/Path;", "path", "Landroid/graphics/Outline;", "updatePathOutline", "(Landroidx/compose/ui/graphics/Path;)Landroid/graphics/Outline;", "obtainAndroidOutline", "()Landroid/graphics/Outline;", "discardContentIfReleasedAndHaveNoParentLayerUsages", "resetOutlineParams", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "record", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "parentLayer", "draw$ui_graphics_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "release$ui_graphics_release", "release", "discardDisplayList$ui_graphics_release", "discardDisplayList", "setPathOutline", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", BuildConfig.FLAVOR, "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "setRoundRectOutline", "setRectOutline-tz77jQw", "setRectOutline", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroidx/compose/ui/graphics/layer/LayerManager;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/jvm/functions/Function1;", "clipDrawBlock", "androidOutline", "Landroid/graphics/Outline;", BuildConfig.FLAVOR, "outlineDirty", "Z", "roundRectOutlineTopLeft", "J", "roundRectOutlineSize", "roundRectCornerRadius", "F", "Landroidx/compose/ui/graphics/Outline;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "Landroidx/compose/ui/graphics/Paint;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", BuildConfig.FLAVOR, "parentLayerUsages", "I", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "<set-?>", "isReleased", "()Z", "value", "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "getSize-YbymL2g", "setSize-ozmzZPI", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "clip", "getClip", "setClip", "(Z)V", "getClip$annotations", "pathBounds", "Landroid/graphics/RectF;", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "compositingStrategy", "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "getScaleX", "setScaleX", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getShadowElevation", "setShadowElevation", "shadowElevation", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getRotationZ", "setRotationZ", "rotationZ", "getCameraDistance", "setCameraDistance", "cameraDistance", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "ambientShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "spotShadowColor", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private boolean clip;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private final LayerManager layerManager;
    private Path outlinePath;
    private int parentLayerUsages;
    private RectF pathBounds;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }
    };
    private final Function1<DrawScope, Unit> clipDrawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Path path;
            boolean z5;
            Function1 function1;
            Function1 function12;
            path = GraphicsLayer.this.outlinePath;
            z5 = GraphicsLayer.this.usePathForClip;
            if (z5 && GraphicsLayer.this.getClip() && path != null) {
                function12 = GraphicsLayer.this.drawBlock;
                int m1480getIntersectrtfAjoo = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo1684clipPathmtrdDE(path, m1480getIntersectrtfAjoo);
                    function12.invoke(drawScope);
                    return;
                } finally {
                    drawContext.getCanvas().restore();
                    drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                }
            }
            function1 = GraphicsLayer.this.drawBlock;
            function1.invoke(drawScope);
        }
    };
    private boolean outlineDirty = true;

    static {
        SnapshotImpl = LayerManager.INSTANCE.isRobolectric() ? LayerSnapshotV21.INSTANCE : Build.VERSION.SDK_INT >= 28 ? LayerSnapshotV28.INSTANCE : SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable() ? LayerSnapshotV22.INSTANCE : LayerSnapshotV21.INSTANCE;
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager) {
        this.impl = graphicsLayerImpl;
        Offset.Companion companion = Offset.INSTANCE;
        this.roundRectOutlineTopLeft = companion.m1349getZeroF1C5BW0();
        this.roundRectOutlineSize = Size.INSTANCE.m1383getUnspecifiedNHjbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m2648getZeronOccac();
        this.size = IntSize.INSTANCE.m2665getZeroYbymL2g();
        this.pivotOffset = companion.m1348getUnspecifiedF1C5BW0();
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void configureOutlineAndClip() {
        if (this.outlineDirty) {
            Outline outline = null;
            if (this.clip || getShadowElevation() > 0.0f) {
                Path path = this.outlinePath;
                if (path != null) {
                    RectF obtainPathBounds = obtainPathBounds();
                    if (!(path instanceof AndroidPath)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((AndroidPath) path).getInternalPath().computeBounds(obtainPathBounds, false);
                    Outline updatePathOutline = updatePathOutline(path);
                    if (updatePathOutline != null) {
                        updatePathOutline.setAlpha(getAlpha());
                        outline = updatePathOutline;
                    }
                    this.impl.mo1736setOutlineO0kMr_c(outline, IntSizeKt.IntSize(Math.round(obtainPathBounds.width()), Math.round(obtainPathBounds.height())));
                    if (this.usePathForClip && this.clip) {
                        this.impl.setClip(false);
                        this.impl.discardDisplayList();
                    } else {
                        this.impl.setClip(this.clip);
                    }
                } else {
                    this.impl.setClip(this.clip);
                    Size.INSTANCE.m1384getZeroNHjbRc();
                    Outline obtainAndroidOutline = obtainAndroidOutline();
                    long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(this.size);
                    long j5 = this.roundRectOutlineTopLeft;
                    long j6 = this.roundRectOutlineSize;
                    long j7 = j6 == 9205357640488583168L ? m2668toSizeozmzZPI : j6;
                    obtainAndroidOutline.setRoundRect(Math.round(Offset.m1337getXimpl(j5)), Math.round(Offset.m1338getYimpl(j5)), Math.round(Offset.m1337getXimpl(j5) + Size.m1377getWidthimpl(j7)), Math.round(Offset.m1338getYimpl(j5) + Size.m1375getHeightimpl(j7)), this.roundRectCornerRadius);
                    obtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.mo1736setOutlineO0kMr_c(obtainAndroidOutline, IntSizeKt.m2667roundToIntSizeuvyYCjk(j7));
                }
            } else {
                this.impl.setClip(false);
                this.impl.mo1736setOutlineO0kMr_c(null, IntSize.INSTANCE.m2665getZeroYbymL2g());
            }
        }
        this.outlineDirty = false;
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            discardDisplayList$ui_graphics_release();
        }
    }

    private final Outline obtainAndroidOutline() {
        Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    private final RectF obtainPathBounds() {
        RectF rectF = this.pathBounds;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.pathBounds = rectF2;
        return rectF2;
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void recordInternal() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        ChildLayerDependenciesTracker.access$setOldDependency$p(childLayerDependenciesTracker, ChildLayerDependenciesTracker.access$getDependency$p(childLayerDependenciesTracker));
        MutableScatterSet access$getDependenciesSet$p = ChildLayerDependenciesTracker.access$getDependenciesSet$p(childLayerDependenciesTracker);
        if (access$getDependenciesSet$p != null && access$getDependenciesSet$p.isNotEmpty()) {
            MutableScatterSet access$getOldDependenciesSet$p = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childLayerDependenciesTracker);
            if (access$getOldDependenciesSet$p == null) {
                access$getOldDependenciesSet$p = ScatterSetKt.mutableScatterSetOf();
                ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(childLayerDependenciesTracker, access$getOldDependenciesSet$p);
            }
            access$getOldDependenciesSet$p.addAll(access$getDependenciesSet$p);
            access$getDependenciesSet$p.clear();
        }
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childLayerDependenciesTracker, true);
        this.impl.record(this.density, this.layoutDirection, this, this.clipDrawBlock);
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childLayerDependenciesTracker, false);
        GraphicsLayer access$getOldDependency$p = ChildLayerDependenciesTracker.access$getOldDependency$p(childLayerDependenciesTracker);
        if (access$getOldDependency$p != null) {
            access$getOldDependency$p.onRemovedFromParentLayer();
        }
        MutableScatterSet access$getOldDependenciesSet$p2 = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childLayerDependenciesTracker);
        if (access$getOldDependenciesSet$p2 == null || !access$getOldDependenciesSet$p2.isNotEmpty()) {
            return;
        }
        Object[] objArr = access$getOldDependenciesSet$p2.elements;
        long[] jArr = access$getOldDependenciesSet$p2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            ((GraphicsLayer) objArr[(i5 << 3) + i7]).onRemovedFromParentLayer();
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        access$getOldDependenciesSet$p2.clear();
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m1383getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m1349getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m1715setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo1738setPositionH0pRuoY(IntOffset.m2640getXimpl(topLeft), IntOffset.m2641getYimpl(topLeft), size);
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m1716setSizeozmzZPI(long j5) {
        if (IntSize.m2659equalsimpl0(this.size, j5)) {
            return;
        }
        this.size = j5;
        m1715setPositionVbeCjmY(this.topLeft, j5);
        if (this.roundRectOutlineSize == 9205357640488583168L) {
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        float m2640getXimpl = IntOffset.m2640getXimpl(this.topLeft);
        float m2641getYimpl = IntOffset.m2641getYimpl(this.topLeft);
        float m2640getXimpl2 = IntOffset.m2640getXimpl(this.topLeft) + IntSize.m2661getWidthimpl(this.size);
        float m2641getYimpl2 = IntOffset.m2641getYimpl(this.topLeft) + IntSize.m2660getHeightimpl(this.size);
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int m1717getBlendMode0nO6VwU = m1717getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m1429equalsimpl0(m1717getBlendMode0nO6VwU, BlendMode.INSTANCE.m1459getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m1711equalsimpl0(m1718getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w())) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(alpha);
            paint.mo1408setBlendModes9anfk8(m1717getBlendMode0nO6VwU);
            paint.setColorFilter(colorFilter);
            androidCanvas.saveLayer(m2640getXimpl, m2641getYimpl, m2640getXimpl2, m2641getYimpl2, paint.getInternalPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas.translate(m2640getXimpl, m2641getYimpl);
        androidCanvas.concat(this.impl.calculateMatrix());
    }

    private final Outline updatePathOutline(Path path) {
        Outline outline;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 28 || path.isConvex()) {
            Outline obtainAndroidOutline = obtainAndroidOutline();
            if (i5 >= 30) {
                OutlineVerificationHelper.INSTANCE.setPath(obtainAndroidOutline, path);
            } else {
                if (!(path instanceof AndroidPath)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                obtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            }
            this.usePathForClip = !obtainAndroidOutline.canClip();
            outline = obtainAndroidOutline;
        } else {
            Outline outline2 = this.androidOutline;
            if (outline2 != null) {
                outline2.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
            outline = null;
        }
        this.outlinePath = path;
        return outline;
    }

    public final void discardDisplayList$ui_graphics_release() {
        ChildLayerDependenciesTracker childLayerDependenciesTracker = this.childDependenciesTracker;
        GraphicsLayer access$getDependency$p = ChildLayerDependenciesTracker.access$getDependency$p(childLayerDependenciesTracker);
        if (access$getDependency$p != null) {
            access$getDependency$p.onRemovedFromParentLayer();
            ChildLayerDependenciesTracker.access$setDependency$p(childLayerDependenciesTracker, null);
        }
        MutableScatterSet access$getDependenciesSet$p = ChildLayerDependenciesTracker.access$getDependenciesSet$p(childLayerDependenciesTracker);
        if (access$getDependenciesSet$p != null) {
            Object[] objArr = access$getDependenciesSet$p.elements;
            long[] jArr = access$getDependenciesSet$p.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                ((GraphicsLayer) objArr[(i5 << 3) + i7]).onRemovedFromParentLayer();
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            access$getDependenciesSet$p.clear();
        }
        this.impl.discardDisplayList();
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        if (this.isReleased) {
            return;
        }
        configureOutlineAndClip();
        recreateDisplayListIfNeeded();
        boolean z5 = getShadowElevation() > 0.0f;
        if (z5) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean isHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!isHardwareAccelerated) {
            nativeCanvas.save();
            transformCanvas(nativeCanvas);
        }
        boolean z6 = !isHardwareAccelerated && this.clip;
        if (z6) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.m1475clipRectmtrdDE$default(canvas, outline.getRect(), 0, 2, null);
            } else if (outline instanceof Outline.Rounded) {
                Path path = this.roundRectClipPath;
                if (path != null) {
                    path.rewind();
                } else {
                    path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = path;
                }
                Path.addRoundRect$default(path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.m1473clipPathmtrdDE$default(canvas, path, 0, 2, null);
            } else if (outline instanceof Outline.Generic) {
                androidx.compose.ui.graphics.Canvas.m1473clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (z6) {
            canvas.restore();
        }
        if (z5) {
            canvas.disableZ();
        }
        if (isHardwareAccelerated) {
            return;
        }
        nativeCanvas.restore();
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m1717getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m1718getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path != null) {
            Outline.Generic generic = new Outline.Generic(path);
            this.internalOutline = generic;
            return generic;
        }
        long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(this.size);
        long j5 = this.roundRectOutlineTopLeft;
        long j6 = this.roundRectOutlineSize;
        if (j6 != 9205357640488583168L) {
            m2668toSizeozmzZPI = j6;
        }
        float m1337getXimpl = Offset.m1337getXimpl(j5);
        float m1338getYimpl = Offset.m1338getYimpl(j5);
        float m1377getWidthimpl = m1337getXimpl + Size.m1377getWidthimpl(m2668toSizeozmzZPI);
        float m1375getHeightimpl = m1338getYimpl + Size.m1375getHeightimpl(m2668toSizeozmzZPI);
        float f5 = this.roundRectCornerRadius;
        androidx.compose.ui.graphics.Outline rounded = f5 > 0.0f ? new Outline.Rounded(RoundRectKt.m1368RoundRectgG7oq9Y(m1337getXimpl, m1338getYimpl, m1377getWidthimpl, m1375getHeightimpl, CornerRadiusKt.CornerRadius$default(f5, 0.0f, 2, null))) : new Outline.Rectangle(new Rect(m1337getXimpl, m1338getYimpl, m1377getWidthimpl, m1375getHeightimpl));
        this.internalOutline = rounded;
        return rounded;
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m1722recordmLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        m1716setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    public final void setAlpha(float f5) {
        if (this.impl.getAlpha() == f5) {
            return;
        }
        this.impl.setAlpha(f5);
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m1723setAmbientShadowColor8_81llA(long j5) {
        if (Color.m1487equalsimpl0(j5, this.impl.getAmbientShadowColor())) {
            return;
        }
        this.impl.mo1734setAmbientShadowColor8_81llA(j5);
    }

    public final void setCameraDistance(float f5) {
        if (this.impl.getCameraDistance() == f5) {
            return;
        }
        this.impl.setCameraDistance(f5);
    }

    public final void setClip(boolean z5) {
        if (this.clip != z5) {
            this.clip = z5;
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m1724setCompositingStrategyWpw9cng(int i5) {
        if (CompositingStrategy.m1711equalsimpl0(this.impl.getCompositingStrategy(), i5)) {
            return;
        }
        this.impl.mo1735setCompositingStrategyWpw9cng(i5);
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutlineAndClip();
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m1725setPivotOffsetk4lQ0M(long j5) {
        if (Offset.m1334equalsimpl0(this.pivotOffset, j5)) {
            return;
        }
        this.pivotOffset = j5;
        this.impl.mo1737setPivotOffsetk4lQ0M(j5);
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m1726setRectOutlinetz77jQw(long topLeft, long size) {
        m1727setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        this.impl.getRenderEffect();
        if (Intrinsics.areEqual((Object) null, renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    public final void setRotationX(float f5) {
        if (this.impl.getRotationX() == f5) {
            return;
        }
        this.impl.setRotationX(f5);
    }

    public final void setRotationY(float f5) {
        if (this.impl.getRotationY() == f5) {
            return;
        }
        this.impl.setRotationY(f5);
    }

    public final void setRotationZ(float f5) {
        if (this.impl.getRotationZ() == f5) {
            return;
        }
        this.impl.setRotationZ(f5);
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m1727setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m1334equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m1374equalsimpl0(this.roundRectOutlineSize, size) && this.roundRectCornerRadius == cornerRadius && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutlineAndClip();
    }

    public final void setScaleX(float f5) {
        if (this.impl.getScaleX() == f5) {
            return;
        }
        this.impl.setScaleX(f5);
    }

    public final void setScaleY(float f5) {
        if (this.impl.getScaleY() == f5) {
            return;
        }
        this.impl.setScaleY(f5);
    }

    public final void setShadowElevation(float f5) {
        if (this.impl.getShadowElevation() == f5) {
            return;
        }
        this.impl.setShadowElevation(f5);
        this.outlineDirty = true;
        configureOutlineAndClip();
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m1728setSpotShadowColor8_81llA(long j5) {
        if (Color.m1487equalsimpl0(j5, this.impl.getSpotShadowColor())) {
            return;
        }
        this.impl.mo1739setSpotShadowColor8_81llA(j5);
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m1729setTopLeftgyyYBs(long j5) {
        if (IntOffset.m2639equalsimpl0(this.topLeft, j5)) {
            return;
        }
        this.topLeft = j5;
        m1715setPositionVbeCjmY(j5, this.size);
    }

    public final void setTranslationX(float f5) {
        if (this.impl.getTranslationX() == f5) {
            return;
        }
        this.impl.setTranslationX(f5);
    }

    public final void setTranslationY(float f5) {
        if (this.impl.getTranslationY() == f5) {
            return;
        }
        this.impl.setTranslationY(f5);
    }
}
