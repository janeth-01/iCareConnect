package org.openmrs.module.icare.store.dao;

// Generated Oct 7, 2020 12:49:21 PM by Hibernate Tools 5.2.10.Final

import org.hibernate.Query;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.module.icare.core.dao.BaseDAO;
import org.openmrs.module.icare.store.models.RequisitionItem;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class StRequisitionItem.
 * 
 * @see org.openmrs.module.icare.core.dao.StRequisitionItem
 * @author Hibernate Tools
 */

public class RequisitionItemDAO extends BaseDAO<RequisitionItem> {

    public RequisitionItem updateRequisitionItem(RequisitionItem requisitionItem) {

        DbSession dbSession = this.getSession();
        String queryStr = "UPDATE RequisitionItem ri";

        if(requisitionItem.getItem() != null){
            if (!queryStr.contains("SET")) {
                queryStr += " SET ";
            } else {
                queryStr += " , ";
            }
            queryStr += " ri.item = :item";
        }

        if(requisitionItem.getQuantity() != null){
            if (!queryStr.contains("SET")) {
                queryStr += " SET ";
            } else {
                queryStr += " , ";
            }
            queryStr += " ri.quantity = :quantity";
        }

        if (requisitionItem.getVoided() != null) {
            if (!queryStr.contains("SET")) {
                queryStr += " SET ";
            } else {
                queryStr += " ,";
            }
            queryStr += " ri.voided = :voided";
        }



        queryStr += " WHERE ri.uuid = :uuid";

        Query query = dbSession.createQuery(queryStr);

        if(requisitionItem.getItem() != null){
            query.setParameter("item",requisitionItem.getItem());
        }

        if(requisitionItem.getQuantity() != null){
            query.setParameter("quantity",requisitionItem.getQuantity());
        }

        if(requisitionItem.getVoided() != null){
            query.setParameter("voided",requisitionItem.getVoided());
        }

        query.setParameter("uuid",requisitionItem.getUuid());

        Integer success = query.executeUpdate();

        if (success == 1) {
            return requisitionItem;
        } else {
            return null;
        }



    }
}
