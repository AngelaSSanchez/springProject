package persistence.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import persistence.entities.Gender;
import persistence.entities.UnRelatedEntity;
import persistence.daos.UnRelatedDao;

@Controller
public class UnRelatedController {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity1 = new UnRelatedEntity("Your Nick", Gender.FEMALE, new GregorianCalendar(1989, 4, 18), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity2 = new UnRelatedEntity("Pepico", Gender.MALE, new GregorianCalendar(2000, 8, 1), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity3 = new UnRelatedEntity("Ana Pi", Gender.FEMALE, new GregorianCalendar(1975, 2, 28), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity4 = new UnRelatedEntity("SonIa", Gender.FEMALE, new GregorianCalendar(1980, 1, 31), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity5 = new UnRelatedEntity("Anto", Gender.MALE, new GregorianCalendar(1979, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity6 = new UnRelatedEntity("Laura", Gender.FEMALE, new GregorianCalendar(2008, 3, 4), "...", list,
                Arrays.asList(list), "no persistence");
        UnRelatedEntity entity7 = new UnRelatedEntity("Man", Gender.MALE, new GregorianCalendar(2002, 10, 3), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        unRelatedDao.save(entity1);
        unRelatedDao.save(entity2);
        unRelatedDao.save(entity3);
        unRelatedDao.save(entity4);
        unRelatedDao.save(entity5);
        unRelatedDao.save(entity6);
        unRelatedDao.save(entity7);
        
        System.out.println("Count:  " + unRelatedDao.count());
        
        
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findOne(entity.getId()));
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findByIdGreaterThan(0, new PageRequest(0,5)));
        /////
        System.out.println("Busqueda por genero: " + unRelatedDao.findByGenderEquals(Gender.MALE).toString());
        System.out.println("Busqueda por nick: " + unRelatedDao.findByNickLike("%ick%"));
        System.out.println("Por id: " + unRelatedDao.findById(entity.getId()).toString());
        System.out.println("JPQL" );
        System.out.println("Por GENERO: " + unRelatedDao.findBornDateByGender(Gender.FEMALE).toString());
        System.out.println("SQL" );
        System.out.println("Por Nacimiento: " + unRelatedDao.findByBornDate( new GregorianCalendar(1989, 11, 31)));
        
    }
}
