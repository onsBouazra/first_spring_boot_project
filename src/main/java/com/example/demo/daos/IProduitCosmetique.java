package com.example.demo.daos;


        import com.example.demo.models.ProduitCosmetique;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface IProduitCosmetique extends JpaRepository<ProduitCosmetique, Long> {
}


