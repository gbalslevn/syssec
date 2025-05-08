package io.michaelrocks.libphonenumber.android;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class ShortNumberInfo {
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT;
    private static final Logger logger = Logger.getLogger(ShortNumberInfo.class.getName());

    static {
        HashSet hashSet = new HashSet();
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = hashSet;
        hashSet.add("BR");
        hashSet.add("CL");
        hashSet.add("NI");
    }
}
