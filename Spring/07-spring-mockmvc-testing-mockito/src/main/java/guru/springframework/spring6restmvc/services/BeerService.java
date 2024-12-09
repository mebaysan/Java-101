package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerService {
    public List<Beer> listBeers();

    Beer getBeerById(UUID id);

    public Beer saveBeer(Beer beer);

    public Beer updateById(UUID beerId, Beer beer);

    public void deleteById(UUID beerId);
}
