package androidx.graphics.path;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/graphics/path/ConicConverter;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "conicPoints", BuildConfig.FLAVOR, "offset", "quadraticPoints", BuildConfig.FLAVOR, "weight", "tolerance", "internalConicToQuadratics", "([FI[FFF)I", "<set-?>", "quadraticCount", "I", "getQuadraticCount", "()I", "currentQuadratic", "getCurrentQuadratic", "setCurrentQuadratic", "(I)V", "quadraticData", "[F", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData;

    private final native int internalConicToQuadratics(float[] conicPoints, int offset, float[] quadraticPoints, float weight, float tolerance);
}
