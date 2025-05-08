package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a!\u0010\f\u001a\u00020\u000b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "onDraw", "drawBehind", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "onBuildDrawCache", "drawWithCache", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "CacheDrawModifierNode", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/draw/CacheDrawModifierNode;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawWithContent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DrawModifierKt {
    public static final CacheDrawModifierNode CacheDrawModifierNode(Function1<? super CacheDrawScope, DrawResult> function1) {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), function1);
    }

    public static final Modifier drawBehind(Modifier modifier, Function1<? super DrawScope, Unit> function1) {
        return modifier.then(new DrawBehindElement(function1));
    }

    public static final Modifier drawWithCache(Modifier modifier, Function1<? super CacheDrawScope, DrawResult> function1) {
        return modifier.then(new DrawWithCacheElement(function1));
    }

    public static final Modifier drawWithContent(Modifier modifier, Function1<? super ContentDrawScope, Unit> function1) {
        return modifier.then(new DrawWithContentElement(function1));
    }
}
