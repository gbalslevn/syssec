package androidx.compose.ui;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAbsoluteAlignment;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR \u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR \u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR \u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR \u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\bR \u0010\u001a\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u0012\u0004\b!\u0010\u0003\u001a\u0004\b \u0010\u001d¨\u0006\""}, d2 = {"Landroidx/compose/ui/AbsoluteAlignment;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/Alignment;", "TopLeft", "Landroidx/compose/ui/Alignment;", "getTopLeft", "()Landroidx/compose/ui/Alignment;", "getTopLeft$annotations", "TopRight", "getTopRight", "getTopRight$annotations", "CenterLeft", "getCenterLeft", "getCenterLeft$annotations", "CenterRight", "getCenterRight", "getCenterRight$annotations", "BottomLeft", "getBottomLeft", "getBottomLeft$annotations", "BottomRight", "getBottomRight", "getBottomRight$annotations", "Landroidx/compose/ui/Alignment$Horizontal;", "Left", "Landroidx/compose/ui/Alignment$Horizontal;", "getLeft", "()Landroidx/compose/ui/Alignment$Horizontal;", "getLeft$annotations", "Right", "getRight", "getRight$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AbsoluteAlignment {
    public static final AbsoluteAlignment INSTANCE = new AbsoluteAlignment();
    private static final Alignment TopLeft = new BiasAbsoluteAlignment(-1.0f, -1.0f);
    private static final Alignment TopRight = new BiasAbsoluteAlignment(1.0f, -1.0f);
    private static final Alignment CenterLeft = new BiasAbsoluteAlignment(-1.0f, 0.0f);
    private static final Alignment CenterRight = new BiasAbsoluteAlignment(1.0f, 0.0f);
    private static final Alignment BottomLeft = new BiasAbsoluteAlignment(-1.0f, 1.0f);
    private static final Alignment BottomRight = new BiasAbsoluteAlignment(1.0f, 1.0f);
    private static final Alignment.Horizontal Left = new BiasAbsoluteAlignment.Horizontal(-1.0f);
    private static final Alignment.Horizontal Right = new BiasAbsoluteAlignment.Horizontal(1.0f);

    private AbsoluteAlignment() {
    }

    public final Alignment.Horizontal getLeft() {
        return Left;
    }

    public final Alignment.Horizontal getRight() {
        return Right;
    }

    public final Alignment getTopLeft() {
        return TopLeft;
    }

    public final Alignment getTopRight() {
        return TopRight;
    }
}
