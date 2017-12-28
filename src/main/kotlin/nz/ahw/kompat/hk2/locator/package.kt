package nz.ahw.kompat.hk2.locator

import org.glassfish.hk2.api.ServiceHandle
import org.glassfish.hk2.api.ServiceLocator

// Get Service

inline fun <reified T> ServiceLocator.getService(vararg qualifiers: Annotation): T =
        this.getService(T::class.java, *qualifiers)

inline fun <reified T> ServiceLocator.getService(name: String, vararg qualifiers: Annotation): T =
        this.getService(T::class.java, name, *qualifiers)

inline fun <reified T> ServiceLocator.getAllServices(vararg qualifiers: Annotation): List<T> =
        this.getAllServices(T::class.java, *qualifiers)


// Get Service Handle

inline fun <reified T> ServiceLocator.getServiceHandle(vararg qualifiers: Annotation): ServiceHandle<T> =
        this.getServiceHandle(T::class.java, *qualifiers)

inline fun <reified T> ServiceLocator.getServiceHandle(name: String, vararg qualifiers: Annotation): ServiceHandle<T> =
        this.getServiceHandle(T::class.java, name, *qualifiers)

inline fun <reified T> ServiceLocator.getAllServiceHandles(vararg qualifiers: Annotation): List<ServiceHandle<T>> =
        this.getAllServiceHandles(T::class.java, *qualifiers)


// Create

inline fun <reified T> ServiceLocator.create(): T = this.create(T::class.java)

inline fun <reified T> ServiceLocator.create(strategy: String): T = this.create(T::class.java, strategy)


// Create and Initialize

inline fun <reified T> ServiceLocator.createAndInitialize(): T = this.createAndInitialize(T::class.java)

inline fun <reified T> ServiceLocator.createAndInitialize(strategy: String): T = this.createAndInitialize(T::class.java, strategy)





