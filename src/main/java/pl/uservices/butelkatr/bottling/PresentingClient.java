package pl.uservices.butelkatr.bottling;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.uservices.butelkatr.bottling.model.Version;

@FeignClient("presenting")
@RequestMapping("/feed")
public interface PresentingClient {
    @RequestMapping(
            value = "/bottles/{bottles}",
            produces = Version.PRESENTING_V1,
            consumes = Version.PRESENTING_V1,
            method = PUT)
    String updateBottles(@PathVariable("bottles") int bottles, @RequestHeader("PROCESS-ID") String processId);

    @RequestMapping(
            value = "/bottling",
            produces = Version.PRESENTING_V1,
            consumes = Version.PRESENTING_V1,
            method = PUT)
    void bottlingFeed(@RequestHeader("PROCESS-ID") String processId);
}