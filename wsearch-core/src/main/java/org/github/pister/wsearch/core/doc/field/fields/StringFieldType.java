package org.github.pister.wsearch.core.doc.field.fields;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.search.SortField;
import org.github.pister.wsearch.core.doc.field.FieldInfo;

/**
 * User: longyi
 * Date: 13-9-29
 * Time: 下午3:11
 */
public class StringFieldType extends AbstractFieldType {

    @Override
    public Fieldable createField(FieldInfo fieldInfo, Object value) {
        Field.Store store = getStore(fieldInfo);
        String s;
        if (value != null) {
             s = value.toString();
        } else {
            s = null;
        }
        Field field = new Field(fieldInfo.getName(), s, store, getIndex(fieldInfo), fieldInfo.getTermVector());
        return field;
    }

    @Override
    public Object getValue(Fieldable fieldable) {
        return fieldable.stringValue();
    }

    @Override
    public int getSortType() {
        return SortField.STRING;
    }
}
