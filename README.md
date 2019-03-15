# Warp 10™ Modules

This repository contains a template for creating Warp 10™ modules such as extensions, plugins, authentication plugins or macro packages.

After cloning this repo, you must initialize it with informations related to your module, namely:

* The module **group**, this is the [maven]() *groupId* under which your module will be published
* The module **artifact**, this is the *artifactId* of your published module
* The module initial **version**
* The module **description**

Such an initialization is performed using `gradlew`:

```
./gradlew bootstrap -Pg=group -Pa=artifact -Pv=x.y.z -Pd='description of your module'
```