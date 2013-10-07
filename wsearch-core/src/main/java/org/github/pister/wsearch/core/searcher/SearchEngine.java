package org.github.pister.wsearch.core.searcher;

import org.github.pister.wsearch.core.doc.InputDocument;
import org.github.pister.wsearch.core.searcher.query.SearchQuery;
import org.github.pister.wsearch.core.searcher.response.AddResponse;
import org.github.pister.wsearch.core.searcher.response.DeleteResponse;
import org.github.pister.wsearch.core.searcher.response.OperationResponse;
import org.github.pister.wsearch.core.searcher.response.PongResponse;
import org.github.pister.wsearch.core.searcher.response.QueryResponse;
import org.github.pister.wsearch.core.searcher.response.Response;

import java.util.Collection;
import java.util.List;

/**
 * User: longyi
 * Date: 13-9-29
 * Time: 上午10:49
 */
public interface SearchEngine {

    OperationResponse reopen();

    AddResponse add(InputDocument inputDocument);

    AddResponse add(Collection<InputDocument> inputDocument);

    OperationResponse commit();

    OperationResponse optimize();

    OperationResponse commitAndOptimize();

    OperationResponse rollback();

    DeleteResponse deleteByIds(List<String> ids);

    DeleteResponse deleteById(String id);

    QueryResponse query(SearchQuery searchQuery);

}