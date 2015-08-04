package delight.json.internal;

import delight.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class JSONObjectImpl extends JSONObject {

    private final List<Entry<String, Object>> entries;

    @Override
    public JSONObject add(final String key, final Object value) {

        entries.add(new Entry<String, Object>() {

            @Override
            public String setValue(final Object value) {
                return null;
            }

            @Override
            public Object getValue() {

                return value;
            }

            @Override
            public String getKey() {
                return key;
            }
        });

        return this;

    }

    @Override
    public String render() {
        return render(0);
    }

    @Override
    public String render(final int indentSize) {
        final String indent = JSONUtils.indent(indentSize);
        String res = "{\n";

        int count = 0;
        for (final Entry<String, Object> e : entries) {
            count += 1;

            res += indent + "    '" + e.getKey() + "': " + JSONUtils.render(indent, e.getValue()) + "";

            if (count != entries.size()) {
                res += ",\n";
            } else {
                res += "\n";
            }

        }

        res += indent + "}";

        return res;

    }

    public JSONObjectImpl() {
        super();
        this.entries = new ArrayList<Entry<String, Object>>();
    }

    @Override
    public void print() {
        System.out.println(this.render());
    }

    @Override
    public String toString() {

        return this.render();
    }

}
