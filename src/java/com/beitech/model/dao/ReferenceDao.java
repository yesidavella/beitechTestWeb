package com.beitech.model.dao;

import com.beitech.model.ReferenceForm;

/**
 *
 * @author yesid
 */
public interface ReferenceDao {
    
    public ReferenceForm getReferenceById(String reference);
    public boolean updateReference(ReferenceForm referenceForm);
    
}
