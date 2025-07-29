package sn.edu.isepdiamniadio.coursspring.domain;


import org.springframework.data.jpa.domain.Specification;

public class Specificat {

    public static Specification<Ecole> hasProfesseursGreaterThan(int idPro) {
        return (root, query, builder) ->
            builder.greaterThan(builder.size(root.get("professeurs")), idPro);
    }

    public static Specification<Ecole> hasIdLessThan(Long id) {
        return (root, query, builder) ->
            builder.lessThan(root.get("id"), id);
    }

    public static Specification<Ecole> avecSpecification(int idPro, Long id) {
        return Specification.where(hasProfesseursGreaterThan(idPro))
                            .and(hasIdLessThan(id));
    }
}