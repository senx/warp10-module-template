# Create a WarpScript extension

Use this template to [create a Warp 10 extension](http://www.warp10.io/howto/create-a-warpscript-extension/) that will add one or more [Warp 10 UDF](http://www.warp10.io/howto/create-a-udf/), to add custom user made functions to WarpScript.

## Build

Build this project executing the following command.

```
gradle shadowJar
```

## Add this extension in a Warp10 platform

Change Warp10 conf file to include your extension. 

```
//
// Comma separated list of WarpScriptExtension classes to instantiate to modify the defined WarpScript functions
//
warpscript.extensions = io.warp10.tutorial.TutorialExtension
```
Finally add the compiled jar in the classpath used to launch the Warp10 platform.

Restart the platform.

## USE

The custom user made functions can be called using the names defined in the Extension class in any WarpScript executed on a Warp 10 platform launched with the extension.
