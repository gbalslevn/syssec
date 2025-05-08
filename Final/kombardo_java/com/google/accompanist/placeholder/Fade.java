package com.google.accompanist.placeholder;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000f\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/google/accompanist/placeholder/Fade;", "Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", BuildConfig.FLAVOR, "animationSpec", "<init>", "(JLandroidx/compose/animation/core/InfiniteRepeatableSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "progress", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Brush;", "brush-d16Qtg0", "(FJ)Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "(F)F", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "J", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/SolidColor;", "placeholder_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class Fade implements PlaceholderHighlight {
    private final InfiniteRepeatableSpec<Float> animationSpec;
    private final SolidColor brush;
    private final long highlightColor;

    public /* synthetic */ Fade(long j5, InfiniteRepeatableSpec infiniteRepeatableSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, infiniteRepeatableSpec);
    }

    @Override // com.google.accompanist.placeholder.PlaceholderHighlight
    public float alpha(float progress) {
        return progress;
    }

    @Override // com.google.accompanist.placeholder.PlaceholderHighlight
    /* renamed from: brush-d16Qtg0, reason: not valid java name */
    public Brush mo2906brushd16Qtg0(float progress, long size) {
        return this.brush;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) other;
        return Color.m1487equalsimpl0(this.highlightColor, fade.highlightColor) && Intrinsics.areEqual(this.animationSpec, fade.animationSpec);
    }

    @Override // com.google.accompanist.placeholder.PlaceholderHighlight
    public InfiniteRepeatableSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return (Color.m1493hashCodeimpl(this.highlightColor) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Fade(highlightColor=" + ((Object) Color.m1494toStringimpl(this.highlightColor)) + ", animationSpec=" + this.animationSpec + ')';
    }

    private Fade(long j5, InfiniteRepeatableSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.highlightColor = j5;
        this.animationSpec = animationSpec;
        this.brush = new SolidColor(j5, null);
    }
}
