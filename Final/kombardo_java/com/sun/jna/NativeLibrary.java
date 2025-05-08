package com.sun.jna;

import com.sun.jna.internal.Cleaner;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class NativeLibrary implements Closeable {
    private static final Level DEBUG_LOAD_LEVEL;
    private static final int DEFAULT_OPEN_OPTIONS = -1;
    private static final Logger LOG = Logger.getLogger(NativeLibrary.class.getName());
    private static final SymbolProvider NATIVE_SYMBOL_PROVIDER;
    private static Method addSuppressedMethod;
    private static final Map<String, Reference<NativeLibrary>> libraries;
    private static final LinkedHashSet<String> librarySearchPath;
    private static final Map<String, List<String>> searchPaths;
    private final int callFlags;
    private final Cleaner.Cleanable cleanable;
    private final String encoding;
    private final Map<String, Function> functions;
    private volatile long handle;
    private final String libraryName;
    private final String libraryPath;
    private final Map<String, ?> options;
    private final SymbolProvider symbolProvider;

    /* loaded from: classes2.dex */
    private static final class NativeLibraryDisposer implements Runnable {
        private long handle;

        public NativeLibraryDisposer(long j5) {
            this.handle = j5;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                long j5 = this.handle;
                if (j5 != 0) {
                    try {
                        Native.close(j5);
                        this.handle = 0L;
                    } catch (Throwable th) {
                        this.handle = 0L;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    static {
        String sb;
        DEBUG_LOAD_LEVEL = Native.DEBUG_LOAD ? Level.INFO : Level.FINE;
        NATIVE_SYMBOL_PROVIDER = new SymbolProvider() { // from class: com.sun.jna.NativeLibrary.1
            @Override // com.sun.jna.SymbolProvider
            public long getSymbolAddress(long j5, String str, SymbolProvider symbolProvider) {
                return Native.findSymbol(j5, str);
            }
        };
        libraries = new HashMap();
        searchPaths = new ConcurrentHashMap();
        librarySearchPath = new LinkedHashSet<>();
        if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
        }
        addSuppressedMethod = null;
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        } catch (NoSuchMethodException unused) {
        } catch (SecurityException e5) {
            Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", (Throwable) e5);
        }
        String webStartLibraryPath = Native.getWebStartLibraryPath("jnidispatch");
        if (webStartLibraryPath != null) {
            librarySearchPath.add(webStartLibraryPath);
        }
        if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            if (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD() || Platform.iskFreeBSD()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Platform.isSolaris() ? "/" : BuildConfig.FLAVOR);
                sb2.append(Native.POINTER_SIZE * 8);
                sb = sb2.toString();
            } else {
                sb = BuildConfig.FLAVOR;
            }
            String[] strArr = {"/usr/lib" + sb, "/lib" + sb, "/usr/lib", "/lib"};
            if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
                String multiArchPath = getMultiArchPath();
                strArr = new String[]{"/usr/lib/" + multiArchPath, "/lib/" + multiArchPath, "/usr/lib" + sb, "/lib" + sb, "/usr/lib", "/lib"};
            }
            if (Platform.isLinux()) {
                ArrayList<String> linuxLdPaths = getLinuxLdPaths();
                for (int length = strArr.length - 1; length >= 0; length--) {
                    int indexOf = linuxLdPaths.indexOf(strArr[length]);
                    if (indexOf != -1) {
                        linuxLdPaths.remove(indexOf);
                    }
                    linuxLdPaths.add(0, strArr[length]);
                }
                strArr = (String[]) linuxLdPaths.toArray(new String[0]);
            }
            String str = BuildConfig.FLAVOR;
            String str2 = str;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                File file = new File(strArr[i5]);
                if (file.exists() && file.isDirectory()) {
                    str = str + str2 + strArr[i5];
                    str2 = File.pathSeparator;
                }
            }
            if (!BuildConfig.FLAVOR.equals(str)) {
                System.setProperty("jna.platform.library.path", str);
            }
        }
        librarySearchPath.addAll(initPaths("jna.platform.library.path"));
    }

    private NativeLibrary(String str, String str2, long j5, Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        this.functions = hashMap;
        String libraryName = getLibraryName(str);
        this.libraryName = libraryName;
        this.libraryPath = str2;
        this.handle = j5;
        this.cleanable = Cleaner.getCleaner().register(this, new NativeLibraryDisposer(j5));
        Object obj = map.get(Library.OPTION_CALLING_CONVENTION);
        int intValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
        this.callFlags = intValue;
        this.options = map;
        SymbolProvider symbolProvider = (SymbolProvider) map.get(Library.OPTION_SYMBOL_PROVIDER);
        if (symbolProvider == null) {
            this.symbolProvider = NATIVE_SYMBOL_PROVIDER;
        } else {
            this.symbolProvider = symbolProvider;
        }
        String str3 = (String) map.get(Library.OPTION_STRING_ENCODING);
        str3 = str3 == null ? Native.getDefaultStringEncoding() : str3;
        this.encoding = str3;
        if (Platform.isWindows() && "kernel32".equals(libraryName.toLowerCase())) {
            synchronized (hashMap) {
                hashMap.put(functionKey("GetLastError", intValue, str3), new Function(this, "GetLastError", 63, str3) { // from class: com.sun.jna.NativeLibrary.2
                    @Override // com.sun.jna.Function
                    Object invoke(Object[] objArr, Class<?> cls, boolean z5, int i5) {
                        return Integer.valueOf(Native.getLastError());
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.sun.jna.Function
                    public Object invoke(Method method, Class<?>[] clsArr, Class<?> cls, Object[] objArr, Map<String, ?> map2) {
                        return Integer.valueOf(Native.getLastError());
                    }
                });
            }
        }
    }

    public static final void addSearchPath(String str, String str2) {
        Map<String, List<String>> map = searchPaths;
        List<String> list = map.get(str);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
            map.put(str, list);
        }
        list.add(str2);
    }

    private static void addSuppressedReflected(Throwable th, Throwable th2) {
        Method method = addSuppressedMethod;
        if (method == null) {
            return;
        }
        try {
            method.invoke(th, th2);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e5) {
            throw new RuntimeException("Failed to call addSuppressedMethod", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disposeAll() {
        LinkedHashSet linkedHashSet;
        Map<String, Reference<NativeLibrary>> map = libraries;
        synchronized (map) {
            linkedHashSet = new LinkedHashSet(map.values());
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            NativeLibrary nativeLibrary = (NativeLibrary) ((Reference) it.next()).get();
            if (nativeLibrary != null) {
                nativeLibrary.close();
            }
        }
    }

    private static String findLibraryPath(String str, Collection<String> collection) {
        if (new File(str).isAbsolute()) {
            return str;
        }
        String mapSharedLibraryName = mapSharedLibraryName(str);
        for (String str2 : collection) {
            File file = new File(str2, mapSharedLibraryName);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            if (Platform.isMac() && mapSharedLibraryName.endsWith(".dylib")) {
                File file2 = new File(str2, mapSharedLibraryName.substring(0, mapSharedLibraryName.lastIndexOf(".dylib")) + ".jnilib");
                if (file2.exists()) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return mapSharedLibraryName;
    }

    private static String functionKey(String str, int i5, String str2) {
        return str + "|" + i5 + "|" + str2;
    }

    public static final NativeLibrary getInstance(String str) {
        return getInstance(str, (Map<String, ?>) Collections.emptyMap());
    }

    private String getLibraryName(String str) {
        String mapSharedLibraryName = mapSharedLibraryName("---");
        int indexOf = mapSharedLibraryName.indexOf("---");
        if (indexOf > 0 && str.startsWith(mapSharedLibraryName.substring(0, indexOf))) {
            str = str.substring(indexOf);
        }
        int indexOf2 = str.indexOf(mapSharedLibraryName.substring(indexOf + 3));
        return indexOf2 != -1 ? str.substring(0, indexOf2) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
    
        if (r2 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<String> getLinuxLdPaths() {
        Process process;
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            process = Runtime.getRuntime().exec("/sbin/ldconfig -p");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            int indexOf = readLine.indexOf(" => ");
                            int lastIndexOf = readLine.lastIndexOf(47);
                            if (indexOf != -1 && lastIndexOf != -1 && indexOf < lastIndexOf) {
                                String substring = readLine.substring(indexOf + 4, lastIndexOf);
                                if (!arrayList.contains(substring)) {
                                    arrayList.add(substring);
                                }
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (process == null) {
                            throw th;
                        }
                        try {
                            process.waitFor();
                            throw th;
                        } catch (InterruptedException unused5) {
                            throw th;
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Exception unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused7) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        try {
            process.waitFor();
        } catch (InterruptedException unused8) {
            return arrayList;
        }
    }

    private static String getMultiArchPath() {
        String str = Platform.ARCH;
        String str2 = Platform.iskFreeBSD() ? "-kfreebsd" : Platform.isGNU() ? BuildConfig.FLAVOR : "-linux";
        String str3 = "-gnu";
        if (Platform.isIntel()) {
            str = Platform.is64Bit() ? "x86_64" : "i386";
        } else if (Platform.isPPC()) {
            str = Platform.is64Bit() ? "powerpc64" : "powerpc";
        } else if (Platform.isARM()) {
            str = "arm";
            str3 = "-gnueabi";
        } else if (str.equals("mips64el")) {
            str3 = "-gnuabi64";
        }
        return str + str2 + str3;
    }

    public static final synchronized NativeLibrary getProcess() {
        NativeLibrary nativeLibrary;
        synchronized (NativeLibrary.class) {
            nativeLibrary = getInstance(null);
        }
        return nativeLibrary;
    }

    private static List<String> initPaths(String str) {
        String property = System.getProperty(str, BuildConfig.FLAVOR);
        if (BuildConfig.FLAVOR.equals(property)) {
            return Collections.emptyList();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property, File.pathSeparator);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!BuildConfig.FLAVOR.equals(nextToken)) {
                arrayList.add(nextToken);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVersionedName(String str) {
        int lastIndexOf;
        int i5;
        if (!str.startsWith("lib") || (lastIndexOf = str.lastIndexOf(".so.")) == -1 || (i5 = lastIndexOf + 4) >= str.length()) {
            return false;
        }
        for (i5 = lastIndexOf + 4; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (!Character.isDigit(charAt) && charAt != '.') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static NativeLibrary loadLibrary(String str, Map<String, ?> map) {
        long j5;
        Logger logger = LOG;
        Level level = DEBUG_LOAD_LEVEL;
        logger.log(level, "Looking for library '" + str + "'");
        ArrayList<Throwable> arrayList = new ArrayList();
        boolean isAbsolute = new File(str).isAbsolute();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int openFlags = openFlags(map);
        List<String> list = searchPaths.get(str);
        if (list != null) {
            synchronized (list) {
                linkedHashSet.addAll(list);
            }
        }
        String webStartLibraryPath = Native.getWebStartLibraryPath(str);
        if (webStartLibraryPath != null) {
            logger.log(level, "Adding web start path " + webStartLibraryPath);
            linkedHashSet.add(webStartLibraryPath);
        }
        logger.log(level, "Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
        linkedHashSet.addAll(initPaths("jna.library.path"));
        String findLibraryPath = findLibraryPath(str, linkedHashSet);
        try {
            logger.log(level, "Trying " + findLibraryPath);
            j5 = Native.open(findLibraryPath, openFlags);
        } catch (UnsatisfiedLinkError e5) {
            Logger logger2 = LOG;
            Level level2 = DEBUG_LOAD_LEVEL;
            logger2.log(level2, "Loading failed with message: " + e5.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("Adding system paths: ");
            LinkedHashSet<String> linkedHashSet2 = librarySearchPath;
            sb.append(linkedHashSet2);
            logger2.log(level2, sb.toString());
            arrayList.add(e5);
            linkedHashSet.addAll(linkedHashSet2);
            j5 = 0;
        }
        if (j5 == 0) {
            try {
                findLibraryPath = findLibraryPath(str, linkedHashSet);
                LOG.log(DEBUG_LOAD_LEVEL, "Trying " + findLibraryPath);
                j5 = Native.open(findLibraryPath, openFlags);
                if (j5 == 0) {
                    throw new UnsatisfiedLinkError("Failed to load library '" + str + "'");
                }
            } catch (UnsatisfiedLinkError e6) {
                Logger logger3 = LOG;
                Level level3 = DEBUG_LOAD_LEVEL;
                logger3.log(level3, "Loading failed with message: " + e6.getMessage());
                arrayList.add(e6);
                if (Platform.isAndroid()) {
                    try {
                        logger3.log(level3, "Preload (via System.loadLibrary) " + str);
                        System.loadLibrary(str);
                        j5 = Native.open(findLibraryPath, openFlags);
                    } catch (UnsatisfiedLinkError e7) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e7.getMessage());
                        arrayList.add(e7);
                    }
                } else if (Platform.isLinux() || Platform.isFreeBSD()) {
                    logger3.log(level3, "Looking for version variants");
                    findLibraryPath = matchLibrary(str, linkedHashSet);
                    if (findLibraryPath != null) {
                        logger3.log(level3, "Trying " + findLibraryPath);
                        try {
                            j5 = Native.open(findLibraryPath, openFlags);
                        } catch (UnsatisfiedLinkError e8) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e8.getMessage());
                            arrayList.add(e8);
                        }
                    }
                } else if (Platform.isMac() && !str.endsWith(".dylib")) {
                    for (String str2 : matchFramework(str)) {
                        try {
                            LOG.log(DEBUG_LOAD_LEVEL, "Trying " + str2);
                            j5 = Native.open(str2, openFlags);
                            break;
                        } catch (UnsatisfiedLinkError e9) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e9.getMessage());
                            arrayList.add(e9);
                        }
                    }
                } else if (Platform.isWindows() && !isAbsolute) {
                    logger3.log(level3, "Looking for lib- prefix");
                    findLibraryPath = findLibraryPath("lib" + str, linkedHashSet);
                    if (findLibraryPath != null) {
                        logger3.log(level3, "Trying " + findLibraryPath);
                        try {
                            j5 = Native.open(findLibraryPath, openFlags);
                        } catch (UnsatisfiedLinkError e10) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e10.getMessage());
                            arrayList.add(e10);
                        }
                    }
                }
                if (j5 == 0) {
                    try {
                        File extractFromResourcePath = Native.extractFromResourcePath(str, (ClassLoader) map.get(Library.OPTION_CLASSLOADER));
                        if (extractFromResourcePath != null) {
                            try {
                                j5 = Native.open(extractFromResourcePath.getAbsolutePath(), openFlags);
                                findLibraryPath = extractFromResourcePath.getAbsolutePath();
                                if (Native.isUnpacked(extractFromResourcePath)) {
                                    Native.deleteLibrary(extractFromResourcePath);
                                }
                            } catch (Throwable th) {
                                if (Native.isUnpacked(extractFromResourcePath)) {
                                    Native.deleteLibrary(extractFromResourcePath);
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e11) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e11.getMessage());
                        arrayList.add(e11);
                    }
                }
                if (j5 == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to load library '");
                    sb2.append(str);
                    sb2.append("':");
                    for (Throwable th2 : arrayList) {
                        sb2.append("\n");
                        sb2.append(th2.getMessage());
                    }
                    UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(sb2.toString());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        addSuppressedReflected(unsatisfiedLinkError, (Throwable) it.next());
                    }
                    throw unsatisfiedLinkError;
                }
            }
        }
        String str3 = findLibraryPath;
        LOG.log(DEBUG_LOAD_LEVEL, "Found library '" + str + "' at " + str3);
        return new NativeLibrary(str, str3, j5, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mapSharedLibraryName(String str) {
        if (Platform.isMac()) {
            if (str.startsWith("lib") && (str.endsWith(".dylib") || str.endsWith(".jnilib"))) {
                return str;
            }
            String mapLibraryName = System.mapLibraryName(str);
            if (!mapLibraryName.endsWith(".jnilib")) {
                return mapLibraryName;
            }
            return mapLibraryName.substring(0, mapLibraryName.lastIndexOf(".jnilib")) + ".dylib";
        }
        if (Platform.isLinux() || Platform.isFreeBSD()) {
            if (isVersionedName(str) || str.endsWith(".so")) {
                return str;
            }
        } else if (Platform.isAIX()) {
            if (isVersionedName(str) || str.endsWith(".so") || str.startsWith("lib") || str.endsWith(".a")) {
                return str;
            }
        } else if (Platform.isWindows() && (str.endsWith(".drv") || str.endsWith(".dll") || str.endsWith(".ocx"))) {
            return str;
        }
        String mapLibraryName2 = System.mapLibraryName(str);
        return (Platform.isAIX() && mapLibraryName2.endsWith(".so")) ? mapLibraryName2.replaceAll(".so$", ".a") : mapLibraryName2;
    }

    static String[] matchFramework(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        File file = new File(str);
        if (!file.isAbsolute()) {
            String[] strArr = {System.getProperty("user.home"), BuildConfig.FLAVOR, "/System"};
            if (!str.contains(".framework")) {
                str = str + ".framework/" + str;
            }
            for (int i5 = 0; i5 < 3; i5++) {
                File file2 = new File(strArr[i5] + "/Library/Frameworks/" + str);
                if (file2.exists()) {
                    return new String[]{file2.getAbsolutePath()};
                }
                linkedHashSet.add(file2.getAbsolutePath());
            }
        } else if (!str.contains(".framework")) {
            File file3 = new File(new File(file.getParentFile(), file.getName() + ".framework"), file.getName());
            if (file3.exists()) {
                return new String[]{file3.getAbsolutePath()};
            }
            linkedHashSet.add(file3.getAbsolutePath());
        } else {
            if (file.exists()) {
                return new String[]{file.getAbsolutePath()};
            }
            linkedHashSet.add(file.getAbsolutePath());
        }
        return (String[]) linkedHashSet.toArray(new String[0]);
    }

    static String matchLibrary(final String str, Collection<String> collection) {
        File file = new File(str);
        if (file.isAbsolute()) {
            collection = Arrays.asList(file.getParent());
        }
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.sun.jna.NativeLibrary.3
            /* JADX WARN: Code restructure failed: missing block: B:6:0x003b, code lost:
            
                if (r1.startsWith("lib") != false) goto L8;
             */
            @Override // java.io.FilenameFilter
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean accept(File file2, String str2) {
                if (!str2.startsWith("lib" + str + ".so")) {
                    if (str2.startsWith(str + ".so")) {
                    }
                }
                return NativeLibrary.isVersionedName(str2);
            }
        };
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            File[] listFiles = new File(it.next()).listFiles(filenameFilter);
            if (listFiles != null && listFiles.length > 0) {
                linkedList.addAll(Arrays.asList(listFiles));
            }
        }
        Iterator it2 = linkedList.iterator();
        double d5 = -1.0d;
        String str2 = null;
        while (it2.hasNext()) {
            String absolutePath = ((File) it2.next()).getAbsolutePath();
            double parseVersion = parseVersion(absolutePath.substring(absolutePath.lastIndexOf(".so.") + 4));
            if (parseVersion > d5) {
                str2 = absolutePath;
                d5 = parseVersion;
            }
        }
        return str2;
    }

    private static int openFlags(Map<String, ?> map) {
        Object obj = map.get(Library.OPTION_OPEN_FLAGS);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return -1;
    }

    static double parseVersion(String str) {
        String str2;
        int indexOf = str.indexOf(".");
        double d5 = 1.0d;
        double d6 = 0.0d;
        while (str != null) {
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                indexOf = substring2.indexOf(".");
                str2 = substring2;
                str = substring;
            } else {
                str2 = null;
            }
            try {
                d6 += Integer.parseInt(str) / d5;
                d5 *= 100.0d;
                str = str2;
            } catch (NumberFormatException unused) {
                return 0.0d;
            }
        }
        return d6;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HashSet hashSet = new HashSet();
        Map<String, Reference<NativeLibrary>> map = libraries;
        synchronized (map) {
            try {
                for (Map.Entry<String, Reference<NativeLibrary>> entry : map.entrySet()) {
                    if (entry.getValue().get() == this) {
                        hashSet.add(entry.getKey());
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    libraries.remove((String) it.next());
                }
            } finally {
            }
        }
        synchronized (this) {
            try {
                if (this.handle != 0) {
                    this.handle = 0L;
                    this.cleanable.clean();
                }
            } finally {
            }
        }
    }

    @Deprecated
    public void dispose() {
        close();
    }

    public File getFile() {
        if (this.libraryPath == null) {
            return null;
        }
        return new File(this.libraryPath);
    }

    public Function getFunction(String str) {
        return getFunction(str, this.callFlags);
    }

    public Pointer getGlobalVariableAddress(String str) {
        try {
            return new Pointer(getSymbolAddress(str));
        } catch (UnsatisfiedLinkError e5) {
            throw new UnsatisfiedLinkError("Error looking up '" + str + "': " + e5.getMessage());
        }
    }

    public String getName() {
        return this.libraryName;
    }

    public Map<String, ?> getOptions() {
        return this.options;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSymbolAddress(String str) {
        if (this.handle != 0) {
            return this.symbolProvider.getSymbolAddress(this.handle, str, NATIVE_SYMBOL_PROVIDER);
        }
        throw new UnsatisfiedLinkError("Library has been unloaded");
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public static final NativeLibrary getInstance(String str, ClassLoader classLoader) {
        return getInstance(str, (Map<String, ?>) Collections.singletonMap(Library.OPTION_CLASSLOADER, classLoader));
    }

    public static final synchronized NativeLibrary getProcess(Map<String, ?> map) {
        NativeLibrary nativeLibrary;
        synchronized (NativeLibrary.class) {
            nativeLibrary = getInstance((String) null, map);
        }
        return nativeLibrary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Function getFunction(String str, Method method) {
        FunctionMapper functionMapper = (FunctionMapper) this.options.get(Library.OPTION_FUNCTION_MAPPER);
        if (functionMapper != null) {
            str = functionMapper.getFunctionName(this, method);
        }
        String property = System.getProperty("jna.profiler.prefix", "$$YJP$$");
        if (str.startsWith(property)) {
            str = str.substring(property.length());
        }
        int i5 = this.callFlags;
        for (Class<?> cls : method.getExceptionTypes()) {
            if (LastErrorException.class.isAssignableFrom(cls)) {
                i5 |= 64;
            }
        }
        return getFunction(str, i5);
    }

    public static final NativeLibrary getInstance(String str, Map<String, ?> map) {
        NativeLibrary nativeLibrary;
        NativeLibrary loadLibrary;
        HashMap hashMap = new HashMap(map);
        if (hashMap.get(Library.OPTION_CALLING_CONVENTION) == null) {
            hashMap.put(Library.OPTION_CALLING_CONVENTION, 0);
        }
        if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(str)) {
            str = null;
        }
        Map<String, Reference<NativeLibrary>> map2 = libraries;
        synchronized (map2) {
            try {
                Reference<NativeLibrary> reference = map2.get(str + hashMap);
                nativeLibrary = reference != null ? reference.get() : null;
                if (nativeLibrary == null) {
                    if (str == null) {
                        loadLibrary = new NativeLibrary("<process>", null, Native.open(null, openFlags(hashMap)), hashMap);
                    } else {
                        loadLibrary = loadLibrary(str, hashMap);
                    }
                    nativeLibrary = loadLibrary;
                    WeakReference weakReference = new WeakReference(nativeLibrary);
                    map2.put(nativeLibrary.getName() + hashMap, weakReference);
                    File file = nativeLibrary.getFile();
                    if (file != null) {
                        map2.put(file.getAbsolutePath() + hashMap, weakReference);
                        map2.put(file.getName() + hashMap, weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeLibrary;
    }

    public Function getFunction(String str, int i5) {
        return getFunction(str, i5, this.encoding);
    }

    public Function getFunction(String str, int i5, String str2) {
        Function function;
        if (str != null) {
            synchronized (this.functions) {
                try {
                    String functionKey = functionKey(str, i5, str2);
                    function = this.functions.get(functionKey);
                    if (function == null) {
                        function = new Function(this, str, i5, str2);
                        this.functions.put(functionKey, function);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return function;
        }
        throw new NullPointerException("Function name may not be null");
    }
}
