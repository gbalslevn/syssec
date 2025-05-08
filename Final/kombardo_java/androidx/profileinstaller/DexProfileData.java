package androidx.profileinstaller;

import java.util.TreeMap;

/* loaded from: classes.dex */
class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DexProfileData(String str, String str2, long j5, long j6, int i5, int i6, int i7, int[] iArr, TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j5;
        this.mTypeIdCount = j6;
        this.classSetSize = i5;
        this.hotMethodRegionSize = i6;
        this.numMethodIds = i7;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
