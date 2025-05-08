package androidx.navigation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a;\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroidx/navigation/NavArgument;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "isArgumentMissing", BuildConfig.FLAVOR, "missingRequiredArguments", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavArgumentKt {
    public static final List<String> missingRequiredArguments(Map<String, NavArgument> map, Function1<? super String, Boolean> isArgumentMissing) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(isArgumentMissing, "isArgumentMissing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, NavArgument> entry : map.entrySet()) {
            NavArgument value = entry.getValue();
            Boolean valueOf = value != null ? Boolean.valueOf(value.getIsNullable()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (!valueOf.booleanValue() && !value.getIsDefaultValuePresent()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (isArgumentMissing.invoke((String) obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
