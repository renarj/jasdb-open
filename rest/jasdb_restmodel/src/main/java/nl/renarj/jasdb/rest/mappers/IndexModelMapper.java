package nl.renarj.jasdb.rest.mappers;

import nl.renarj.jasdb.api.metadata.IndexDefinition;
import nl.renarj.jasdb.rest.model.IndexEntry;

/**
 * @author Renze de Vries
 *         Date: 8-6-12
 *         Time: 14:51
 */
public class IndexModelMapper {
    private IndexModelMapper() {

    }

    public static IndexEntry map(IndexDefinition definition, boolean isUnique) {
        return new IndexEntry(definition.getIndexName(), definition.getHeaderDescriptor(), definition.getValueDescriptor(), isUnique, definition.getIndexType());
    }

    public static IndexDefinition map(IndexEntry entry) {
        return new IndexDefinition(entry.getName(), entry.getKeyHeader(), entry.getValueHeader(), entry.getIndexType());
    }
}
