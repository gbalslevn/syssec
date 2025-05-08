package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent;", BuildConfig.FLAVOR, "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", ParameterComponent.PARAMETER_NAME_KEY, BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", ParameterComponent.PARAMETER_PATH_KEY, BuildConfig.FLAVOR, "Lcom/facebook/appevents/codeless/internal/PathComponent;", "getPath", "()Ljava/util/List;", "pathType", "getPathType", ParameterComponent.PARAMETER_VALUE_KEY, "getValue", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ParameterComponent {
    private static final String PARAMETER_NAME_KEY = "name";
    private static final String PARAMETER_PATH_KEY = "path";
    private static final String PARAMETER_VALUE_KEY = "value";
    private final String name;
    private final List<PathComponent> path;
    private final String pathType;
    private final String value;

    public ParameterComponent(JSONObject component) {
        int length;
        Intrinsics.checkNotNullParameter(component, "component");
        String string = component.getString(PARAMETER_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PARAMETER_NAME_KEY)");
        this.name = string;
        String optString = component.optString(PARAMETER_VALUE_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = optString;
        String optString2 = component.optString("path_type", "absolute");
        Intrinsics.checkNotNullExpressionValue(optString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.pathType = optString2;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = component.optJSONArray(PARAMETER_PATH_KEY);
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonPathArray.getJSONObject(i)");
                arrayList.add(new PathComponent(jSONObject));
                if (i6 >= length) {
                    break;
                } else {
                    i5 = i6;
                }
            }
        }
        this.path = arrayList;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PathComponent> getPath() {
        return this.path;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final String getValue() {
        return this.value;
    }
}
