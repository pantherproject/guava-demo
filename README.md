# guava-demo
##引言
           Guava工程包含了若干被Google的 Java项目广泛依赖 的核心库，例如：集合 [collections]、缓存 [caching]、
        原生类型支持 [primitives support] 、并发库 [concurrency libraries]、通用注解 [common annotations]、
        字符串处理 [string processing] 、I/O 等等。
##1. 基本工具 [Basic utilities]
        让使用Java语言变得更舒适
###1.1 使用和避免null
        null是模棱两可的，会引起令人困惑的错误，有些时候它让人很不舒服。很多Guava工具类用快速失败拒绝null值，而不是盲目地接受
###1.2 前置条件
        让方法中的条件检查更简单
###1.3 常见Object方法
        简化Object方法实现，如hashCode()和toString()
###1.4 排序
        Guava强大的”流畅风格比较器”
###1.5 Throwables
        简化了异常和错误的传播与检查