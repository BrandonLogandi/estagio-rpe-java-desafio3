package rpe.estagio.desafio3.template;

public interface DTOConverter<T, D> {

    public D toDTO(T entity);

    public Iterable<D> toDTOIter(Iterable<T> entityList);

    public T toEntity(D dto);

    public Iterable<T> toEntityIter(Iterable<D> dtoList);
    
}
