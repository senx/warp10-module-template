# Create a WarpScript extension

Use this template to [create a Warp 10 extension](https://www.warp10.io/content/03_Documentation/07_Extending_Warp_10/03_Extensions) that will add one or more custom user made functions to WarpScript.

## Build

Build this project executing the following command.

```
./gradlew shadowJar
```

## Add this extension in a Warp 10 platform

Change Warp 10 configuration file to include your extension.

```
//
// Comma separated list of WarpScriptExtension classes to instantiate to modify the defined WarpScript functions
//
warpscript.extensions = ext.TutorialExtension

//
// Individual extension
//
warpscript.extension.template = ext.TutorialExtension
```

Finally add the compiled jar in the classpath used to launch the Warp 10 platform (for example, if you are launching the Warp 10 platform using the script warp10-standalone.init provided with the sources, you have to modify the line where it sets WARP10_CP).

Restart the platform.

## Usage

The custom user made functions can be called using the names defined in the Extension class in any WarpScript executed on a Warp 10 platform launched with the extension.

## WarpFleet integration

If you intend to reference your extension in WarpFleet, you need to publish it on a Maven repository.

The `build.gradle` included in this template contains the definition of two Maven publications, `stdjar` and `uberjar` which will publish your extension either as a simple `.jar` with dependencies listed in the accompanying `.pom` file, or as an ûber jar with no external dependencies.

The `build.gradle` contains a task to publish the jars on [bintray](), simply execute

```
./gradlew bintrayUpload
```

for uploading the simple jar, or

```
./gradlew -Duberjar bintrayUpload
``

to upload the über jar.

Bintray user, API key and optional organization must be specified in a `gradle.properties`. Please refer to the beginning of the `build.gradle` file to learn what properties should be defined.
