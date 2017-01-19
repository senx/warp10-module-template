package io.warp10.tutorial;

import io.warp10.warp.sdk.WarpScriptExtension;

import java.util.HashMap;
import java.util.Map;

public class TutorialExtension extends WarpScriptExtension {

    private final Map<String,Object> functions;

    public TutorialExtension() {
        this.functions = new HashMap<String, Object>();
        functions.put("HELLOWARP10", new HELLOWARP10("HELLOWARP10"));
    }

    public Map<String, Object> getFunctions() {
        return functions;
    }
}
