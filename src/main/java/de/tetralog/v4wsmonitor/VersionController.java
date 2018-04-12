package de.tetralog.v4wsmonitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @RequestMapping(method={RequestMethod.GET},value={"/version"}, produces = "text/html")
    public String getVersion() {
        return "1.0";
    }
}
