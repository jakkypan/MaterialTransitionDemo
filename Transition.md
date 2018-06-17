# Transition

如[TransitionFramework](./TransitionFramework.md)对整个动画框架的介绍，可以看出Transition是中间较为复杂，并且也是最灵活的部分，我们即可以使用系统内置的Transition，也定制特有的Transition。

共有的属性：

* duration
* startDelay
* interpolator
* matchOrder

## 内置的Transtion

### Visibility

这个是抽象类，追踪starting scene和ending scene中的target views的可见性的改变。

主要是2个重要的方法，并且子类需要实现：

> onAppear

出现的回调，参数：

* sceneRoot：The root of the transition hierarchy
* view：要出现的view，必须在sceneRoot层级里
* startValues：The target values in the start scene
* endValues：The target values in the end scene

```java
public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues,
            TransitionValues endValues) {
        return null;
    }
```

> onDisappear

view消失的回调：

```java
public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues,
            TransitionValues endValues) {
    return null;
}
```

### Fade

属性：

* fadingMode：in 或 out

### Explode

starting scene和ending scene的进入退出是从屏幕的多个边上发生的。

### Silde

starting scene和ending scene的进入退出是从屏幕的一个边上发生的。**（默认是从底部）**

边的指定又属性决定：

* slideEdge

### ChangeBounds

检测view的位置边界的变化创建动画（captures the layout bounds of target views）

属性：

* resizeClip

### ChangeTransform

检测view的scale和rotation的变化创建缩放和旋转动画（captures scale and rotation for Views）

### ChangeClipBounds

检测view的剪切区域，通过`setClipBound()`来设置剪切区域。**这个API18之前是没效果的，这是因为`setClipBound()`是API18之后才有的方法。**

### ChangeImageTransform

检测ImageView（这里是专指ImageView）的尺寸，位置以及ScaleType，并创建相应动画。(captures an ImageView's matrix)


### TransitionSet

这个是动画集合，比较重要的方法：

> addTransition

```java
public TransitionSet addTransition(@NonNull Transition transition) {
        mTransitions.add(transition);
        transition.mParent = this;
        if (mDuration >= 0) {
            transition.setDuration(mDuration);
        }
        return this;
    }
```

> setOrdering

```java
public TransitionSet setOrdering(int ordering) {
        switch (ordering) {
            case ORDERING_SEQUENTIAL:
                mPlayTogether = false;
                break;
            case ORDERING_TOGETHER:
                mPlayTogether = true;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet "
                        + "ordering: " + ordering);
        }
        return this;
    }
```

属性：

* transitionOrdering：只有2个值`ORDERING_SEQUENTIAL`或`ORDERING_TOGETHER`

### AutoTransition

这个是系统缺省的Transition：

```java
public class AutoTransition extends TransitionSet {

    /**
     * Constructs an AutoTransition object, which is a TransitionSet which
     * first fades out disappearing targets, then moves and resizes existing
     * targets, and finally fades in appearing targets.
     */
    public AutoTransition() {
        init();
    }

    public AutoTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrdering(ORDERING_SEQUENTIAL);
        addTransition(new Fade(Fade.OUT))
                .addTransition(new ChangeBounds())
                .addTransition(new Fade(Fade.IN));
    }

}
```

## 自定义Transtion

// TODO

## TransitionInflater

这个是inflate transition资源的类。

> inflateTransition

Loads a Transition object from a resource

```java
TransitionInflater.from(this).inflateTransition(R.transition.explode);
```

> inflateTransitionManager

Loads a TransitionManager object from a resource


## 界面切换动画

这个有2种情况：

* 不带共享元素的Content Transition
* 带有共享元素的Shared Element Transition

// TODO