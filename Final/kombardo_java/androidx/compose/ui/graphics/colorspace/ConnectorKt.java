package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.graphics.colorspace.RenderIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "Connectors", "Landroidx/collection/MutableIntObjectMap;", "getConnectors", "()Landroidx/collection/MutableIntObjectMap;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ConnectorKt {
    private static final MutableIntObjectMap<Connector> Connectors;

    static {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        int id = colorSpaces.getSrgb().getId();
        int id2 = colorSpaces.getSrgb().getId();
        RenderIntent.Companion companion = RenderIntent.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Connectors = IntObjectMapKt.mutableIntObjectMapOf(id | (id2 << 6) | (companion.m1657getPerceptualuksYyKA() << 12), Connector.INSTANCE.identity$ui_graphics_release(colorSpaces.getSrgb()), colorSpaces.getSrgb().getId() | (colorSpaces.getOklab().getId() << 6) | (companion.m1657getPerceptualuksYyKA() << 12), new Connector(colorSpaces.getSrgb(), colorSpaces.getOklab(), companion.m1657getPerceptualuksYyKA(), defaultConstructorMarker), colorSpaces.getOklab().getId() | (colorSpaces.getSrgb().getId() << 6) | (companion.m1657getPerceptualuksYyKA() << 12), new Connector(colorSpaces.getOklab(), colorSpaces.getSrgb(), companion.m1657getPerceptualuksYyKA(), defaultConstructorMarker));
    }

    public static final MutableIntObjectMap<Connector> getConnectors() {
        return Connectors;
    }
}
