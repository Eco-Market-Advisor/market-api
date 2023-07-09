package eco.market.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author matthew
 */
@RestController
@RequestMapping("/api")
public class ItemControllerImpl {
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String getHelloWorld() throws InternalError {
        return "Hello world!";
    }
    
}
