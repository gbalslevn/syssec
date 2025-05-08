package dk.molslinjen.ui.views.reusable.clickableText;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/reusable/clickableText/ClickableTextData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, Callback.METHOD_NAME, "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/text/font/FontWeight;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Lkotlin/jvm/functions/Function0;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/text/style/TextDecoration;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/graphics/Color;", "getColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ClickableTextData {
    private final Function0<Unit> callback;
    private final Color color;
    private final FontWeight fontWeight;
    private final String text;
    private final TextDecoration textDecoration;

    public /* synthetic */ ClickableTextData(String str, Function0 function0, TextDecoration textDecoration, Color color, FontWeight fontWeight, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function0, textDecoration, color, fontWeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickableTextData)) {
            return false;
        }
        ClickableTextData clickableTextData = (ClickableTextData) other;
        return Intrinsics.areEqual(this.text, clickableTextData.text) && Intrinsics.areEqual(this.callback, clickableTextData.callback) && Intrinsics.areEqual(this.textDecoration, clickableTextData.textDecoration) && Intrinsics.areEqual(this.color, clickableTextData.color) && Intrinsics.areEqual(this.fontWeight, clickableTextData.fontWeight);
    }

    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    /* renamed from: getColor-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getColor() {
        return this.color;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final String getText() {
        return this.text;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public int hashCode() {
        int hashCode = ((((this.text.hashCode() * 31) + this.callback.hashCode()) * 31) + this.textDecoration.hashCode()) * 31;
        Color color = this.color;
        int m1493hashCodeimpl = (hashCode + (color == null ? 0 : Color.m1493hashCodeimpl(color.getValue()))) * 31;
        FontWeight fontWeight = this.fontWeight;
        return m1493hashCodeimpl + (fontWeight != null ? fontWeight.hashCode() : 0);
    }

    public String toString() {
        return "ClickableTextData(text=" + this.text + ", callback=" + this.callback + ", textDecoration=" + this.textDecoration + ", color=" + this.color + ", fontWeight=" + this.fontWeight + ")";
    }

    private ClickableTextData(String text, Function0<Unit> callback, TextDecoration textDecoration, Color color, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        this.text = text;
        this.callback = callback;
        this.textDecoration = textDecoration;
        this.color = color;
        this.fontWeight = fontWeight;
    }

    public /* synthetic */ ClickableTextData(String str, Function0 function0, TextDecoration textDecoration, Color color, FontWeight fontWeight, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function0, (i5 & 4) != 0 ? TextDecoration.INSTANCE.getUnderline() : textDecoration, (i5 & 8) != 0 ? null : color, (i5 & 16) != 0 ? null : fontWeight, null);
    }
}
