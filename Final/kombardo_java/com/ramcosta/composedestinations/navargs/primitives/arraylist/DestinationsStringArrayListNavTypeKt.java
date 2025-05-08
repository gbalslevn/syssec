package com.ramcosta.composedestinations.navargs.primitives.arraylist;

import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import java.util.ArrayList;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"+\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"stringArrayListNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "getStringArrayListNavType", "()Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationsStringArrayListNavTypeKt {
    private static final DestinationsNavType<ArrayList<String>> stringArrayListNavType = DestinationsStringArrayListNavType.INSTANCE;

    public static final DestinationsNavType<ArrayList<String>> getStringArrayListNavType() {
        return stringArrayListNavType;
    }
}
