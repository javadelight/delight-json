package de.mxro.json.examples;

import delight.json.JSON;
import delight.json.JSONObject;

public class ExampleRenderSimpleDocument {

    public static void main(final String[] args) {

        final JSONObject json = JSON.create();

        json.add("text", "hello");
        json.add("number", 123);

        json.print();

    }

}
