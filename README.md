# Warp 10™ Modules

Warp 10™ is very modular, you can augment or modify the features of a Warp 10™ deployment through the use of several mechanisms commonly called **modules**.

The four types of modules are:

* WarpScript™ Extensions (`extensions`)
* Warp 10™ Plugins (`plugins`)
* Warp 10™ Authentication Plugins (`authplugins`)
* Macro Packages (`packages`)

All those module types can be created using this template.

Modules can be private, *i.e.* their use is limited to your organization, or public. For public modules, [SenX](https://senx.io/) manages a directory called WarpFleet which describes modules which were made public by their authors.

# Extension

WarpScript™ [extensions](https://warp10.io/content/03_Documentation/07_Extending_Warp_10/03_Extensions) add, remove or modify functions.

## Authoring an extension

An extension is a Java class which will declare WarpScript™ functions, each function being itself a Java class.

The skeleton of the extension Java class is

```
import io.warp10.warp.sdk.WarpScriptExtension;

import java.util.HashMap;
import java.util.Map;

/**
 * Functions declared by this extension
 * must be present in the 'functions' field.
 */
public class MyExtension extends WarpScriptExtension {

  private static final Map<String, Object> functions;

  static {
    functions = new HashMap<String, Object>();

    //
    // Declare the functions in the 'functions' map
    //
    // The key is name of the WarpScript™ function
    // The value is an instance of the associated Java class
    //

    functions.put("MYFUNC", new MYFUNC("MYFUNC"));
  }

  public Map<String, Object> getFunctions() {
    return functions;
  }
}
```

Each function is a Java class with the following skeleton:

```
package ext;

import io.warp10.script.NamedWarpScriptFunction;
import io.warp10.script.WarpScriptException;
import io.warp10.script.WarpScriptStack;
import io.warp10.script.WarpScriptStackFunction;

public class MYFUNC extends NamedWarpScriptFunction implements WarpScriptStackFunction {

  public MYFUNC(String name) {
    super(name);
  }

  /**
   * The 'apply' method is where your function logic is implemented
   *
   * @param stack The stack from which your function was called
   * @return stack The original stack
   * @throws WarpScriptException If errors are encountered
   */
  public Object apply(WarpScriptStack stack) throws WarpScriptException {
    
    //
    // You function logic goes here
    //

    return stack;
  }
}
```

## Building the extension

The `jar` and `shadowJar` gradle tasks will build the extension and package it in a simple or über (with all dependencies) jar.

## Using an extension

Extensions must be deployed in the classpath of the Warp 10™ instance, typically by placing their `.jar` file in the `lib` directory of the Warp 10™ installation. We recommend you use the über jar as you do not have to worry about copying the dependencies jar files as they are already included.

The extension must then be declared in the configuration file of the Warp 10™ instance using the following syntax:

```
warpscript.extension.NAME = your.extension.package.ANDCLASS
```

When the Warp 10™ instance is restarted, the functions declared by the extension will be available in WarpScript™.

# Plugin

## Authoring a plugin
## Building the plugin
## Deploying the plugin

# Authentication Plugin

# Macro Package


# WarpFleet integration

If you intend to reference your extension in WarpFleet, you need to publish it on a Maven repository.

The `build.gradle` included in this template contains the definition of two Maven publications, `stdjar` and `uberjar` which will publish your extension either as a simple `.jar` with dependencies listed in the accompanying `.pom` file, or as an ûber jar with no external dependencies.

## Publishing to a maven repository

The `publish` task will publish the `stdjar` and `uberjar` publications to the declared maven repository (defaults to the local one).

To use a specific repo, add it to the `publishing` section in the `build.gradle` file. The syntax is describe [here](https://docs.gradle.org/current/userguide/publishing_maven.html#publishing_maven:repositories).

## Publishing on bintray

The `build.gradle` contains a task to publish the jars on [bintray](), simply execute

```
./gradlew bintrayUpload
```

for uploading the simple jar, or

```
./gradlew -Duberjar bintrayUpload
```

to upload the über jar.

Bintray user, API key and optional organization must be specified in a `gradle.properties`. Please refer to the beginning of the `build.gradle` file to learn what properties should be defined.
