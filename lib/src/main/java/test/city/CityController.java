package test.city;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/cities")
@RestController
public class CityController {
    @Autowired
    private CityDAO cityDAO;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody City city) throws URISyntaxException {
        return ResponseEntity.created(new URI("/cities/" + cityDAO.saveAndFlush(city).getCode())).build();
    }

    @RequestMapping(value = "/{code}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> findByCode(@PathVariable(name = "code") String code) {
        City result = cityDAO.findOne(code);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{code}",
            method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "code") String code) {
        cityDAO.delete(cityDAO.findOne(code));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> find(
            @RequestParam(value = "page", defaultValue = "0", required = true) int page,
            @RequestParam(value = "pageSize", defaultValue = "100", required = true) int pageSize) {
        PageRequest paging = new PageRequest(page, pageSize, new Sort(Sort.Direction.ASC, "code"));
        Page<City> p = cityDAO.findAll(paging);
        List<City> result = new ArrayList<City>((int) p.getTotalElements());
        result.addAll(p.getContent());
        return ResponseEntity.ok(result);
    }
}
