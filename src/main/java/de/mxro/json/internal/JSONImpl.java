package de.mxro.json.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import de.mxro.json.JSON;

public class JSONImpl extends JSON {

    private final List<Entry<String, Object>> entries;

    @Override
    public void add(final String key, final Object value) {

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

    }

    private final String indent(final int size) {
        String indent = "";
        for (int i = 1; i <= size; i++) {
            indent += " ";
        }
        return indent;
    }

    @Override
    public String render() {
        return render(0);
    }

    @Override
    public String render(final int indentSize) {
        final String indent = indent(indentSize);
        String res = "{\n";

        int count = 0;
        for (final Entry<String, Object> e : entries) {
            count += 1;
            if (e.getValue() instanceof String) {
                res += indent + "    '" + e.getKey() + "': '" + e.getValue() + "'";

            } else if (e.getValue() instanceof JSONImpl) {

                final JSON json = (JSON) e.getValue();

                res += "    '" + e.getKey() + "': ";

                res += json.render(indentSize + 4);
                continue;
            } else {

                res += indent + "    '" + e.getKey() + "': '" + e.getValue().toString() + "'";
            }

            if (count != entries.size()) {
                res += ",\n";
            } else {
                res += "\n";
            }

        }

        res += indent + "}\n";

        return res;

    }

    public JSONImpl() {
        super();
        this.entries = new ArrayList<Entry<String, Object>>();
    }

}
