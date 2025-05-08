package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (INSTANCE == null) {
                    preload();
                }
                appCompatDrawableManager = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i5, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
                    private final int[] TINT_COLOR_CONTROL_NORMAL = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};
                    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] TINT_COLOR_CONTROL_STATE_LIST = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
                    private final int[] TINT_CHECKABLE_BUTTON_LIST = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

                    private boolean arrayContains(int[] iArr, int i5) {
                        for (int i6 : iArr) {
                            if (i6 == i5) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList createBorderlessButtonColorStateList(Context context) {
                        return createButtonColorStateList(context, 0);
                    }

                    private ColorStateList createButtonColorStateList(Context context, int i5) {
                        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlHighlight);
                        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i5), ColorUtils.compositeColors(themeAttrColor, i5), i5});
                    }

                    private ColorStateList createColoredButtonColorStateList(Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.colorAccent));
                    }

                    private ColorStateList createDefaultButtonColorStateList(Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.colorButtonNormal));
                    }

                    private ColorStateList createSwitchThumbColorStateList(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        int i5 = R$attr.colorSwitchThumbNormal;
                        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i5);
                        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i5);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = ThemeUtils.getThemeAttrColor(context, i5);
                        } else {
                            int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                            iArr[0] = iArr3;
                            iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = themeAttrColorStateList.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i5) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i5);
                        Drawable drawable = resourceManagerInternal.getDrawable(context, R$drawable.abc_star_black_48dp);
                        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R$drawable.abc_star_half_black_48dp);
                        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable = (BitmapDrawable) drawable;
                            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            drawable.draw(canvas);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                        if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) drawable2;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            drawable2.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                        layerDrawable.setId(0, R.id.background);
                        layerDrawable.setId(1, R.id.secondaryProgress);
                        layerDrawable.setId(2, R.id.progress);
                        return layerDrawable;
                    }

                    private void setPorterDuffColorFilter(Drawable drawable, int i5, PorterDuff.Mode mode) {
                        Drawable mutate = drawable.mutate();
                        if (mode == null) {
                            mode = AppCompatDrawableManager.DEFAULT_MODE;
                        }
                        mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i5, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i5) {
                        if (i5 == R$drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R$drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
                        }
                        if (i5 == R$drawable.abc_ratingbar_material) {
                            return getRatingBarLayerDrawable(resourceManagerInternal, context, R$dimen.abc_star_big);
                        }
                        if (i5 == R$drawable.abc_ratingbar_indicator_material) {
                            return getRatingBarLayerDrawable(resourceManagerInternal, context, R$dimen.abc_star_medium);
                        }
                        if (i5 == R$drawable.abc_ratingbar_small_material) {
                            return getRatingBarLayerDrawable(resourceManagerInternal, context, R$dimen.abc_star_small);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList getTintListForDrawableRes(Context context, int i5) {
                        if (i5 == R$drawable.abc_edit_text_material) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_edittext);
                        }
                        if (i5 == R$drawable.abc_switch_track_mtrl_alpha) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_switch_track);
                        }
                        if (i5 == R$drawable.abc_switch_thumb_material) {
                            return createSwitchThumbColorStateList(context);
                        }
                        if (i5 == R$drawable.abc_btn_default_mtrl_shape) {
                            return createDefaultButtonColorStateList(context);
                        }
                        if (i5 == R$drawable.abc_btn_borderless_material) {
                            return createBorderlessButtonColorStateList(context);
                        }
                        if (i5 == R$drawable.abc_btn_colored_material) {
                            return createColoredButtonColorStateList(context);
                        }
                        if (i5 == R$drawable.abc_spinner_mtrl_am_alpha || i5 == R$drawable.abc_spinner_textfield_background_material) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_spinner);
                        }
                        if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i5)) {
                            return ThemeUtils.getThemeAttrColorStateList(context, R$attr.colorControlNormal);
                        }
                        if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i5)) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_default);
                        }
                        if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i5)) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_btn_checkable);
                        }
                        if (i5 == R$drawable.abc_seekbar_thumb_material) {
                            return AppCompatResources.getColorStateList(context, R$color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode getTintModeForDrawableRes(int i5) {
                        if (i5 == R$drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean tintDrawable(Context context, int i5, Drawable drawable) {
                        if (i5 == R$drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                            int i6 = R$attr.colorControlNormal;
                            setPorterDuffColorFilter(findDrawableByLayerId, ThemeUtils.getThemeAttrColor(context, i6), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, i6), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(R.id.progress), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        }
                        if (i5 != R$drawable.abc_ratingbar_material && i5 != R$drawable.abc_ratingbar_indicator_material && i5 != R$drawable.abc_ratingbar_small_material) {
                            return false;
                        }
                        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(R.id.background), ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                        Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
                        int i7 = R$attr.colorControlActivated;
                        setPorterDuffColorFilter(findDrawableByLayerId2, ThemeUtils.getThemeAttrColor(context, i7), AppCompatDrawableManager.DEFAULT_MODE);
                        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(R.id.progress), ThemeUtils.getThemeAttrColor(context, i7), AppCompatDrawableManager.DEFAULT_MODE);
                        return true;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:12:0x0066 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0051  */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean tintDrawableUsingColorFilter(Context context, int i5, Drawable drawable) {
                        PorterDuff.Mode mode;
                        int i6;
                        boolean z5;
                        int round;
                        PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                        if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i5)) {
                            i6 = R$attr.colorControlNormal;
                        } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i5)) {
                            i6 = R$attr.colorControlActivated;
                        } else {
                            if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i5)) {
                                mode2 = PorterDuff.Mode.MULTIPLY;
                            } else {
                                if (i5 == R$drawable.abc_list_divider_mtrl_alpha) {
                                    z5 = true;
                                    round = Math.round(40.8f);
                                    i6 = 16842800;
                                    mode = mode2;
                                    if (z5) {
                                        return false;
                                    }
                                    Drawable mutate = drawable.mutate();
                                    mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i6), mode));
                                    if (round != -1) {
                                        mutate.setAlpha(round);
                                    }
                                    return true;
                                }
                                if (i5 != R$drawable.abc_dialog_material_background) {
                                    mode = mode2;
                                    i6 = 0;
                                    z5 = false;
                                    round = -1;
                                    if (z5) {
                                    }
                                }
                            }
                            mode = mode2;
                            round = -1;
                            i6 = 16842801;
                            z5 = true;
                            if (z5) {
                            }
                        }
                        mode = mode2;
                        z5 = true;
                        round = -1;
                        if (z5) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(Context context, int i5) {
        return this.mResourceManager.getDrawable(context, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(Context context, int i5) {
        return this.mResourceManager.getTintList(context, i5);
    }
}
