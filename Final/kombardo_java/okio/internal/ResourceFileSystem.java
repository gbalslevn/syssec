package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020%2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010'R-\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0,0\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "classLoader", BuildConfig.FLAVOR, "indexEagerly", "<init>", "(Ljava/lang/ClassLoader;Z)V", "Lokio/Path;", "path", "canonicalizeInternal", "(Lokio/Path;)Lokio/Path;", BuildConfig.FLAVOR, "toRelativePath", "(Lokio/Path;)Ljava/lang/String;", "dir", BuildConfig.FLAVOR, "list", "(Lokio/Path;)Ljava/util/List;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", BuildConfig.FLAVOR, "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "Lkotlin/Pair;", "roots$delegate", "Lkotlin/Lazy;", "getRoots", "()Ljava/util/List;", "roots", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);

    /* renamed from: roots$delegate, reason: from kotlin metadata */
    private final Lazy roots;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", BuildConfig.FLAVOR, "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", BuildConfig.FLAVOR, "path", "removeBase", "base", "toClasspathRoots", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt.endsWith(path.name(), ".class", true);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path base) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            return getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix(path.toString(), base.toString()), '\\', '/', false, 4, (Object) null));
        }

        public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources(BuildConfig.FLAVOR);
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
            ArrayList<URL> list = Collections.list(resources);
            Intrinsics.checkNotNullExpressionValue(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            for (URL it : list) {
                Companion companion = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Pair<FileSystem, Path> fileRoot = companion.toFileRoot(it);
                if (fileRoot != null) {
                    arrayList.add(fileRoot);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<URL> list2 = Collections.list(resources2);
            Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (URL it2 : list2) {
                Companion companion2 = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Pair<FileSystem, Path> jarRoot = companion2.toJarRoot(it2);
                if (jarRoot != null) {
                    arrayList2.add(jarRoot);
                }
            }
            return CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        }

        public final Pair<FileSystem, Path> toFileRoot(URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            if (Intrinsics.areEqual(url.getProtocol(), "file")) {
                return TuplesKt.to(FileSystem.SYSTEM, Path.Companion.get$default(Path.INSTANCE, new File(url.toURI()), false, 1, (Object) null));
            }
            return null;
        }

        public final Pair<FileSystem, Path> toJarRoot(URL url) {
            int lastIndexOf$default;
            Intrinsics.checkNotNullParameter(url, "<this>");
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString()");
            if (!StringsKt.startsWith$default(url2, "jar:file:", false, 2, (Object) null) || (lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.INSTANCE;
            String substring = url2.substring(4, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return TuplesKt.to(ZipFilesKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ResourceFileSystem$Companion$toJarRoot$zip$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ZipEntry entry) {
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(entry.getCanonicalPath()));
                }
            }), getROOT());
        }

        private Companion() {
        }
    }

    public ResourceFileSystem(final ClassLoader classLoader, boolean z5) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.roots = LazyKt.lazy(new Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Pair<? extends FileSystem, ? extends Path>> invoke() {
                return ResourceFileSystem.Companion.toClasspathRoots(classLoader);
            }
        });
        if (z5) {
            getRoots().size();
        }
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots.getValue();
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z5 = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem component1 = pair.component1();
            Path component2 = pair.component2();
            try {
                List<Path> list = component1.list(component2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((Path) it.next(), component2));
                }
                CollectionsKt.addAll(linkedHashSet, arrayList2);
                z5 = true;
            } catch (IOException unused) {
            }
        }
        if (z5) {
            return CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileMetadata metadataOrNull = pair.component1().metadataOrNull(pair.component2().resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            try {
                return pair.component1().openReadOnly(pair.component2().resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            try {
                return pair.component1().source(pair.component2().resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }
}
