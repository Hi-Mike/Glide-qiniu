# Glide qiniu

>使用Glide4的generated API方式封装七牛的高级图片处理API

## 使用

1. 使用这个库需要用到Glide4的generated API，请参考Glide配置。

2. Glide4的Module要求一个应用只能有一个AppGlideModule，所以你需要设置一个，如

```java
@GlideModule
public class TestGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Registry registry) {
        super.registerComponents(context, registry);
    }
}
```

3. 使用，需要用生成的GlideApp

```java
    GlideApp.with(this)
            .load("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg")
            .format(Format.webp)
            .blur(20, 20)
            .fitView()
            .transition(DrawableTransitionOptions.withCrossFade())
            .skipMemoryCache(true)
            .into((ImageView) findViewById(R.id.image));
```

## 方法说明

| 方法 | 说明
| --- | ---
| autoOrient(boolean) | 根据原图EXIF信息自动旋正，默认true
| strip(Void) | 去除图片中的元信息，默认false
| format(Format) | 图片格式，origin, jpg, gif, png, webp
| rotate(int) | 旋转图片
| blur(int,int) | 高斯模糊
| jpgQuality(int) | 图片质量控制
| sharpen(Void) | 图片锐化，默认false
| w(int) | 指定图片宽
| h(int) | 指定图片高
| size(int,int) | 指定图片宽高，与单独指定相互覆盖
| fixScale() | 按照指定宽高分别缩放，图片会变形
| fitView() | 根据ImageView测绘宽高，以等比缩放较小值请求图片，注意宽高可能无测量值
| fitViewWidth() | 根据ImageView测绘宽，高度等比缩放
| fitViewHeight() | 根据ImageView测绘高，宽度等比缩放
| fitWHMin() | 需要设置size，等比缩放以缩放值较小的请求图片
| fitWHMax() | 需要设置size，等比缩放以缩放值较大的请求图片
| zoomOut() | 需要设置size，等比缩小，缩放图片不大于原图宽高
| zoomIn() | 需要设置size，等比放大，缩放图片不小于原图宽高

>注：当指定多个宽高设置时，优先级fixScale > fitView >...> zoomIn