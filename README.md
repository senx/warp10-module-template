# Create a WarpScript extension

Use this template to [create a Warp 10 extension](http://www.warp10.io/howto/create-a-warpscript-extension/) that will add one or more custom user made functions to WarpScript.

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
