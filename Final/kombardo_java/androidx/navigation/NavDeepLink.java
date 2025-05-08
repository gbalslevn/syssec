package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavDeepLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 \u007f2\u00020\u0001:\u0007\u0080\u0001\u007f\u0081\u0001\u0082\u0001B'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J7\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ5\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¢\u0006\u0004\b\"\u0010#J5\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¢\u0006\u0004\b%\u0010&JC\u0010+\u001a\u00020\u00122\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¢\u0006\u0004\b+\u0010,J1\u00100\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b0\u00101J3\u00102\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105J\u001b\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)06H\u0002¢\u0006\u0004\b7\u00108J#\u0010:\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u000109H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u00105J\u0017\u0010A\u001a\u00020\u00122\u0006\u0010>\u001a\u00020=H\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010DJ/\u0010E\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020\u00112\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0007¢\u0006\u0004\bE\u0010FJ/\u0010H\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0000¢\u0006\u0004\bG\u0010FJ\u0019\u0010L\u001a\u00020B2\b\u0010I\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010N\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020BH\u0016¢\u0006\u0004\bP\u0010QR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010R\u001a\u0004\bU\u0010TR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010RR\u001d\u0010_\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\\\u001a\u0004\ba\u0010bR'\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\\\u001a\u0004\bd\u00108R\u0016\u0010f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR/\u0010j\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\\\u001a\u0004\bi\u0010;R!\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\\\u001a\u0004\bl\u0010mR\u001d\u0010q\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\\\u001a\u0004\bp\u0010TR\u001d\u0010t\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\\\u001a\u0004\bs\u0010^R\u0018\u0010u\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010RR\u001d\u0010x\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\\\u001a\u0004\bw\u0010^R*\u0010z\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\u00128G@@X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010g\u001a\u0004\bz\u0010b\"\u0004\b{\u0010|R\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b}\u0010m¨\u0006\u0083\u0001"}, d2 = {"Landroidx/navigation/NavDeepLink;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "uriPattern", "action", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uri", BuildConfig.FLAVOR, "args", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", BuildConfig.FLAVOR, "buildRegex", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/StringBuilder;)V", "Landroid/net/Uri;", BuildConfig.FLAVOR, "matchUri", "(Landroid/net/Uri;)Z", "matchAction", "(Ljava/lang/String;)Z", "matchMimeType", "fragment", "Landroid/os/Bundle;", "bundle", BuildConfig.FLAVOR, "Landroidx/navigation/NavArgument;", "arguments", "getMatchingUriFragment", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "Ljava/util/regex/Matcher;", "matcher", "getMatchingPathArguments", "(Ljava/util/regex/Matcher;Landroid/os/Bundle;Ljava/util/Map;)Z", "deepLink", "getMatchingQueryArguments", "(Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/Map;)Z", BuildConfig.FLAVOR, "inputParams", "Landroidx/navigation/NavDeepLink$ParamQuery;", "storedParam", "parseInputParams", "(Ljava/util/List;Landroidx/navigation/NavDeepLink$ParamQuery;Landroid/os/Bundle;Ljava/util/Map;)Z", "name", "value", "argument", "parseArgument", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "parseArgumentForRepeatedParam", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "parsePath", "()V", BuildConfig.FLAVOR, "parseQuery", "()Ljava/util/Map;", "Lkotlin/Pair;", "parseFragment", "()Lkotlin/Pair;", "parseMime", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "matches$navigation_common_release", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "matches", BuildConfig.FLAVOR, "getMimeTypeMatchRating", "(Ljava/lang/String;)I", "getMatchingArguments", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "getMatchingPathAndQueryArgs$navigation_common_release", "getMatchingPathAndQueryArgs", "requestedLink", "calculateMatchingPathSegments$navigation_common_release", "(Landroid/net/Uri;)I", "calculateMatchingPathSegments", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getUriPattern", "()Ljava/lang/String;", "getAction", "getMimeType", "pathArgs", "Ljava/util/List;", "pathRegex", "Ljava/util/regex/Pattern;", "pathPattern$delegate", "Lkotlin/Lazy;", "getPathPattern", "()Ljava/util/regex/Pattern;", "pathPattern", "isParameterizedQuery$delegate", "isParameterizedQuery", "()Z", "queryArgsMap$delegate", "getQueryArgsMap", "queryArgsMap", "isSingleQueryParamValueOnly", "Z", "fragArgsAndRegex$delegate", "getFragArgsAndRegex", "fragArgsAndRegex", "fragArgs$delegate", "getFragArgs", "()Ljava/util/List;", "fragArgs", "fragRegex$delegate", "getFragRegex", "fragRegex", "fragPattern$delegate", "getFragPattern", "fragPattern", "mimeTypeRegex", "mimeTypePattern$delegate", "getMimeTypePattern", "mimeTypePattern", "<set-?>", "isExactDeepLink", "setExactDeepLink$navigation_common_release", "(Z)V", "getArgumentsNames$navigation_common_release", "argumentsNames", "Companion", "Builder", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavDeepLink {
    private final String action;

    /* renamed from: fragArgs$delegate, reason: from kotlin metadata */
    private final Lazy fragArgs;

    /* renamed from: fragArgsAndRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragArgsAndRegex;

    /* renamed from: fragPattern$delegate, reason: from kotlin metadata */
    private final Lazy fragPattern;

    /* renamed from: fragRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragRegex;
    private boolean isExactDeepLink;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;

    /* renamed from: mimeTypePattern$delegate, reason: from kotlin metadata */
    private final Lazy mimeTypePattern;
    private String mimeTypeRegex;
    private String pathRegex;

    /* renamed from: queryArgsMap$delegate, reason: from kotlin metadata */
    private final Lazy queryArgsMap;
    private final String uriPattern;
    private static final Companion Companion = new Companion(null);
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");
    private static final String SCHEME_REGEX = "http[s]?://";
    private static final String WILDCARD_REGEX = ".*";
    private static final String WILDCARD_REGEX_ESCAPED = "\\E.*\\Q";
    private static final String PATH_REGEX = "([^/]*?|)";
    private final List<String> pathArgs = new ArrayList();

    /* renamed from: pathPattern$delegate, reason: from kotlin metadata */
    private final Lazy pathPattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pathPattern$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.pathRegex;
            if (str != null) {
                return Pattern.compile(str, 2);
            }
            return null;
        }
    });

    /* renamed from: isParameterizedQuery$delegate, reason: from kotlin metadata */
    private final Lazy isParameterizedQuery = LazyKt.lazy(new Function0<Boolean>() { // from class: androidx.navigation.NavDeepLink$isParameterizedQuery$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf((NavDeepLink.this.getUriPattern() == null || Uri.parse(NavDeepLink.this.getUriPattern()).getQuery() == null) ? false : true);
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "uriPattern", "setUriPattern", "(Ljava/lang/String;)Landroidx/navigation/NavDeepLink$Builder;", "action", "setAction", "mimeType", "setMimeType", "Landroidx/navigation/NavDeepLink;", "build", "()Landroidx/navigation/NavDeepLink;", "Ljava/lang/String;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private String action;
        private String mimeType;
        private String uriPattern;

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        public final Builder setAction(String action) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.action = action;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final Builder setUriPattern(String uriPattern) {
            Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
            this.uriPattern = uriPattern;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", BuildConfig.FLAVOR, "()V", "FILL_IN_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATH_REGEX", BuildConfig.FLAVOR, "SCHEME_PATTERN", "SCHEME_REGEX", "WILDCARD_REGEX", "WILDCARD_REGEX_ESCAPED", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mimeType", "<init>", "(Ljava/lang/String;)V", "other", BuildConfig.FLAVOR, "compareTo", "(Landroidx/navigation/NavDeepLink$MimeType;)I", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "subType", "getSubType", "setSubType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String mimeType) {
            List emptyList;
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            List<String> split = new Regex("/").split(mimeType, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt.emptyList();
            this.type = (String) emptyList.get(0);
            this.subType = (String) emptyList.get(1);
        }

        public final String getSubType() {
            return this.subType;
        }

        public final String getType() {
            return this.type;
        }

        @Override // java.lang.Comparable
        public int compareTo(MimeType other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i5 = Intrinsics.areEqual(this.type, other.type) ? 2 : 0;
            return Intrinsics.areEqual(this.subType, other.subType) ? i5 + 1 : i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "addArgumentName", "(Ljava/lang/String;)V", "paramRegex", "Ljava/lang/String;", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", BuildConfig.FLAVOR, "arguments", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final void addArgumentName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.arguments.add(name);
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Map<String, ParamQuery>>() { // from class: androidx.navigation.NavDeepLink$queryArgsMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, NavDeepLink.ParamQuery> invoke() {
                Map<String, NavDeepLink.ParamQuery> parseQuery;
                parseQuery = NavDeepLink.this.parseQuery();
                return parseQuery;
            }
        });
        this.fragArgsAndRegex = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Pair<? extends List<String>, ? extends String>>() { // from class: androidx.navigation.NavDeepLink$fragArgsAndRegex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends List<String>, ? extends String> invoke() {
                Pair<? extends List<String>, ? extends String> parseFragment;
                parseFragment = NavDeepLink.this.parseFragment();
                return parseFragment;
            }
        });
        this.fragArgs = LazyKt.lazy(lazyThreadSafetyMode, new Function0<List<String>>() { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<String> invoke() {
                Pair fragArgsAndRegex;
                List<String> list;
                fragArgsAndRegex = NavDeepLink.this.getFragArgsAndRegex();
                return (fragArgsAndRegex == null || (list = (List) fragArgsAndRegex.getFirst()) == null) ? new ArrayList() : list;
            }
        });
        this.fragRegex = LazyKt.lazy(lazyThreadSafetyMode, new Function0<String>() { // from class: androidx.navigation.NavDeepLink$fragRegex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Pair fragArgsAndRegex;
                fragArgsAndRegex = NavDeepLink.this.getFragArgsAndRegex();
                if (fragArgsAndRegex != null) {
                    return (String) fragArgsAndRegex.getSecond();
                }
                return null;
            }
        });
        this.fragPattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$fragPattern$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pattern invoke() {
                String fragRegex;
                fragRegex = NavDeepLink.this.getFragRegex();
                if (fragRegex != null) {
                    return Pattern.compile(fragRegex, 2);
                }
                return null;
            }
        });
        this.mimeTypePattern = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pattern invoke() {
                String str4;
                str4 = NavDeepLink.this.mimeTypeRegex;
                if (str4 != null) {
                    return Pattern.compile(str4);
                }
                return null;
            }
        });
        parsePath();
        parseMime();
    }

    private final void buildRegex(String uri, List<String> args, StringBuilder uriRegex) {
        Matcher matcher = FILL_IN_PATTERN.matcher(uri);
        int i5 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group, "null cannot be cast to non-null type kotlin.String");
            args.add(group);
            if (matcher.start() > i5) {
                String substring = uri.substring(i5, matcher.start());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                uriRegex.append(Pattern.quote(substring));
            }
            uriRegex.append(PATH_REGEX);
            i5 = matcher.end();
        }
        if (i5 < uri.length()) {
            String substring2 = uri.substring(i5);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            uriRegex.append(Pattern.quote(substring2));
        }
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> getFragArgsAndRegex() {
        return (Pair) this.fragArgsAndRegex.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex.getValue();
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> arguments) {
        List<String> list = this.pathArgs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            String value = Uri.decode(matcher.group(i6));
            NavArgument navArgument = arguments.get(str);
            try {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                parseArgument(bundle, str, value, navArgument);
                arrayList.add(Unit.INSTANCE);
                i5 = i6;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri deepLink, Bundle bundle, Map<String, NavArgument> arguments) {
        String query;
        for (Map.Entry<String, ParamQuery> entry : getQueryArgsMap().entrySet()) {
            String key = entry.getKey();
            ParamQuery value = entry.getValue();
            List<String> inputParams = deepLink.getQueryParameters(key);
            if (this.isSingleQueryParamValueOnly && (query = deepLink.getQuery()) != null && !Intrinsics.areEqual(query, deepLink.toString())) {
                inputParams = CollectionsKt.listOf(query);
            }
            Intrinsics.checkNotNullExpressionValue(inputParams, "inputParams");
            if (!parseInputParams(inputParams, value, bundle, arguments)) {
                return false;
            }
        }
        return true;
    }

    private final void getMatchingUriFragment(String fragment, Bundle bundle, Map<String, NavArgument> arguments) {
        Pattern fragPattern = getFragPattern();
        Matcher matcher = fragPattern != null ? fragPattern.matcher(String.valueOf(fragment)) : null;
        if (matcher != null && matcher.matches()) {
            List<String> fragArgs = getFragArgs();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragArgs, 10));
            int i5 = 0;
            for (Object obj : fragArgs) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                String value = Uri.decode(matcher.group(i6));
                NavArgument navArgument = arguments.get(str);
                try {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    parseArgument(bundle, str, value, navArgument);
                    arrayList.add(Unit.INSTANCE);
                    i5 = i6;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern.getValue();
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern.getValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery.getValue()).booleanValue();
    }

    private final boolean matchAction(String action) {
        boolean z5 = action == null;
        String str = this.action;
        return z5 != (str != null) && (action == null || Intrinsics.areEqual(str, action));
    }

    private final boolean matchMimeType(String mimeType) {
        if ((mimeType == null) != (this.mimeType != null)) {
            if (mimeType == null) {
                return true;
            }
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(mimeType).matches()) {
                return true;
            }
        }
        return false;
    }

    private final boolean matchUri(Uri uri) {
        if ((uri == null) != (getPathPattern() != null)) {
            if (uri == null) {
                return true;
            }
            Pattern pathPattern = getPathPattern();
            Intrinsics.checkNotNull(pathPattern);
            if (pathPattern.matcher(uri.toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    private final void parseArgument(Bundle bundle, String name, String value, NavArgument argument) {
        if (argument != null) {
            argument.getType().parseAndPut(bundle, name, value);
        } else {
            bundle.putString(name, value);
        }
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String name, String value, NavArgument argument) {
        if (!bundle.containsKey(name)) {
            return true;
        }
        if (argument == null) {
            return false;
        }
        NavType<Object> type = argument.getType();
        type.parseAndPut(bundle, name, value, type.get(bundle, name));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(fragment);
        buildRegex(fragment, arrayList, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "fragRegex.toString()");
        return TuplesKt.to(arrayList, sb2);
    }

    private final boolean parseInputParams(List<String> inputParams, ParamQuery storedParam, Bundle bundle, Map<String, NavArgument> arguments) {
        Object obj;
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        Iterator<T> it = storedParam.getArguments().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            NavArgument navArgument = arguments.get(str);
            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
            if ((type instanceof CollectionNavType) && !navArgument.getIsDefaultValuePresent()) {
                type.put(bundleOf, str, ((CollectionNavType) type).emptyCollection());
            }
        }
        for (String str2 : inputParams) {
            String paramRegex = storedParam.getParamRegex();
            Matcher matcher = paramRegex != null ? Pattern.compile(paramRegex, 32).matcher(str2) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            List<String> arguments2 = storedParam.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments2, 10));
            int i5 = 0;
            for (Object obj2 : arguments2) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj2;
                String group = matcher.group(i6);
                if (group == null) {
                    group = BuildConfig.FLAVOR;
                } else {
                    Intrinsics.checkNotNullExpressionValue(group, "argMatcher.group(index + 1) ?: \"\"");
                }
                NavArgument navArgument2 = arguments.get(str3);
                try {
                    if (bundleOf.containsKey(str3)) {
                        obj = Boolean.valueOf(parseArgumentForRepeatedParam(bundleOf, str3, group, navArgument2));
                    } else {
                        parseArgument(bundleOf, str3, group, navArgument2);
                        obj = Unit.INSTANCE;
                    }
                } catch (IllegalArgumentException unused) {
                    obj = Unit.INSTANCE;
                }
                arrayList.add(obj);
                i5 = i6;
            }
        }
        bundle.putAll(bundleOf);
        return true;
    }

    private final void parseMime() {
        if (this.mimeType == null) {
            return;
        }
        if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
        }
        MimeType mimeType = new MimeType(this.mimeType);
        this.mimeTypeRegex = StringsKt.replace$default("^(" + mimeType.getType() + "|[*]+)/(" + mimeType.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
    }

    private final void parsePath() {
        if (this.uriPattern == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
            sb.append(SCHEME_REGEX);
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
        matcher.find();
        boolean z5 = false;
        String substring = this.uriPattern.substring(0, matcher.start());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        buildRegex(substring, this.pathArgs, sb);
        String str = WILDCARD_REGEX;
        if (!StringsKt.contains$default((CharSequence) sb, (CharSequence) str, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) sb, (CharSequence) PATH_REGEX, false, 2, (Object) null)) {
            z5 = true;
        }
        this.isExactDeepLink = z5;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "uriRegex.toString()");
        this.pathRegex = StringsKt.replace$default(sb2, str, WILDCARD_REGEX_ESCAPED, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isParameterizedQuery()) {
            return linkedHashMap;
        }
        Uri parse = Uri.parse(this.uriPattern);
        for (String paramName : parse.getQueryParameterNames()) {
            StringBuilder sb = new StringBuilder();
            List<String> queryParams = parse.getQueryParameters(paramName);
            if (queryParams.size() > 1) {
                throw new IllegalArgumentException(("Query parameter " + paramName + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
            Intrinsics.checkNotNullExpressionValue(queryParams, "queryParams");
            String queryParam = (String) CollectionsKt.firstOrNull((List) queryParams);
            if (queryParam == null) {
                this.isSingleQueryParamValueOnly = true;
                queryParam = paramName;
            }
            Matcher matcher = FILL_IN_PATTERN.matcher(queryParam);
            ParamQuery paramQuery = new ParamQuery();
            int i5 = 0;
            while (matcher.find()) {
                String group = matcher.group(1);
                Intrinsics.checkNotNull(group, "null cannot be cast to non-null type kotlin.String");
                paramQuery.addArgumentName(group);
                Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
                String substring = queryParam.substring(i5, matcher.start());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                sb.append(Pattern.quote(substring));
                sb.append("(.+?)?");
                i5 = matcher.end();
            }
            if (i5 < queryParam.length()) {
                Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
                String substring2 = queryParam.substring(i5);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                sb.append(Pattern.quote(substring2));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "argRegex.toString()");
            paramQuery.setParamRegex(StringsKt.replace$default(sb2, WILDCARD_REGEX, WILDCARD_REGEX_ESCAPED, false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(paramName, "paramName");
            linkedHashMap.put(paramName, paramQuery);
        }
        return linkedHashMap;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri requestedLink) {
        if (requestedLink == null || this.uriPattern == null) {
            return 0;
        }
        List<String> requestedPathSegments = requestedLink.getPathSegments();
        List<String> uriPathSegments = Uri.parse(this.uriPattern).getPathSegments();
        Intrinsics.checkNotNullExpressionValue(requestedPathSegments, "requestedPathSegments");
        Intrinsics.checkNotNullExpressionValue(uriPathSegments, "uriPathSegments");
        return CollectionsKt.intersect(requestedPathSegments, uriPathSegments).size();
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) other;
        return Intrinsics.areEqual(this.uriPattern, navDeepLink.uriPattern) && Intrinsics.areEqual(this.action, navDeepLink.action) && Intrinsics.areEqual(this.mimeType, navDeepLink.mimeType);
    }

    public final String getAction() {
        return this.action;
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> list = this.pathArgs;
        Collection<ParamQuery> values = getQueryArgsMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ParamQuery) it.next()).getArguments());
        }
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) list, (Iterable) arrayList), (Iterable) getFragArgs());
    }

    public final Bundle getMatchingArguments(Uri deepLink, Map<String, NavArgument> arguments) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        final Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, arguments)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(deepLink, bundle, arguments)) {
            return null;
        }
        getMatchingUriFragment(deepLink.getFragment(), bundle, arguments);
        if (NavArgumentKt.missingRequiredArguments(arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDeepLink$getMatchingArguments$missingRequiredArguments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String argName) {
                Intrinsics.checkNotNullParameter(argName, "argName");
                return Boolean.valueOf(!bundle.containsKey(argName));
            }
        }).isEmpty()) {
            return bundle;
        }
        return null;
    }

    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(Uri deepLink, Map<String, NavArgument> arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Bundle bundle = new Bundle();
        if (deepLink == null) {
            return bundle;
        }
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return bundle;
        }
        getMatchingPathArguments(matcher, bundle, arguments);
        if (isParameterizedQuery()) {
            getMatchingQueryArguments(deepLink, bundle, arguments);
        }
        return bundle;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getMimeTypeMatchRating(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(mimeType).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(mimeType));
            }
        }
        return -1;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        String str = this.uriPattern;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /* renamed from: isExactDeepLink, reason: from getter */
    public final boolean getIsExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        if (matchUri(deepLinkRequest.getUri()) && matchAction(deepLinkRequest.getAction())) {
            return matchMimeType(deepLinkRequest.getMimeType());
        }
        return false;
    }
}
