# guava-demo
##引言
           Guava工程包含了若干被Google的 Java项目广泛依赖 的核心库，例如：集合 [collections]、缓存 [caching]、
        原生类型支持 [primitives support] 、并发库 [concurrency libraries]、通用注解 [common annotations]、
        字符串处理 [string processing] 、I/O 等等。
##1. 基本工具 [Basic utilities]
        让使用Java语言变得更舒适

###1.1 使用和避免null
        null是模棱两可的，会引起令人困惑的错误，有些时候它让人很不舒服。很多Guava工具类用快速失败拒绝null值，
        而不是盲目地接受轻率地使用null可能会导致很多令人惊愕的问题。通过学习Google底层代码库，我们发现95%的
        集合类不接受null值作为元素。我们认为， 相比默默地接受null，使用快速失败操作拒绝null值对开发者更有帮助。
        此外，Null的含糊语义让人很不舒服。Null很少可以明确地表示某种语义，例如，Map.get(key)返回Null时，
        可能表示map中的值是null，亦或map中没有key对应的值。Null可以表示失败、成功或几乎任何情况。
        使用Null以外的特定值，会让你的逻辑描述变得更清晰。Null确实也有合适和正确的使用场景，
        如在性能和速度方面Null是廉价的，而且在对象数组中，出现Null也是无法避免的。
        但相对于底层库来说，在应用级别的代码中，Null往往是导致混乱，疑难问题和模糊语义的元凶，
        就如同我们举过的Map.get(key)的例子。最关键的是，Null本身没有定义它表达的意思。鉴于这些原因，
        很多Guava工具类对Null值都采用快速失败操作，除非工具类本身提供了针对Null值的因变措施。
        此外，Guava还提供了很多工具类，让你更方便地用特定值替换Null值。
######具体的案例
        不要在Set中使用null，或者把null作为map的键值。使用特殊值代表null会让查找操作的语义更清晰。
        如果你想把null作为map中某条目的值，更好的办法是 不把这一条目放到map中，而是单独维护一个”
        值为null的键集合” (null keys)。Map 中对应某个键的值是null，和map中没有对应某个键的值，
        是非常容易混淆的两种情况。因此，最好把值为null的键分离开，并且仔细想想，null值的键在你的项目中
        到底表达了什么语义。如果你需要在列表中使用null——并且这个列表的数据是稀疏的，
        使用Map<Integer, E>可能会更高效，并且更准确地符合你的潜在需求。
        此外，考虑一下使用自然的null对象——特殊值。举例来说，为某个enum类型增加特殊的枚举值表示null，
        比如java.math.RoundingMode就定义了一个枚举值UNNECESSARY，它表示一种不做任何舍入操作的模式，
        用这种模式做舍入操作会直接抛出异常。如果你真的需要使用null值，但是null值不能和Guava中的集合实现
        一起工作，你只能选择其他实现。
        比如，用JDK中的Collections.unmodifiableList替代Guava的ImmutableList
###1.2 前置条件
        让方法中的条件检查更简单
###1.3 常见Object方法
        简化Object方法实现，如hashCode()和toString()
###1.4 排序
        Guava强大的”流畅风格比较器”
###1.5 Throwables
        简化了异常和错误的传播与检查