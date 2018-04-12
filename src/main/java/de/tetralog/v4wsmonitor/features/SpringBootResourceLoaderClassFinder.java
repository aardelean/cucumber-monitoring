package de.tetralog.v4wsmonitor.features;

import cucumber.runtime.io.Resource;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SpringBootResourceLoaderClassFinder extends ResourceLoaderClassFinder {
    private ResourceLoader resourceLoader;
    public SpringBootResourceLoaderClassFinder(ResourceLoader resourceLoader, ClassLoader classLoader) {
        super(resourceLoader, classLoader);
        this.resourceLoader = resourceLoader;
    }

    @Override
    public <T> Collection<Class<? extends T>> getDescendants(Class<T> parentType, String packageName) {
        Collection<Class<? extends T>> result = new HashSet<Class<? extends T>>();
        String packagePath = "classpath:BOOT-INF/classes/" + packageName.replace('.', '/').replace(File.separatorChar, '/');
        for (Resource classResource : resourceLoader.resources(packagePath, ".class")) {
            String className = classResource.getClassName(".class").replace("BOOT-INF.classes.", "");

            try {
                Class<?> clazz = loadClass(className);
                if (clazz != null && !parentType.equals(clazz) && parentType.isAssignableFrom(clazz)) {
                    result.add(clazz.asSubclass(parentType));
                }
            } catch (ClassNotFoundException ignore) {
            } catch (NoClassDefFoundError ignore) {
            }
        }
        return result;
    }

}
