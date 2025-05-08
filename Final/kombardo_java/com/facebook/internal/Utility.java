package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sun.jna.Callback;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0088\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ%\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0016\u0010\u0011J!\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ!\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\u00020\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b&\u0010'J+\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020 2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b+\u0010,J+\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020 2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0004\b2\u00103J\u0019\u00106\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0004\b6\u00107J\u0019\u0010:\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\b:\u0010;J#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010>2\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\b?\u0010@J#\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0>2\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\bA\u0010@J-\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010Dj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`E2\b\u0010C\u001a\u0004\u0018\u00010BH\u0007¢\u0006\u0004\bF\u0010GJ\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0H2\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bI\u0010JJ-\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020<2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\bL\u0010MJ\u0019\u0010P\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010NH\u0007¢\u0006\u0004\bP\u0010QJ!\u0010U\u001a\u00020T2\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bU\u0010VJ\u001f\u0010X\u001a\u00020*2\u0006\u00109\u001a\u0002082\u0006\u0010W\u001a\u00020\tH\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020*2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bZ\u0010[J)\u0010`\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010\t2\u000e\u0010_\u001a\n\u0018\u00010]j\u0004\u0018\u0001`^H\u0007¢\u0006\u0004\b`\u0010aJ#\u0010`\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010\t2\b\u0010b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b`\u0010cJ-\u0010`\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010\t2\b\u0010b\u001a\u0004\u0018\u00010\t2\b\u0010e\u001a\u0004\u0018\u00010dH\u0007¢\u0006\u0004\b`\u0010fJ)\u0010i\u001a\u00020\u0006\"\u0004\b\u0000\u0010g2\b\u0010h\u001a\u0004\u0018\u00018\u00002\b\u0010(\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\bi\u0010jJ\u001d\u0010k\u001a\b\u0012\u0004\u0012\u00020\t0H2\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bk\u0010JJ\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020\t0l2\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bm\u0010nJ'\u0010p\u001a\u00020\t2\u0016\u0010o\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0>H\u0007¢\u0006\u0004\bp\u0010qJ#\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0>2\u0006\u0010r\u001a\u00020\tH\u0007¢\u0006\u0004\bs\u0010tJ;\u0010z\u001a\u00020*2\u0006\u0010u\u001a\u00020<2\b\u0010w\u001a\u0004\u0018\u00010v2\b\u0010x\u001a\u0004\u0018\u00010\t2\u0006\u0010y\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bz\u0010{J\u0011\u0010|\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b|\u0010}J \u0010\u007f\u001a\u00020*2\u0006\u0010u\u001a\u00020<2\u0006\u0010~\u001a\u000208H\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001JP\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\f\u0010\u0082\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u00012\u0007\u0010\u0083\u0001\u001a\u00020\t2\"\u0010\u0085\u0001\u001a\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u0081\u00010\u0084\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0081\u0001H\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001JK\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0089\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020\t2\"\u0010\u0085\u0001\u001a\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u0081\u00010\u0084\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0081\u0001H\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u008a\u0001JC\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010\u008c\u0001\u001a\u00030\u0086\u00012\u0018\u0010\u008d\u0001\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0084\u0001\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0090\u0001\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0005\b\u0090\u0001\u0010;J\u001d\u0010\u0092\u0001\u001a\u00020\u00062\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001d\u0010\u0094\u0001\u001a\u00020\u00062\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001J\u001d\u0010\u0095\u0001\u001a\u00020\u00062\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001J\u001c\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0096\u0001\u001a\u00020\"H\u0007¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J3\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u00012\b\u0010-\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u009b\u0001\u001a\u00030\u009a\u0001H\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J6\u0010 \u0001\u001a\u00020*2\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0018\u0010o\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010>H\u0007¢\u0006\u0006\b \u0001\u0010¡\u0001J.\u0010¢\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010>2\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001H\u0007¢\u0006\u0006\b¢\u0001\u0010£\u0001J2\u0010¤\u0001\u001a\u00020*2\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010>H\u0007¢\u0006\u0006\b¤\u0001\u0010¡\u0001J*\u0010¥\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010>2\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001H\u0007¢\u0006\u0006\b¥\u0001\u0010£\u0001J\u001e\u0010¨\u0001\u001a\u00020\u00062\n\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0007¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001c\u0010«\u0001\u001a\u00020\t2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0005\b«\u0001\u0010\u0011J%\u0010¯\u0001\u001a\u00020*2\u0007\u0010¬\u0001\u001a\u00020\t2\b\u0010®\u0001\u001a\u00030\u00ad\u0001H\u0007¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001d\u0010±\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010¬\u0001\u001a\u00020\tH\u0007¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001c\u0010´\u0001\u001a\u00030³\u00012\u0007\u0010¬\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u001c\u0010·\u0001\u001a\u00020\t2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0005\b·\u0001\u0010\u0011J\u0013\u0010¸\u0001\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0005\b¸\u0001\u0010}J\u0012\u0010¹\u0001\u001a\u00020TH\u0002¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0019\u0010»\u0001\u001a\u00020*2\u0006\u0010~\u001a\u000208H\u0002¢\u0006\u0005\b»\u0001\u0010[J\u0011\u0010¼\u0001\u001a\u00020*H\u0002¢\u0006\u0005\b¼\u0001\u0010\u0003J\u0019\u0010½\u0001\u001a\u00020*2\u0006\u0010~\u001a\u000208H\u0002¢\u0006\u0005\b½\u0001\u0010[J\u0012\u0010¾\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u0011\u0010À\u0001\u001a\u00020*H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0003J\u0011\u0010Á\u0001\u001a\u00020*H\u0002¢\u0006\u0005\bÁ\u0001\u0010\u0003J\u001c\u0010Ã\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0013\u001a\u00030Â\u0001H\u0002¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J4\u0010Å\u0001\u001a\u00020*2\u0006\u0010u\u001a\u00020<2\u0006\u0010w\u001a\u00020v2\b\u0010x\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J*\u0010Ç\u0001\u001a\u00020*2\u0006\u0010u\u001a\u00020<2\u0006\u0010w\u001a\u00020v2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u001a\u0010É\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u001b\u0010Ì\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020TH\u0007¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001a\u0010Î\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0006\bÎ\u0001\u0010Ê\u0001J\u001a\u0010Ï\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0006\bÏ\u0001\u0010Ê\u0001J\u001a\u0010Ð\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0006\bÐ\u0001\u0010Ê\u0001J\u001e\u0010Ó\u0001\u001a\u00020*2\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0007¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0019\u0010Õ\u0001\u001a\u00020\t2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0005\bÕ\u0001\u0010;R\u0017\u0010Ö\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0017\u0010Ø\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bØ\u0001\u0010×\u0001R\u0017\u0010Ù\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÙ\u0001\u0010×\u0001R\u0017\u0010Ú\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÚ\u0001\u0010×\u0001R\u0017\u0010Û\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÛ\u0001\u0010×\u0001R\u0017\u0010Ü\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÜ\u0001\u0010×\u0001R\u0017\u0010Ý\u0001\u001a\u00020T8\u0002X\u0082T¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u0017\u0010ß\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bß\u0001\u0010×\u0001R\u0019\u0010à\u0001\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Þ\u0001R\u001a\u0010á\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u001a\u0010ã\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010â\u0001R*\u0010ä\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010â\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R\u0019\u0010é\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010×\u0001R(\u0010ê\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bê\u0001\u0010×\u0001\u001a\u0005\bë\u0001\u0010}\"\u0006\bì\u0001\u0010í\u0001R(\u0010î\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bî\u0001\u0010×\u0001\u001a\u0005\bï\u0001\u0010}\"\u0006\bð\u0001\u0010í\u0001R*\u0010ñ\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bñ\u0001\u0010×\u0001\u001a\u0005\bò\u0001\u0010}\"\u0006\bó\u0001\u0010í\u0001R,\u0010õ\u0001\u001a\u0005\u0018\u00010ô\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bõ\u0001\u0010ö\u0001\u001a\u0006\b÷\u0001\u0010ø\u0001\"\u0006\bù\u0001\u0010ú\u0001R\u0017\u0010û\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bû\u0001\u0010×\u0001R\u0017\u0010ü\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bü\u0001\u0010×\u0001R\u0017\u0010ý\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bý\u0001\u0010×\u0001R\u0017\u0010ÿ\u0001\u001a\u0005\u0018\u00010ô\u00018G¢\u0006\b\u001a\u0006\bþ\u0001\u0010ø\u0001R\u0015\u0010\u0081\u0002\u001a\u00030ô\u00018G¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010ø\u0001R\u001e\u0010\u0082\u0002\u001a\u00020\u00068FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0083\u0002\u0010\u0003\u001a\u0006\b\u0082\u0002\u0010¿\u0001R\u0016\u0010\u0086\u0002\u001a\u0004\u0018\u00010<8G¢\u0006\b\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0014\u0010\u0087\u0002\u001a\u00020\u00068G¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010¿\u0001¨\u0006\u0089\u0002"}, d2 = {"Lcom/facebook/internal/Utility;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "c", BuildConfig.FLAVOR, "isNullOrEmpty", "(Ljava/util/Collection;)Z", BuildConfig.FLAVOR, "s", "(Ljava/lang/String;)Z", "valueIfNullOrEmpty", "coerceValueIfNullOrEmpty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "md5hash", "(Ljava/lang/String;)Ljava/lang/String;", BuildConfig.FLAVOR, "bytes", "sha1hash", "([B)Ljava/lang/String;", "sha256hash", "algorithm", "hashWithAlgorithm", "(Ljava/lang/String;[B)Ljava/lang/String;", "Ljava/security/MessageDigest;", "hash", "hashBytes", "(Ljava/security/MessageDigest;[B)Ljava/lang/String;", "authority", "path", "Landroid/os/Bundle;", "parameters", "Landroid/net/Uri;", "buildUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/net/Uri;", "queryString", "parseUrlQueryString", "(Ljava/lang/String;)Landroid/os/Bundle;", "b", "value", BuildConfig.FLAVOR, "putNonEmptyString", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "bundle", "putJSONValueInBundle", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)Z", "Ljava/io/Closeable;", "closeable", "closeQuietly", "(Ljava/io/Closeable;)V", "Ljava/net/URLConnection;", "connection", "disconnectQuietly", "(Ljava/net/URLConnection;)V", "Landroid/content/Context;", "context", "getMetadataApplicationId", "(Landroid/content/Context;)Ljava/lang/String;", "Lorg/json/JSONObject;", "jsonObject", BuildConfig.FLAVOR, "convertJSONObjectToHashMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "convertJSONObjectToStringMap", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "convertJSONArrayToHashSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", BuildConfig.FLAVOR, "convertJSONArrayToList", "(Lorg/json/JSONArray;)Ljava/util/List;", "nonJSONPropertyKey", "getStringPropertyAsJSON", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Ljava/io/InputStream;", "inputStream", "readStreamToString", "(Ljava/io/InputStream;)Ljava/lang/String;", "Ljava/io/OutputStream;", "outputStream", BuildConfig.FLAVOR, "copyAndCloseInputStream", "(Ljava/io/InputStream;Ljava/io/OutputStream;)I", "domain", "clearCookiesForDomain", "(Landroid/content/Context;Ljava/lang/String;)V", "clearFacebookCookies", "(Landroid/content/Context;)V", "tag", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "logd", "(Ljava/lang/String;Ljava/lang/Exception;)V", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "T", "a", "areObjectsEqual", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "jsonArrayToStringList", BuildConfig.FLAVOR, "jsonArrayToSet", "(Lorg/json/JSONArray;)Ljava/util/Set;", "map", "mapToJsonStr", "(Ljava/util/Map;)Ljava/lang/String;", "str", "jsonStrToMap", "(Ljava/lang/String;)Ljava/util/Map;", "params", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventAttributionParameters", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;ZLandroid/content/Context;)V", "getAppVersion", "()Ljava/lang/String;", "appContext", "setAppEventExtendedDeviceInfoParameters", "(Lorg/json/JSONObject;Landroid/content/Context;)V", "Ljava/lang/Class;", "clazz", "methodName", BuildConfig.FLAVOR, "parameterTypes", "Ljava/lang/reflect/Method;", "getMethodQuietly", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "receiver", "method", "args", "invokeMethodQuietly", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "getActivityName", "uri", "isWebUri", "(Landroid/net/Uri;)Z", "isContentUri", "isFileUri", "contentUri", BuildConfig.FLAVOR, "getContentSize", "(Landroid/net/Uri;)J", "Ljava/util/Date;", "dateBase", "getBundleLongAsDate", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Date;", "Landroid/os/Parcel;", "parcel", "writeStringMapToParcel", "(Landroid/os/Parcel;Ljava/util/Map;)V", "readStringMapFromParcel", "(Landroid/os/Parcel;)Ljava/util/Map;", "writeNonnullStringMapToParcel", "readNonnullStringMapFromParcel", "Lcom/facebook/AccessToken;", "token", "isCurrentAccessToken", "(Lcom/facebook/AccessToken;)Z", "tokenGraphDomain", "getGraphDomainFromTokenDomain", "accessToken", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", Callback.METHOD_NAME, "getGraphMeRequestWithCacheAsync", "(Ljava/lang/String;Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;)V", "awaitGetGraphMeRequestWithCache", "(Ljava/lang/String;)Lorg/json/JSONObject;", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCache", "(Ljava/lang/String;)Lcom/facebook/GraphRequest;", "graphDomain", "getProfileFieldsForGraphDomain", "getCurrentTokenDomainWithDefault", "refreshBestGuessNumberOfCPUCores", "()I", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshCarrierName", "externalStorageExists", "()Z", "refreshAvailableExternalStorage", "refreshTotalExternalStorage", BuildConfig.FLAVOR, "convertBytesToGB", "(D)J", "appendAnonIdUnderCompliance", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;Landroid/content/Context;)V", "appendAttributionIdUnderCompliance", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Landroid/content/Context;)V", "isGooglePlayServicesAvailable", "(Landroid/content/Context;)Z", "length", "generateRandomString", "(I)Ljava/lang/String;", "mustFixWindowParamsForAutofill", "isAutofillAvailable", "isChromeOS", "Ljava/lang/Runnable;", "runnable", "runOnNonUiThread", "(Ljava/lang/Runnable;)V", "getAppName", "HASH_ALGORITHM_MD5", "Ljava/lang/String;", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "URL_SCHEME", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "UTF8", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "I", "NO_CARRIER", "numCPUCores", "timestampOfLastCheck", "J", "totalExternalStorageGB", "availableExternalStorageGB", "getAvailableExternalStorageGB", "()J", "setAvailableExternalStorageGB", "(J)V", "deviceTimezoneAbbreviation", "deviceTimeZoneName", "getDeviceTimeZoneName", "setDeviceTimeZoneName", "(Ljava/lang/String;)V", "carrierName", "getCarrierName", "setCarrierName", "versionName", "getVersionName", "setVersionName", "Ljava/util/Locale;", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "ARC_DEVICE_PATTERN", "FACEBOOK_PROFILE_FIELDS", "INSTAGRAM_PROFILE_FIELDS", "getResourceLocale", "resourceLocale", "getCurrentLocale", "currentLocale", "isAutoAppLinkSetup", "isAutoAppLinkSetup$annotations", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "dataProcessingOptions", "isDataProcessingRestricted", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static Locale locale;
    private static int numCPUCores;
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;
    private static String deviceTimezoneAbbreviation = BuildConfig.FLAVOR;
    private static String deviceTimeZoneName = BuildConfig.FLAVOR;
    private static final String NO_CARRIER = "NoCarrier";
    private static String carrierName = NO_CARRIER;
    private static String versionName = BuildConfig.FLAVOR;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", BuildConfig.FLAVOR, "onFailure", BuildConfig.FLAVOR, "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException error);

        void onSuccess(JSONObject userInfo);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(JSONObject params, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            params.put("anon_id", anonymousAppDeviceGUID);
        } else {
            if (attributionIdentifiers.getIsTrackingLimited()) {
                return;
            }
            params.put("anon_id", anonymousAppDeviceGUID);
        }
    }

    private final void appendAttributionIdUnderCompliance(JSONObject params, AttributionIdentifiers attributionIdentifiers, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            params.put("attribution", attributionIdentifiers.getAttributionId());
        } else {
            if (attributionIdentifiers.getIsTrackingLimited()) {
                return;
            }
            params.put("attribution", attributionIdentifiers.getAttributionId());
        }
    }

    public static final <T> boolean areObjectsEqual(T a5, T b5) {
        return a5 == null ? b5 == null : Intrinsics.areEqual(a5, b5);
    }

    public static final JSONObject awaitGetGraphMeRequestWithCache(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(accessToken).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJsonObject();
    }

    public static final Uri buildUri(String authority, String path, Bundle parameters) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(authority);
        builder.path(path);
        if (parameters != null) {
            for (String str : parameters.keySet()) {
                Object obj = parameters.get(str);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    private final void clearCookiesForDomain(Context context, String domain) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(domain);
        if (cookie == null) {
            return;
        }
        Object[] array = StringsKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i5 = 0;
        while (i5 < length) {
            String str = strArr[i5];
            i5++;
            Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr2 = (String[]) array2;
            if (strArr2.length > 0) {
                String str2 = strArr2[0];
                int length2 = str2.length() - 1;
                int i6 = 0;
                boolean z5 = false;
                while (i6 <= length2) {
                    boolean z6 = Intrinsics.compare((int) str2.charAt(!z5 ? i6 : length2), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z6) {
                        i6++;
                    } else {
                        z5 = true;
                    }
                }
                cookieManager.setCookie(domain, Intrinsics.stringPlus(str2.subSequence(i6, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, "facebook.com");
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String coerceValueIfNullOrEmpty(String s5, String valueIfNullOrEmpty) {
        return isNullOrEmpty(s5) ? valueIfNullOrEmpty : s5;
    }

    private final long convertBytesToGB(double bytes) {
        return Math.round(bytes / 1.073741824E9d);
    }

    public static final HashSet<String> convertJSONArrayToHashSet(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        int length = jsonArray.length();
        if (length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                String string = jsonArray.getString(i5);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return hashSet;
    }

    public static final List<String> convertJSONArrayToList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            if (length <= 0) {
                return arrayList;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                String string = jsonArray.getString(i5);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i6 >= length) {
                    return arrayList;
                }
                i5 = i6;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jsonObject) {
        int length;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jsonObject.names();
        if (names != null && (length = names.length()) > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                try {
                    String string = names.getString(i5);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject) value);
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    hashMap.put(string, value);
                } catch (JSONException unused) {
                }
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return hashMap;
    }

    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String optString = jsonObject.optString(key);
            if (optString != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                hashMap.put(key, optString);
            }
        }
        return hashMap;
    }

    public static final int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            int i5 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i5 += read;
            }
            bufferedInputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return i5;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static final void disconnectQuietly(URLConnection connection) {
        if (connection == null || !(connection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) connection).disconnect();
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual("mounted", Environment.getExternalStorageState());
    }

    public static final String generateRandomString(int length) {
        String bigInteger = new BigInteger(length * 5, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    public static final String getAppName(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i5 = applicationInfo.labelRes;
            if (i5 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i5);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final Date getBundleLongAsDate(Bundle bundle, String key, Date dateBase) {
        long parseLong;
        Intrinsics.checkNotNullParameter(dateBase, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(key);
        if (!(obj instanceof Long)) {
            if (obj instanceof String) {
                try {
                    parseLong = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        parseLong = ((Number) obj).longValue();
        return parseLong == 0 ? new Date(Long.MAX_VALUE) : new Date(dateBase.getTime() + (parseLong * 1000));
    }

    public static final long getContentSize(Uri contentUri) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Cursor cursor = null;
        try {
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
            if (cursor == null) {
                return 0L;
            }
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j5 = cursor.getLong(columnIndex);
            cursor.close();
            return j5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        return locale2;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? "facebook" : currentAccessToken.getGraphDomain();
    }

    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    public static final String getGraphDomainFromTokenDomain(String tokenGraphDomain) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        return tokenGraphDomain == null ? facebookDomain : Intrinsics.areEqual(tokenGraphDomain, "gaming") ? StringsKt.replace$default(facebookDomain, "facebook.com", "fb.gg", false, 4, (Object) null) : Intrinsics.areEqual(tokenGraphDomain, "instagram") ? StringsKt.replace$default(facebookDomain, "facebook.com", "instagram.com", false, 4, (Object) null) : facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String accessToken) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", accessToken);
        GraphRequest newMeRequest = GraphRequest.INSTANCE.newMeRequest(null, null);
        newMeRequest.setParameters(bundle);
        newMeRequest.setHttpMethod(HttpMethod.GET);
        return newMeRequest;
    }

    public static final void getGraphMeRequestWithCacheAsync(final String accessToken, final GraphMeRequestWithCacheCallback callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            callback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: o0.k
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                Utility.m2864getGraphMeRequestWithCacheAsync$lambda3(Utility.GraphMeRequestWithCacheCallback.this, accessToken, graphResponse);
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(accessToken);
        graphMeRequestWithCache.setCallback(callback2);
        graphMeRequestWithCache.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3, reason: not valid java name */
    public static final void m2864getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback callback, String accessToken, GraphResponse response) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(accessToken, "$accessToken");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getError() != null) {
            callback.onFailure(response.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ProfileInformationCache.putProfileInformation(accessToken, jsonObject);
        callback.onSuccess(response.getJsonObject());
    }

    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        return FacebookSdk.getApplicationId();
    }

    public static final Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String graphDomain) {
        return Intrinsics.areEqual(graphDomain, "instagram") ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object getStringPropertyAsJSON(JSONObject jsonObject, String key, String nonJSONPropertyKey) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Object opt = jsonObject.opt(key);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (nonJSONPropertyKey == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(nonJSONPropertyKey, opt);
        return jSONObject;
    }

    private final String hashBytes(MessageDigest hash, byte[] bytes) {
        hash.update(bytes);
        byte[] digest = hash.digest();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        int length = digest.length;
        int i5 = 0;
        while (i5 < length) {
            byte b5 = digest[i5];
            i5++;
            sb.append(Integer.toHexString((b5 >> 4) & 15));
            sb.append(Integer.toHexString(b5 & 15));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    private final String hashWithAlgorithm(String algorithm, String key) {
        Charset charset = Charsets.UTF_8;
        if (key == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = key.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(algorithm, bytes);
    }

    public static final Object invokeMethodQuietly(Object receiver, Method method, Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return method.invoke(receiver, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean isAutofillAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        return autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String DEVICE = Build.DEVICE;
        if (DEVICE != null) {
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(DEVICE)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isContentUri(Uri uri) {
        return uri != null && StringsKt.equals("content", uri.getScheme(), true);
    }

    public static final boolean isCurrentAccessToken(AccessToken token) {
        return token != null && Intrinsics.areEqual(token, AccessToken.INSTANCE.getCurrentAccessToken());
    }

    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray("data_processing_options");
                int length = jSONArray.length();
                if (length > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        String string = jSONArray.getString(i5);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual(lowerCase, "ldu")) {
                            return true;
                        }
                        if (i6 >= length) {
                            break;
                        }
                        i5 = i6;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    public static final boolean isFileUri(Uri uri) {
        return uri != null && StringsKt.equals("file", uri.getScheme(), true);
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = invokeMethodQuietly(null, methodQuietly, context);
        return (invokeMethodQuietly instanceof Integer) && Intrinsics.areEqual(invokeMethodQuietly, (Object) 0);
    }

    public static final boolean isNullOrEmpty(Collection<?> c5) {
        return c5 == null || c5.isEmpty();
    }

    public static final boolean isWebUri(Uri uri) {
        return uri != null && (StringsKt.equals("http", uri.getScheme(), true) || StringsKt.equals("https", uri.getScheme(), true) || StringsKt.equals("fbstaging", uri.getScheme(), true));
    }

    public static final Set<String> jsonArrayToSet(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        if (length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                String string = jsonArray.getString(i5);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return hashSet;
    }

    public static final List<String> jsonArrayToStringList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        if (length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                arrayList.add(jsonArray.getString(i5));
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return arrayList;
    }

    public static final Map<String, String> jsonStrToMap(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String string = jSONObject.getString(key);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                hashMap.put(key, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void logd(String tag, Exception e5) {
        if (!FacebookSdk.isDebugEnabled() || tag == null || e5 == null) {
            return;
        }
        Log.d(tag, e5.getClass().getSimpleName() + ": " + ((Object) e5.getMessage()));
    }

    public static final String mapToJsonStr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        boolean isEmpty = map.isEmpty();
        String str = BuildConfig.FLAVOR;
        if (!isEmpty) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    public static final String md5hash(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, key);
    }

    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    public static final Bundle parseUrlQueryString(String queryString) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(queryString)) {
            if (queryString == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Object[] array = StringsKt.split$default((CharSequence) queryString, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                i5++;
                Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr2 = (String[]) array2;
                try {
                    if (strArr2.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                    } else if (strArr2.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), BuildConfig.FLAVOR);
                    }
                } catch (UnsupportedEncodingException e5) {
                    logd("FacebookSDK", e5);
                }
            }
        }
        return bundle;
    }

    public static final boolean putJSONValueInBundle(Bundle bundle, String key, Object value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (value == null) {
            bundle.remove(key);
            return true;
        }
        if (value instanceof Boolean) {
            bundle.putBoolean(key, ((Boolean) value).booleanValue());
            return true;
        }
        if (value instanceof boolean[]) {
            bundle.putBooleanArray(key, (boolean[]) value);
            return true;
        }
        if (value instanceof Double) {
            bundle.putDouble(key, ((Number) value).doubleValue());
            return true;
        }
        if (value instanceof double[]) {
            bundle.putDoubleArray(key, (double[]) value);
            return true;
        }
        if (value instanceof Integer) {
            bundle.putInt(key, ((Number) value).intValue());
            return true;
        }
        if (value instanceof int[]) {
            bundle.putIntArray(key, (int[]) value);
            return true;
        }
        if (value instanceof Long) {
            bundle.putLong(key, ((Number) value).longValue());
            return true;
        }
        if (value instanceof long[]) {
            bundle.putLongArray(key, (long[]) value);
            return true;
        }
        if (value instanceof String) {
            bundle.putString(key, (String) value);
            return true;
        }
        if (value instanceof JSONArray) {
            bundle.putString(key, ((JSONArray) value).toString());
            return true;
        }
        if (!(value instanceof JSONObject)) {
            return false;
        }
        bundle.putString(key, ((JSONObject) value).toString());
        return true;
    }

    public static final void putNonEmptyString(Bundle b5, String key, String value) {
        Intrinsics.checkNotNullParameter(b5, "b");
        if (isNullOrEmpty(value)) {
            return;
        }
        b5.putString(key, value);
    }

    public static final Map<String, String> readNonnullStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i5 = 0;
            do {
                i5++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (readString != null && readString2 != null) {
                    hashMap.put(readString, readString2);
                }
            } while (i5 < readInt);
        }
        return hashMap;
    }

    public static final String readStreamToString(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb2;
                        }
                        sb.append(cArr, 0, read);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i5 = 0;
            do {
                i5++;
                hashMap.put(parcel.readString(), parcel.readString());
            } while (i5 < readInt);
        }
        return hashMap;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i5 = numCPUCores;
        if (i5 > 0) {
            return i5;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: o0.l
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    boolean m2865refreshBestGuessNumberOfCPUCores$lambda4;
                    m2865refreshBestGuessNumberOfCPUCores$lambda4 = Utility.m2865refreshBestGuessNumberOfCPUCores$lambda4(file, str);
                    return m2865refreshBestGuessNumberOfCPUCores$lambda4;
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4, reason: not valid java name */
    public static final boolean m2865refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context appContext) {
        if (Intrinsics.areEqual(carrierName, NO_CARRIER)) {
            try {
                Object systemService = appContext.getSystemService("phone");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                carrierName = networkOperatorName;
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context appContext) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(appContext);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final void setAppEventAttributionParameters(JSONObject params, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage, Context context) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            params.put("anon_id", anonymousAppDeviceGUID);
        }
        params.put("application_tracking_enabled", !limitEventUsage);
        params.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(params, attributionIdentifiers, anonymousAppDeviceGUID, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(params, attributionIdentifiers, context);
                } else {
                    params.put("attribution", attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                params.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                params.put("advertiser_tracking_enabled", !attributionIdentifiers.getIsTrackingLimited());
            }
            if (!attributionIdentifiers.getIsTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    params.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
        AppLinkManager companion = AppLinkManager.INSTANCE.getInstance();
        Object info = companion == null ? null : companion.getInfo("campaign_ids");
        if (info != null) {
            params.put("campaign_ids", info);
        }
    }

    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject params, Context appContext) {
        Locale locale2;
        String language;
        int i5;
        Display display;
        String country;
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(appContext);
        String packageName = appContext.getPackageName();
        int i6 = 0;
        int i7 = -1;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return;
        }
        i7 = packageInfo.versionCode;
        versionName = packageInfo.versionName;
        jSONArray.put(packageName);
        jSONArray.put(i7);
        jSONArray.put(versionName);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale2 = appContext.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale2 = Locale.getDefault();
        }
        locale = locale2;
        StringBuilder sb = new StringBuilder();
        Locale locale3 = locale;
        String str = BuildConfig.FLAVOR;
        if (locale3 == null || (language = locale3.getLanguage()) == null) {
            language = BuildConfig.FLAVOR;
        }
        sb.append(language);
        sb.append('_');
        Locale locale4 = locale;
        if (locale4 != null && (country = locale4.getCountry()) != null) {
            str = country;
        }
        sb.append(str);
        jSONArray.put(sb.toString());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d5 = 0.0d;
        try {
            Object systemService = appContext.getSystemService("display");
            display = null;
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            }
        } catch (Exception unused3) {
        }
        if (display != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            int i8 = displayMetrics.widthPixels;
            try {
                i6 = displayMetrics.heightPixels;
                d5 = displayMetrics.density;
            } catch (Exception unused4) {
            }
            i5 = i6;
            i6 = i8;
            jSONArray.put(i6);
            jSONArray.put(i5);
            jSONArray.put(new DecimalFormat("#.##").format(d5));
            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            params.put("extinfo", jSONArray.toString());
        }
        i5 = 0;
        jSONArray.put(i6);
        jSONArray.put(i5);
        jSONArray.put(new DecimalFormat("#.##").format(d5));
        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        params.put("extinfo", jSONArray.toString());
    }

    public static final String sha1hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bytes);
    }

    public static final String sha256hash(String key) {
        if (key == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", key);
    }

    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public final long getAvailableExternalStorageGB() {
        return availableExternalStorageGB;
    }

    public final String getCarrierName() {
        return carrierName;
    }

    public final String getDeviceTimeZoneName() {
        return deviceTimeZoneName;
    }

    public final Locale getLocale() {
        return locale;
    }

    public final String getVersionName() {
        return versionName;
    }

    public static final Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(clazz, "clazz");
            return getMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String algorithm, byte[] bytes) {
        try {
            MessageDigest hash = MessageDigest.getInstance(algorithm);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            return hashBytes(hash, bytes);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final boolean isNullOrEmpty(String s5) {
        return s5 == null || s5.length() == 0;
    }

    public static final void logd(String tag, String msg) {
        if (!FacebookSdk.isDebugEnabled() || tag == null || msg == null) {
            return;
        }
        Log.d(tag, msg);
    }

    public static final void logd(String tag, String msg, Throwable t5) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(tag)) {
            return;
        }
        Log.d(tag, msg, t5);
    }
}
