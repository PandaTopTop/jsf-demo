package repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.CoverageItem;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class CoverageItemRepository {
    @PersistenceContext
    EntityManager em;

    public List<CoverageItem> findCoveragesWithFilter(Integer id, String name,
                                                      BigDecimal minLimit, BigDecimal maxLimit,
                                                      BigDecimal minPremium, BigDecimal maxPremium,
                                                      Boolean active){
       return em.createNamedQuery("CoverageItem.findAllWithFilter",CoverageItem.class)
                .setParameter("id",id)
                .setParameter("name",(name == null || name.isEmpty())? null : "%" + name +"%")
                .setParameter("minLimit", minLimit)
                .setParameter("maxLimit", maxLimit)
                .setParameter("minPremium", minPremium)
                .setParameter("maxPremium", maxPremium)
                .setParameter("active", active)
                .getResultList();
    }

    public void save(CoverageItem item) {
        if (item.getCoverageId() == null) {
            em.persist(item); // Create new
        } else {
            em.merge(item);   // Update existing
        }
    }

    public void delete(Integer id) {
        CoverageItem item = em.find(CoverageItem.class, id);
        if (item != null) {
            em.remove(item);
        }
    }
}
