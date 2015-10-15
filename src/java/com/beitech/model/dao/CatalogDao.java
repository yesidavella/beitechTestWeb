
package com.beitech.model.dao;

import com.beitech.model.CatalogForm;

/**
 *
 * @author yesid
 */
public interface CatalogDao {
    
    public boolean insertProductInCatalog(CatalogForm catalogForm);
    public boolean deleteProductInCatalog(CatalogForm catalogForm);
}
