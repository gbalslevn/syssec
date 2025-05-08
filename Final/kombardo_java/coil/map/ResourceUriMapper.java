package coil.map;

import android.content.res.Resources;
import android.net.Uri;
import coil.request.Options;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcoil/map/ResourceUriMapper;", "Lcoil/map/Mapper;", "Landroid/net/Uri;", "()V", "isApplicable", BuildConfig.FLAVOR, "data", "map", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResourceUriMapper implements Mapper<Uri, Uri> {
    private final boolean isApplicable(Uri data) {
        String authority;
        return Intrinsics.areEqual(data.getScheme(), "android.resource") && (authority = data.getAuthority()) != null && !StringsKt.isBlank(authority) && data.getPathSegments().size() == 2;
    }

    @Override // coil.map.Mapper
    public Uri map(Uri data, Options options) {
        if (!isApplicable(data)) {
            return null;
        }
        String authority = data.getAuthority();
        if (authority == null) {
            authority = BuildConfig.FLAVOR;
        }
        Resources resourcesForApplication = options.getContext().getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = data.getPathSegments();
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (identifier != 0) {
            Uri parse = Uri.parse("android.resource://" + authority + '/' + identifier);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
            return parse;
        }
        throw new IllegalStateException(("Invalid android.resource URI: " + data).toString());
    }
}
