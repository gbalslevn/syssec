package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001 B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/navigation/serialization/RouteBuilder;", "T", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "serializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", BuildConfig.FLAVOR, "path", BuildConfig.FLAVOR, "addPath", "(Ljava/lang/String;)V", "name", "value", "addQuery", "(Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "index", "Landroidx/navigation/NavType;", "type", "Landroidx/navigation/serialization/RouteBuilder$ParamType;", "computeParamType", "(ILandroidx/navigation/NavType;)Landroidx/navigation/serialization/RouteBuilder$ParamType;", "build", "()Ljava/lang/String;", BuildConfig.FLAVOR, "appendArg", "(ILjava/lang/String;Landroidx/navigation/NavType;Ljava/util/List;)V", "Lkotlinx/serialization/KSerializer;", "Ljava/lang/String;", "pathArgs", "queryArgs", "ParamType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RouteBuilder<T> {
    private final String path;
    private String pathArgs;
    private String queryArgs;
    private final KSerializer<T> serializer;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/serialization/RouteBuilder$ParamType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "PATH", "QUERY", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum ParamType {
        PATH,
        QUERY
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParamType.values().length];
            try {
                iArr[ParamType.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ParamType.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RouteBuilder(KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.pathArgs = BuildConfig.FLAVOR;
        this.queryArgs = BuildConfig.FLAVOR;
        this.serializer = serializer;
        this.path = serializer.getDescriptor().getSerialName();
    }

    private final void addPath(String path) {
        this.pathArgs += '/' + path;
    }

    private final void addQuery(String name, String value) {
        this.queryArgs += (this.queryArgs.length() == 0 ? "?" : "&") + name + '=' + value;
    }

    private final ParamType computeParamType(int index, NavType<Object> type) {
        return ((type instanceof CollectionNavType) || this.serializer.getDescriptor().isElementOptional(index)) ? ParamType.QUERY : ParamType.PATH;
    }

    public final void appendArg(int index, String name, NavType<Object> type, List<String> value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        int i5 = WhenMappings.$EnumSwitchMapping$0[computeParamType(index, type).ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                return;
            }
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                addQuery(name, (String) it.next());
            }
            return;
        }
        if (value.size() == 1) {
            addPath((String) CollectionsKt.first((List) value));
            return;
        }
        throw new IllegalArgumentException(("Expected one value for argument " + name + ", found " + value.size() + "values instead.").toString());
    }

    public final String build() {
        return this.path + this.pathArgs + this.queryArgs;
    }
}
