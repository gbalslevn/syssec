package coil.request;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcoil/request/Parameters;", BuildConfig.FLAVOR, "css", "(Lcoil/request/Parameters;)Ljava/lang/String;", "coil-svg_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Svgs {
    public static final String css(Parameters parameters) {
        return (String) parameters.value("coil#css");
    }
}
