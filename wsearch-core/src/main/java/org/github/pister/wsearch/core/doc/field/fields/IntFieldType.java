package org.github.pister.wsearch.core.doc.field.fields;

import org.apache.lucene.document.NumericField;
import org.apache.lucene.search.SortField;

/**
 * User: longyi
 * Date: 13-9-29
 * Time: 下午4:40
 */
public class IntFieldType extends AbstractNumericFieldType {

    @Override
    protected void setValue(NumericField numericField, Object value) {
        if (value instanceof Number) {
            numericField.setIntValue(((Number) value).intValue());
        } else {
            numericField.setIntValue(Integer.parseInt(value.toString()));
        }
    }

    @Override
    protected Object getValue(NumericField numericField) {
        Number number = numericField.getNumericValue();
        if (number != null) {
            return number.intValue();
        }
        return null;
    }

    @Override
    public int getSortType() {
        return SortField.INT;
    }
}
