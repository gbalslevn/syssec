package androidx.compose.ui.text.font;

import com.adjust.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "(I)V", "getWeight", "()I", "compareTo", "other", "equals", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontWeight implements Comparable<FontWeight> {
    private static final FontWeight Black;
    private static final FontWeight Bold;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FontWeight ExtraBold;
    private static final FontWeight ExtraLight;
    private static final FontWeight Light;
    private static final FontWeight Medium;
    private static final FontWeight Normal;
    private static final FontWeight SemiBold;
    private static final FontWeight Thin;
    private static final FontWeight W100;
    private static final FontWeight W200;
    private static final FontWeight W300;
    private static final FontWeight W400;
    private static final FontWeight W500;
    private static final FontWeight W600;
    private static final FontWeight W700;
    private static final FontWeight W800;
    private static final FontWeight W900;
    private static final List<FontWeight> values;
    private final int weight;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR \u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR \u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR \u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR \u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\bR \u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/font/FontWeight$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/font/FontWeight;", "W400", "Landroidx/compose/ui/text/font/FontWeight;", "getW400", "()Landroidx/compose/ui/text/font/FontWeight;", "getW400$annotations", "W500", "getW500", "getW500$annotations", "W600", "getW600", "getW600$annotations", "Light", "getLight", "getLight$annotations", "Normal", "getNormal", "getNormal$annotations", "Medium", "getMedium", "getMedium$annotations", "Bold", "getBold", "getBold$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FontWeight getBold() {
            return FontWeight.Bold;
        }

        public final FontWeight getLight() {
            return FontWeight.Light;
        }

        public final FontWeight getMedium() {
            return FontWeight.Medium;
        }

        public final FontWeight getNormal() {
            return FontWeight.Normal;
        }

        public final FontWeight getW400() {
            return FontWeight.W400;
        }

        public final FontWeight getW500() {
            return FontWeight.W500;
        }

        public final FontWeight getW600() {
            return FontWeight.W600;
        }

        private Companion() {
        }
    }

    static {
        FontWeight fontWeight = new FontWeight(100);
        W100 = fontWeight;
        FontWeight fontWeight2 = new FontWeight(200);
        W200 = fontWeight2;
        FontWeight fontWeight3 = new FontWeight(300);
        W300 = fontWeight3;
        FontWeight fontWeight4 = new FontWeight(Constants.MINIMAL_ERROR_STATUS_CODE);
        W400 = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(500);
        W500 = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        W600 = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(700);
        W700 = fontWeight7;
        FontWeight fontWeight8 = new FontWeight(800);
        W800 = fontWeight8;
        FontWeight fontWeight9 = new FontWeight(900);
        W900 = fontWeight9;
        Thin = fontWeight;
        ExtraLight = fontWeight2;
        Light = fontWeight3;
        Normal = fontWeight4;
        Medium = fontWeight5;
        SemiBold = fontWeight6;
        Bold = fontWeight7;
        ExtraBold = fontWeight8;
        Black = fontWeight9;
        values = CollectionsKt.listOf((Object[]) new FontWeight[]{fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9});
    }

    public FontWeight(int i5) {
        this.weight = i5;
        if (1 > i5 || i5 >= 1001) {
            throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i5).toString());
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FontWeight) && this.weight == ((FontWeight) other).weight;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.weight;
    }

    public String toString() {
        return "FontWeight(weight=" + this.weight + ')';
    }

    @Override // java.lang.Comparable
    public int compareTo(FontWeight other) {
        return Intrinsics.compare(this.weight, other.weight);
    }
}
