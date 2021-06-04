package com.inprogress.reactnativeyoutube;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;


public class ReactNativeYouTubePlayerModule extends ReactContextBaseJavaModule {

    private static final String E_MODULE_ERROR = "E_MODULE_ERROR";

    private ReactApplicationContext mReactContext;

    public ReactNativeYouTubePlayerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ReactNativeYouTubePlayerModule";
    }

    @ReactMethod
    public void getVideosIndex(final int reactTag, final Promise promise) {
        try {
            UIManagerModule uiManager = mReactContext.getNativeModule(UIManagerModule.class);

            uiManager.addUIBlock(new UIBlock() {
                public void execute (NativeViewHierarchyManager nvhm) {
                    ReactNativeYouTubePlayerView reactNatievYouTubePlayerView = (ReactNativeYouTubePlayerView) nvhm.resolveView(reactTag);
                    ReactNativeYouTubePlayerManager reactNativeYouTubePlayerManager = (ReactNativeYouTubePlayerManager) nvhm.resolveViewManager(reactTag);

                    int index = reactNativeYouTubePlayerManager.getVideosIndex(reactNatievYouTubePlayerView);

                    promise.resolve(index);
                }
            });
        } catch (IllegalViewOperationException e) {
            promise.reject(E_MODULE_ERROR, e);
        }
    }

    @ReactMethod
    public void getCurrentTime(final int reactTag, final Promise promise) {
        try {
            UIManagerModule uiManager = mReactContext.getNativeModule(UIManagerModule.class);

            uiManager.addUIBlock(new UIBlock() {
                public void execute (NativeViewHierarchyManager nvhm) {
                    ReactNativeYouTubePlayerView reactNatievYouTubePlayerView = (ReactNativeYouTubePlayerView) nvhm.resolveView(reactTag);
                    ReactNativeYouTubePlayerManager reactNativeYouTubePlayerManager = (ReactNativeYouTubePlayerManager) nvhm.resolveViewManager(reactTag);

                    float currentTime = reactNativeYouTubePlayerManager.getCurrentTime(reactNatievYouTubePlayerView);

                    promise.resolve(currentTime);
                }
            });
        } catch (IllegalViewOperationException e) {
            promise.reject(E_MODULE_ERROR, e);
        }
    }

    @ReactMethod
    public void getDuration(final int reactTag, final Promise promise) {
        try {
            UIManagerModule uiManager = mReactContext.getNativeModule(UIManagerModule.class);

            uiManager.addUIBlock(new UIBlock() {
                public void execute (NativeViewHierarchyManager nvhm) {
                    ReactNativeYouTubePlayerView reactNatievYouTubePlayerView = (ReactNativeYouTubePlayerView) nvhm.resolveView(reactTag);
                    ReactNativeYouTubePlayerManager reactNativeYouTubePlayerManager = (ReactNativeYouTubePlayerManager) nvhm.resolveViewManager(reactTag);

                    float duration = reactNativeYouTubePlayerManager.getDuration(reactNatievYouTubePlayerView);

                    promise.resolve(duration);
                }
            });
        } catch (IllegalViewOperationException e) {
            promise.reject(E_MODULE_ERROR, e);
        }
    }
}
