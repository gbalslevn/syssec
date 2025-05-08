package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bw\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"androidx/compose/ui/text/font/FontVariation$Setting", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "toVariationValue", "(Landroidx/compose/ui/unit/Density;)F", BuildConfig.FLAVOR, "getAxisName", "()Ljava/lang/String;", "axisName", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FontVariation$Setting {
    String getAxisName();

    float toVariationValue(Density density);
}
