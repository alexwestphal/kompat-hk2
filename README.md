Kompat HK2
========

A Kotlin compatibility layer for constructing HK2 Bindings and using HK2 Service Locators.

[ ![Download](https://api.bintray.com/packages/ahwnz/kompat/kompat-hk2/images/download.svg) ](https://bintray.com/ahwnz/kompat/ompat-hk2/_latestVersion)


## Binding

kompat-hk2 provides slightly nicer syntax for programmatically constructing HK2 bindings.

```kotlin
// Before
val myBinder = object: AbstractBinder() {
    override fun configure() {
        bind(B::class.java).`in`(Singleton::class.java).to(A::class.java)
        
        bindAsContract(C::class.java).`in`(PerThread::class.java)
    }
}

// With kompat-hk2
val myBinder = binder {
    bind(B::class) inScope Singleton::class toContract A::class
    
    bindAsContract(C::Class) inScope PerThread::class
}
```


## Getting Services

kompat-hk2 provides slightly nicer syntax that allows for the type to be inferred in some cases.

```kotlin
// Before
val clock: Clock = serviceLocator.getService(Clock::class.java)

// With kompat-hk2
val clock: Clock = serviceLocator.getService()
// or
val clock = serviceLocator.getService<Clock>()
```


## Maven

Configure the kompat repository

```xml
<repository>
    <id>bintray-ahwnz-kompat</id>
    <name>bintray-kompat</name>
    <url>https://dl.bintray.com/ahwnz/kompat</url>
</repository>
```

Add the dependency

```xml
<dependency>
    <groupId>nz.ahw.kompat</groupId>
    <artifactId>kompat-hk2</artifactId>
    <version>{version}</version>
</dependency>
```